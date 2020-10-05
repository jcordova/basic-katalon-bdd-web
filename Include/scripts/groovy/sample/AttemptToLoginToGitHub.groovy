package sample

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class AttemptToLoginToGitHub {

	// DATA DEFINITION
	String loginpage = findTestData('Credentials').getValue('Base URL', 1)
	String username = findTestData('Credentials').getValue('Username', 1)
	String password = findTestData('Credentials').getValue('Password', 1)
	String errorMessage = findTestData('Credentials').getValue('Error Message', 1)

	@Given('I navigate to GitHub loginpage')
	def I_navigate_to_GitHub_startpage() {
		WebUI.openBrowser(null)
		WebUI.navigateToUrl(loginpage)
	}

	@When('I enter invalid username "(.*)"')
	def I_enter_invalid_username(String username) {
		WebUI.setText(findTestObject('GitHub_LoginPage/USERNAME_TEXTBOX'), username)
	}

	@And('I enter invalid password "(.*)"')
	def I_enter_invalid_password(String password) {
		WebUI.setText(findTestObject('GitHub_LoginPage/PASSWORD_TEXTBOX'), password)
	}

	@And('I click Sign In button')
	def I_click_Sign_In_button() {
		WebUI.click(findTestObject('GitHub_LoginPage/SIGN_IN_BUTTON'))
	}

	@Then('I should fail to login')
	def I_should_fail_to_login() {
		WebUI.verifyTextPresent(errorMessage, false)
		WebUI.closeBrowser()
	}
}