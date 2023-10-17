package com.juaracoding.driver.strategy;

import com.juaracoding.utils.Constants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Android implements DriverStrategy{
    @Override
    public AndroidDriver setStrategy() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName",Constants.DEVICENAME);
        desiredCapabilities.setCapability("udid",Constants.UDID);
        desiredCapabilities.setCapability("platformName",Constants.PLATFORMNAME);
        desiredCapabilities.setCapability("appPackage",Constants.APPPACKAGE);
        desiredCapabilities.setCapability("appActivity",Constants.APPACTIVITY);
        desiredCapabilities.setCapability("noReset",true);

        URL url = new URL(Constants.URL);

        AndroidDriver driver = new AndroidDriver<> (url, desiredCapabilities);

        return driver;
    }
}
