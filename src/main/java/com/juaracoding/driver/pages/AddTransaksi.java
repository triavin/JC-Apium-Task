package com.juaracoding.driver.pages;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.AddTransaksiElement;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.List;

public class AddTransaksi {
    private MobileDriver driver;
//    private MobileElement addBtn;
//    private MobileElement incomeBtn;
//    private MobileElement expenseBtn;
//    private MobileElement category;
//    private MobileElement amount;
//    private MobileElement note;
//    private MobileElement save;


    @AndroidFindBy(id = AddTransaksiElement.ADDBUTTON)
    private AndroidElement addBtn ;
    @AndroidFindBy(id = AddTransaksiElement.INCOME)
    private AndroidElement incomeBtn ;
    @AndroidFindBy(id = AddTransaksiElement.EXPENSE)
    private AndroidElement expenseBtn ;
    @AndroidFindBy(id = AddTransaksiElement.CATEGORY)
    private AndroidElement category ;
    @AndroidFindBy(id = "com.chad.financialrecord:id/llForm")
    private AndroidElement category2 ;
    @AndroidFindBy(xpath = "//android.widget.TextView")
    private AndroidElement category3 ;
    @AndroidFindBy(id = AddTransaksiElement.AMOUNT)
    private AndroidElement amount ;
    @AndroidFindBy(id = AddTransaksiElement.NOTE)
    private AndroidElement note ;
    @AndroidFindBy(id = AddTransaksiElement.SAVE)
    private AndroidElement save ;

    public AddTransaksi() throws MalformedURLException {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        DriverSingleton.delay(3);
    }

    public void AddIncome(String amount, String note){
        this.incomeBtn.click();
        this.amount.sendKeys(amount);
        this.note.sendKeys(note);
        this.save.click();
    }
    public void AddExpense(String amount, String note){
        this.expenseBtn.click();
        this.amount.sendKeys(amount);
        this.note.sendKeys(note);
        this.save.click();
    }

    public void addData() {
        this.addBtn.click();
    }

//    public void getElement(){
//        this.incomeBtn = (MobileElement) driver.findElement(By.id(AddTransaksiElement.INCOME));
//        this.expenseBtn = (MobileElement) driver.findElement(By.id(AddTransaksiElement.EXPENSE));
//        this.category = (MobileElement) driver.findElement(By.id(AddTransaksiElement.CATEGORY));
//        this.amount = (MobileElement) driver.findElement(By.id(AddTransaksiElement.AMOUNT));
//        this.note = (MobileElement) driver.findElement(By.id(AddTransaksiElement.NOTE));
//        this.save = (MobileElement) driver.findElement(By.id(AddTransaksiElement.SAVE));
//    }

    public void getCategory(){
        category.click();
        List<MobileElement> menuList = driver.findElementsById("com.chad.financialrecord:id/tvName");
        int listSize = menuList.size();
        System.out.println("size list menu : " + listSize);
        int index = 0;

        for(MobileElement menu : menuList)
        {
            String label = menu.getText();
            System.out.printf("%d of, %s\n", index,label);
            index++;
        }
    }


}
