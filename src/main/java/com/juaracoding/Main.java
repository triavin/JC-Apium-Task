package com.juaracoding;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.driver.pages.AddTransaksi;
import com.juaracoding.utils.Constants;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class Main {
    public static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException {
        //DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // URL
        //URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // instance AndroidDriver
       // AndroidDriver driver = new AndroidDriver<>(url,desiredCapabilities);
        DriverSingleton.getInstance(Constants.ANDROID);

        //driver = DriverSingleton.getDriver();
        // Mobile Element
        //MobileElement add = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/fabMenu"));

        //add.click();

        AddTransaksi addTransaksi = new AddTransaksi();
        DriverSingleton.delay(5);
        System.out.println("print after delay");
        addTransaksi.addData();
        DriverSingleton.delay(1);
//        addTransaksi.getElement();
        System.out.println("get element");
        DriverSingleton.delay(1);
        addTransaksi.AddIncome("1000","Test");

        //
        // driver.quit();
    }
}
