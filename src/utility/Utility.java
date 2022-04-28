package utility;

import browsertesting.BaseTest;
import com.beust.jcommander.internal.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void switchToAlert() {
        driver.switchTo().alert().accept();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dropDown(By by) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
    }

    public void selectByVisibleText(By by) {
        WebElement selectByVisibleText = driver.findElement(by);
        Select select = new Select(selectByVisibleText);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void mouseHoverClick(By by)throws InterruptedException  {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        actions.moveToElement(mouseHoover).build().perform();
    }

    public void scrolldown(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseScrollDown = driver.findElement(by);
        Thread.sleep(3000);
        actions.moveToElement(mouseScrollDown).build().perform();
    }

    public void verifyText(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }

    public WebElement randomEmail1(By by) {
        WebElement emailtxt = driver.findElement(by);
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailtxt.sendKeys("Savalia" + randomInt + "@gmail.com");

        return emailtxt;

    }

    public void listDropDown(By by, String text, By by1) {
        List<WebElement> itemList = driver.findElements(by);
        for (WebElement item : itemList) {
            if (item.getText().equalsIgnoreCase(text)) {
                System.out.println(item.getText());
                Assert.assertEquals("Verify", text, item.getText());
                clickOnElement(by1);
            }
        }
    }

    // Validate Checkbox isSelected method and click
    public void setCheckBoxElement(By by) {
        WebElement checkBoxElement = driver.findElement(by);
        boolean isSelected = checkBoxElement.isSelected();
        if (isSelected == false) {
            checkBoxElement.click();
        }
    }

    //Validate Radio button using isSelected() method
    public void setRadioElement(By by) {
        WebElement radioElement = driver.findElement(by);
        boolean selectState = radioElement.isSelected();
        if (selectState == false) {
            radioElement.click();
        }
    }
    public void verifyUrl (String text){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "" );

    }
}
