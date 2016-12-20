package com.cucumber.steps;


import com.cucumber.driver.wait.CustomSleeper;
import com.cucumber.entity.DataEntity;
import com.cucumber.pages.Question;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionSteps extends Step {

    private static final Logger iLogger =  Logger.getLogger(QuestionSteps.class);

    @Autowired
    Question question;

    @And("^Verify visible question about age \"([^\"]*)\"$")
    public void verifyVisibleQuestionAboutAge(String quest) throws Throwable {
        iLogger.info("STEP 6  - check Question Form " );
        question.checkQuestionForm(quest);
    }


    @When("^Set confident$")
    public void setConfident(List<DataEntity> entities) throws Throwable {
        iLogger.info("STEP 7  - set Confident Data " );
        question.setConfidentData(entities);
    }

    @And("^I press button \"([^\"]*)\"$")
    public void iPressButton(String nameButton) throws Throwable {
        iLogger.info("STEP 8  - pressButton" + nameButton);
        question.pressButton(nameButton);
        CustomSleeper.SYSTEM_SLEEPER.sleep(1000L);
    }
}
