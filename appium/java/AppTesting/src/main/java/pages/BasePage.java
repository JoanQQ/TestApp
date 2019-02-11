package pages;

import utils.HnaDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    static WebElement find(By locator) {
        return HnaDriver.getCurrentDriver().findElement(locator);
    }

    static By locate(String locator) {
        if(locator.matches("/.*")) {
            return By.xpath(locator);
        }else {
            return By.id(locator);
        }
    }

    static By text(String content) {
        return By.xpath("//*[@text='"+ content + "']");
    }

    /**
    static MobileElement wait(HnaDriver driver, int time, String locator) {
        WebElement webElement = new WebDriverWait((WebDriver) driver, time).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return (MobileElement)webElement;
    }
    */
}
