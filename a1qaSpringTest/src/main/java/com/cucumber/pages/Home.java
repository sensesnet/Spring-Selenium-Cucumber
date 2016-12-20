package com.cucumber.pages;

import com.cucumber.driver.utility.FileDownloader;
import com.cucumber.driver.wait.CustomSleeper;
import com.cucumber.test.locator.ICommonLocators;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;


@Component
public class Home extends Page implements ICommonLocators {

    private static final Logger iLogger =  Logger.getLogger(Page.class);
    private static final String URl = "http://store.steampowered.com/";
//    private static final String URL = ResourceBundle.getBundle("resources").getString("URl");
//    private static final String locate = ResourceBundle.getBundle("resources").getString("app.locale");

    private String SALE;
    private String PRICE;
    private String PriceWithSALE;


    public void open() {
        iLogger.info("Open url from Home class" + URl);
        open(URl);
    }


    public WebElement getCategory(String name) {
        iLogger.info("getCategory from Home class -" + name);
        return $(MENU_GAME_LINK_XPATH, name);
    }

    public WebElement getOption(String optionType) {
        iLogger.info("getOption from Home class -" + optionType);
        return $(MENU_ACTION_LINK_XPATH, optionType);
    }

    public WebElement getSection(String secType) {
        iLogger.info("getSection from Home class");
        return $(MENU_SECTION_LINK_XPATH, secType);
    }

    public void choseGameWithMaxSale() {
        SALE = null;
        PRICE = null;
        PriceWithSALE = null;
        iLogger.info("choseGameWithMaxSale from Home class, take listSale listPrice listPriceWithSale ");
        List<WebElement> listSale = $$(By.xpath(LIST_VALUE_OF_SALE_XPATH));
        List<WebElement> listPrice = $$(By.xpath(LIST_VALUE_OF_PRIZE_XPATH));
        List<WebElement> listPriceWithSale = $$(By.xpath(LIST_VALUE_OF_PRIZE_WITH_SALE_XPATH));


        Integer y = Integer.valueOf(listSale.get(0).getText().replaceAll("[\\D]", ""));
        SALE = listSale.get(0).getText().replaceAll("[\\D]", "");
        PRICE = listPrice.get(0).getText().replaceAll("[\\D]", "");
        PriceWithSALE = listPriceWithSale.get(0).getText().replaceAll("[\\D]", "");

        iLogger.info("chose Game With Max Sale loop");
        int j = 0;
        for (int i = 0; i < listSale.size(); i++) {
            Integer x = Integer.valueOf(listSale.get(i).getText().replaceAll("[\\D]", ""));
            if (y < x) {
                y = x;
                    SALE = listSale.get(i).getText();
                    PRICE = listPrice.get(i).getText();
                    PriceWithSALE = listPriceWithSale.get(i).getText();
                j++;
            }
        }
        iLogger.info("push link Game With Max Sale loop");
        $(By.xpath(String.format(DISCOUNT_GAME_XPATH, Integer.toString(j + 1)))).click();

    }

    public void verifyPriceAndSale() {
        iLogger.info("verify Price And Sale "+PriceWithSALE+"USD  "+SALE+"%");
        CustomSleeper.SYSTEM_SLEEPER.sleep(5000L);
        Assert.assertEquals($(By.xpath(WEB_VALUE_OF_PRICE_WITH_SALE_XPATH)).getText().replaceAll("[\\D]", ""), PriceWithSALE);
        Assert.assertEquals($(By.xpath(WEB_VALUE_OF_SALE_XPATH)).getText().replaceAll("[\\D]", ""), SALE);

    }

    public void selectlink(String streamButton) {
        iLogger.info("select link by Home class");
        $(By.xpath(PageUtil.buildXpath(STREAM_BUTTON_XPATH, streamButton))).click();
    }

    public void saveSetupFile() throws Exception {
        CustomSleeper.SYSTEM_SLEEPER.sleep(10000L);

//        $(By.xpath(STREAM_SETUP_BUTTON_XPATH)).click();
//        save and check
//        String workingDirectory = System.getProperty("user.dir");
//        String absoluteDirectory = workingDirectory + File.separator + "SteamSetup.exe";
//        File termsAndConditions = new File(absoluteDirectory);


        FileDownloader fileDownloader = new FileDownloader(driver);
        //fileDownloader.setURI("https://steamcdn-a.akamaihd.net/client/installer/SteamSetup.exe");
        fileDownloader.setURI($(By.xpath(STREAM_SETUP_BUTTON_XPATH)).getAttribute("href"));
        File steamFile = fileDownloader.downloadFile();
        String tempLocation = steamFile.getAbsolutePath();
        iLogger.info("TEMP File Location :"+steamFile.getAbsolutePath());
        iLogger.info("TEMP File Name :"+steamFile.getName());
        int httpStatusCode = fileDownloader.getLastDownloadHTTPStatus();
        Assert.assertTrue(steamFile.exists());
        Assert.assertEquals(httpStatusCode, 200);

        //change_location and name
        iLogger.info("Your file saved C:/SteamSetup.exe");
        steamFile.renameTo(new File("C:\\SteamSetup.exe"));
        //delete temp file
        new File(tempLocation).delete();
        //JOptionPane.showMessageDialog (null, "Your file saved C:/SteamSetup.exe", "File saved", JOptionPane.INFORMATION_MESSAGE);
        //Assert.assertEquals(getFileHash(termsAndConditions, SHA1), ("bfbc857f1496a126f1703273e3d62a35cffdd34c"));
        CustomSleeper.SYSTEM_SLEEPER.sleep(10000L);
    }


//    @After("@a1qa")
//    public void tearDown() {
//        driver.close();
//    }


}
