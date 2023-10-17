package com.juaracoding.driver;

import com.juaracoding.driver.strategy.DriverStrategy;
import com.juaracoding.driver.strategy.DriverStrategyImplementer;
import com.juaracoding.utils.Constants;
import io.appium.java_client.MobileDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    public static DriverSingleton instance = null;
    private static MobileDriver driver;

    public DriverSingleton(String driver) throws MalformedURLException {
        instantiate(driver);
    }

    public MobileDriver instantiate(String strategy) throws MalformedURLException {
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);

        return driver;
    }

    public static DriverSingleton getInstance(String driver) throws MalformedURLException {
        if (instance == null){
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static MobileDriver getDriver(){
        return driver;
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }

    public static void delay(long detik){
        // add delay to automation
        try{
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
