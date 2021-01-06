package com.carlos.desafio.liferay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        if(browser != null){
            this.browser = browser;
        } else {
            this.browser = new ChromeDriver();
        }
    }


}