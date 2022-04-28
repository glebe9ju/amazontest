package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class TestSuit extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void testSuit() throws InterruptedException {
        //  Type "Dell Laptop" in the search box and press enter or click on search
        //   Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Del Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        clickOnElement(By.name("accept"));
        // Click on the checkbox brand dell on the left side.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));

//4. Verify that the  30(May be different) products are displayed on the page.
        int expectedQty = 30;
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualQty = elementList.size();
        Thread.sleep(2000);
        Assert.assertEquals("Qty not matched", expectedQty, actualQty);
        //5. Print all product names in the console.
        List<WebElement> names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement e : names) {
            System.out.println(e.getText());
        }

    }

    @After
    public void tearDown() {
        // closeBrowsers();
    }

}
