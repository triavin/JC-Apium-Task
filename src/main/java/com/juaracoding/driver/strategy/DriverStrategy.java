package com.juaracoding.driver.strategy;

import io.appium.java_client.MobileDriver;

import java.net.MalformedURLException;

public interface DriverStrategy {
    MobileDriver setStrategy() throws MalformedURLException;
}
