package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class EmailClickDemo {
	WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<>();
	@FindBy(xpath="//*[@name='loginfmt']")
	private WebElement UserName;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement NextButton;
	
	@FindBy(xpath="//*[@type='password']")
	private WebElement Password;
	
	@FindBy(xpath="//*[@id='idSIButton9']")
	private WebElement Signin;
	
	@FindBy(xpath="//*[@name='DontShowAgain']")
	private WebElement DontShowAgain;
	
	@FindBy(xpath="//*[@id='idSIButton9']")
	private WebElement Yes;

	@Test
	public void clickEmail() throws InterruptedException {
		
		//GmailPageObjects Emaildemo = new GmailPageObjects(TestBase.getDriver());
		//String driverPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hcladmin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hcladmin\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://mail.google.com");
		GmailPageObjects gp =PageFactory.initElements(driver, GmailPageObjects.class);
		gp.enterEmail("testerswathi135@gmail.com");//Replace with your email id
		gp.enterPassword("HCLtester@22");//Replace with your password
		gp.clickEmail("Security alert");//Replace with email subject you want to click
		
		
		/*driver.get("https://www.signwell.com/online-signature/draw/");
		WebElement element = driver.findElement(By.xpath("//canvas[@id='canvas_signature']"));

		Actions builder = new Actions(driver);
		builder.dragAndDropBy(element, 135, 0).build().perform();*/

	}

	

	
}