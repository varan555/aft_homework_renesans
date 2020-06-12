package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void clickWithScroll(WebElement element){
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor)BaseSteps.getDriver()).executeScript("scroll(0,200)");
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void click(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public void switchFrame(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void clear(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
    }

    public void enter(WebElement nameField, String value) {
        clear(nameField);
        nameField.sendKeys(value);
    }

    public Double getValue(WebElement nameField) {
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(nameField));
        String result1 = nameField.getText().replaceAll("[\\u20BD%\\s]+","");
        String result2 = result1.replaceAll("\\,", "\\.");
        return Double.parseDouble(result2);
    }
}


