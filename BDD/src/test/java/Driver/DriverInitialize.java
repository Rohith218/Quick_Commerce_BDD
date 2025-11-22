package Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitialize {
	WebDriver driver = null;
	static FileInputStream fis;
	static Properties prop;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		WebDriverManager 
		getProperties("url");
	}
	public static String getProperties(String value) throws IOException {
		String path = System.getProperty("user.dir");
		path = path +"\\src\\test\\Resources\\config.properties";
		fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		String val = prop.getProperty(value);
		return val;
		
	}
	public String getUrl() throws IOException {
		return getProperties("url");
	}
	public String getBrowser() throws IOException {
		return getProperties("browser");
	}

	public WebDriver initialize(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browser);
		}
		return driver;
	}

	public WebDriver initialize() throws IOException {
		initialize(getBrowser());
		return driver;
	}
	
	public void openPage() throws IOException {
		driver.get(getUrl());
		driver.manage().window().maximize();
	}
}
