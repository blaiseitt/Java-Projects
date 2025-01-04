package pl.dmcs.buarzej.TemperatureConverterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TemperatureConverterDriver {
    WebDriver driver;

    public TemperatureConverterDriver(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(System.getProperty("user.dir")+"\\target\\test-classes\\index.html");
    }

    public Temperature getTemperatureFromBrowser(String celsiusInput){
        driver.findElement(By.name("celsiusDegrees")).clear();
        driver.findElement(By.name("celsiusDegrees")).sendKeys(celsiusInput);

        double actualCelsius = Double.parseDouble(driver.findElement(By.name("celsiusDegrees")).getAttribute("value"));
        double actualKelwin = Double.parseDouble(driver.findElement(By.name("kelwinDegrees")).getAttribute("value"));
        double actualFahrenheit = Double.parseDouble(driver.findElement(By.name("fahrenheitDegrees")).getAttribute("value"));

        Temperature actualTemperature = new Temperature(actualCelsius, actualKelwin, actualFahrenheit);
        return actualTemperature;
    }

    public Temperature getTemperatureWhenBackspaces(String celsiusInput, int numberOfBackspaces){

        driver.findElement(By.name("celsiusDegrees")).clear();
        driver.findElement(By.name("celsiusDegrees")).sendKeys(celsiusInput);
        for (int i = 0; i < numberOfBackspaces; i++) {
            driver.findElement(By.name("celsiusDegrees"))
                    .sendKeys(Keys.BACK_SPACE);
        }
        double actualCelsius = Double.parseDouble(driver.findElement(By.name("celsiusDegrees")).getAttribute("value"));
        double actualKelwin = Double.parseDouble(driver.findElement(By.name("kelwinDegrees")).getAttribute("value"));
        double actualFahrenheit = Double.parseDouble(driver.findElement(By.name("fahrenheitDegrees")).getAttribute("value"));

        Temperature actualTemperature = new Temperature(actualCelsius, actualKelwin, actualFahrenheit);
        return actualTemperature;
    }

    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
