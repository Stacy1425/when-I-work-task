package taskWhenIwork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import taskWhenIwork.utilities.Driver;

public class WorkplacesPage {

    public WebElement workspaceName(String workspace) {
        String xpath = "//strong[text()=" + workspace + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

}
