package com.cucumber.pages;


import com.cucumber.test.locator.ICommonLocators;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class PageUtil extends Page implements ICommonLocators {

    private static final Logger iLogger =  Logger.getLogger(PageUtil.class);

    public static void clickOnOptionFromList(WebElement option, WebElement select) {
        iLogger.info("Start clickOnOptionFromList ");
        if(option.isDisplayed()) {
            iLogger.info("Select option" + option.getText());
            option.click();
            iLogger.info("Select value" +   select.getText());
            select.click();
        }
    }
    public static String buildXpath(String xpath, String args) {
        iLogger.info("buildXpath");
        StringBuilder buildXPATH = new StringBuilder();
        buildXPATH.append('"');
        buildXPATH.append(args);
        buildXPATH.append('"');
        return String.format(xpath, args);
    }

}
