package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.Homepage;
import pageObjects.Loginpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    private WebDriver driver = initializeDriver();
    protected Homepage homepage = new Homepage(driver);
    protected Loginpage loginpage = new Loginpage(driver);

    protected base() throws IOException {

    }

    private WebDriver initializeDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\manue\\selenium-webdriver-testng-framework\\src\\test\\resources\\data.properties");
        properties.load(fileInputStream);

        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\manue\\selenium-webdriver-testng-framework\\src\\test\\resources\\webdriver\\Windows\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\manue\\selenium-webdriver-testng-framework\\src\\test\\resources\\webdriver\\Windows\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeTest
    public void open_page() {
        driver.get("https://courses.rahulshettyacademy.com/");
    }

    @AfterTest
    public void close_browser() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() {

        //data for login credentials
        //each object data corresponds to executions
        Object[][] data = new Object[1][2];
        data[0][0] = "qatestes98@gmail.com";
        data[0][1] = "123testes";

        return data;
    }
}
