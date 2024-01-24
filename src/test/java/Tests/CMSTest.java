package Tests;

import org.testng.annotations.Test;

import com.CMS.Utility.TestBase;
import com.CMS.pom.FunctionalityPom;
import com.CMS.pom.LoginPom;

public class CMSTest extends TestBase {
	
	/*
     *TC_Id      : C47323
     *Tc_Title   : Verify that Search Button Functionality on the "Page Content" on Content Management page
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 1,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_that_Search_Button_Functionality_on_the_Page_Content_on_Content_Management_page() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.displayedI_iconTableFromPageContentAccordion();
	}
	
	/*
     *TC_Id      : C47325
     *Tc_Title   : Verify "Edit" button of  Page Content  accordion on Content Management page
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 2,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Edit_button_of_Page_Content_accordion_on_Content_Management_page() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.editButtonFunctionalityOfPageContentAccordion();
	}
	
	/*
     *TC_Id      : C47326
     *Tc_Title   : Verify that the Jurisdiction System Admin from California Jurisdiction is able to see the localization for Quebec Jurisdiction for “Page Content” Section – Keytype “’i’ icons”
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 3,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_that_the_Jurisdiction_System_Admin_from_California_Jurisdiction_is_able_to_see_the_localization_for_Quebec_Jurisdiction_for_Page_Content_Section_Keytype_i_icons() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.unhideQuebecLocalizationColumnFromDisplayedIIconTable();
	}
	
	/*
     *TC_Id      : C47327
     *Tc_Title   : Verify that the Jurisdiction System Admin from California Jurisdiction is able to see the localization for NovaScotia Jurisdiction for “Page Content” Section – Keytype “’i’ icons”
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 4,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_that_the_Jurisdiction_System_Admin_from_California_Jurisdiction_is_able_to_see_the_localization_for_Nova_Scotia_Jurisdiction_for_Page_Content_Section_Keytype_i_icons() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.unhideNovaScotiaLocalizationColumnFromDisplayedIIconTable();
	}
	
	/*
     *TC_Id      : C47328
     *Tc_Title   : Verify that the Jurisdiction System Admin from California Jurisdiction is able to see the localization for Washington Jurisdiction for “Page Content” Section – Keytype “’i’ icons”
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 5,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_that_the_Jurisdiction_System_Admin_from_California_Jurisdiction_is_able_to_see_the_localization_for_Washington_Jurisdiction_for_Page_Content_Section_Keytype_i_icons() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.unhideWashingtonLocalizationColumnFromDisplayedIIconTable();
	}
	
	/*
     *TC_Id      : C47329
     *Tc_Title   : Verify that the Jurisdiction System Admin from California Jurisdiction is able to see All localization for another Jurisdiction for “Page Content” Section – Keytype “’i’ icons”
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 6,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_that_the_Jurisdiction_System_Admin_from_California_Jurisdiction_is_able_to_see_All_localization_for_another_Jurisdiction_for_Page_Content_Section_Keytype_i_icons() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.unhideAllAnotherJurisdictionLocalizationColumnFromDisplayedIIconTable();
	}
	
	/*
     *TC_Id      : 
     *Tc_Title   : 
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 1,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void contactUsPage() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.getContactUsPagedataFromDisplayedTableColumn();
		ref2.sendDataFromExcelToField();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.sendDataFromExcelToField_Reverse();
	}
	
	/*
     *TC_Id      : C47954
     *Tc_Title   : Verify That WCI, Inc. Admin can Edit One or More Values from  the  Base Language <as selected> column Using Search by Displayed Value tab Under Value Accordion
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 7,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_That_WCI_Inc_Admin_can_Edit_One_or_More_Values_from_the_Base_Language_as_selected_column_Using_Search_by_Displayed_Value_tab_Under_Value_Accordion() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByDisplayedValueTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47955
     *Tc_Title   : Verify That WCI, Inc. Admin can Edit One or More Values from  the  Base Language <as selected> column Using Search by key or value tab Under Value Accordion
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 8,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_That_WCI_Inc_Admin_can_Edit_One_or_More_Values_from_the_Base_Language_as_selected_column_Using_Search_by_key_or_value_tab_Under_Value_Accordion() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByKeyOrValueTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47956
     *Tc_Title   : Verify That WCI, Inc. Admin can Edit One or More Values from  the Base Language <as selected>  Column Using Search by Page" Tab
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 9,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_That_WCI_Inc_Admin_can_Edit_One_or_More_Values_from_the_Base_Language_as_selected_Column_Using_Search_by_Page_Tab() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByPageTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
	}
	
	/*
     *TC_Id      : C47960
     *Tc_Title   : Verify Cancel changes Functionality  Using Search by Page Under Value Accordion as a WCI, Inc. Admin User
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 10,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Cancel_changes_Functionality_Using_Search_by_Page_Under_Value_Accordion_as_a_WCI_Inc_Admin_User() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByPageTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
		ref2.cancelButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
	}
	
	/*
     *TC_Id      : C47961
     *Tc_Title   : Verify Cancel changes Functionality  Using Search by  Displayed Value tab Under Value Accordion as a WCI, Inc. Admin User
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 11,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Cancel_changes_Functionality_Using_Search_by_Displayed_Value_tab_Under_Value_Accordion_as_a_WCI_Inc_Admin_User() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByDisplayedValueTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.cancelButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
	}
	
	/*
     *TC_Id      : C47962
     *Tc_Title   : Verify Cancel changes Functionality  Using Search by key or Value tab Under Value Accordion as a WCI, Inc. Admin User
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 12,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Cancel_changes_Functionality_Using_Search_by_key_or_Value_tab_Under_Value_Accordion_as_a_WCI_Inc_Admin_User() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByKeyOrValueTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.cancelButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
	}
	
	/*
     *TC_Id      : C47957
     *Tc_Title   : Verify That WCI, Inc. Admin can  "Save" updated values in the column by Using the "Search by Value or key" Tab
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 13,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_That_WCI_Inc_Admin_can_Save_updated_values_in_the_column_by_Using_the_Search_by_Value_or_key_Tab() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByKeyOrValueTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.saveButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.reverseTheEditAndSaveValues();
	}
	
	/*
     *TC_Id      : C47959
     *Tc_Title   : Verify that WCI, Inc. Admin user can  "Save" updated values in the column by Using "Search by Displayed Value" Tab
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 14,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_that_WCI_Inc_Admin_user_can_Save_updated_values_in_the_column_by_Using_Search_by_Displayed_Value_Tab() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByDisplayedValueTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.saveButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.reverseTheEditAndSaveValues();
	}
	
	/*
     *TC_Id      : C47958
     *Tc_Title   : Verify that  WCI, Inc. Admin user can  "Save" updated values in the column by Using "Search by Page" Tab
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 15,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_that_WCI_Inc_Admin_user_can_Save_updated_values_in_the_column_by_Using_Search_by_Page_Tab() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithWCIIncAdminUser();
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByPageTab();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		//ref2.editOneValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.saveButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.reverseTheEditAndSaveValues();
	}
	
	/*
     *TC_Id      : C47359
     *Tc_Title   : Verify "Edit" button functionality Using "Search by Value or key" Tab "Values" Accordion
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 16,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Edit_button_functionality_Using_Search_by_Value_or_key_Tab_Values_Accordion() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByKeyOrValueTabFromvaluesAccordianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47360
     *Tc_Title   : Verify "Edit" button functionality Using "Search by Page" Tab on Value Accordion
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 17,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Edit_button_functionality_Using_Search_by_Page_Tab_on_Value_Accordion() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByPageTabOfValuesAccrodianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47361
     *Tc_Title   : Verify "Edit" functionality Using "Search by Displayed Value" Tab on Value Accordion
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 18,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Edit_functionality_Using_Search_by_Displayed_Value_Tab_on_Value_Accordion() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByDisplayedValueTabFromValuesAccordianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47362
     *Tc_Title   : Verify That JSA(Jurisdiction System Admin) can Edit One or More Values from displayed Column Using Search by Displayed Value" Tab
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 19,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_That_JSA_Jurisdiction_System_Admin_can_Edit_One_or_More_Values_from_displayed_Column_Using_Search_by_Displayed_Value_Tab() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByDisplayedValueTabFromValuesAccordianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editMoreValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47363
     *Tc_Title   : Verify That JSA(Jurisdiction System Admin) can Edit One or More Value from displayed Column Using Search by key or value" Tab
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 20,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_That_JSA_Jurisdiction_System_Admin_can_Edit_One_or_More_Value_from_displayed_Column_Using_Search_by_key_or_value_Tab() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByKeyOrValueTabFromvaluesAccordianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editMoreValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47364
     *Tc_Title   : Verify That JSA(Jurisdiction System Admin) can Edit One or More Values from displayed Column Using Search by Page" Tab
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 21,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_That_JSA_Jurisdiction_System_Admin_can_Edit_One_or_More_Values_from_displayed_Column_Using_Search_by_Page_Tab() throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByPageTabOfValuesAccrodianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editMoreValuesFromBaselanguageColumnByWCIadmin();
	}
	
	/*
     *TC_Id      : C47368
     *Tc_Title   : Verify Cancel changes Functionality  Using Search by Page
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 22,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Cancel_changes_Functionality_Using_Search_by_Page () throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByPageTabOfValuesAccrodianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.cancelButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
	}
	
	/*
     *TC_Id      : C47463
     *Tc_Title   : Verify Cancel changes Functionality Using Search by Displayed Value
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 23,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Cancel_changes_Functionality_Using_Search_by_Displayed_Value () throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByDisplayedValueTabFromValuesAccordianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.cancelButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
	}
	
	/*
     *TC_Id      : C47464
     *Tc_Title   : Verify Cancel changes Functionality Using Search by key or Value
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 24,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verify_Cancel_changes_Functionality_Using_Search_by_key_or_Value () throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonFunctionalityOfSearchByKeyOrValueTabFromvaluesAccordianByJSAUser();
		ref2.moreActionsButtonFunctionalityForValuesAccrodian();
		ref2.editButtonOfmoreActionsFunctionalityForValuesAccrodian();
		ref2.editOneValuesFromBaselanguageColumnByWCIadmin();
		ref2.cancelButtonFunctionalityValuesFromBaselanguageColumnByWCIadminFromSelectingPage();
	}
	
	/*
     *TC_Id      : C47354
     *Tc_Title   : Verification of "Search" button functionality of "Page Content" Accordion
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 25,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Search_button_functionality_of_Page_Content_Accordion () throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.searchButtonfunctionalityOfPageContentAccordion();
		ref2.afterSearchButtonfunctionalityOfPageContentAccordion();
	}
	
	/*
     *TC_Id      : C47465
     *Tc_Title   : Verification of "Reset" button functionality of "Page Content" Accordion
     *Author     : pravin.jogi@eqanim.com
     */
	@Test(priority = 26,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Reset_button_functionality_of_Page_Content_Accordion () throws Exception {
		LoginPom ref1 = new LoginPom(driver,prop);
		FunctionalityPom ref2 = new FunctionalityPom(driver,prop);
		ref1.selectJurisdictionAndLangaugeForLandingPageForUnknown("California");
		ref1.loginWithJSAUser("California");
		ref1.handlesecurityQuestion();
		ref2.goToContentManagementPage();
		ref2.resetButtonfunctionalityOfPageContentAccordion();
	}
	
	
	

}
