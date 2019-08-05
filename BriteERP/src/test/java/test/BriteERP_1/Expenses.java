package test.BriteERP_1;

import utilities.BriteERPUtilities;
import utilities.Library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expenses {
    WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }
    @AfterMethod
    public void tearDown(){
        Library.sleep(2);
        //      driver.quit();

    }
    @Test
    public void Expenses_TC14(){
//        "http://54.148.96.210/web#view_type=list&model=hr.expense.sheet&menu_id=394&action=547
//
//        username: in_ex_manager5@info.com
//        password: LLighg92"
//        1) Navigate to the Application URL
        BriteERPUtilities.login(driver, "in_ex_manager5@info.com","LLighg92");
//        2) Click on "Expenses"" link
        Library.sleep(3);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expenses')])[1]")).click();
//        3) Click on Expense Reports to Approve link
        Library.sleep(3);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expense Reports')])[1]")).click();
//        4) Create a Report and send it for approval
        Library.sleep(3);
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_list_button_add']")).click();
        Library.sleep(2);
//        Enter Expense Report Summary "Trip to Istanbul"
        driver.findElement(By.id("o_field_input_19")).sendKeys("Trip to Istanbul");
//        Select Employee
        Library.sleep(3);
        driver.findElement(By.id("o_field_input_20")).click();
        Library.sleep(3);
//        Click "Ashley Presley"
        driver.findElement(By.xpath("//a[.='Ashley Presley']")).click();
        Library.sleep(3);
        driver.findElement(By.xpath("(//button[@class='fa fa-external-link btn btn-default o_external_button'])[1]")).click();
//        5) Send it for approval
    }

    @Test
    public void Expenses_TC11(){
        /*
        "1) Navigate to the Application URL
2) Click on ""My Expenses"" link
3) Click on Expense Reports

         */
        BriteERPUtilities.login(driver, "in_ex_manager5@info.com","LLighg92");
//        2) Click on "Expenses"" link
        Library.sleep(3);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expenses')])[1]")).click();
//        3) Click on Expense Reports
        Library.sleep(3);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(),'Expense Reports')])[1]")).click();
//        4) Verify that page title is "My Reports - Odo"
        Library.sleep(3);
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Reports - Odoo";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

}
