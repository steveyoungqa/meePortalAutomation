package supportMethods;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class DeleteUsers {
	
	public HttpsURLConnection getHttpConnection(String url, String Type) throws IOException{

	URL uri = null;
	try {
		uri = new URL(url);
	} catch (MalformedURLException e) {

		e.printStackTrace();
	}
	HttpsURLConnection httpsCon = (HttpsURLConnection) uri.openConnection();

	httpsCon.setDoOutput(true);
		
	httpsCon.setRequestProperty(
	    "Content-Type", "application/x-www-form-urlencoded");
	httpsCon.setRequestProperty(
			"Authorization", Type);
	httpsCon.setRequestMethod("DELETE");
	httpsCon.connect();
	return httpsCon;
	}
		

}
