package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import static steps.BaseSteps.getDriver;

public class MainPage extends BasePage{

    public void chooseService(String service) {
        WebElement elementMenu = getDriver().findElement(By.xpath("//div[@class = 'service' and contains(., '"+service+"')]"));
        WebElement subMenu = elementMenu.findElement(By.xpath(".//a[@class = 'service__title-action']"));
        try {
            click(elementMenu);
            click(subMenu);
        }
        catch (NoSuchElementException e) {
            System.out.println("Неверное название сервиса");
        }
    }

}
