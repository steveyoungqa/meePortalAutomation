package stepDefinition;

import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import pageObject.LoginPage;
import supportMethods.FileReader;

public class delete {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



//    @Test
//    public void downloadFileRevisitedTest() throws Exception {
//        driver.get("http://the-internet.herokuapp.com/download");
//        String link = driver.findElement(By.xpath("//*[@class=\"example\"]//*[contains(text(),'2016_02_24_Fitness_class.pdf')]")).getAttribute("href");
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpHead request = new HttpHead(link);
//        HttpResponse response = httpClient.execute(request);
//        System.out.println("\n" + "Request: " + request);
//        String contentType = response.getFirstHeader("Content-Type").getValue();
//        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
//        System.out.println("\n" + "Content Type: " + contentType);
//        System.out.println("\n" + "Content Length: " + contentLength);
//        assertThat(contentType, is("application/pdf"));
//        assertThat(contentLength, is(not(0)));
//
//    }

    @Test
    public void downloadFileSpringer() throws Exception {
        driver.get("https://mee-test-useraccesscontrolmanager.ws.macmillaneducation.com/");
        driver.findElement(By.xpath("//*[@data-reactid='.1.2.1.0']")).click();
        String username = FileReader.readProperties().get("username");
        String password = FileReader.readProperties().get("password");
        driver.findElement(By.id("_Username")).sendKeys(username);
        driver.findElement(By.id("_Password")).sendKeys(password);
        driver.findElement(By.xpath(".//input[@type='submit']")).click();
        Thread.sleep(3000);


        String clink = "https://mee-cdn-test.ws.macmillaneducation.com/Releases/MEE-latest.exe";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(clink);
        HttpResponse response = httpClient.execute(request);
        System.out.println("\n" + "Request: " + request);
        String contentType = response.getFirstHeader("Content-Type").getValue();
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());
        System.out.println("\n" + "Content Type: " + contentType);
        System.out.println("\n" + "Content Length: " + contentLength);
        assertThat(contentType, is("application/octet-stream"));
        assertThat(contentLength, is((29455520)));
    }

}
