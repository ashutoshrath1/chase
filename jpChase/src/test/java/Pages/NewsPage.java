package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewsPage extends Parent {
    public NewsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(css = ".fc-slice-wrapper .fc-slice__item")
    private WebElement firstArticle;

    public String getArticleName() {
        return wait.until(ExpectedConditions.visibilityOf(firstArticle)).getText();
    }

}