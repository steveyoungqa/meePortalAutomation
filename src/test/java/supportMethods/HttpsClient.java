package supportMethods;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.json.JSONObject;
import org.junit.Assert;

import webDriver.Driver;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import enums.SampleApiUrls;

public class HttpsClient {

	String redirectUrl = "{0}:{1}";
	String urlLogin = baseUrl() + "Account/Login";
	String urlDelete = baseUrl() + "User/";
	String connectionResponseMessage = null;
	int connectionResponseCode = 0;


	private JSONObject setUsernameAndPassword(String username, String password) {
		JSONObject userDetails = new JSONObject();
		userDetails.put("username", username);
		userDetails.put("password", password);
		return userDetails;
	}
	private String baseUrl () {		
		return SampleApiUrls.getUrl() + "/UserAccessControlService/";
	}
	
	private String registerUrl () {
		return SampleApiUrls.getUrl();
	}
	private String redirectUrl(String userId, String code, String language) {
		return SampleApiUrls.getUrl() + language + "/Registration/Activation?UserId=" + userId + "&Code=" + code;
	}
	
	private String referrerUrl(String language) {
		return SampleApiUrls.getUrl() + language + "/Session/Login";
	}
	
	private JSONObject setRegisterDetails(String firstName, String lastName, String email, String dateOfBirth, String country, String language) throws ParseException {
		JSONObject registerDetails = new JSONObject();
		registerDetails.put("applicationName", "MEE");
		registerDetails.put("country", country);
		registerDetails.put("language", language);
		registerDetails.put("blockEmail", true);
		registerDetails.put("macmillanOptIn", false);
		registerDetails.put("redirectUrl", redirectUrl);
		registerDetails.put("referrerUrl", referrerUrl(language));
		registerDetails.put("firstName", firstName);
		registerDetails.put("lastName", lastName);
		registerDetails.put("email", email);
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
		String newDate = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss").format(date);
		registerDetails.put("dateOfBirth", newDate);
		return registerDetails;
	}
	
	@SuppressWarnings("null")
	private HttpsURLConnection connect(String url) throws IOException {
		HttpsURLConnection connection = null;
		try {
			URL connectionUrl = new URL(url);
			connection = (HttpsURLConnection) connectionUrl.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(connection.getResponseMessage());
		}
		return connection;
	}
	
	public class Verifier implements HostnameVerifier {

	    public boolean verify(String arg0, SSLSession arg1) {
	            return true;   // mark everything as verified
	    }
	}
	int loop = 0;
	private BufferedReader post(String url, String contentType, String dataToWrite) throws IOException  {
		HttpsURLConnection connection = connect(url);
		try {
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", contentType);
			connection.setHostnameVerifier(new Verifier());
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(dataToWrite.getBytes("UTF-8"));
			outputStream.close();
		} catch (ConnectException e) {
			System.out.println(e.getMessage());			
		}
		try {
			connectionResponseCode = connection.getResponseCode();
		} catch (ConnectException e) {
			if (loop < 3) {
				System.out.println("Connection error: " + e.getMessage() + ". Retrying. Attempt " + (loop + 1));
				post(url, contentType, dataToWrite);
				loop = loop + 1;
			}
		}
		if (connectionResponseCode == 400){
			Assert.fail("Could not create user. Please see error message. Response code: 400." + System.lineSeparator() + connection.getResponseMessage());
		}
		try {
			return new BufferedReader(new InputStreamReader((connection.getInputStream())));
		} catch (IOException e) {
			System.out.println(connection.getResponseCode());
			System.out.println(connection.getResponseMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete (String userId, String contentType, String adminAccessToken) throws IOException {
		HttpsURLConnection connection = connect(urlDelete + userId);
	    connection.setRequestMethod("DELETE");
	    connection.setRequestProperty("Content-Type", contentType);
	    connection.setRequestProperty("Authorization", "Bearer " + adminAccessToken);
	    connectionResponseMessage = connection.getResponseMessage();
	    connectionResponseCode = connection.getResponseCode();	 
	}
	
	public int getResponseCode () throws IOException {
		return connectionResponseCode;
	}
	
	public String getResponseMessage () throws IOException {
		return connectionResponseMessage;
	}
	
	public JSONObject registerUser (String firstName, String lastName, String email, String dateOfBirth, String country, String language) throws UnsupportedEncodingException, IOException, ParseException {
		JSONObject userDetails = new JSONObject();
		JSONObject registerDetails = setRegisterDetails(firstName, lastName, email, dateOfBirth, country, language);
		BufferedReader response = post(registerUrl(), "application/json", registerDetails.toString());
		String output;
		while ((output = response.readLine()) != null) {
			if (output.startsWith("{")) {
				JsonObject jsonOutput = new JsonParser().parse(output).getAsJsonObject();
				String callbackUrl = jsonOutput.get("callbackUrl").getAsString();
				String[] userIdAndCode  = callbackUrl.split(":");
				String userId = userIdAndCode[0];
				String code = userIdAndCode[1];
				String username = jsonOutput.get("userName").getAsString();
				String password = jsonOutput.get("password").getAsString();
				userDetails.put("url", redirectUrl(userId, code, language));			
				userDetails.put("username", username);
				userDetails.put("password", password);
				Driver.writeToReport("User created: " + username + "/" + password);
				createdUsersUserIds.add(userId);
			}
		}
		Runtime.getRuntime().addShutdownHook(new Thread( new cleanupRegisteredUsers()));
		return userDetails;
		
	}
	
	List<String> createdUsersUserIds = new ArrayList<String>();	
	public class cleanupRegisteredUsers implements Runnable {
		public void run()  {
			HttpsClient https = new HttpsClient();
			String adminAccessToken = null;
			try {
				adminAccessToken = https.getAdminAccessToken("admin", "M4cmillan");
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (String userId : createdUsersUserIds) {
				try {
					System.out.println(userId);
					//System.out.println(adminAccessToken);
					https.delete(userId, "application/json", adminAccessToken);
					System.out.println(https.getResponseMessage());
					Assert.assertEquals("User was not sucessfully deleted. User ID: " + userId, 204, https.getResponseCode());		
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Deleted users.");
				
		}
	}
	
	public String getUserId (String username, String password) throws UnsupportedEncodingException, IOException {
		String userId = null;
		JSONObject userDetails = setUsernameAndPassword(username, password);
		BufferedReader response = post(urlLogin, "application/json", userDetails.toString());
		String output;
	    while ((output = response.readLine()) != null) {
	    	if (output.startsWith("{")) {
	    		JsonObject jsonOutput = new JsonParser().parse(output).getAsJsonObject();
	    		userId = jsonOutput.get("userId").getAsString();
	        }
	    }
	    return userId;
	}
	
	public String getAdminAccessToken (String username, String password) throws UnsupportedEncodingException, IOException {
		String userId = null;
		JSONObject userDetails = setUsernameAndPassword(username, password);
		BufferedReader response = post(urlLogin, "application/json", userDetails.toString());
		String output;
	    while ((output = response.readLine()) != null) {
	    	if (output.startsWith("{")) {
	    		JsonObject jsonOutput = new JsonParser().parse(output).getAsJsonObject();
	    		userId = jsonOutput.get("access_token").getAsString();
	        }
	    }
	    return userId;
	}
}