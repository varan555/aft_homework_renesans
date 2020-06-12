package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.BaseSteps;
import static org.junit.Assert.*;

public class DepositPage extends BasePage{

    @FindBy(xpath = "//div[@class = 'calculator__currency-row']//span[contains(text(),'Рубли')]")
    WebElement RUB;

    @FindBy(xpath = "//div[@class = 'calculator__currency-row']//span[contains(text(),'Доллары США')]")
    WebElement USD;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement depositAmountElement;

    @FindBy(xpath = "//input[@name='replenish']")
    WebElement depositReplenishElement;

    @FindBy(xpath = "//input[@name='capitalization']/parent::*")
    WebElement capitalization;

    @FindBy(xpath = "//tr[@class='calculator__dep-result-table-row' and contains(.,'Начислено')]//span[@class='js-calc-earned']")
    WebElement accruedInterest;

    @FindBy(xpath = "//tr[@class='calculator__dep-result-table-row' and contains(.,'Пополнение')]//span[@class='js-calc-replenish']")
    WebElement totalReplenish;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement totalResult;

    public void chooseCurrency(String currency) {
        switch (currency) {
            case ("Рубли"):
                clickWithScroll(RUB);
                break;
            case ("Доллары США"):
                clickWithScroll(USD);
                break;
            default:
                System.out.println("Неверная валюта");
        }
    }

    public void chooseDepositAmount(String depositAmount) {
        enter(depositAmountElement, depositAmount);
    }

    public void chooseDepositeTerm(String mounth) {
        String term = null;
        switch (mounth){
            case ("3"):
                term = "0";
                break;
            case ("6"):
                term = "1";
                break;
            case ("9"):
                term = "2";
                break;
            case ("12"):
                term = "3";
                break;
            case ("13"):
                term = "4";
                break;
            case ("18"):
                term = "5";
                break;
             default:
                 System.out.println("Неверное количество месяцев");
        }
        WebElement depositeTerm = BaseSteps.getDriver().findElement(By.xpath("//div[@data-property='period']//div[@data-pos='"+term+"']"));
        click(depositeTerm);
    }

    public void chooseDepositReplenish(String depositReplenish) {
        enter(depositReplenishElement, depositReplenish);
    }

    public void checkCapitalization(){
         click(capitalization);
    }

    public void checkResult(String nameField, Double expected) {
        WebElement field = null;
        switch (nameField) {
            case ("начислено %"):
                field = accruedInterest;
                break;
            case ("пополнение"):
                field = totalReplenish;
                break;
            case ("к снятию"):
                field = totalResult;
                break;
            default:
                System.out.println("Неверно указано поле для проверки:");

                double result = getValue(field);
                assertTrue("Значение поля " + nameField + " не соответствует ожидаемому " + result + "!=" + expected, expected == result);
                //"Значение поля " + nameField + " не соответствует ожидаемому " + result + "!=" + expected, expected == result
        }
    }
}
