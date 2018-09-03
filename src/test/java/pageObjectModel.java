import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class pageObjectModel {

    private WebDriver driver  = null;
    //** The mozilla WebDriver *//*

    private WebDriver mozilla = null;
    //** The Chrome WebDriver *//*
    private WebDriver chrome  = null;


    public void openBrowser(String browserType) {
        Properties props = new Properties();
        try {
            InputStream is = getClass().getResourceAsStream("/host.properties");
            System.out.println("is = " + is.toString());
            props.load(is);
        } catch (IOException e) {
            // ain't no-one got time for dat
        }

        if ("mozilla".equals(browserType)) {
            if (mozilla == null) {
                // fp.setEnableNativeEvents(true);
                // driver = new FirefoxDriver(fp);
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                FirefoxProfile driverfx = new FirefoxProfile();
                driverfx.setPreference("browser.download.dir","geckodriver");
                driverfx.setPreference("browser.download.folderList",2);
                driverfx.setPreference("browser.download.manager.showWhenStarting",false);
                driverfx.setPreference("pdfjs.disabled", true);
                driverfx.setPreference("browser.download.dir","mydownloads");
                driverfx.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
                driverfx.setPreference("browser.download.panel.shown", false);

                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", false);
                capabilities.setCapability(FirefoxDriver.PROFILE, driverfx);

                driver = new FirefoxDriver(capabilities);
          /*   DesiredCapabilities cap = DesiredCapabilities.firefox();
             cap.setCapability("version","");
             cap.setCapability("platform", "LINUX");
*/
               /* try {

                    props.load(AbstractWebConnector.class.getResourceAsStream("/host.properties"));
                } catch (IOException e) {
                    // ain't no-one got time for dat
                }
                try {
                    driver = new RemoteWebDriver(new URL(
                            props.getProperty("webdriver.host", "http://localhost:4444/wd/hub")), cap);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }*/

                mozilla = driver;
            } // if
            driver = mozilla;



        } else if ("chrome".equals(browserType)) {

            //     System.setProperty("webdriver.chrome.driver", "chromedriver");

            if (chrome == null) {
                //   driver = new ChromeDriver();
                // chrome = driver;
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability("version", "");
                cap.setCapability("platform", "LINUX");
                try {
                    driver = new RemoteWebDriver(new URL(
                            props.getProperty("webdriver.host", "http://localhost:4444/wd/hub")), cap);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            driver = chrome;


        }  else {
            System.out.println("THERE IS ERRgetProperties() LAUNCHING BROWSER");
        }

        // Maximaize the browser
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
