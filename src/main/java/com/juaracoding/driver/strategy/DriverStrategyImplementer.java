package com.juaracoding.driver.strategy;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy(String strategy){
        switch (strategy){
            case "android":
                return new Android();
            default:
                return null;
        }
    }
}
