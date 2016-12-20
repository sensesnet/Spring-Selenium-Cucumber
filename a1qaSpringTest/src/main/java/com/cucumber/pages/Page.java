package com.cucumber.pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Page {

    private static final Logger iLogger =  Logger.getLogger(Page.class);

    @Autowired
    WebDriver driver;


    @PostConstruct
    public void setUp() {
        iLogger.info("Open browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void open(String url) {
        iLogger.info("Open url" + url);
        driver.get(url);
    }


    //WebElement
    protected WebElement $(String xpath, String args) {
        iLogger.info("Method $ return element" + String.format(xpath, args));
        return driver.findElement(By.xpath(String.format(xpath, args)));
    }
    protected List<WebElement> $$(By by) {
        iLogger.info("Method $$ return list of element" );
        return driver.findElements(by);}

    protected WebElement $(By by) {
        iLogger.info("Method $ return element" );
        return driver.findElement(by);
    }

}
