package com.CMS.pom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CMS.Utility.GetDataInExcel;
import com.CMS.Utility.ObjectRepo;
import com.CMS.Utility.TestBase;
import com.CMS.Utility.commonLib;
import com.aventstack.extentreports.Status;

public class FunctionalityPom {

	
	WebDriver driver;
	Properties prop;
	public static commonLib CommonLibref = new commonLib();
	public static String beforEditFirstRowValuesOfBaseLang;
	public static String beforEditSecondRowValuesOfBaseLang;

	@FindBy(xpath = "//div[text()='Select Jurisdiction']")
	private WebElement selectJurisdictionDropDown;
	@FindBy(xpath = "//button[text()='SETTINGS']")
	private WebElement menuBarOptionSettings;
	@FindBy(xpath = "//*[text()='Content Management System']")
	private WebElement optionContentManagementSystem;
	@FindBy(xpath = "//*[text()='Page Content']")
	private WebElement accordionPageContent;
	@FindBy(xpath = "(//div[@id='languagePage'])[2]")
	private WebElement dropdownSelectLangFromPageConetent;
	@FindBy(xpath = "//li[@data-value='English#L001']")
	private WebElement optionEnglishLang;
	@FindBy(xpath = "(//input[@id='page-select-demo'])[1]")
	private WebElement dropdownSelectPageFromValuesAccrodian;
	@FindBy(xpath = "(//input[@id='page-select-demo'])[2]")
	private WebElement dropdownSelectPageFromPageContent;
	@FindBy(xpath = "//*[text()='Page_ContactUs']")
	private WebElement optionContactUsPage;
	@FindBy(xpath = "(//button[@data-testid='submitBtn'])[2]")
	private WebElement btnSearchFromPageContent;
	@FindBy(xpath = "(//button[@data-testid='cancelBtn'])[2]")
	private WebElement btnResetFromPageContent;
	@FindBy(xpath = "(//*[@class='MuiTypography-root MuiTypography-body1 css-19m7xuu'])[2]")
	private WebElement sectionNameDisplayedIIconTable;
	@FindBy(xpath = "(//*[text()='Columns'])[1]")
	private WebElement columnsOptionFromDisplayedTable;
	@FindBy(xpath = "(//*[text()='Columns'])[2]")
	private WebElement columnsOptionFromDisplayedIIconTable;
	@FindBy(xpath = "(//*[text()='Filters'])[2]")
	private WebElement filtersOptionFromDisplayedIIconTable;
	@FindBy(xpath = "(//*[text()='Export'])[2]")
	private WebElement exportOptionFromDisplayedIIconTable;
	@FindBy(xpath = "(//input[@placeholder='Search…'])[2]")
	private WebElement searchBarFromDisplayedIIconTable;
	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement btnEditFromPageContent;

	@FindBy(xpath = "//div[text()='Displayed Next to Label']")
	private WebElement displayedNextToLabelColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//div[text()='Key'])[2]")
	private WebElement keyColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//div[text()='Description'])[2]")
	private WebElement descriptionColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//div[text()='Default English'])[2]")
	private WebElement defaultEnglishColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//div[text()='Base Language English'])[2]")
	private WebElement baseLangEnglishColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//div[text()='Jurisdiction Localization'])[2]")
	private WebElement jurisdictionLocalizationColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//div[text()='Displayed'])[2]")
	private WebElement displayedColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//div[text()='Page'])[2]")
	private WebElement pageColumFromDisplayedIIcaonTable;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[1]")
	private WebElement hideButtonForKeyFromDisplayedtable;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[2]")
	private WebElement hideButtonForKey;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[3]")
	private WebElement hideButtonForDescription;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[4]")
	private WebElement hideButtonForDefaultEnglish;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[5]")
	private WebElement hideButtonForBaseLangEnglish;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[7]")
	private WebElement unhideQuebecJurisdictionLocalization;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[8]")
	private WebElement unhideNovaScotiaJurisdictionLocalization;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[9]")
	private WebElement unhideWashingtonJurisdictionLocalization;
	@FindBy(xpath = "(//span[@class='MuiSwitch-thumb css-19gndve'])[9]")
	private WebElement unhideDisplayedColoumnFromDisplayedTable;

	@FindBy(xpath = "//button[text()='CANCEL']")
	private WebElement btnCancelForPageContentAccordion;
	@FindBy(xpath = "//button[text()='SAVE']")
	private WebElement btnSaveForPageContentAccordion;
	@FindBy(xpath = "//button[text()='PUBLISH']")
	private WebElement btnPublsihForPageContentAccordion;
	@FindBy(xpath = "(//label[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-animated MuiFormLabel-colorPrimary MuiInputLabel-root MuiInputLabel-animated css-xya7en'])[2]")
	private WebElement labelSelectALangFromPageContent;
	@FindBy(xpath = "(//label[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-animated MuiFormLabel-colorPrimary MuiInputLabel-root MuiInputLabel-animated css-kz4215'])[2]")
	private WebElement labelSelectAPageFromPageContent;
	@FindBy(xpath = "(//label[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-animated MuiFormLabel-colorPrimary MuiInputLabel-root MuiInputLabel-animated css-kz4215'])[1]")
	private WebElement labelSelectAPageFromValuesAccordian;
	@FindBy(xpath = "//div[text()='Quebec Localization']")
	private WebElement quebecLocalizationColumnFromDisplayedIIcaonTable;
	@FindBy(xpath = "//div[text()='Washington Localization']")
	private WebElement washingtonLocalizationColumnFromDisplayedIIcaonTable;
	@FindBy(xpath = "//div[text()='Nova Scotia Localization']")
	private WebElement novaScotiatonLocalizationColumnFromDisplayedIIcaonTable;
	@FindBy(xpath = "//div[@class='MuiDataGrid-cell MuiDataGrid-cell--textLeft']")
	private WebElement pageName;
	@FindBy(xpath = "//button[text()='Hide all']")
	private WebElement btnHideAll;

	@FindBy(xpath = "//*[text()='Values']")
	private WebElement accordionValues;
	@FindBy(xpath = "//button[text()='Search by Displayed Value']")
	private WebElement tabSearchByDisplayedFromValuesAccordion;
	@FindBy(xpath = "//button[text()='Search by Key or Value']")
	private WebElement tabSearchByKeyOrValueFromValuesAccordion;
	@FindBy(xpath = "//button[text()='Search by Displayed Value']")
	private WebElement tabSearchByPageFromValuesAccordion;
	
	@FindBy(xpath = "(//label[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-animated MuiFormLabel-colorPrimary MuiInputLabel-root MuiInputLabel-animated css-xya7en'])[1]")
	private WebElement labelSelectlangFromValuesAccordion;
	@FindBy(xpath = "//label[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-animated MuiFormLabel-colorPrimary MuiInputLabel-root MuiInputLabel-animated css-1vx7545']")
	private WebElement labelSearchByDisplayedDropdown;
	@FindBy(xpath = "(//label[@class='MuiFormLabel-root MuiInputLabel-root MuiInputLabel-animated MuiFormLabel-colorPrimary MuiInputLabel-root MuiInputLabel-animated css-1nqub2m'])[1]")
	private WebElement labelSearchByKeyOrValueDropdown;
	@FindBy(xpath = "(//button[@data-testid='cancelBtn'])[1]")
	private WebElement btnResetFromValuesAccordion;
	@FindBy(xpath = "(//button[@data-testid='submitBtn'])[1]")
	private WebElement btnPublishFromValuesAccordion;
	@FindBy(xpath = "//div[@id='languageDisplayValue']")
	private WebElement fieldSelectLanguageFromValuesAccordion;
	@FindBy(xpath = "(//div[@id='languagePage'])[1]")
	private WebElement fieldSelectLanguageFromValuesAccordionForSelectAPageTab;
	@FindBy(xpath = "//div[@id='languageKeyValue']")
	private WebElement fieldSelectLanguageFromValuesAccordionForDisplayedKeyOrvalueTab;
	@FindBy(xpath = "//input[@id='searchDisplayedValue']")
	private WebElement fieldSearchDisplayedFromValuesAccordion;
	@FindBy(xpath = "//input[@id='searchkeyValue']")
	private WebElement fieldSearchbyKeyOrValueFromValuesAccordion;
	@FindBy(xpath = "//*[@data-testid='more-actions']")
	private WebElement btnMoreActionsFromValuesAccordion;
	@FindBy(xpath = "//div[text()='Key']")
	private WebElement keyColumnNameOfValuesAccordionByWCIAdmin;
	@FindBy(xpath = "//div[text()='Description']")
	private WebElement descriptionColumnNameOfValuesAccordionByWCIAdmin;
	@FindBy(xpath = "//div[text()='Default English']")
	private WebElement defaultEnglishColumnNameOfValuesAccordionByWCIAdmin;
	@FindBy(xpath = "//div[text()='Base Language English']")
	private WebElement baseLangEnglishColumnNameOfValuesAccordionByWCIAdmin;
	@FindBy(xpath = "//div[text()='Page']")
	private WebElement pageColumnNameOfValuesAccordionByWCIAdmin;
	@FindBy(xpath = "//button[text()='SAVE']")
	private WebElement btnSaveButton;
	@FindBy(xpath = "//button[text()='PUBLISH']")
	private WebElement btnPublishButton;
	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body2 css-1eifdk0']")
	private WebElement successMessage;
	@FindBy(xpath = "(//*[@data-testid='CloseIcon'])[4]")
	private WebElement btnCrossForSuccessMessage;
	@FindBy(xpath = "(//*[@data-testid='CloseIcon'])[3]")
	private WebElement btnCrossForSuccessMessageForWciAdmin;
	
	@FindBy(xpath = "(//div[@data-field='displayedValue'])[2]")
	private WebElement displayedValue1Row;
	@FindBy(xpath = "(//div[@data-field='displayedValue'])[3]")
	private WebElement displayedValue2Row;
	@FindBy(xpath = "(//div[@data-field='displayedValue'])[4]")
	private WebElement displayedValue3Row;
	@FindBy(xpath = "(//*[@class='MuiFormControl-root css-13sljp9'])[3]")
	private WebElement rowPerPageDropdownForDisplayeTableOfpageAccrodian;
	@FindBy(xpath = "//li[@data-value='100']")
	private WebElement pageSelectAS100;
	@FindBy(xpath = "//*[text()='EDIT']")
	private WebElement btnEditForValuesAccordian;
	@FindBy(xpath = "//*[text()='SEARCH AND REPLACE ALL VALUES']")
	private WebElement btnSearchAndReplaceAllValuesForValuesAccordian;
	@FindBy(xpath = "//*[text()='RESET SEARCH']")
	private WebElement btnResetSearchForValuesAccordian;
	@FindBy(xpath = "//div[text()='Jurisdiction Localization']")
	private WebElement jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordian;
	@FindBy(xpath = "//div[text()='Displayed']")
	private WebElement displayedColumFromDisplayedTableOfValuesAccordian;
	
	@FindBy(xpath = "//*[text()='Displayed Value']")
	private WebElement displayedValueTableSectionName;
	@FindBy(xpath = "//*[text()='INFORMATIONAL CONTENT']")
	private WebElement informationalContentSectionName;
	@FindBy(xpath = "//*[text()='TOAST MESSAGES']")
	private WebElement toastMessagesSectionName;
	
	 
	

	public FunctionalityPom(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
	
	
	public void editOneValuesFromBaselanguageColumnByWCIadmin() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		beforEditFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(beforEditFirstRowValuesOfBaseLang, beforEditFirstRowValuesOfBaseLang,"Before edit the value is ="+beforEditFirstRowValuesOfBaseLang, "Before edit the value is ="+beforEditFirstRowValuesOfBaseLang);
		System.out.println("Before edit the value is ="+beforEditFirstRowValuesOfBaseLang);
		CommonLibref.scroll(displayedValue1Row, "scrollToElement", "displayedValue1Row");
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue1Row));
		CommonLibref.click(displayedValue1Row, "seleniumClick", "displayedValue1Row");
		Actions act = new Actions(driver);
		act.doubleClick(displayedValue1Row).sendKeys(displayedValue1Row, "\b").build().perform();
		String enterNewValue = beforEditFirstRowValuesOfBaseLang+"_New";
		act.click(displayedValue1Row).sendKeys(enterNewValue).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue2Row));
		CommonLibref.click(displayedValue2Row, "javascriptClick", "displayedValue2Row");
		String afterEditFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(afterEditFirstRowValuesOfBaseLang, enterNewValue,"After edit the value is =" + afterEditFirstRowValuesOfBaseLang, "After edit the value is =" + afterEditFirstRowValuesOfBaseLang);
		System.out.println("After edit the value is =" + afterEditFirstRowValuesOfBaseLang);
	}
	
	public void editMoreValuesFromBaselanguageColumnByWCIadmin() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		beforEditFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(beforEditFirstRowValuesOfBaseLang, beforEditFirstRowValuesOfBaseLang,"Before edit the value is ="+beforEditFirstRowValuesOfBaseLang, "Before edit the value is ="+beforEditFirstRowValuesOfBaseLang);
		System.out.println("Before edit the value is ="+beforEditFirstRowValuesOfBaseLang);
		CommonLibref.scroll(displayedValue1Row, "scrollToElement", "displayedValue1Row");
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue1Row));
		CommonLibref.click(displayedValue1Row, "seleniumClick", "displayedValue1Row");
		Actions act = new Actions(driver);
		act.doubleClick(displayedValue1Row).sendKeys(displayedValue1Row, "\b").build().perform();
		String enterNewValue = beforEditFirstRowValuesOfBaseLang+"_New";
		act.click(displayedValue1Row).sendKeys(enterNewValue).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue2Row));
		CommonLibref.click(displayedValue2Row, "javascriptClick", "displayedValue2Row");
		String afterEditFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(afterEditFirstRowValuesOfBaseLang, enterNewValue,"After edit the value is =" + afterEditFirstRowValuesOfBaseLang, "After edit the value is =" + afterEditFirstRowValuesOfBaseLang);
		System.out.println("After edit the value is =" + afterEditFirstRowValuesOfBaseLang);
		beforEditSecondRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue2Row);
		CommonLibref.verifyTextTypeString(beforEditSecondRowValuesOfBaseLang, beforEditSecondRowValuesOfBaseLang,"Before edit the value is ="+beforEditSecondRowValuesOfBaseLang, "Before edit the value is ="+beforEditSecondRowValuesOfBaseLang);
		System.out.println("Before edit the value is ="+beforEditSecondRowValuesOfBaseLang);
		CommonLibref.scroll(displayedValue2Row, "scrollToElement", "displayedValue2Row");
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue2Row));
		CommonLibref.click(displayedValue2Row, "seleniumClick", "displayedValue2Row");
		act.doubleClick(displayedValue2Row).sendKeys(displayedValue2Row, "\b").build().perform();
		String enterNewValuein2ndRow = beforEditSecondRowValuesOfBaseLang+"_New";
		act.click(displayedValue2Row).sendKeys(enterNewValuein2ndRow).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue2Row));
		CommonLibref.click(displayedValue2Row, "javascriptClick", "displayedValue2Row");
		CommonLibref.click(displayedValue3Row, "seleniumClick", "displayedValue3Row");
		wait.until(ExpectedConditions.visibilityOf(displayedValue3Row));
		String afterEditSecondRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue2Row);
		CommonLibref.verifyTextTypeString(afterEditSecondRowValuesOfBaseLang, enterNewValuein2ndRow,"After edit the value is =" + afterEditSecondRowValuesOfBaseLang, "After edit the value is =" + afterEditSecondRowValuesOfBaseLang);
		System.out.println("After edit the value is =" + afterEditSecondRowValuesOfBaseLang);
	}
	
	public void reverseTheEditAndSaveValues() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(btnEditForValuesAccordian));
		CommonLibref.click(btnEditForValuesAccordian, "seleniumClick", "btnEditForValuesAccordian");
		String reveseValueBeforeEdit = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(reveseValueBeforeEdit, reveseValueBeforeEdit,"Before edit the value is ="+reveseValueBeforeEdit, "Before edit the value is ="+reveseValueBeforeEdit);
		System.out.println("Before edit the value is ="+reveseValueBeforeEdit);
		CommonLibref.scroll(displayedValue1Row, "scrollToElement", "displayedValue1Row");
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue1Row));
		CommonLibref.click(displayedValue1Row, "seleniumClick", "displayedValue1Row");
		Actions act = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue1Row));
		act.doubleClick(displayedValue1Row).sendKeys(displayedValue1Row, "\b").build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue1Row));
		act.click(displayedValue1Row).sendKeys(beforEditFirstRowValuesOfBaseLang).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(displayedValue2Row));
		CommonLibref.click(displayedValue2Row, "javascriptClick", "displayedValue2Row");
		CommonLibref.scroll(btnResetFromPageContent, "scrollToElement", "btnResetFromPageContent");
		CommonLibref.click(btnResetFromPageContent, "javascriptClick", "btnResetFromPageContent");
		System.out.println("Step: Click on 'Save' Button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on 'Save' Button");
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		String successMessageActual = CommonLibref.getTextElement(successMessage);
		CommonLibref.verifyTextTypeString(successMessageActual, "Saved edited keys successfully","Success message is ="+ successMessageActual, "Success message is ="+ successMessageActual);
		System.out.println("Success message is ="+ successMessageActual);
		wait.until(ExpectedConditions.elementToBeClickable(btnCrossForSuccessMessageForWciAdmin));
		btnCrossForSuccessMessageForWciAdmin.click();
		CommonLibref.scroll(displayedValue1Row, "scrollToTopOFPage", "displayedValue1Row");
		wait.until(ExpectedConditions.visibilityOf(displayedValue1Row));
		String afterSaveFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(afterSaveFirstRowValuesOfBaseLang, afterSaveFirstRowValuesOfBaseLang,"After Save the value is ="+ afterSaveFirstRowValuesOfBaseLang, "After Save the value is ="+ afterSaveFirstRowValuesOfBaseLang);
		System.out.println("After Save the value is ="+ afterSaveFirstRowValuesOfBaseLang);
	}
	
	public void saveButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		String beforSaveFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(beforSaveFirstRowValuesOfBaseLang, beforSaveFirstRowValuesOfBaseLang,"After editing and Before Save the value is =" +beforSaveFirstRowValuesOfBaseLang, "After editing and Before Save the value is =" +beforSaveFirstRowValuesOfBaseLang);
		System.out.println("After editing and Before Save the value is =" +beforSaveFirstRowValuesOfBaseLang);
		CommonLibref.scroll(btnResetFromPageContent, "scrollToElement", "btnResetFromPageContent");
		CommonLibref.click(btnResetFromPageContent, "javascriptClick", "btnResetFromPageContent");
		System.out.println("Step: Click on 'Save' Button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on 'Save' Button");
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		String successMessageActual = CommonLibref.getTextElement(successMessage);
		CommonLibref.verifyTextTypeString(successMessageActual, "Saved edited keys successfully","Success message is ="+ successMessageActual, "Success message is ="+ successMessageActual);
		System.out.println("Success message is ="+ successMessageActual);
		wait.until(ExpectedConditions.elementToBeClickable(btnCrossForSuccessMessageForWciAdmin));
		btnCrossForSuccessMessageForWciAdmin.click();
		CommonLibref.scroll(displayedValue1Row, "scrollToTopOFPage", "displayedValue1Row");
		wait.until(ExpectedConditions.visibilityOf(displayedValue1Row));
		String afterSaveFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(afterSaveFirstRowValuesOfBaseLang, afterSaveFirstRowValuesOfBaseLang,"After Save the value is ="+ afterSaveFirstRowValuesOfBaseLang, "After Save the value is ="+ afterSaveFirstRowValuesOfBaseLang);
		System.out.println("After Save the value is ="+ afterSaveFirstRowValuesOfBaseLang);
	}
	
	public void cancelButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage() throws InterruptedException {
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		String beforcancelFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(beforcancelFirstRowValuesOfBaseLang, beforcancelFirstRowValuesOfBaseLang,"After editing and Before Cancel the value is =" +beforcancelFirstRowValuesOfBaseLang, "After editing and Before Cancel the value is =" +beforcancelFirstRowValuesOfBaseLang);
		System.out.println("After editing and Before Cancel the value is =" +beforcancelFirstRowValuesOfBaseLang);
		CommonLibref.scroll(btnResetFromValuesAccordion, "scrollToElement", "btnResetFromValuesAccordion");
		CommonLibref.click(btnResetFromValuesAccordion, "javascriptClick", "btnResetFromValuesAccordion");
		System.out.println("Step: Click on 'CANCEL' Button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on 'CANCEL' Button");
		String afterCancelFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(afterCancelFirstRowValuesOfBaseLang, beforEditFirstRowValuesOfBaseLang,"After cancel the value is ="+ afterCancelFirstRowValuesOfBaseLang, "After cancel the value is ="+ afterCancelFirstRowValuesOfBaseLang);
		System.out.println("After cancel the value is ="+ afterCancelFirstRowValuesOfBaseLang);
		CommonLibref.scroll(displayedValue1Row, "scrollToTopOFPage", "displayedValue1Row");
	}
	
	public void editOneValuesFromBaselanguageColumnByWCIadminFromSelectingPage() throws InterruptedException {
		Thread.sleep(2000);
		String beforEditFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(beforEditFirstRowValuesOfBaseLang, beforEditFirstRowValuesOfBaseLang,"Before edit the value is = "+beforEditFirstRowValuesOfBaseLang, "Before edit the value is = "+beforEditFirstRowValuesOfBaseLang);
		System.out.println("Before edit the value is = "+beforEditFirstRowValuesOfBaseLang);
		CommonLibref.scroll(displayedValue1Row, "scrollToElement", "displayedValue1Row");
		CommonLibref.click(displayedValue1Row, "seleniumClick", "displayedValue1Row");
		Actions act = new Actions(driver);
		act.doubleClick(displayedValue1Row).sendKeys(displayedValue1Row, "\b").build().perform();
		Thread.sleep(1000);
		String enteredNewValue = beforEditFirstRowValuesOfBaseLang+"_New";
		act.click(displayedValue1Row).sendKeys(enteredNewValue).build().perform();
		Thread.sleep(1000);
		CommonLibref.click(displayedValue2Row, "javascriptClick", "displayedValue2Row");
		String afterEditFirstRowValuesOfBaseLang = CommonLibref.getTextElement(displayedValue1Row);
		CommonLibref.verifyTextTypeString(afterEditFirstRowValuesOfBaseLang, afterEditFirstRowValuesOfBaseLang,"After edit the value is = "+ afterEditFirstRowValuesOfBaseLang, "After edit the value is = "+ afterEditFirstRowValuesOfBaseLang);
		System.out.println("After edit the value is = "+ afterEditFirstRowValuesOfBaseLang);
	}
	
	public void editButtonOfmoreActionsFunctionalityForValuesAccrodian() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(btnEditForValuesAccordian, "seleniumClick", "btnEditForValuesAccordian");
		System.out.println("Step: Click on EDIT option");
		ObjectRepo.test.log(Status.PASS, "Step: Click on EDIT option");
		Thread.sleep(2000);
		String btnResetFromValuesAccordionActual = CommonLibref.getTextElement(btnResetFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnResetFromValuesAccordionActual, "CANCEL","Matched Expected and Actual = CANCEL", "Matched Expected and Actual = CANCEL");
		System.out.println("Matched Expected and Actual = " + btnResetFromValuesAccordionActual);
		String btnResetFromPageContentActual = CommonLibref.getTextElement(btnResetFromPageContent);
		CommonLibref.verifyTextTypeString(btnResetFromPageContentActual, "SAVE","Matched Expected and Actual = SAVE", "Matched Expected and Actual = SAVE");
		System.out.println("Matched Expected and Actual = " + btnResetFromPageContentActual);
		String btnPublishFromValuesAccordionActual = CommonLibref.getTextElement(btnPublishFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnPublishFromValuesAccordionActual, "PUBLISH","Matched Expected and Actual = PUBLISH", "Matched Expected and Actual = PUBLISH");
		System.out.println("Matched Expected and Actual = " + btnPublishFromValuesAccordionActual);
	}
	
	
	public void moreActionsButtonFunctionalityForValuesAccrodian() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(btnMoreActionsFromValuesAccordion, "seleniumClick", "btnMoreActionsFromValuesAccordion");
		System.out.println("Step: Click on MORE ACTIONS button and observe Options");
		ObjectRepo.test.log(Status.PASS, "Step: Click on MORE ACTIONS button and observe Options");
		Thread.sleep(2000);
		String btnEditForValuesAccordianActual = CommonLibref
				.getTextElement(btnEditForValuesAccordian);
		CommonLibref.verifyTextTypeString(btnEditForValuesAccordianActual, "EDIT",
				"Matched Expected and Actual = EDIT", "Matched Expected and Actual = EDIT");
		System.out.println("Matched Expected and Actual = " + btnEditForValuesAccordianActual);
		String btnSearchAndReplaceAllValuesForValuesAccordianActual = CommonLibref
				.getTextElement(btnSearchAndReplaceAllValuesForValuesAccordian);
		CommonLibref.verifyTextTypeString(btnSearchAndReplaceAllValuesForValuesAccordianActual, "SEARCH AND REPLACE ALL VALUES",
				"Matched Expected and Actual = SEARCH AND REPLACE ALL VALUES", "Matched Expected and Actual = SEARCH AND REPLACE ALL VALUES");
		System.out.println("Matched Expected and Actual = " + btnSearchAndReplaceAllValuesForValuesAccordianActual);
		String btnResetSearchForValuesAccordianActual = CommonLibref
				.getTextElement(btnResetSearchForValuesAccordian);
		CommonLibref.verifyTextTypeString(btnResetSearchForValuesAccordianActual, "RESET SEARCH",
				"Matched Expected and Actual = RESET SEARCH", "Matched Expected and Actual = RESET SEARCH");
		System.out.println("Matched Expected and Actual = " + btnResetSearchForValuesAccordianActual);
	}
	
	public void searchButtonFunctionalityOfSearchByPageTabOfValuesAccrodianByJSAUser() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(accordionValues));
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(accordionValues, "seleniumClick", "accordionValues");
		System.out.println("Step: Click on Value Accordion");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Value Accordion");
		String labelSelectlangFromValuesAccordionActual = CommonLibref.getTextElement(labelSelectlangFromValuesAccordion);
		CommonLibref.verifyTextTypeString(labelSelectlangFromValuesAccordionActual, "Select a Language*","Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual = " + labelSelectlangFromValuesAccordionActual);
		String labelSelectAPageFromValuesAccordianActual = CommonLibref.getTextElement(labelSelectAPageFromValuesAccordian);
		CommonLibref.verifyTextTypeString(labelSelectAPageFromValuesAccordianActual, "Select a Page*","Matched Expected and Actual = Select a Page*", "Matched Expected and Actual = Select a Page*");
		System.out.println("Matched Expected and Actual = " + labelSelectAPageFromValuesAccordianActual);
		String btnResetFromValuesAccordionActual = CommonLibref.getTextElement(btnResetFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnResetFromValuesAccordionActual, "RESET","Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual = " + btnResetFromValuesAccordionActual);
		String btnSearchFromValuesAccordionActual = CommonLibref.getTextElement(btnPublishFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnSearchFromValuesAccordionActual, "SEARCH","Matched Expected and Actual = SEARCH Button", "Matched Expected and Actual = SEARCH Button");
		System.out.println("Matched Expected and Actual = " + btnSearchFromValuesAccordionActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(fieldSelectLanguageFromValuesAccordionForSelectAPageTab, "seleniumClick",
				"fieldSelectLanguageFromValuesAccordionForSelectAPageTab");
		CommonLibref.click(optionEnglishLang, "javascriptClick", "optionEnglishLang");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		//CommonLibref.click(dropdownSelectPageFromValuesAccrodian, "seleniumClick", "dropdownSelectPageFromValuesAccrodian");
		dropdownSelectPageFromValuesAccrodian.sendKeys("Contact");
		CommonLibref.click(optionContactUsPage, "javascriptClick", "optionContactUsPage");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		CommonLibref.click(btnPublishFromValuesAccordion, "seleniumClick", "btnSearchFromValuesAccordion");
		System.out.println("Step: Click on Page Dropdown & Select Page and Click on 'SEARCH' button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Page Dropdown & Select Page and Click on 'SEARCH' button");
		wait.until(ExpectedConditions.visibilityOf(keyColumnNameOfValuesAccordionByWCIAdmin));
		String keyColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(keyColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(keyColumnNameOfValuesAccordionByWCIAdminActual, "Key",
				"Matched Expected and Actual = Key", "Matched Expected and Actual = Key");
		System.out.println("Matched Expected and Actual = " + keyColumnNameOfValuesAccordionByWCIAdminActual);
		String descriptionColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(descriptionColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(descriptionColumnNameOfValuesAccordionByWCIAdminActual, "Description",
				"Matched Expected and Actual = Description", "Matched Expected and Actual = Description");
		System.out.println("Matched Expected and Actual = " + descriptionColumnNameOfValuesAccordionByWCIAdminActual);
		String defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(defaultEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Default English",
				"Matched Expected and Actual = Default English", "Matched Expected and Actual = Default English");
		System.out.println("Matched Expected and Actual = " + defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(baseLangEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Base Language English",
				"Matched Expected and Actual = Base Language English", "Matched Expected and Actual = Base Language English");
		System.out.println("Matched Expected and Actual = " + baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual = CommonLibref.getTextElement(jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordian);
		CommonLibref.verifyTextTypeString(jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual, "Jurisdiction Localization","Matched Expected and Actual = Jurisdiction Localization", "Matched Expected and Actual = Jurisdiction Localization");
		System.out.println("Matched Expected and Actual = " + jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual);
		String displayedColumFromDisplayedTableOfValuesAccordianActual = CommonLibref.getTextElement(displayedColumFromDisplayedTableOfValuesAccordian);
		CommonLibref.verifyTextTypeString(displayedColumFromDisplayedTableOfValuesAccordianActual, "Displayed","Matched Expected and Actual = Displayed", "Matched Expected and Actual = Displayed");
		System.out.println("Matched Expected and Actual = " + displayedColumFromDisplayedTableOfValuesAccordianActual);
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.elementToBeClickable(hideButtonForKeyFromDisplayedtable));
		CommonLibref.click(hideButtonForKeyFromDisplayedtable, "javascriptClick", "hideButtonForKeyFromDisplayedtable");
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.visibilityOf(pageColumnNameOfValuesAccordionByWCIAdmin));
		String pageColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(pageColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(pageColumnNameOfValuesAccordionByWCIAdminActual, "Page",
				"Matched Expected and Actual = Page", "Matched Expected and Actual = Page");
		System.out.println("Matched Expected and Actual = " + pageColumnNameOfValuesAccordionByWCIAdminActual);
		
	}
	
	public void searchButtonFunctionalityOfSearchByPageTab() throws InterruptedException {
		Thread.sleep(5000);;
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(accordionValues, "seleniumClick", "accordionValues");
		System.out.println("Step: Click on Value Accordion");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Value Accordion");
		String labelSelectlangFromValuesAccordionActual = CommonLibref.getTextElement(labelSelectlangFromValuesAccordion);
		CommonLibref.verifyTextTypeString(labelSelectlangFromValuesAccordionActual, "Select a Language*","Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual = " + labelSelectlangFromValuesAccordionActual);
		String labelSelectAPageFromValuesAccordianActual = CommonLibref.getTextElement(labelSelectAPageFromValuesAccordian);
		CommonLibref.verifyTextTypeString(labelSelectAPageFromValuesAccordianActual, "Select a Page*","Matched Expected and Actual = Select a Page*", "Matched Expected and Actual = Select a Page*");
		System.out.println("Matched Expected and Actual = " + labelSelectAPageFromValuesAccordianActual);
		String btnResetFromValuesAccordionActual = CommonLibref.getTextElement(btnResetFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnResetFromValuesAccordionActual, "RESET","Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual = " + btnResetFromValuesAccordionActual);
		String btnSearchFromValuesAccordionActual = CommonLibref.getTextElement(btnPublishFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnSearchFromValuesAccordionActual, "SEARCH","Matched Expected and Actual = SEARCH Button", "Matched Expected and Actual = SEARCH Button");
		System.out.println("Matched Expected and Actual = " + btnSearchFromValuesAccordionActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(fieldSelectLanguageFromValuesAccordionForSelectAPageTab, "seleniumClick",
				"fieldSelectLanguageFromValuesAccordionForSelectAPageTab");
		CommonLibref.click(optionEnglishLang, "javascriptClick", "optionEnglishLang");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		dropdownSelectPageFromValuesAccrodian.sendKeys("Contact");
		CommonLibref.click(optionContactUsPage, "javascriptClick", "optionContactUsPage");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		CommonLibref.click(btnPublishFromValuesAccordion, "seleniumClick", "btnSearchFromValuesAccordion");
		System.out.println("Step: Click on Page Dropdown & Select Page and Click on 'SEARCH' button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Page Dropdown & Select Page and Click on 'SEARCH' button");
		Thread.sleep(4000);
		String keyColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(keyColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(keyColumnNameOfValuesAccordionByWCIAdminActual, "Key",
				"Matched Expected and Actual = Key", "Matched Expected and Actual = Key");
		System.out.println("Matched Expected and Actual = " + keyColumnNameOfValuesAccordionByWCIAdminActual);
		String descriptionColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(descriptionColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(descriptionColumnNameOfValuesAccordionByWCIAdminActual, "Description",
				"Matched Expected and Actual = Description", "Matched Expected and Actual = Description");
		System.out.println("Matched Expected and Actual = " + descriptionColumnNameOfValuesAccordionByWCIAdminActual);
		String defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(defaultEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Default English",
				"Matched Expected and Actual = Default English", "Matched Expected and Actual = Default English");
		System.out.println("Matched Expected and Actual = " + defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(baseLangEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Base Language English",
				"Matched Expected and Actual = Base Language English", "Matched Expected and Actual = Base Language English");
		System.out.println("Matched Expected and Actual = " + baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String pageColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(pageColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(pageColumnNameOfValuesAccordionByWCIAdminActual, "Page",
				"Matched Expected and Actual = Page", "Matched Expected and Actual = Page");
		System.out.println("Matched Expected and Actual = " + pageColumnNameOfValuesAccordionByWCIAdminActual);
	}
	
	public void searchButtonFunctionalityOfSearchByKeyOrValueTab() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(accordionValues, "seleniumClick", "accordionValues");
		System.out.println("Step: Click on Value Accordion");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Value Accordion");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(tabSearchByKeyOrValueFromValuesAccordion, "seleniumClick",
				"tabSearchByKeyOrValueFromValuesAccordion");
		System.out.println("Step: Click on Search by key or Value tab");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Search by key or Value tab");
		String labelSelectlangFromValuesAccordionActual = CommonLibref
				.getTextElement(labelSelectlangFromValuesAccordion);
		CommonLibref.verifyTextTypeString(labelSelectlangFromValuesAccordionActual, "Select a Language*",
				"Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual = " + labelSelectlangFromValuesAccordionActual);
		String labelSearchByKeyOrValueDropdownActual = CommonLibref.getTextElement(labelSearchByKeyOrValueDropdown);
		CommonLibref.verifyTextTypeString(labelSearchByKeyOrValueDropdownActual, "Search Key or Value*",
				"Matched Expected and Actual = Search Key or Value**", "");
		System.out.println("Matched Expected and Actual = " + labelSearchByKeyOrValueDropdownActual);
		String btnResetFromValuesAccordionActual = CommonLibref.getTextElement(btnResetFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnResetFromValuesAccordionActual, "RESET",
				"Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual = " + btnResetFromValuesAccordionActual);
		String btnSearchFromValuesAccordionActual = CommonLibref.getTextElement(btnPublishFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnSearchFromValuesAccordionActual, "SEARCH",
				"Matched Expected and Actual = SEARCH Button", "Matched Expected and Actual = SEARCH Button");
		System.out.println("Matched Expected and Actual = " + btnSearchFromValuesAccordionActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(fieldSelectLanguageFromValuesAccordionForDisplayedKeyOrvalueTab, "seleniumClick",
				"fieldSelectLanguageFromValuesAccordionForDisplayedKeyOrvalueTab");
		CommonLibref.click(optionEnglishLang, "javascriptClick", "optionEnglishLang");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		fieldSearchbyKeyOrValueFromValuesAccordion.sendKeys("Log In");
		CommonLibref.click(btnPublishFromValuesAccordion, "seleniumClick", "btnSearchFromValuesAccordion");
		System.out.println("Step: Enter Valid data in Search Displayed field & Click on Search Button");
		ObjectRepo.test.log(Status.PASS, "Step: Enter Valid data in Search Displayed field & Click on Search Button");
		Thread.sleep(2000);
		String keyColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(keyColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(keyColumnNameOfValuesAccordionByWCIAdminActual, "Key",
				"Matched Expected and Actual = Key", "Matched Expected and Actual = Key");
		System.out.println("Matched Expected and Actual = " + keyColumnNameOfValuesAccordionByWCIAdminActual);
		String descriptionColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(descriptionColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(descriptionColumnNameOfValuesAccordionByWCIAdminActual, "Description",
				"Matched Expected and Actual = Description", "Matched Expected and Actual = Description");
		System.out.println("Matched Expected and Actual = " + descriptionColumnNameOfValuesAccordionByWCIAdminActual);
		String defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(defaultEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Default English",
				"Matched Expected and Actual = Default English", "Matched Expected and Actual = Default English");
		System.out.println("Matched Expected and Actual = " + defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(baseLangEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Base Language English",
				"Matched Expected and Actual = Base Language English", "Matched Expected and Actual = Base Language English");
		System.out.println("Matched Expected and Actual = " + baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String pageColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(pageColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(pageColumnNameOfValuesAccordionByWCIAdminActual, "Page",
				"Matched Expected and Actual = Page", "Matched Expected and Actual = Page");
		System.out.println("Matched Expected and Actual = " + pageColumnNameOfValuesAccordionByWCIAdminActual);
	}
	
	public void searchButtonFunctionalityOfSearchByKeyOrValueTabFromvaluesAccordianByJSAUser() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(accordionValues));
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(accordionValues, "seleniumClick", "accordionValues");
		System.out.println("Step: Click on Value Accordion");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Value Accordion");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(tabSearchByKeyOrValueFromValuesAccordion, "seleniumClick",
				"tabSearchByKeyOrValueFromValuesAccordion");
		System.out.println("Step: Click on Search by key or Value tab");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Search by key or Value tab");
		String labelSelectlangFromValuesAccordionActual = CommonLibref
				.getTextElement(labelSelectlangFromValuesAccordion);
		CommonLibref.verifyTextTypeString(labelSelectlangFromValuesAccordionActual, "Select a Language*",
				"Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual = " + labelSelectlangFromValuesAccordionActual);
		String labelSearchByKeyOrValueDropdownActual = CommonLibref.getTextElement(labelSearchByKeyOrValueDropdown);
		CommonLibref.verifyTextTypeString(labelSearchByKeyOrValueDropdownActual, "Search Key or Value*",
				"Matched Expected and Actual = Search Key or Value**", "");
		System.out.println("Matched Expected and Actual = " + labelSearchByKeyOrValueDropdownActual);
		String btnResetFromValuesAccordionActual = CommonLibref.getTextElement(btnResetFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnResetFromValuesAccordionActual, "RESET",
				"Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual = " + btnResetFromValuesAccordionActual);
		String btnSearchFromValuesAccordionActual = CommonLibref.getTextElement(btnPublishFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnSearchFromValuesAccordionActual, "SEARCH",
				"Matched Expected and Actual = SEARCH Button", "Matched Expected and Actual = SEARCH Button");
		System.out.println("Matched Expected and Actual = " + btnSearchFromValuesAccordionActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(fieldSelectLanguageFromValuesAccordionForDisplayedKeyOrvalueTab, "seleniumClick",
				"fieldSelectLanguageFromValuesAccordionForDisplayedKeyOrvalueTab");
		wait.until(ExpectedConditions.elementToBeClickable(optionEnglishLang));
		CommonLibref.click(optionEnglishLang, "javascriptClick", "optionEnglishLang");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		fieldSearchbyKeyOrValueFromValuesAccordion.sendKeys("Log In");
		CommonLibref.click(btnPublishFromValuesAccordion, "seleniumClick", "btnSearchFromValuesAccordion");
		System.out.println("Step: Enter Valid data in Search Displayed field & Click on Search Button");
		ObjectRepo.test.log(Status.PASS, "Step: Enter Valid data in Search Displayed field & Click on Search Button");
		wait.until(ExpectedConditions.visibilityOf(keyColumnNameOfValuesAccordionByWCIAdmin));
		String keyColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(keyColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(keyColumnNameOfValuesAccordionByWCIAdminActual, "Key",
				"Matched Expected and Actual = Key", "Matched Expected and Actual = Key");
		System.out.println("Matched Expected and Actual = " + keyColumnNameOfValuesAccordionByWCIAdminActual);
		String descriptionColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(descriptionColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(descriptionColumnNameOfValuesAccordionByWCIAdminActual, "Description",
				"Matched Expected and Actual = Description", "Matched Expected and Actual = Description");
		System.out.println("Matched Expected and Actual = " + descriptionColumnNameOfValuesAccordionByWCIAdminActual);
		String defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(defaultEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Default English",
				"Matched Expected and Actual = Default English", "Matched Expected and Actual = Default English");
		System.out.println("Matched Expected and Actual = " + defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(baseLangEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Base Language English",
				"Matched Expected and Actual = Base Language English", "Matched Expected and Actual = Base Language English");
		System.out.println("Matched Expected and Actual = " + baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual = CommonLibref.getTextElement(jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordian);
		CommonLibref.verifyTextTypeString(jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual, "Jurisdiction Localization","Matched Expected and Actual = Jurisdiction Localization", "Matched Expected and Actual = Jurisdiction Localization");
		System.out.println("Matched Expected and Actual = " + jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual);
		String displayedColumFromDisplayedTableOfValuesAccordianActual = CommonLibref.getTextElement(displayedColumFromDisplayedTableOfValuesAccordian);
		CommonLibref.verifyTextTypeString(displayedColumFromDisplayedTableOfValuesAccordianActual, "Displayed","Matched Expected and Actual = Displayed", "Matched Expected and Actual = Displayed");
		System.out.println("Matched Expected and Actual = " + displayedColumFromDisplayedTableOfValuesAccordianActual);
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.elementToBeClickable(hideButtonForKeyFromDisplayedtable));
		CommonLibref.click(hideButtonForKeyFromDisplayedtable, "javascriptClick", "hideButtonForKeyFromDisplayedtable");
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.visibilityOf(pageColumnNameOfValuesAccordionByWCIAdmin));
		String pageColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(pageColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(pageColumnNameOfValuesAccordionByWCIAdminActual, "Page",
				"Matched Expected and Actual = Page", "Matched Expected and Actual = Page");
		System.out.println("Matched Expected and Actual = " + pageColumnNameOfValuesAccordionByWCIAdminActual);
	}

	public void searchButtonFunctionalityOfSearchByDisplayedValueTab() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(accordionValues, "seleniumClick", "accordionValues");
		System.out.println("Step: Click on Value Accordion");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Value Accordion");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(tabSearchByDisplayedFromValuesAccordion, "seleniumClick",
				"tabSearchByDisplayedFromValuesAccordion");
		System.out.println("Step: Click on Search by Displayed Value Tab");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Search by Displayed Value Tab");
		String labelSelectlangFromValuesAccordionActual = CommonLibref
				.getTextElement(labelSelectlangFromValuesAccordion);
		CommonLibref.verifyTextTypeString(labelSelectlangFromValuesAccordionActual, "Select a Language*",
				"Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual = " + labelSelectlangFromValuesAccordionActual);
		String labelSearchByDisplayedDropdownActual = CommonLibref.getTextElement(labelSearchByDisplayedDropdown);
		CommonLibref.verifyTextTypeString(labelSearchByDisplayedDropdownActual, "Search Displayed Value*",
				"Matched Expected and Actual = Search Displayed Value*", "");
		System.out.println("Matched Expected and Actual = " + labelSearchByDisplayedDropdownActual);
		String btnResetFromValuesAccordionActual = CommonLibref.getTextElement(btnResetFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnResetFromValuesAccordionActual, "RESET",
				"Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual = " + btnResetFromValuesAccordionActual);
		String btnSearchFromValuesAccordionActual = CommonLibref.getTextElement(btnPublishFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnSearchFromValuesAccordionActual, "SEARCH",
				"Matched Expected and Actual = SEARCH Button", "Matched Expected and Actual = SEARCH Button");
		System.out.println("Matched Expected and Actual = " + btnSearchFromValuesAccordionActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(fieldSelectLanguageFromValuesAccordion, "seleniumClick",
				"fieldSelectLanguageFromValuesAccordion");
		CommonLibref.click(optionEnglishLang, "javascriptClick", "optionEnglishLang");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		fieldSearchDisplayedFromValuesAccordion.sendKeys("Log In");
		CommonLibref.click(btnPublishFromValuesAccordion, "seleniumClick", "btnSearchFromValuesAccordion");
		System.out.println("Step: Enter Valid data in Search Displayed field & Click on Search Button");
		ObjectRepo.test.log(Status.PASS, "Step: Enter Valid data in Search Displayed field & Click on Search Button");
		Thread.sleep(2000);
		String keyColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(keyColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(keyColumnNameOfValuesAccordionByWCIAdminActual, "Key",
				"Matched Expected and Actual = Key", "Matched Expected and Actual = Key");
		System.out.println("Matched Expected and Actual = " + keyColumnNameOfValuesAccordionByWCIAdminActual);
		String descriptionColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(descriptionColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(descriptionColumnNameOfValuesAccordionByWCIAdminActual, "Description",
				"Matched Expected and Actual = Description", "Matched Expected and Actual = Description");
		System.out.println("Matched Expected and Actual = " + descriptionColumnNameOfValuesAccordionByWCIAdminActual);
		String defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(defaultEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Default English",
				"Matched Expected and Actual = Default English", "Matched Expected and Actual = Default English");
		System.out.println("Matched Expected and Actual = " + defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(baseLangEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Base Language English",
				"Matched Expected and Actual = Base Language English", "Matched Expected and Actual = Base Language English");
		System.out.println("Matched Expected and Actual = " + baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String pageColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(pageColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(pageColumnNameOfValuesAccordionByWCIAdminActual, "Page",
				"Matched Expected and Actual = Page", "Matched Expected and Actual = Page");
		System.out.println("Matched Expected and Actual = " + pageColumnNameOfValuesAccordionByWCIAdminActual);
	}
	
	public void searchButtonFunctionalityOfSearchByDisplayedValueTabFromValuesAccordianByJSAUser() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(accordionValues));
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(accordionValues, "seleniumClick", "accordionValues");
		System.out.println("Step: Click on Value Accordion");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Value Accordion");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(tabSearchByDisplayedFromValuesAccordion, "seleniumClick",
				"tabSearchByDisplayedFromValuesAccordion");
		System.out.println("Step: Click on Search by Displayed Value Tab");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Search by Displayed Value Tab");
		String labelSelectlangFromValuesAccordionActual = CommonLibref
				.getTextElement(labelSelectlangFromValuesAccordion);
		CommonLibref.verifyTextTypeString(labelSelectlangFromValuesAccordionActual, "Select a Language*",
				"Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual = " + labelSelectlangFromValuesAccordionActual);
		String labelSearchByDisplayedDropdownActual = CommonLibref.getTextElement(labelSearchByDisplayedDropdown);
		CommonLibref.verifyTextTypeString(labelSearchByDisplayedDropdownActual, "Search Displayed Value*",
				"Matched Expected and Actual = Search Displayed Value*", "");
		System.out.println("Matched Expected and Actual = " + labelSearchByDisplayedDropdownActual);
		String btnResetFromValuesAccordionActual = CommonLibref.getTextElement(btnResetFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnResetFromValuesAccordionActual, "RESET",
				"Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual = " + btnResetFromValuesAccordionActual);
		String btnSearchFromValuesAccordionActual = CommonLibref.getTextElement(btnPublishFromValuesAccordion);
		CommonLibref.verifyTextTypeString(btnSearchFromValuesAccordionActual, "SEARCH",
				"Matched Expected and Actual = SEARCH Button", "Matched Expected and Actual = SEARCH Button");
		System.out.println("Matched Expected and Actual = " + btnSearchFromValuesAccordionActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(fieldSelectLanguageFromValuesAccordion, "seleniumClick",
				"fieldSelectLanguageFromValuesAccordion");
		wait.until(ExpectedConditions.elementToBeClickable(optionEnglishLang));
		CommonLibref.click(optionEnglishLang, "javascriptClick", "optionEnglishLang");
		System.out.println("Step: Click on Select a Language dropdown and select language");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Select a Language dropdown and select language");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		fieldSearchDisplayedFromValuesAccordion.sendKeys("Log In");
		CommonLibref.click(btnPublishFromValuesAccordion, "seleniumClick", "btnSearchFromValuesAccordion");
		System.out.println("Step: Enter Valid data in Search Displayed field & Click on Search Button");
		ObjectRepo.test.log(Status.PASS, "Step: Enter Valid data in Search Displayed field & Click on Search Button");
		wait.until(ExpectedConditions.visibilityOf(keyColumnNameOfValuesAccordionByWCIAdmin));
		String keyColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(keyColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(keyColumnNameOfValuesAccordionByWCIAdminActual, "Key",
				"Matched Expected and Actual = Key", "Matched Expected and Actual = Key");
		System.out.println("Matched Expected and Actual = " + keyColumnNameOfValuesAccordionByWCIAdminActual);
		String descriptionColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(descriptionColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(descriptionColumnNameOfValuesAccordionByWCIAdminActual, "Description",
				"Matched Expected and Actual = Description", "Matched Expected and Actual = Description");
		System.out.println("Matched Expected and Actual = " + descriptionColumnNameOfValuesAccordionByWCIAdminActual);
		String defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(defaultEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Default English",
				"Matched Expected and Actual = Default English", "Matched Expected and Actual = Default English");
		System.out.println("Matched Expected and Actual = " + defaultEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(baseLangEnglishColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual, "Base Language English",
				"Matched Expected and Actual = Base Language English", "Matched Expected and Actual = Base Language English");
		System.out.println("Matched Expected and Actual = " + baseLangEnglishColumnNameOfValuesAccordionByWCIAdminActual);
		String jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual = CommonLibref.getTextElement(jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordian);
		CommonLibref.verifyTextTypeString(jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual, "Jurisdiction Localization","Matched Expected and Actual = Jurisdiction Localization", "Matched Expected and Actual = Jurisdiction Localization");
		System.out.println("Matched Expected and Actual = " + jurisdictionLocalizationColumFromDisplayedTableOfValuesAccordianActual);
		String displayedColumFromDisplayedTableOfValuesAccordianActual = CommonLibref.getTextElement(displayedColumFromDisplayedTableOfValuesAccordian);
		CommonLibref.verifyTextTypeString(displayedColumFromDisplayedTableOfValuesAccordianActual, "Displayed","Matched Expected and Actual = Displayed", "Matched Expected and Actual = Displayed");
		System.out.println("Matched Expected and Actual = " + displayedColumFromDisplayedTableOfValuesAccordianActual);
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.elementToBeClickable(hideButtonForKeyFromDisplayedtable));
		CommonLibref.click(hideButtonForKeyFromDisplayedtable, "javascriptClick", "hideButtonForKeyFromDisplayedtable");
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.visibilityOf(pageColumnNameOfValuesAccordionByWCIAdmin));
		String pageColumnNameOfValuesAccordionByWCIAdminActual = CommonLibref
				.getTextElement(pageColumnNameOfValuesAccordionByWCIAdmin);
		CommonLibref.verifyTextTypeString(pageColumnNameOfValuesAccordionByWCIAdminActual, "Page",
				"Matched Expected and Actual = Page", "Matched Expected and Actual = Page");
		System.out.println("Matched Expected and Actual = " + pageColumnNameOfValuesAccordionByWCIAdminActual);
	}
	
	public void sendDataFromExcelToField_Reverse() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.elementToBeClickable(btnHideAll));
		CommonLibref.click(btnHideAll, "javascriptClick", "btnHideAll");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForKeyFromDisplayedtable, "javascriptClick", "hideButtonForKeyFromDisplayedtable");
		Thread.sleep(1000);
		CommonLibref.click(unhideDisplayedColoumnFromDisplayedTable, "javascriptClick",
				"unhideDisplayedColoumnFromDisplayedTable");
		Thread.sleep(1000);
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		Thread.sleep(1000);
		CommonLibref.scroll(rowPerPageDropdownForDisplayeTableOfpageAccrodian, "scrollToElement", "rowPerPageDropdownForDisplayeTableOfpageAccrodian");
		wait.until(ExpectedConditions.elementToBeClickable(rowPerPageDropdownForDisplayeTableOfpageAccrodian));
		CommonLibref.click(rowPerPageDropdownForDisplayeTableOfpageAccrodian, "seleniumClick", "rowPerPageDropdownForDisplayeTableOfpageAccrodian");
		CommonLibref.scroll(pageSelectAS100, "scrollToElement", "pageSelectAS100");
		wait.until(ExpectedConditions.elementToBeClickable(pageSelectAS100));
		CommonLibref.click(pageSelectAS100, "moveToElementClick", "pageSelectAS100");
		Thread.sleep(2000);
		List<WebElement> elementList = driver.findElements(By.xpath(
				"//div[@class='super-app-theme--cell MuiDataGrid-cell MuiDataGrid-cell--textCenter MuiDataGrid-cell--editable']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
		String validationFilePath = System.getProperty("user.dir") + "//GetData//Output.xlsx";

		try (FileInputStream fileInputStream = new FileInputStream(validationFilePath);
				Workbook validationWorkbook = WorkbookFactory.create(fileInputStream)) {
			Sheet validationSheet = validationWorkbook.getSheetAt(0);
			for (int i = 0; i < Math.min(elementList.size(), validationSheet.getPhysicalNumberOfRows()); i++) {
				Row validationRow = validationSheet.getRow(i);
				String dataToEnter = validationRow.getCell(1).getStringCellValue();
				WebElement currentElement = elementList.get(i);
				String existingData = currentElement.getText();
				if (existingData.equals(dataToEnter)) {
					System.out.println("Validation Passed for Row " + (i + 1));
				} else {
					System.out.println("Validation Failed for Row " + (i + 1));
				}
				Thread.sleep(2000);
				CommonLibref.scroll(currentElement, "scrollToElement", "currentElement");
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(currentElement));
				currentElement.click();
				Thread.sleep(2000);
				Actions act = new Actions(driver);
				act.doubleClick(currentElement).sendKeys(currentElement, "\b").build().perform();
				Thread.sleep(1000);
				act.click(currentElement).sendKeys(dataToEnter).build().perform();
				Thread.sleep(1000);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		CommonLibref.scroll(displayedValue1Row, "scrollToTopOFPage", "currentElement");
		Thread.sleep(2000);
		displayedValue1Row.click();
		Thread.sleep(2000);
		CommonLibref.scroll(btnSaveButton, "scrollToTopOFPage", "btnSaveButton");
		CommonLibref.click(btnSaveButton, "javascriptClick", "btnSaveButton");
		Thread.sleep(2000);
		btnCrossForSuccessMessage.click();
		Thread.sleep(2000);
		btnEditFromPageContent.click();
		Thread.sleep(2000);
		btnPublishButton.click();
		Thread.sleep(2000);
		btnCrossForSuccessMessage.click();
		Thread.sleep(5000);
		CommonLibref.scroll(accordionPageContent, "scrollToTopOFPage", "accordionPageContent");
		CommonLibref.click(accordionPageContent, "javascriptClick", "accordionPageContent");
	}

	public void sendDataFromExcelToField() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(btnEditFromPageContent));
		CommonLibref.scroll(btnEditFromPageContent, "scrollToElement", "btnEditFromPageContent");
		wait.until(ExpectedConditions.elementToBeClickable(btnEditFromPageContent));
		CommonLibref.click(btnEditFromPageContent, "seleniumClick", "btnEditFromPageContent");
		Thread.sleep(5000);
		List<WebElement> elementList = driver.findElements(By.xpath(
				"//div[@class='super-app-theme--cell MuiDataGrid-cell MuiDataGrid-cell--textCenter MuiDataGrid-cell--editable']"));
		
		String validationFilePath = System.getProperty("user.dir") + "//GetData//Output.xlsx";
		try (FileInputStream fileInputStream = new FileInputStream(validationFilePath);
				Workbook validationWorkbook = WorkbookFactory.create(fileInputStream)) {
			Sheet validationSheet = validationWorkbook.getSheetAt(0);
			for (int i = 0; i < Math.min(elementList.size(), validationSheet.getPhysicalNumberOfRows()); i++) {
				Row validationRow = validationSheet.getRow(i);
				String dataToEnter = validationRow.getCell(2).getStringCellValue();
				WebElement currentElement = elementList.get(i);
				String existingData = currentElement.getText();
				if (existingData.equals(dataToEnter)) {
					System.out.println("Validation Passed for Row " + (i + 1));
				} else {
					System.out.println("Validation Failed for Row " + (i + 1));
				}
				//Thread.sleep(2000);
				CommonLibref.scroll(currentElement, "scrollToElement", "currentElement");
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(currentElement));
				currentElement.click();
				//Thread.sleep(2000);
				Actions act = new Actions(driver);
				act.doubleClick(currentElement).sendKeys(currentElement, "\b").build().perform();
				//Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(currentElement));
				act.click(currentElement).sendKeys(dataToEnter).build().perform();
				//Thread.sleep(1000);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		CommonLibref.scroll(displayedValue1Row, "scrollToTopOFPage", "currentElement");
		Thread.sleep(2000);
		displayedValue1Row.click();
		Thread.sleep(5000);
		CommonLibref.scroll(btnSaveButton, "scrollToTopOFPage", "btnSaveButton");
		CommonLibref.click(btnSaveButton, "javascriptClick", "btnSaveButton");
		Thread.sleep(5000);
		btnCrossForSuccessMessage.click();
		Thread.sleep(2000);
		btnEditFromPageContent.click();
		Thread.sleep(2000);
		btnPublishButton.click();
		Thread.sleep(5000);
		btnCrossForSuccessMessage.click();
		Thread.sleep(5000);
		CommonLibref.scroll(accordionPageContent, "scrollToTopOFPage", "accordionPageContent");
		CommonLibref.click(accordionPageContent, "javascriptClick", "accordionPageContent");
	}

	public void getContactUsPagedataFromDisplayedTableColumn() throws InterruptedException {
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(columnsOptionFromDisplayedTable));
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		wait.until(ExpectedConditions.elementToBeClickable(btnHideAll));
		CommonLibref.click(btnHideAll, "javascriptClick", "btnHideAll");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForKeyFromDisplayedtable, "javascriptClick", "hideButtonForKeyFromDisplayedtable");
		Thread.sleep(1000);
		CommonLibref.click(unhideDisplayedColoumnFromDisplayedTable, "javascriptClick",
				"unhideDisplayedColoumnFromDisplayedTable");
		Thread.sleep(1000);
		CommonLibref.click(columnsOptionFromDisplayedTable, "seleniumClick", "columnsOptionFromDisplayedTable");
		Thread.sleep(1000);
		CommonLibref.scroll(rowPerPageDropdownForDisplayeTableOfpageAccrodian, "scrollToElement", "rowPerPageDropdownForDisplayeTableOfpageAccrodian");
		wait.until(ExpectedConditions.elementToBeClickable(rowPerPageDropdownForDisplayeTableOfpageAccrodian));
		CommonLibref.click(rowPerPageDropdownForDisplayeTableOfpageAccrodian, "seleniumClick", "rowPerPageDropdownForDisplayeTableOfpageAccrodian");
		CommonLibref.scroll(pageSelectAS100, "scrollToElement", "pageSelectAS100");
		wait.until(ExpectedConditions.elementToBeClickable(pageSelectAS100));
		CommonLibref.click(pageSelectAS100, "moveToElementClick", "pageSelectAS100");
		List<WebElement> keyColumn = driver
				.findElements(By.xpath("//div[@class='MuiDataGrid-cell MuiDataGrid-cell--textLeft']"));
		List<WebElement> displayedColumn = driver
				.findElements(By.xpath("//div[@class='MuiDataGrid-cell MuiDataGrid-cell--textCenter']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(keyColumn));
		wait.until(ExpectedConditions.visibilityOfAllElements(displayedColumn));
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Sheet1");
			int maxSize = Math.max(keyColumn.size(), displayedColumn.size());
			for (int i = 0; i < maxSize; i++) {
				Row row = sheet.createRow(i);
				if (i < keyColumn.size()) {
					Cell cell1 = row.createCell(0);
					cell1.setCellValue(keyColumn.get(i).getText());
				}
				if (i < displayedColumn.size()) {
					Cell cell2 = row.createCell(1);
					cell2.setCellValue(displayedColumn.get(i).getText());
				}
				Cell cell3 = row.createCell(2);
				cell3.setCellValue(displayedColumn.get(i).getText() + "_NEW");
			}
			String filePath = System.getProperty("user.dir") + "//GetData//Output.xlsx";
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
				System.out.println("Data has been saved to " + filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void unhideAllAnotherJurisdictionLocalizationColumnFromDisplayedIIconTable() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.scroll(sectionNameDisplayedIIconTable, "scrollToElement", "Displayed I Icon Table Name");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		Thread.sleep(1000);
		CommonLibref.click(unhideQuebecJurisdictionLocalization, "javascriptClick",
				"unhideQuebecJurisdictionLocalization");
		Thread.sleep(1000);
		CommonLibref.click(unhideNovaScotiaJurisdictionLocalization, "javascriptClick",
				"unhideQuebecJurisdictionLocalization");
		Thread.sleep(1000);
		CommonLibref.click(unhideWashingtonJurisdictionLocalization, "javascriptClick",
				"unhideWashingtonJurisdictionLocalization");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForKey, "javascriptClick", "hideButtonForKey");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForDescription, "javascriptClick", "hideButtonForDescription");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForDefaultEnglish, "javascriptClick", "hideButtonForDefaultEnglish");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForBaseLangEnglish, "javascriptClick", "hideButtonForBaseLangEnglish");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		System.out.println(
				"Step: Click on Columns menu of Displayed i Icon Table and unhide a hidden Quebec localization Nova Scotia localization and Washington localization columns");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Columns menu of Displayed i Icon Table and unhide a hidden Quebec localization Nova Scotia localization and Washington localization columns");
		String quebecLocalizationColumnFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(quebecLocalizationColumnFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(quebecLocalizationColumnFromDisplayedIIcaonTableActual, "Quebec Localization",
				"Matched Expected and actual = Quebec Localization",
				"Matched Expected and actual = Quebec Localization");
		System.out.println("Matched Expected and actual =" + quebecLocalizationColumnFromDisplayedIIcaonTableActual);
		String novaScotiatonLocalizationColumnFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(novaScotiatonLocalizationColumnFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(novaScotiatonLocalizationColumnFromDisplayedIIcaonTableActual,
				"Nova Scotia Localization", "Matched Expected and actual = Nova Scotia Localization",
				"Matched Expected and actual = Nova Scotia Localization");
		System.out.println(
				"Matched Expected and actual =" + novaScotiatonLocalizationColumnFromDisplayedIIcaonTableActual);
		String washingtonLocalizationColumnFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(washingtonLocalizationColumnFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(washingtonLocalizationColumnFromDisplayedIIcaonTableActual,
				"Washington Localization", "Matched Expected and actual = Washington Localization",
				"Matched Expected and actual = Washington Localization");
		System.out
				.println("Matched Expected and actual =" + washingtonLocalizationColumnFromDisplayedIIcaonTableActual);
	}

	public void unhideWashingtonLocalizationColumnFromDisplayedIIconTable() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.scroll(sectionNameDisplayedIIconTable, "scrollToElement", "Displayed I Icon Table Name");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		Thread.sleep(1000);
		CommonLibref.click(unhideWashingtonJurisdictionLocalization, "javascriptClick",
				"unhideWashingtonJurisdictionLocalization");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForKey, "javascriptClick", "hideButtonForKey");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForDescription, "javascriptClick", "hideButtonForDescription");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		System.out.println(
				"Step: Click on Columns menu of Displayed i Icon Table and unhide the hidden Washington localization column");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Columns menu of Displayed i Icon Table and unhide the hidden Washington localization column");
		String washingtonLocalizationColumnFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(washingtonLocalizationColumnFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(washingtonLocalizationColumnFromDisplayedIIcaonTableActual,
				"Washington Localization", "Matched Expected and actual = Washington Localization",
				"Matched Expected and actual = Washington Localization");
		System.out
				.println("Matched Expected and actual =" + washingtonLocalizationColumnFromDisplayedIIcaonTableActual);
	}

	public void unhideNovaScotiaLocalizationColumnFromDisplayedIIconTable() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.scroll(sectionNameDisplayedIIconTable, "scrollToElement", "Displayed I Icon Table Name");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		Thread.sleep(1000);
		CommonLibref.click(unhideNovaScotiaJurisdictionLocalization, "javascriptClick",
				"unhideNovaScotiaJurisdictionLocalization");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForKey, "javascriptClick", "hideButtonForKey");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForDescription, "javascriptClick", "hideButtonForDescription");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		System.out.println(
				"Step: Click on Columns menu of Displayed i Icon Table and unhide the hidden Nova Scotia localization column");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Columns menu of Displayed i Icon Table and unhide the hidden Nova Scotia localization column");
		String novaScotiatonLocalizationColumnFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(novaScotiatonLocalizationColumnFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(novaScotiatonLocalizationColumnFromDisplayedIIcaonTableActual,
				"Nova Scotia Localization", "Matched Expected and actual = Nova Scotia Localization",
				"Matched Expected and actual = Nova Scotia Localization");
		System.out.println(
				"Matched Expected and actual =" + novaScotiatonLocalizationColumnFromDisplayedIIcaonTableActual);
	}

	public void unhideQuebecLocalizationColumnFromDisplayedIIconTable() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.scroll(sectionNameDisplayedIIconTable, "scrollToElement", "Displayed I Icon Table Name");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		Thread.sleep(1000);
		CommonLibref.click(unhideQuebecJurisdictionLocalization, "javascriptClick",
				"unhideQuebecJurisdictionLocalization");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForKey, "javascriptClick", "hideButtonForKey");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForDescription, "javascriptClick", "hideButtonForDescription");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		System.out.println(
				"Step: Click on Columns menu of Displayed i Icon Table and unhide the hidden Quebec localization column");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Columns menu of Displayed i Icon Table and unhide the hidden Quebec localization column");
		String quebecLocalizationColumnFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(quebecLocalizationColumnFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(quebecLocalizationColumnFromDisplayedIIcaonTableActual, "Quebec Localization",
				"Matched Expected and actual = Quebec Localization",
				"Matched Expected and actual = Quebec Localization");
		System.out.println("Matched Expected and actual =" + quebecLocalizationColumnFromDisplayedIIcaonTableActual);
	}

	public void editButtonFunctionalityOfPageContentAccordion() throws InterruptedException {
		Thread.sleep(8000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.click(btnEditFromPageContent, "seleniumClick", "btnEditFromPageContent");
		System.out.println("Step: Click on Edit button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Edit button");
		String btnCancelForPageContentAccordionActual = CommonLibref.getTextElement(btnCancelForPageContentAccordion);
		CommonLibref.verifyTextTypeString(btnCancelForPageContentAccordionActual, "CANCEL",
				"Matched Expected and Actual = CANCEL Button", "Matched Expected and Actual = CANCEL Button");
		System.out.println("Matched Expected and Actual = " + btnCancelForPageContentAccordionActual);
		String btnSaveForPageContentAccordionActual = CommonLibref.getTextElement(btnSaveForPageContentAccordion);
		CommonLibref.verifyTextTypeString(btnSaveForPageContentAccordionActual, "SAVE",
				"Matched Expected and Actual = CANCEL Button", "Matched Expected and Actual = CANCEL Button");
		System.out.println("Matched Expected and Actual = " + btnSaveForPageContentAccordionActual);
		String btnPublishForPageContentAccordionActual = CommonLibref.getTextElement(btnPublsihForPageContentAccordion);
		CommonLibref.verifyTextTypeString(btnPublishForPageContentAccordionActual, "PUBLISH",
				"Matched Expected and Actual = PUBLISH button", "Matched Expected and Actual = PUBLISH button");
		System.out.println("Matched Expected and Actual = " + btnPublishForPageContentAccordionActual);
	}

	public void displayedI_iconTableFromPageContentAccordion() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		CommonLibref.scroll(sectionNameDisplayedIIconTable, "scrollToElement", "sectionNameDisplayedIIconTable");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sectionNameDisplayedIIconTable));
		String sectionNameDisplayedIIconTableActual = CommonLibref.getTextElement(sectionNameDisplayedIIconTable);
		CommonLibref.verifyTextTypeString(sectionNameDisplayedIIconTableActual, "Displayed 'i' Icons",
				"Matched Expected and Actual = Displayed I Icon Table Name",
				"Matched Expected and Actual = Displayed I Icon Table Name");
		System.out.println("Matched Expected and Actual =" + sectionNameDisplayedIIconTableActual);
		String columnsOptionFromDisplayedIIconTableActaul = CommonLibref
				.getTextElement(columnsOptionFromDisplayedIIconTable);
		CommonLibref.verifyTextTypeString(columnsOptionFromDisplayedIIconTableActaul, "Columns",
				"Matched Expected and Actual = Columns", "Matched Expected and Actual = Columns");
		System.out.println("Matched Expected and Actual =" + columnsOptionFromDisplayedIIconTableActaul);
		String filtersOptionFromDisplayedIIconTableActaul = CommonLibref
				.getTextElement(filtersOptionFromDisplayedIIconTable);
		CommonLibref.verifyTextTypeString(filtersOptionFromDisplayedIIconTableActaul, "0\n" + "Filters",
				"Matched Expected and Actual = Filters", "Matched Expected and Actual = Filters");
		System.out.println("Matched Expected and Actual =" + filtersOptionFromDisplayedIIconTableActaul);
		String exportOptionFromDisplayedIIconTableActaul = CommonLibref
				.getTextElement(exportOptionFromDisplayedIIconTable);
		CommonLibref.verifyTextTypeString(exportOptionFromDisplayedIIconTableActaul, "Export",
				"Matched Expected and Actual = Export", "Matched Expected and Actual = Export");
		System.out.println("Matched Expected and Actual =" + exportOptionFromDisplayedIIconTableActaul);
		String searchBarFromDisplayedIIconTableActual = CommonLibref.getTextElement(searchBarFromDisplayedIIconTable);
		// CommonLibref.verifyTextTypeString(searchBarFromDisplayedIIconTableActual,
		// "Search…", "Matched Expected and Actual = Search Bar", "Matched Expected and
		// Actual = Search Bar");
		System.out.println("Matched Expected and Actual =" + searchBarFromDisplayedIIconTableActual);
		String btnEditFromPageContentActual = CommonLibref.getTextElement(btnEditFromPageContent);
		CommonLibref.verifyTextTypeString(btnEditFromPageContentActual, "EDIT", "Matched Expected and Actual",
				"Matched Expected and Actual");
		System.out.println("Matched Expected and Actual =" + btnEditFromPageContentActual);
		String displayedNextToLabelColumFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(displayedNextToLabelColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(displayedNextToLabelColumFromDisplayedIIcaonTableActual,
				"Displayed Next to Label", "Matched Expected and Actual = Displayed Next to Label",
				"Matched Expected and Actual = Displayed Next to Label");
		System.out.println("Matched Expected and Actual =" + displayedNextToLabelColumFromDisplayedIIcaonTableActual);
		String keyColumFromDisplayedIIcaonTableActual = CommonLibref.getTextElement(keyColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(keyColumFromDisplayedIIcaonTableActual, "Key",
				"Matched Expected and Actual = Key", "Matched Expected and Actual = Key");
		System.out.println("Matched Expected and Actual =" + keyColumFromDisplayedIIcaonTableActual);
		String descriptionColumFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(descriptionColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(descriptionColumFromDisplayedIIcaonTableActual, "Description",
				"Matched Expected and Actual = Description", "Matched Expected and Actual = Description");
		System.out.println("Matched Expected and Actual =" + descriptionColumFromDisplayedIIcaonTableActual);
		String defaultEnglishColumFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(defaultEnglishColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(defaultEnglishColumFromDisplayedIIcaonTableActual, "Default English",
				"Matched Expected and Actual = Default English", "Matched Expected and Actual = Default English");
		System.out.println("Matched Expected and Actual =" + defaultEnglishColumFromDisplayedIIcaonTableActual);
		String baseLangEnglishColumFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(baseLangEnglishColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(baseLangEnglishColumFromDisplayedIIcaonTableActual, "Base Language English",
				"Matched Expected and Actual = Base Language English",
				"Matched Expected and Actual = Base Language English");
		System.out.println("Matched Expected and Actual =" + baseLangEnglishColumFromDisplayedIIcaonTableActual);
		String jurisdictionLocalizationColumFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(jurisdictionLocalizationColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(jurisdictionLocalizationColumFromDisplayedIIcaonTableActual,
				"Jurisdiction Localization", "Matched Expected and Actual = Jurisdiction Localization",
				"Matched Expected and Actual = Jurisdiction Localization");
		System.out
				.println("Matched Expected and Actual =" + jurisdictionLocalizationColumFromDisplayedIIcaonTableActual);
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		Thread.sleep(1000);
		CommonLibref.click(hideButtonForKey, "javascriptClick", "hideButtonForKey");
		Thread.sleep(2000);
		CommonLibref.click(hideButtonForDescription, "javascriptClick", "hideButtonForDescription");
		Thread.sleep(2000);
		CommonLibref.click(columnsOptionFromDisplayedIIconTable, "seleniumClick",
				"columnsOptionFromDisplayedIIconTable");
		Thread.sleep(2000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(displayedColumFromDisplayedIIcaonTable));
		String displayedColumFromDisplayedIIcaonTableActual = CommonLibref
				.getTextElement(displayedColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(displayedColumFromDisplayedIIcaonTableActual, "Displayed",
				"Matched Expected and Actual = Displayed", "Matched Expected and Actual = Displayed");
		System.out.println("Matched Expected and Actual =" + displayedColumFromDisplayedIIcaonTableActual);
		String pageColumFromDisplayedIIcaonTableActual = CommonLibref.getTextElement(pageColumFromDisplayedIIcaonTable);
		CommonLibref.verifyTextTypeString(pageColumFromDisplayedIIcaonTableActual, "Page",
				"Matched Expected and Actual = Page", "Matched Expected and Actual = Page");
		System.out.println("Matched Expected and Actual =" + pageColumFromDisplayedIIcaonTableActual);
		System.out.println("Step: Observe Displayed i Icons section");
		ObjectRepo.test.log(Status.PASS, "Step: Observe Displayed i Icons section");
	}

	public void goToContentManagementPage() throws InterruptedException {
		Thread.sleep(35000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(menuBarOptionSettings));
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(menuBarOptionSettings));
		CommonLibref.click(menuBarOptionSettings, "seleniumClick", "menuBarOptionSettings");
		System.out.println("Step: Click on Settings menu");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Settings menu");
		System.out.println("Step: Click on Content Management System option");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Content Management System option");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(optionContentManagementSystem));
		CommonLibref.click(optionContentManagementSystem, "seleniumClick", "optionContentManagementSystem");
		System.out.println("Step: Click on Settings menu");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Settings menu");
	}
	
	public void afterSearchButtonfunctionalityOfPageContentAccordion() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		System.out.println("-------------------------------Expected--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Expected--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(accordionPageContent));
		String displayedValueTableSectionNameActual = CommonLibref.getTextElement(displayedValueTableSectionName);
		CommonLibref.verifyTextTypeString(displayedValueTableSectionNameActual, "Displayed Value",
				"Matched Expected and Actual = " + displayedValueTableSectionNameActual, "Matched Expected and Actual = " + displayedValueTableSectionNameActual);
		System.out.println("Matched Expected and Actual = " + displayedValueTableSectionNameActual);
		String sectionNameDisplayedIIconTableActual = CommonLibref.getTextElement(sectionNameDisplayedIIconTable);
		CommonLibref.verifyTextTypeString(sectionNameDisplayedIIconTableActual, "Displayed 'i' Icons",
				"Matched Expected and Actual = " + sectionNameDisplayedIIconTableActual, "Matched Expected and Actual = " + sectionNameDisplayedIIconTableActual);
		System.out.println("Matched Expected and Actual = " + sectionNameDisplayedIIconTableActual);
		String informationalContentSectionNameActual = CommonLibref.getTextElement(informationalContentSectionName);
		CommonLibref.verifyTextTypeString(informationalContentSectionNameActual, "INFORMATIONAL CONTENT",
				"Matched Expected and Actual = " + informationalContentSectionNameActual, "Matched Expected and Actual = " + informationalContentSectionNameActual);
		System.out.println("Matched Expected and Actual = " + informationalContentSectionNameActual);
		String toastMessagesSectionNameActual = CommonLibref.getTextElement(toastMessagesSectionName);
		CommonLibref.verifyTextTypeString(toastMessagesSectionNameActual, "TOAST MESSAGES",
				"Matched Expected and Actual = " + toastMessagesSectionNameActual, "Matched Expected and Actual = " + toastMessagesSectionNameActual);
		System.out.println("Matched Expected and Actual = " + toastMessagesSectionNameActual);
		String btnEditFromPageContentActual = CommonLibref.getTextElement(btnEditFromPageContent);
		CommonLibref.verifyTextTypeString(btnEditFromPageContentActual, "EDIT",
				"Matched Expected and Actual = " + btnEditFromPageContentActual, "Matched Expected and Actual = " + btnEditFromPageContentActual);
		System.out.println("Matched Expected and Actual = " + btnEditFromPageContentActual);
	}

	public void searchButtonfunctionalityOfPageContentAccordion() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(accordionPageContent));
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(accordionPageContent));
		CommonLibref.click(accordionPageContent, "seleniumClick", "accordionPageContent");
		System.out.println("Step: Click on Page content Accordion from Language and Localization section");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Page content Accordion from Language and Localization section");
		String labelSelectALangFromPageContentActual = CommonLibref.getTextElement(labelSelectALangFromPageContent);
		CommonLibref.verifyTextTypeString(labelSelectALangFromPageContentActual, "Select a Language*",
				"Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual =" + labelSelectALangFromPageContentActual);
		String labelSelectAPageFromPageContentActual = CommonLibref.getTextElement(labelSelectAPageFromPageContent);
		CommonLibref.verifyTextTypeString(labelSelectAPageFromPageContentActual, "Select a Page*",
				"Matched Expected and Actual = Select a Page*", "Matched Expected and Actual = Select a Page*");
		System.out.println("Matched Expected and Actual =" + labelSelectAPageFromPageContentActual);
		String btnSearchFromPageContentActual = CommonLibref.getTextElement(btnSearchFromPageContent);
		CommonLibref.verifyTextTypeString(btnSearchFromPageContentActual, "SEARCH",
				"Matched Expected and Actual = SEARCH button", "Matched Expected and Actual = SEARCH button");
		System.out.println("Matched Expected and Actual =" + btnSearchFromPageContentActual);
		String btnResetFromPageContentActual = CommonLibref.getTextElement(btnResetFromPageContent);
		CommonLibref.verifyTextTypeString(btnResetFromPageContentActual, "RESET",
				"Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual =" + btnResetFromPageContentActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(dropdownSelectLangFromPageConetent));
		CommonLibref.click(dropdownSelectLangFromPageConetent, "seleniumClick", "dropdownSelectLangFromPageConetent");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(optionEnglishLang));
		CommonLibref.click(optionEnglishLang, "seleniumClick", "optionEnglishLang");
		System.out.println("Step: Click on Select Language dropdown and select language from Language dropdown");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Select Language dropdown and select language from Language dropdown");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(dropdownSelectPageFromPageContent));
		CommonLibref.click(dropdownSelectPageFromPageContent, "seleniumClick", "dropdownSelectPageFromPageContent");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(optionContactUsPage));
		CommonLibref.click(optionContactUsPage, "seleniumClick", "optionContactUsPage");
		System.out.println("Step: Click on Select a Page dropdown and select page from Page Dropdown");
		ObjectRepo.test.log(Status.PASS,
				"Step: Step: Click on Select a Page dropdown and select page from Page Dropdown");
		CommonLibref.isEnabled(btnSearchFromPageContent, "btnSearchFromPageContent");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(btnSearchFromPageContent));
		CommonLibref.click(btnSearchFromPageContent, "seleniumClick", "btnSearchFromPageContent");
		System.out.println("Step: Click on Search button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Search button");
	}
	
	public void resetButtonfunctionalityOfPageContentAccordion() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(accordionPageContent));
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(accordionPageContent));
		CommonLibref.click(accordionPageContent, "seleniumClick", "accordionPageContent");
		System.out.println("Step: Click on Page content Accordion from Language and Localization section");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Page content Accordion from Language and Localization section");
		String labelSelectALangFromPageContentActual = CommonLibref.getTextElement(labelSelectALangFromPageContent);
		CommonLibref.verifyTextTypeString(labelSelectALangFromPageContentActual, "Select a Language*",
				"Matched Expected and Actual = Select a Language*", "Matched Expected and Actual = Select a Language*");
		System.out.println("Matched Expected and Actual =" + labelSelectALangFromPageContentActual);
		String labelSelectAPageFromPageContentActual = CommonLibref.getTextElement(labelSelectAPageFromPageContent);
		CommonLibref.verifyTextTypeString(labelSelectAPageFromPageContentActual, "Select a Page*",
				"Matched Expected and Actual = Select a Page*", "Matched Expected and Actual = Select a Page*");
		System.out.println("Matched Expected and Actual =" + labelSelectAPageFromPageContentActual);
		String btnSearchFromPageContentActual = CommonLibref.getTextElement(btnSearchFromPageContent);
		CommonLibref.verifyTextTypeString(btnSearchFromPageContentActual, "SEARCH",
				"Matched Expected and Actual = SEARCH button", "Matched Expected and Actual = SEARCH button");
		System.out.println("Matched Expected and Actual =" + btnSearchFromPageContentActual);
		String btnResetFromPageContentActual = CommonLibref.getTextElement(btnResetFromPageContent);
		CommonLibref.verifyTextTypeString(btnResetFromPageContentActual, "RESET",
				"Matched Expected and Actual = RESET button", "Matched Expected and Actual = RESET button");
		System.out.println("Matched Expected and Actual =" + btnResetFromPageContentActual);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(dropdownSelectLangFromPageConetent));
		CommonLibref.click(dropdownSelectLangFromPageConetent, "seleniumClick", "dropdownSelectLangFromPageConetent");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(optionEnglishLang));
		CommonLibref.click(optionEnglishLang, "seleniumClick", "optionEnglishLang");
		System.out.println("Step: Click on Select Language dropdown and select language from Language dropdown");
		ObjectRepo.test.log(Status.PASS,
				"Step: Click on Select Language dropdown and select language from Language dropdown");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(dropdownSelectLangFromPageConetent));
		String beforeResetdropdownSelectLangFromPageConetent = CommonLibref.getTextElement(dropdownSelectLangFromPageConetent);
		CommonLibref.verifyTextTypeString(beforeResetdropdownSelectLangFromPageConetent, beforeResetdropdownSelectLangFromPageConetent,
				"Before reset value of Select a Language dropdown ="+beforeResetdropdownSelectLangFromPageConetent, "Before reset value of Select a Language dropdown ="+beforeResetdropdownSelectLangFromPageConetent);
		System.out.println("Before reset value of Select a Language dropdown =" + beforeResetdropdownSelectLangFromPageConetent);
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(dropdownSelectPageFromPageContent));
		CommonLibref.click(dropdownSelectPageFromPageContent, "seleniumClick", "dropdownSelectPageFromPageContent");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(optionContactUsPage));
		CommonLibref.click(optionContactUsPage, "seleniumClick", "optionContactUsPage");
		System.out.println("Step: Click on Select a Page dropdown and select page from Page Dropdown");
		ObjectRepo.test.log(Status.PASS,
				"Step: Step: Click on Select a Page dropdown and select page from Page Dropdown");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(dropdownSelectPageFromPageContent));
		Thread.sleep(2000);
		String beforeResetdropdownSelectPageFromPageContentt = dropdownSelectPageFromPageContent.getAttribute("Value");
		CommonLibref.verifyTextTypeString(beforeResetdropdownSelectPageFromPageContentt, beforeResetdropdownSelectPageFromPageContentt,
				"Before reset value of Select a Page dropdown ="+beforeResetdropdownSelectPageFromPageContentt, "Before reset value of Select a Page dropdown ="+beforeResetdropdownSelectPageFromPageContentt);
		System.out.println("Before reset value of Select a Page dropdown =" + beforeResetdropdownSelectPageFromPageContentt);
		CommonLibref.isEnabled(btnSearchFromPageContent, "btnSearchFromPageContent");
		System.out.println("-------------------------------Step--------------------------------------");
		ObjectRepo.test.log(Status.PASS, "-------------------------------Step--------------------------------------");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(btnResetFromPageContent));
		CommonLibref.click(btnResetFromPageContent, "seleniumClick", "btnSearchFromPageContent");
		System.out.println("Step: Click on Reset button");
		ObjectRepo.test.log(Status.PASS, "Step: Click on Reset button");
		Thread.sleep(4000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(dropdownSelectLangFromPageConetent));
		String afterResetdropdownSelectLangFromPageConetent = CommonLibref.getTextElement(dropdownSelectLangFromPageConetent);
		CommonLibref.verifyTextTypeString(afterResetdropdownSelectLangFromPageConetent, afterResetdropdownSelectLangFromPageConetent,
				"After reset value of Select a Language dropdown ="+afterResetdropdownSelectLangFromPageConetent, "After reset value of Select a Language dropdown ="+afterResetdropdownSelectLangFromPageConetent);
		System.out.println("After reset value of Select a Language dropdown =" + afterResetdropdownSelectLangFromPageConetent);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(dropdownSelectPageFromPageContent));
		String afterResetdropdownSelectPageFromPageContentt = dropdownSelectPageFromPageContent.getAttribute("Value");
		CommonLibref.verifyTextTypeString(afterResetdropdownSelectPageFromPageContentt, afterResetdropdownSelectPageFromPageContentt,
				"After reset value of Select a Page dropdown ="+afterResetdropdownSelectPageFromPageContentt, "After reset value of Select a Page dropdown ="+afterResetdropdownSelectPageFromPageContentt);
		System.out.println("After reset value of Select a Page dropdown =" + afterResetdropdownSelectPageFromPageContentt);	
		Assert.assertNotEquals(beforeResetdropdownSelectLangFromPageConetent,afterResetdropdownSelectLangFromPageConetent);
		Assert.assertNotEquals(beforeResetdropdownSelectPageFromPageContentt,afterResetdropdownSelectPageFromPageContentt);
	}

}
