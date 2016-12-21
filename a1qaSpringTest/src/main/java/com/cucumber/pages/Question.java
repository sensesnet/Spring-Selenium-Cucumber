package com.cucumber.pages;

import com.cucumber.driver.wait.CustomSleeper;
import com.cucumber.entity.DataEntity;
import com.cucumber.test.locator.ICommonLocators;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Question extends Page implements ICommonLocators {

    private static final Logger iLogger = Logger.getLogger(Question.class);

    private static Boolean QUESTIONFORM = null;

    public void checkQuestionForm(String question) {
        try {
            iLogger.info("Check question form ");
            $(QUESTION_FORM_XPATH, question);
            QUESTIONFORM = true;
            iLogger.info("Question form was open ");
        } catch (NoSuchElementException e) {
            iLogger.error("Question form not found: ", e);
            iLogger.info("Question form wasn't open ");
            QUESTIONFORM = false;
        }
    }

    public void setConfidentData(List<DataEntity> entities) {
        iLogger.info("Question form was open is" + QUESTIONFORM);
        if (QUESTIONFORM) {
            Assert.assertNotNull("No data to be set!", entities);
            Assert.assertTrue("Data to be set is empty!", !entities.isEmpty());
            DataEntity entity = entities.get(0);
            CustomSleeper.SYSTEM_SLEEPER.sleep(1000L);
            iLogger.info("Choose ageDay: " + entity.getAgeDay());
            clickOnAgeDayList(entity.getAgeDay());
            CustomSleeper.SYSTEM_SLEEPER.sleep(1000L);
            iLogger.info("Choose ageMonth: " + entity.getAgeMonth());
            clickOnAgeMonthList(entity.getAgeMonth());
            CustomSleeper.SYSTEM_SLEEPER.sleep(1000L);
            iLogger.info("Choose ageYear: " + entity.getAgeYear());
            clickOnAgeYearList(entity.getAgeYear());
            CustomSleeper.SYSTEM_SLEEPER.sleep(1000L);
        }
        if (!QUESTIONFORM) {
            iLogger.info("Question form wasn't open");
        }
    }

    private void clickOnAgeYearList(String ageYear) {
        PageUtil.clickOnOptionFromList($(QUESTION_FORM_BD_XPATH, "ageYear"), $(QUESTION_FORM_VALUE_XPATH, ageYear));
    }

    private void clickOnAgeMonthList(String ageMonth) {
        PageUtil.clickOnOptionFromList($(QUESTION_FORM_BD_XPATH, "ageMonth"), $(QUESTION_FORM_VALUE_XPATH, ageMonth));
    }

    private void clickOnAgeDayList(String ageDay) {
        PageUtil.clickOnOptionFromList($(QUESTION_FORM_BD_XPATH, "ageDay"), $(QUESTION_FORM_VALUE_XPATH, ageDay));
    }

    public void pressButton(String nameButton) {
        if (QUESTIONFORM) {
            iLogger.info("Push button " + nameButton);
            $(By.xpath(QUESTION_FORM_SEND_BUTTON_XPATH)).click();
        }
        if (!QUESTIONFORM) {
            iLogger.info("Question form wasn't open ");
        }
    }
}
