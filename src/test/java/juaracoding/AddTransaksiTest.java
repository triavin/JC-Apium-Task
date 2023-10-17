package juaracoding;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.driver.pages.AddTransaksi;
import com.juaracoding.driver.pages.HomePage;
import com.juaracoding.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AddTransaksiTest {
    private AddTransaksi addTransaksi;
    private HomePage homePage;
    private int saldoAwal;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DriverSingleton.getInstance(Constants.ANDROID);
        DriverSingleton.delay(3);
        this.homePage = new HomePage();
        this.addTransaksi = new AddTransaksi();
        System.out.println("setup berhasil!");
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        System.out.println("Test Finish");
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testAddIncome(){
        System.out.println("test 1 : add income");

//        homePage.getElement();
        homePage.getInfo();
        saldoAwal = homePage.getSaldo();
        System.out.println("get data saldo");

        addTransaksi.addData();
//        addTransaksi.getElement();
        System.out.println("get element");
        addTransaksi.AddIncome(Constants.TESTAMOUNT, "Test");

        homePage.getInfo();

        int actual = homePage.getSaldo();
        int expected = saldoAwal + Integer.parseInt(Constants.TESTAMOUNT);

        Assert.assertEquals(actual,expected);
        System.out.println("test add income valid");
    }
    @Test(priority = 2)
    public void testAddExpense(){
        System.out.println("test 2 : add expense");

//        homePage.getElement();
        homePage.getInfo();
        saldoAwal = homePage.getSaldo();
        System.out.println("get data saldo");

        addTransaksi.addData();
//        addTransaksi.getElement();
        System.out.println("get element");
        addTransaksi.AddExpense(Constants.TESTAMOUNT, "Test");

        homePage.getInfo();

        int actual = homePage.getSaldo();
        int expected = saldoAwal - Integer.parseInt(Constants.TESTAMOUNT);

        Assert.assertEquals(actual,expected);
        System.out.println("test add expense valid");
    }

    @Test(priority = 3)
    public void getCategory(){
        System.out.println("test 3 : get category element");

//        homePage.getElement();
//        homePage.getInfo();
//        saldoAwal = homePage.getSaldo();
//        System.out.println("get data saldo");

        addTransaksi.addData();
        addTransaksi.getCategory();
//        addTransaksi.getElement();

        System.out.println("get element");

//        addTransaksi.AddExpense(Constants.TESTAMOUNT, "Test");

//        homePage.getInfo();
//
//        int actual = homePage.getSaldo();
//        int expected = saldoAwal - Integer.parseInt(Constants.TESTAMOUNT);
//
//        Assert.assertEquals(actual,expected);
//        System.out.println("test add expense valid");
    }

}
