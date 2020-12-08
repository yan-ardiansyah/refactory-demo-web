import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.comment(testcase)

'Launch the Web'
WebUI.openBrowser(GlobalVariable.url)

today = new Date()
String todaysDate = today.format('MM_dd_yy')
String nowTime = today.format('hh_mm_ss')

WebUI.takeScreenshot(GlobalVariable.ss + todaysDate + nowTime + ".png")

'Wait until Element Home visible'
WebUI.waitForElementVisible(findTestObject('Login/Page_STORE/Home'), 9)

'Verify the store name, when clicked as home button'
WebUI.verifyElementVisible(findTestObject('Login/Page_STORE/Home'), FailureHandling.STOP_ON_FAILURE)

'Verify login menu button'
WebUI.verifyElementVisible(findTestObject('Login/Page_STORE/login_menu'), FailureHandling.STOP_ON_FAILURE)

'Verify login menu button is clickable'
WebUI.verifyElementClickable(findTestObject('Login/Page_STORE/login_menu'))

'Click Log In menu'
WebUI.click(findTestObject('Login/Page_STORE/login_menu'))

'Wait until element input field username visible'
WebUI.waitForElementVisible(findTestObject('Login/Page_STORE/input_Username'), 9)

'Verify element field input username'
WebUI.verifyElementVisible(findTestObject('Login/Page_STORE/input_Username'))

WebUI.takeScreenshot(GlobalVariable.ss + testcase + todaysDate + nowTime + ".png")

'Set username on the field'
WebUI.setText(findTestObject('Login/Page_STORE/input_Username'), username)

'Verify element field input password'
WebUI.verifyElementVisible(findTestObject('Login/Page_STORE/input_Password'))

'Set pasword on the field'
WebUI.setText(findTestObject('Login/Page_STORE/input_Password'), password)

'Verify login button is clickable'
WebUI.verifyElementClickable(findTestObject('Login/Page_STORE/button_Log in'))

'Click Login button'
WebUI.click(findTestObject('Login/Page_STORE/button_Log in'))

if (WebUI.verifyElementVisible(findTestObject('Login/Page_STORE/nama user'), FailureHandling.OPTIONAL)) {
    'Verify element Name of User'
    WebUI.verifyElementVisible(findTestObject('Login/Page_STORE/nama user'))

    'Get Name of User'
    name_user = WebUI.getText(findTestObject('Login/Page_STORE/nama user'))

    'Print nama_user'
    println(name_user)

    'Verify nama_user equal to username var from Data Files'
    WebUI.verifyEqual(name_user, 'Welcome ' + username)

    WebUI.takeScreenshot(GlobalVariable.ss + name_user + todaysDate + nowTime + ".png")
} else {
    'Click Login button'
    WebUI.click(findTestObject('Login/Page_STORE/button_Log in'))

    'Wait for alert appear'
    WebUI.waitForAlert(0)

    'Verify alert present'
    WebUI.verifyAlertPresent(0)

    'Call factory driver function'
    WebDriver driver = DriverFactory.getWebDriver()

    'Get alert text and save it to alert var'
    alert = driver.switchTo().alert().getText()

	WebUI.takeScreenshot(GlobalVariable.ss + alert + todaysDate + nowTime + ".png")
	
	'Print alert var'
    println(alert)

    'Verify alert var value equal to alert_m var from Data Files'
    WebUI.verifyEqual(alert, alert_m)
}

