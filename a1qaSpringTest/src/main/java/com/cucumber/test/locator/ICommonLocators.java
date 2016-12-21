package com.cucumber.test.locator;

/**
 * Created by KIRILL on 17.09.2016.
 */
public interface ICommonLocators {

    //location_xpath
    String LANGUAGE_PULLDOWN_XPATH = "//*[@id='language_pulldown']";

    String LANGUAGE_RUSIIAN_XPATH = "//*[@id='language_dropdown']/div/a[contains(text(),%s)]";

    //for_step_1
    //*[@id='genre_tab']/span/a[@class='pulldown_desktop'][Text()='Игры']
    String MENU_GAME_LINK_XPATH = "//*[@id='genre_tab']/span";

    //for_step_2
    String MENU_ACTION_LINK_XPATH ="//*[@id='genre_flyout']/div/a[14]";

    //for_step_3
    String MENU_SECTION_LINK_XPATH ="//*[@id='tab_select_Discounts']/div";

    //for_step_4

    String DISCOUNT_GAME_XPATH = "//*[@id='DiscountsRows']/a[%S]/div[1]/img";

    String LIST_VALUE_OF_SALE_XPATH ="//*[@id='DiscountsRows']/a/div[2]/div[1]";

    String LIST_VALUE_OF_PRIZE_XPATH ="//*[@id='DiscountsRows']/a/div[2]/div[2]/div[1]";

    String LIST_VALUE_OF_PRIZE_WITH_SALE_XPATH ="//*[@id='DiscountsRows']/a/div[2]/div[2]/div[2]";

    // for_step_4.1_

    String QUESTION_FORM_XPATH = "//*[@id='agecheck_form']/h2";

    String QUESTION_FORM_BD_XPATH = "//*[@id='agecheck_form']/select[@name='%s']";

    String QUESTION_FORM_VALUE_XPATH ="//*[@id='agecheck_form']/select/option[@value='%s']";

    String QUESTION_FORM_SEND_BUTTON_XPATH = "//*[@id='agecheck_form']/a";

    //for_step_5

    String WEB_VALUE_OF_SALE_XPATH ="//*[@id='game_area_purchase']/div/div/div/div[1]/div[1]";
    String WEB_VALUE_OF_PRICE_WITH_SALE_XPATH ="//*[@id='game_area_purchase']/div/div/div/div[1]/div[2]/div[2]";

    //for_step_8

    String STREAM_BUTTON_XPATH = "//*[@id='global_action_menu']/div/a[contains(text(),%s)]";

    //for_step_9

    //String STREAM_SETUP_BUTTON_XPATH = "//*[@id='about_install_steam_link']/span";
    String STREAM_SETUP_BUTTON_XPATH ="//*[@id='about_install_steam_link'][@id='about_install_steam_link']";




}
