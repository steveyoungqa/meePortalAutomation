package pageObject;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

/**
 * Created by youngey on 30/11/2016.
 */
public class AppiumBrowser {
    AndroidDriver driver;

    public String NewRegisterLandingPage()throws IOException {
        return ("//*[@class='button style-1']");
    }

    public String AccessCodeField()throws IOException {
        return ("_AccessCode");
    }

    public String AccessCodeNextButton()throws IOException {
        return ("_submitBtn");
    }

    public String FirstName()throws IOException {
        return ("_FirstName");
    }

    public String Surname()throws IOException {
        return ("_LastName");
    }
}
