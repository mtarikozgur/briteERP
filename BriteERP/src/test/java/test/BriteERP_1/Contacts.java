package test.BriteERP_1;

import utilities.BriteERPUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Contacts {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//created only once for rest of the whole code
    }
    @AfterMethod
    public void closeDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }
    @Test
    public void contactTC43() throws InterruptedException {

        /*User Story: "Manager should be able to Click on Action
 and verify that Delete, icon does delete"
        Credentials:
       - url : 54.148.96.210
       - username: in_manuf_manager5@info.com
       - password: kop98tfgQ72""
       - Contact name: RACHEL
       1) Navigate to the Application URL
       2)Enter username
       3) Enter password
       4) Click sign in button
         */

        BriteERPUtilities.login(driver, "in_manuf_manager5@info.com", "kop98tfgQ72");
//5) Click on ""Contacts"" link
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(), 'Contacts')])[1]")).click();
//6) Select contact name ""RACHEL"
        driver.findElement(By.xpath("(//span[.='RACHEL'])[1]")).click();
        /*
7) Click actions
        driver.findElement(By.xpath("(//button[@aria-expanded='false'][@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[3]")).click();
8) Select delete and click ok botton to delete selected contact"
         */
        driver.findElement(By.xpath("//div/button[@aria-expanded='false'][@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'][contains(text(), 'Action')]")).click();
        driver.findElement(By.cssSelector("a[data-index='0'][data-section='other']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(("button[class='btn btn-sm btn-primary']"))).click();

        driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-primary'])[1]")).click();
        //  driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();


    }
    @Test
    public void contactTC39() throws InterruptedException {
        /*
        User Story: "Manager should be able to click and see the
         next and previous page of contacts"
         Credentials:
       - url : 54.148.96.210
       - username: in_manuf_manager5@info.com
       - password: kop98tfgQ72
            1) Navigate to the Application URL
            2)Enter username
            3) Enter password
            4) Click sign in button
            5) Click on ""Contacts"" link

         */

        BriteERPUtilities.login(driver, "in_manuf_manager5@info.com", "kop98tfgQ72");
//        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class='oe_menu_text'][contains(text(), 'Contacts')])[1]")).click();
//            6) Click ""<"" (back) and  "">"" (forth) arrows
//            located at right top hand corner."
        driver.findElement(By.cssSelector("button[class='fa fa-chevron-left btn btn-icon o_pager_previous']")).click();
        driver.findElement(By.cssSelector("button[class='fa fa-chevron-right btn btn-icon o_pager_next']")).click();
    }
}