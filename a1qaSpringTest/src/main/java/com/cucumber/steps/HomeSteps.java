package com.cucumber.steps;

import com.cucumber.driver.wait.CustomSleeper;
import com.cucumber.pages.Home;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeSteps extends Step {

    private static final Logger iLogger =  Logger.getLogger(HomeSteps.class);

    @Autowired
    Home home;

    @Given("^I open store\\.steampowered\\.com$")
    public void iOpenStoreSteampoweredCom() throws Throwable {
        iLogger.info("STEP 1  - i Open store.steampowered.com");
        home.open();
        CustomSleeper.SYSTEM_SLEEPER.sleep(5000L);
    }

    @When("^I select category \"(.*?)\"$")
    public void iSelectCategory(String catType) throws Throwable {
        iLogger.info("STEP 2  - i select category " + catType );
        Actions builder = new Actions(driver);
        builder.moveToElement(home.getCategory(catType)).build().perform();

    }

    @And("^I select option \"([^\"]*)\"$")
    public void iSelectOption(String optionType) throws Throwable {
        iLogger.info("STEP 3  - i select option " + optionType );
        home.getOption(optionType).click();
        CustomSleeper.SYSTEM_SLEEPER.sleep(5000L);
    }

    @And("^I select section \"([^\"]*)\"$")
    public void iSelectSection(String secType) throws Throwable {
        iLogger.info("STEP 4  - i select section " + secType );
        home.getSection(secType).click();
        CustomSleeper.SYSTEM_SLEEPER.sleep(5000L);
    }

    @Then("^I should choose game with max sale$")
    public void iShouldChooseGameWithMaxSale() throws Throwable {
        iLogger.info("STEP 5  - i choose game with max sale " );
        home.choseGameWithMaxSale();
    }


    @And("^Verify price and sale$")
    public void verifyPriceAndSale() throws Throwable {
        iLogger.info("STEP 9  - verify price and sale " );
        home.verifyPriceAndSale();
    }

    @And("^I select link \"([^\"]*)\"$")
    public void iSelectLink(String streamButton) throws Throwable {
        iLogger.info("STEP 10  - i select link " + streamButton );
        home.selectlink(streamButton);

    }

    @Then("^Save setup file$")
    public void saveSetupFile() throws Throwable {
        iLogger.info("STEP 11  - save Setup file ");
        home.saveSetupFile();
        CustomSleeper.SYSTEM_SLEEPER.sleep(5000L);
    }
}
