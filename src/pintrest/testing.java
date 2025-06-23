package pintrest;

import java.util.List;
import java.util.Random;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testing extends TestData {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetup() {

		driver.get("https://uk.pinterest.com/");

		driver.manage().window().maximize();
	}

	public WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/*
	 * Automates the Pinterest signup process by: Clicking the sign-up button
	 * Entering email, password, and birthdate Submitting the form
	 */

	@Test(enabled = false)
	public void signUp() throws InterruptedException {
		WebDriverWait wait = getWait();

		// Wait for the button inside the sign-up div and click it
		WebElement signUpButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[data-test-id='simple-signup-button'] button")));

		signUpButton.click();

		Thread.sleep(3000);

		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(myEmail);

		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordField.sendKeys(myPassword);

		WebElement birthdateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("birthdate")));
		birthdateField.sendKeys(myBirthdate);

		WebElement continuebutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".B1n.tg7.fxm.dyH.xl9.stq")));

		continuebutton.click();

		Thread.sleep(3000);

	}

	/**
	 * Tests the login functionality on Pinterest. Enters valid credentials and
	 * submits the login form.
	 */

//(priority = 1)
	@Test(priority = 1)
	public void login() throws InterruptedException {
		WebDriverWait wait = getWait();

		WebElement loginbutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Log in']")));
		loginbutton.click();

		Thread.sleep(3000);

		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(myEmail);
		Thread.sleep(3000);

		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(myPassword);

		WebElement submitLoginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Log in'])[2]")));
		submitLoginButton.click();

	}

	/**
	 * Tests the 'Forgot Password' feature by: Navigating to the login page Clicking
	 * the reset password link Submitting a reset request using email
	 * 
	 */

	@Test(enabled = false)
	public void forgotPassword() throws InterruptedException {
		WebDriverWait wait = getWait();

		WebElement loginbutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Log in']")));
		loginbutton.click();
		Thread.sleep(3000);

		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(myEmail);

		WebElement forgotPasswordLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href^='/password/reset/']")));

		forgotPasswordLink.click();

		WebElement sendResetEmailButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class, 'B1n') and text()='Send a password reset email']")));

		sendResetEmailButton.click();
	}

	// (priority = 2)
	@Test(enabled = false)
	public void clickRandomPinterestElement() throws InterruptedException {
		WebDriverWait wait = getWait();

		// Step 1: Wait for all matching elements to load
		List<WebElement> elements = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.cssSelector("div.Jea.KS5.MIw.QLY.Rym.hjq.mQ8.ojN.p6V.zI7.iyn.Hsu")));

		// Step 2: Pick a random one
		Random rand = new Random();
		WebElement randomElement = elements.get(rand.nextInt(elements.size()));
		System.out.println("Clicking element: " + randomElement.getText());

		// Step 4: Click using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomElement);

		System.out.println("Clicked a random element successfully.");

	}

	// (priority = 3)
	@Test(enabled = false)
	public void clickSaveButton() {
		WebDriverWait wait = getWait();

		// Wait for the button using the aria-label (very stable)
		WebElement saveButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Save']")));

		// Click the button directly
		saveButton.click();

		System.out.println("Clicked the Save button successfully.");
	}

	@Test(enabled = false)
	public void verifySearchReturnsRelevantResults() {
		WebDriverWait wait = getWait();

		// Step 1: Locate the search input by aria-label
		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-label='Search']")));

		String keyword = "books";
		searchInput.sendKeys(keyword);
		searchInput.sendKeys(Keys.ENTER);

		// Step 2: Wait for search results to load (images with alt attributes)
		List<WebElement> results = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("img[alt]")));

		// Step 3: Check if any image alt contains the keyword
		boolean foundRelevantResult = false;
		for (WebElement image : results) {
			String altText = image.getDomAttribute("alt").toLowerCase();
			if (altText.contains(keyword.toLowerCase())) {
				foundRelevantResult = true;
				System.out.println(" Found relevant result: " + altText);
				break;
			}
		}
		Assert.assertTrue(foundRelevantResult, "❌ No relevant search results found for keyword: " + keyword);

	}

	@Test(enabled = false)
	public void newBoard() {
		WebDriverWait wait = getWait();

		// Locate the profile button by role and class
		WebElement profileButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='button'].MZd")));

		// Click the profile button
		profileButton.click();

		WebElement create = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[aria-label='Create a Pin or a board']")));

		// Click the button
		create.click();

		WebElement boardSpan = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Board' and text()='Board']")));

		// Click the element
		boardSpan.click();

		WebElement boardNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("boardEditName")));
		boardNameInput.sendKeys("My Pinterest Board");

		WebElement createbutton = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[data-test-id='board-form-submit-button']")));

		// Click the button
		createbutton.click();

	}

	@Test(enabled = false)
	public void upLoadPin() {
		WebDriverWait wait = getWait();

		// Locate the profile button by role and class
		WebElement profileButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='button'].MZd")));

		// Click the profile button
		profileButton.click();

		WebElement create = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[aria-label='Create a Pin or a board']")));

		// Click the button
		create.click();

		WebElement pinButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Pin']")));

		// Click the "Pin" button
		pinButton.click();

		WebElement fileInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.id("storyboard-upload-input")));

		// Upload the image using sendKeys
		fileInput.sendKeys(imagePath);

		WebElement titleInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.id("storyboard-selector-title")));

		// Send text to the input field
		titleInput.sendKeys("My Pin Title");

		WebElement publishButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@data-test-id='storyboard-creation-nav-done']//button")));

		// Click the Publish button
		publishButton.click();

	}

	@Test (enabled = false)
	public void profileInformation() throws InterruptedException {
		WebDriverWait wait = getWait();

		// Locate the profile button by role and class
		WebElement profileButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='button'].MZd")));

		// Click the profile button
		profileButton.click();

		WebElement viewProfileButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[data-test-id='selfProfileHeader-view-profile-button']")));
		viewProfileButton.click();

		WebElement editProfileButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//div[text()='Edit profile']]")));
		editProfileButton.click();

		// Locate the First Name input by its ID and send new text
		WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("first_name")));
		firstNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		firstNameField.sendKeys(Keys.BACK_SPACE);
		firstNameField.sendKeys("hala");

		WebElement lastNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("last_name")));
		lastNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		lastNameField.sendKeys(Keys.BACK_SPACE);
		lastNameField.sendKeys("alajawi");

		WebElement saveButton = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-id='done-button'] button")));


		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);

	}

	@Test(enabled = false)
	public void VisualSearch() throws InterruptedException {
		WebDriverWait wait = getWait();

		// Wait until at least one image is present
		List<WebElement> imageList = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.cssSelector(".Jea.KS5.MIw.QLY.Rym.hjq.mQ8.ojN.p6V.zI7.iyn.Hsu")));

		// Pick a random element
		Random random = new Random();
		WebElement randomImage = imageList.get(random.nextInt(imageList.size()));

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", randomImage);
		Thread.sleep(1000); // give time for layout to settle


		// Click using JavaScript to avoid interception
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomImage);

		WebElement shopButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-test-id='shop-button']")));

		shopButton.click();
	}

	@Test(enabled = false)
	public void likePin() throws InterruptedException {
		WebDriverWait wait = getWait();

		List<WebElement> imageList = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.cssSelector(".Jea.KS5.MIw.QLY.Rym.hjq.mQ8.ojN.p6V.zI7.iyn.Hsu")));

		Random random = new Random();
		WebElement randomImage = imageList.get(random.nextInt(imageList.size()));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", randomImage);
		Thread.sleep(1000); 

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomImage);

		WebElement reactButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test-id='react-button']")));

		reactButton.click();

	}

	@Test(enabled = false)
	public void changeLanguage() throws InterruptedException {
		WebDriverWait wait = getWait();

		// Locate the profile button by role and class
		WebElement profileButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='button'].MZd")));

		profileButton.click();

		WebElement viewProfileButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("button[data-test-id='selfProfileHeader-view-profile-button']")));
		viewProfileButton.click();

		WebElement editProfileButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//div[text()='Edit profile']]")));
		editProfileButton.click();
		
		WebElement accountManagementButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[data-test-id='settings-menu-item-account-settings']")));

		accountManagementButton.click();

		WebElement languageDropdown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountBasicsLanguage")));
		Select select = new Select(languageDropdown);
		select.selectByValue("ar-SA");


		WebElement saveButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-test-id='done-button'] button")));
		saveButton.click();
		 Thread.sleep(3000);

	}

}
