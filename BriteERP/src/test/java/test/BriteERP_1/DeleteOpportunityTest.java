package test.BriteERP_1;

import utilities.BriteERPUtilities;
import utilities.Library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeleteOpportunityTest {
    /*
   User Story : As a user, when I already created an opportunity in CRM module of Bribe ERP application,
   I want to be able to delete it.Acceptance Criteria :
   1.Verify that user should be able to see the list view.
   2.Verify that user should be able to delete the opportunity from action drop down list .

   Feature: Delete the opportunity in CRM Module
Scenario: Delete the opportunity from CRM Module, when you already created it.
Given the opportunity already created in CRM Module
When the user clicks the list view
Then the user should be able to see the opportunities listed view
When the user clicks the checkbox already created opportunity
Then the user should be able to delete the opportunity from the Action dropdown

username: eventscrmmanager52@info.com
password: eventscrmmanager
    */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//created only once for rest of the whole code
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.quit();
    }
    @Test(description = "Go to Create and create first Precondition",priority = 3)

    public void CreatePreConditions() throws InterruptedException {

        BriteERPUtilities.login(driver, "eventscrmmanager52@info.com", "eventscrmmanager");
//click CRM
        driver.findElement(By.xpath("//span[@class='oe_menu_text'][contains(text(), 'CRM')]")).click();
//create contact
        WebElement createButton=driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm o-kanban-button-new']"));
        createButton.click();


        //Go to Opportunity Title and filled up
        WebElement OpportunityTitle=driver.findElement(By.xpath("//*[@class='o_field_char o_field_widget o_input o_required_modifier']"));
        OpportunityTitle.sendKeys("Printer");
        //Go to Customer

        WebElement  selectElement=driver.findElement(By.xpath("//*[@class='o_field_widget o_field_many2one']"));

        selectElement.click();

        //  Sleep.sleep(2);

        WebElement firstOption=driver.findElement(By.xpath("//ul/li[@class='ui-menu-item'][1]"));
        Library.sleep(2);
        firstOption.click();

        WebElement revenue=driver.findElement(By.xpath("//*[@class='o_field_float o_field_number o_field_widget o_input']"));
        revenue.clear();
        revenue.sendKeys("300.00");

        Library.sleep(2);
        WebElement CreateButton=driver.findElement(By.xpath("//*[@name='close_dialog']"));
        CreateButton.click();




    }
    @Test
    public void deleteOpportunityCRM() throws InterruptedException {

        BriteERPUtilities.login(driver, "eventscrmmanager52@info.com","eventscrmmanager");
        driver.findElement(By.xpath("//span[@class='oe_menu_text'][contains(text(), 'CRM')]")).click();
        driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")).click();
        //Pipeline is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='Pipeline']")).isDisplayed());
        driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();

        String numberText = driver.findElement(By.cssSelector(".o_pager_limit")).getText();
        int intnumberText = Integer.parseInt(numberText);
        System.out.println(intnumberText);

        driver.findElement(By.xpath("//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'][contains(text(),'Action')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Delete")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[.='Ok']")).click();

        Thread.sleep(5000);
        String numberText2 = driver.findElement(By.cssSelector(".o_pager_limit")).getText();
        int intnumberText2 = Integer.parseInt(numberText2);
        System.out.println(intnumberText2);
        Thread.sleep(5000);
        Assert.assertTrue(intnumberText>intnumberText2);

    }

}
