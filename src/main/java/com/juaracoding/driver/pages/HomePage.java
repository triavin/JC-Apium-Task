package com.juaracoding.driver.pages;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.HomePageElement;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class HomePage {
    private MobileDriver driver;
//    private MobileElement balanceInfo;
//    private MobileElement incomeInfo;
//    private MobileElement expenseInfo;

    private int saldo;
    private int pemasukan;
    private int pengeluaran;

    @AndroidFindBy(id = HomePageElement.BALANCEINFO)
    private AndroidElement balanceInfo ;
    @AndroidFindBy(id = HomePageElement.INCOMEINFO)
    private AndroidElement incomeInfo ;
    @AndroidFindBy(id = HomePageElement.EXPENSEINFO)
    private AndroidElement expenseInfo ;

    public HomePage() throws MalformedURLException {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        DriverSingleton.delay(3);
    }

    public void getInfo(){
//        saldo = Integer.parseInt(balanceInfo.getText());
//        pemasukan = Integer.parseInt(incomeInfo.getText());
//        pengeluaran = Integer.parseInt(expenseInfo.getText());

        this.saldo = getSaldo();
        this.pemasukan = getPemasukan();
        this.pengeluaran = getPengeluaran();
    }

    public int getSaldo() {
        if (balanceInfo.getText().contains(".")){
            return saldo = Integer.parseInt(balanceInfo.getText().replaceAll("\\.",""));
        } else {
            return saldo = Integer.parseInt(balanceInfo.getText());
        }
    }

    public int getPemasukan() {
        if (incomeInfo.getText().contains(".")){
            return pemasukan = Integer.parseInt(incomeInfo.getText().replaceAll("\\.",""));
        } else {
            return pemasukan = Integer.parseInt(incomeInfo.getText());
        }
    }

    public int getPengeluaran() {
        if (expenseInfo.getText().contains(".")){
            return pengeluaran = Integer.parseInt(expenseInfo.getText().replaceAll("\\.",""));
        }
        return pengeluaran = Integer.parseInt(expenseInfo.getText());
    }

//    public void getElement(){
//        this.balanceInfo = (MobileElement) driver.findElement(By.id(HomePageElement.BALANCEINFO));
//        this.incomeInfo = (MobileElement) driver.findElement(By.id(HomePageElement.INCOMEINFO));
//        this.expenseInfo = (MobileElement) driver.findElement(By.id(HomePageElement.EXPENSEINFO));
//    }

}
