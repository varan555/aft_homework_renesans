package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DepositPage;

import java.util.Map;

public class DepositPageSteps {

        @When("выбирается валюта {string}:")
        public void chooseCurrency(String currency) {
            new DepositPage().chooseCurrency(currency);
        }

        @When("вводится сумма депозита {string}:")
        public void chooseDepositAmount(String depositAmount) {
            new DepositPage().chooseDepositAmount(depositAmount);
        }

        @When("выбран срок {string} месяцев:")
        public void chooseDepositeTerm(String mounth) {
            new DepositPage().chooseDepositeTerm(mounth);
        }

        @When("вводится сумма пополнений {string}:")
        public void chooseDepositReplenish(String depositReplenish) {
            new DepositPage().chooseDepositReplenish(depositReplenish);
        }

        @When("выбирается капитализация процентов:")
        public void checkCapitalization(){
            new DepositPage().checkCapitalization();
        }

    @Then("ожидаемые значения равны:")
    public DepositPageSteps checkResults(Map<String, Double> fields){
        fields.forEach(this::checkResult);
        return this;
    }

    public void checkResult(String nameField, Double expected) {
        new DepositPage().checkResult(nameField, expected);
    }

    }

