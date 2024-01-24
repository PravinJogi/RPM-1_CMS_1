package com.CMS.Utility;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends commonLib {

	private By securityQuestion1ForLogin = By.xpath("//*[@class='MuiTypography-root MuiTypography-h6 css-1etlmxt']");
	private By answerField = By.xpath("//input[@id='Answer']");
	private By continueButtonForLogin = By.xpath("//button[text()='CONTINUE']");

	public CommonMethods() {
		PageFactory.initElements(driver, this);
	}

	public void handlesecurityQuestion() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(securityQuestion1ForLogin));
		String str = driver.findElement(securityQuestion1ForLogin).getText().trim();
		if (str.contains("first job?")) {
			try {
				driver.findElement(answerField).sendKeys("aaaa");
			} catch (Exception e) {
				driver.findElement(answerField).sendKeys("Answer1");
			}
		} else if (str.contains("maiden name?")) {
			try {
				driver.findElement(answerField).sendKeys("bbbb");
			} catch (Exception e) {
				driver.findElement(answerField).sendKeys("Answer2");
			}
		} else if (str.contains("first car?")) {
			try {
				driver.findElement(answerField).sendKeys("cccc");
			} catch (Exception e) {
				driver.findElement(answerField).sendKeys("Answer3");
			}
		} else {
			System.out.println("Nothing");
		}
		driver.findElement(continueButtonForLogin).click();
		System.out.println("Registrar User should logged in successfully.");
	}

	public void handlesecurityQuestion2() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(securityQuestion1ForLogin));
		String str = driver.findElement(securityQuestion1ForLogin).getText().trim();
		if (str.contains("first job?")) {

			driver.findElement(answerField).sendKeys("Answer1");

		} else if (str.contains("maiden name?")) {

			driver.findElement(answerField).sendKeys("Answer2");

		} else if (str.contains("first car?")) {

			driver.findElement(answerField).sendKeys("Answer3");

		} else {
			System.out.println("Nothing");
		}
		driver.findElement(continueButtonForLogin).click();
		System.out.println("Registrar User should logged in successfully.");
	}
}