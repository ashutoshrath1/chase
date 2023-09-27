package Pages;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Parent {

    public WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

    public void mySendKeys(WebElement element, String key){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(key);
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
