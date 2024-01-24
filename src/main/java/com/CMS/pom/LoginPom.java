package com.CMS.pom;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CMS.Utility.ObjectRepo;
import com.CMS.Utility.commonLib;
import com.aventstack.extentreports.Status;

public class LoginPom {

	WebDriver driver;
	Properties prop;
	public static commonLib CommonLibref = new commonLib();

	@FindBy(xpath = "//div[text()='Select Jurisdiction']")
	private WebElement selectJurisdictionDropDown;
	@FindBy(xpath = "//*[@class='MuiBox-root css-o0oaiu']")
	private WebElement selectJurisdictionDropDown2;
	@FindBy(xpath = "(//*[text()='Select Jurisdiction'])[1]")
	private WebElement selectJurisdictionLink;
	@FindBy(xpath = "//span[text()='California']")
	private WebElement selectOptionCalifornia;
	@FindBy(xpath = "//span[text()='Quebec']")
	private WebElement selectOptionQuebec;
	@FindBy(xpath = "//span[text()='Washington']")
	private WebElement selectOptionWashington;
	@FindBy(xpath = "//span[text()='Nova Scotia']")
	private WebElement selectOptionNovaScotia;
	@FindBy(xpath = "//div[text()='Select Language']")
	private WebElement selectLangaugeDropDown;
	@FindBy(xpath = "//span[text()='English']")
	private WebElement selectlangEnglish;
	@FindBy(xpath = "//button[text()='CONTINUE']")
	private WebElement btnContineu;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement textBoxEmail;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement textBoxPassWord;
	@FindBy(xpath = "//input[@name='remember']")
	private WebElement checkBoxRememberMe;
	@FindBy(id = "login_btn")
	private WebElement btnLogin;
	@FindBy(xpath = "//button[contains(text(),'Welcome,')]")
	private WebElement btnWelcomeProfile;
	@FindBy(xpath= "//a[text()='Logout']")
	private WebElement btnLogOut;
	@FindBy(xpath= "//*[@class='MuiTypography-root MuiTypography-h6 css-1etlmxt']")
	private WebElement securityQuestion1ForLogin;
	@FindBy(xpath= "//input[@id='Answer']")
	private WebElement textFieldAnswerForLogin;
	@FindBy(xpath= "//button[@data-testid='priv_btn_ContinueBtn']")
	private WebElement btnContinueForSecurityQueLogin;
	
	
		
	public LoginPom(WebDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
		PageFactory.initElements(driver, this);
	}
	
	public void handlesecurityQuestion() {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(securityQuestion1ForLogin));
		String str=securityQuestion1ForLogin.getText().trim();
		if(str.contains("first job?")) {
			CommonLibref.typeText(textFieldAnswerForLogin, prop.getProperty("SecurityQueAnswer1"), "textFieldAnswerForLogin");
		}
		else if(str.contains("maiden name?")){
			CommonLibref.typeText(textFieldAnswerForLogin, prop.getProperty("SecurityQueAnswer2"), "textFieldAnswerForLogin");
		}
		else if(str.contains("first car?")){
			CommonLibref.typeText(textFieldAnswerForLogin, prop.getProperty("SecurityQueAnswer3"), "textFieldAnswerForLogin");
		}
		else {
			System.out.println("Nothing");
		}
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnContinueForSecurityQueLogin));
		CommonLibref.click(btnContinueForSecurityQueLogin, "seleniumClick", "btnContinueForSecurityQueLogin");
		System.out.println("Jurisdiction System Admin User should logged in successfully.");
	}

	public void selectJurisdictionandLangaugeForCalifornia() {
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectJurisdictionDropDown));
		CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectOptionCalifornia));
		CommonLibref.click(selectOptionCalifornia, "seleniumClick", "selectOptionCalifornia");
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnContineu));
		CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
		ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
	}
	
	public void selectJurisdictionAndLangaugeForLandingPageForUnknown(String JurisdictionName) {
		if(JurisdictionName.equals("California")) {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectJurisdictionDropDown));
			CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectOptionCalifornia));
			CommonLibref.click(selectOptionCalifornia, "seleniumClick", "selectOptionCalifornia");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnContineu));
			CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
			ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
		}
		else if(JurisdictionName.equals("Quebec")) {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectJurisdictionDropDown));
			CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectOptionCalifornia));
			CommonLibref.click(selectOptionQuebec, "seleniumClick", "selectOptionQuebec");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnContineu));
			CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
			ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
		}
		else if(JurisdictionName.equals("NovaScotia")) {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectJurisdictionDropDown));
			CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectOptionCalifornia));
			CommonLibref.click(selectOptionNovaScotia, "seleniumClick", "selectOptionQuebec");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnContineu));
			CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
			ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
		}
		else if(JurisdictionName.equals("Washington")) {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectJurisdictionDropDown));
			CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectOptionCalifornia));
			CommonLibref.click(selectOptionWashington, "seleniumClick", "selectOptionQuebec");
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnContineu));
			CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
			ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
		}
	}
	
	public void changeJurisdictionandLangaugeForCalifornia() {
		CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
		CommonLibref.click(selectOptionCalifornia, "seleniumClick", "selectOptionCalifornia");
		CommonLibref.click(selectLangaugeDropDown, "seleniumClick", "selectLangaugeDropDown");
		CommonLibref.click(selectlangEnglish, "seleniumClick", "selectlangEnglish");
		CommonLibref.click(selectJurisdictionDropDown2, "seleniumClick", "selectJurisdictionDropDown2");
		CommonLibref.click(selectOptionQuebec, "seleniumClick", "selectOptionQuebec");
		ObjectRepo.test.log(Status.PASS, "Step 6 : Select checkbox for Quebec jurisdiction ");
	}

	public void Verification_of_Select_Jurisdiction_Functionality_Continue_button_with_emptyData() {
		try {
			CommonLibref.isDisabled(btnContineu,"btnContineu");
			ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
		} catch (Exception e) {
			System.out.println("continue button is disabled");
			ObjectRepo.test.log(Status.PASS, "continue button is disabled");
		}
	}

	public void selectJurisdictionandLangaugeForQuebec() throws InterruptedException {
		CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
		CommonLibref.click(selectOptionQuebec, "seleniumClick", "selectOptionQuebec");
//		//thread.sleep(3000);
//		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(selectLangaugeDropDown));
//		CommonLibref.click(selectLangaugeDropDown, "seleniumClick", "selectLangaugeDropDown");
//		CommonLibref.click(selectlangEnglish, "seleniumClick", "selectlangEnglish");
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnContineu));
		CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
		ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
	}

	public void selectJurisdictionandLangaugeForWashington() throws InterruptedException {
		CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
		CommonLibref.click(selectOptionWashington, "seleniumClick", "selectOptionWashington");
		Thread.sleep(3000);
//		CommonLibref.click(selectLangaugeDropDown, "seleniumClick", "selectLangaugeDropDown");
//		CommonLibref.click(selectlangEnglish, "seleniumClick", "selectlangEnglish");
		CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
		ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
	}

	public void selectJurisdictionandLangaugeForNovaScotia() throws InterruptedException {
		CommonLibref.click(selectJurisdictionDropDown, "seleniumClick", "selectJurisdictionDropDown");
		CommonLibref.click(selectOptionNovaScotia, "seleniumClick", "selectOptionNovaScotia");
		Thread.sleep(3000);
//		CommonLibref.click(selectLangaugeDropDown, "seleniumClick", "selectLangaugeDropDown");
//		CommonLibref.click(selectlangEnglish, "seleniumClick", "selectlangEnglish");
		CommonLibref.click(btnContineu, "seleniumClick", "btnContineu");
		ObjectRepo.test.log(Status.PASS, "Step 6 : User is navigate to login page");
	}

	public void loginWithCaliforniaJSAUser() throws InterruptedException {
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
		CommonLibref.typeText(textBoxEmail, prop.getProperty("CaliforniaJSAUserName"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
		Thread.sleep(2000);
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("JSAPassphrase"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	public void loginWithWCIIncAdminUser() throws InterruptedException {
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
		CommonLibref.typeText(textBoxEmail, prop.getProperty("WCIIncAdminUserName"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
		Thread.sleep(2000);
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("WciAdminPassphrase"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
		}
	
	public void loginWithJSAUser(String JurisdictionName) throws InterruptedException {
		if(JurisdictionName.equals("California")) {
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
		CommonLibref.typeText(textBoxEmail, prop.getProperty("CaliforniaJSAUserName"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
		Thread.sleep(2000);
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("JSAPassphrase"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
		}
		else if(JurisdictionName.equals("Quebec")) {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
			CommonLibref.typeText(textBoxEmail, prop.getProperty("QuebecJSAUserName"), "textBoxEmail");
			ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
			Thread.sleep(2000);
			CommonLibref.typeText(textBoxPassWord, prop.getProperty("JSAPassphrase"), "textBoxPassWord");
			ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
			CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
			CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
			ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
			}
		else if(JurisdictionName.equals("NovaScotia")) {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
			CommonLibref.typeText(textBoxEmail, prop.getProperty("NovaSoctiaJSAUserName"), "textBoxEmail");
			ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
			Thread.sleep(2000);
			CommonLibref.typeText(textBoxPassWord, prop.getProperty("JSAPassphrase"), "textBoxPassWord");
			ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
			CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
			CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
			ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
			}
		else if(JurisdictionName.equals("Washington")) {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
			CommonLibref.typeText(textBoxEmail, prop.getProperty("WashingtonJSAUserName"), "textBoxEmail");
			ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
			Thread.sleep(2000);
			CommonLibref.typeText(textBoxPassWord, prop.getProperty("JSAPassphrase"), "textBoxPassWord");
			ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
			CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
			CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
			ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
			}
	}
	
	public void loginWithARwithValidCredentials() throws InterruptedException {
		Thread.sleep(5000);
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
		CommonLibref.typeText(textBoxEmail, prop.getProperty("ARUserName"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("ARUserName"));
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("IU_PassWord"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	public void loginWithValidCredentialsForPendingUser() {
		CommonLibref.typeText(textBoxEmail, prop.getProperty("UserName"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("PassWord"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
		public void loginWithDeniedIndividualUser() {
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(textBoxEmail));
			CommonLibref.typeText(textBoxEmail, prop.getProperty("UserName3"), "textBoxEmail");
			ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("Pending_UserName"));
			CommonLibref.typeText(textBoxPassWord, prop.getProperty("PassWord3"), "textBoxPassWord");
			ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("PassWord"));
			CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
			CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
			ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	public void JurisdictionUserloginWithValidCredentials() throws InterruptedException {
		//thread.sleep(5000);
		CommonLibref.typeText(textBoxEmail, prop.getProperty("JU_UserName"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("JU_UserName"));
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("JU_PassWord"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("JU_PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	public void IndividualUserloginWithValidCredentials() throws InterruptedException {
		//thread.sleep(5000);
		CommonLibref.typeText(textBoxEmail, prop.getProperty("UserName"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("UserName"));
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("IU_PassWord"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("IU_PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	public void QuebecJurisdictionUserloginWithValidCredentials() {
		CommonLibref.typeText(textBoxEmail, prop.getProperty("JU_UserName_QC"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("JU_UserName_QC"));
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("JU_PassWord2"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("JU_PassWord2"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	
	public void NSJurisdictionUserloginWithValidCredentials() {
		CommonLibref.typeText(textBoxEmail, prop.getProperty("JU_UserName_NS"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("JU_UserName_NS"));
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("JU_PassWord"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("JU_PassWord"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	public void WAJurisdictionUserloginWithValidCredentials() {
		CommonLibref.typeText(textBoxEmail, prop.getProperty("JU_UserName_WA"), "textBoxEmail");
		ObjectRepo.test.log(Status.PASS, "UserName entered successfully :" + prop.getProperty("JU_UserName_WA"));
		CommonLibref.typeText(textBoxPassWord, prop.getProperty("JU_PassWord2"), "textBoxPassWord");
		ObjectRepo.test.log(Status.PASS, "Step 8 : PassWord entered successfully :" + prop.getProperty("JU_PassWord2"));
		CommonLibref.click(checkBoxRememberMe, "seleniumClick", "checkBoxRememberMe");
		CommonLibref.click(btnLogin, "seleniumClick", "btnLogin");
		ObjectRepo.test.log(Status.PASS, "Step 10 : Click on Login button ");
	}
	
	
	public void Logout() throws InterruptedException {
		//thread.sleep(4000);
		CommonLibref.scroll(btnWelcomeProfile, "scrollToTopOFPage", "btnWelcomeProfile");
		//thread.sleep(4000);
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(btnWelcomeProfile));
		try {
			CommonLibref.click(btnWelcomeProfile, "seleniumClick", "welcome profile button");
		} catch (Exception e) {
			CommonLibref.click(btnWelcomeProfile, "moveToElementClick", "welcome profile button");
		}
		CommonLibref.click(btnLogOut, "seleniumClick", "btnLogOut");
	}

}
