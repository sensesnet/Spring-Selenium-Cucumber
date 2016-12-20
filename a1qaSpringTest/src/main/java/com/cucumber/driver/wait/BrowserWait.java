package com.cucumber.driver.wait;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BrowserWait extends FluentWait<WebDriver> {	

	private static final long DEFAULT_POLLING_TIMEOUT = 100;

	private static final long DEFAULT_TIMEOUT_SEC = 30;

	public BrowserWait(WebDriver driver) {
		super(driver);
		withTimeout(DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS).pollingEvery(DEFAULT_POLLING_TIMEOUT, TimeUnit.MILLISECONDS);
	}
	
	public BrowserWait(WebDriver driver, long timeoutSec) {
		super(driver);
		withTimeout(timeoutSec, TimeUnit.SECONDS).pollingEvery(DEFAULT_POLLING_TIMEOUT, TimeUnit.MILLISECONDS);
	}
	
	public BrowserWait(WebDriver driver, long timeoutSec, long pollingTimeoutMillis) {
		super(driver);
		withTimeout(timeoutSec, TimeUnit.SECONDS).pollingEvery(pollingTimeoutMillis, TimeUnit.MILLISECONDS);
	}

}
