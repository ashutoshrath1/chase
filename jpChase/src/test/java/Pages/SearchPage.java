package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends Parent{
    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "q") private WebElement searchBox;
    @FindBy(css = ".tF2Cxc") private List<WebElement> searchResults;

    public SearchPage enterSearchResult(String searchContent){
        mySendKeys(searchBox,searchContent+"/n");
        return this;
    }
    public boolean validArticle(){
        int count =0;
        // Loop through the search results and print the links and website names
        for (WebElement result : searchResults) {
            WebElement link = result.findElement(By.tagName("a"));
            String linkText = link.getAttribute("href");
            System.out.println(link);
            if(!linkText.contains("theguardian")){
                count++;
            }
        }

        if(count>=2){
            return true;
        }
        else{
            return false;
        }
    }
}
