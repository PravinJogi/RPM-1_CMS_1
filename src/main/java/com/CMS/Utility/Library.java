package com.CMS.Utility;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class Library {
	
	public static void custom_Sendkeys(WebElement element,String valuetobeSent,String FiledName) {
		try {
			element.sendKeys(valuetobeSent);
			ObjectRepo.test.log(Status.PASS, FiledName+"==value send =="+valuetobeSent);
		}catch(Exception e) {
			ObjectRepo.test.log(Status.FAIL, FiledName+"==unable to send =="+valuetobeSent);
		}
	}
	public static void custom_Click(WebElement element,String FiledName) {
		try {
			element.click();;
			ObjectRepo.test.log(Status.PASS, FiledName+"==Clicked Successfully  ");
		}catch(Exception e) {
			ObjectRepo.test.log(Status.FAIL, FiledName+"==Unable to Click");
		}
	}
}
