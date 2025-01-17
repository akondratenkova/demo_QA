package textBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Form {
    private By inputFullName = By.xpath("//*[@id='userName']");
    private By inputEmail = By.xpath("//*[@id='userEmail']");
    private By inputCrtAddress = By.xpath("//*[@id='currentAddress']");
    private By inputPrmtAddress = By.xpath("//*[@id='permanentAddress']");

    @Test
    public void filling(){
        WebDriver driver = new ChromeDriver();
        Data getData = new Data();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get(getData.getUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(inputFullName).sendKeys(getData.fullName);
        driver.findElement(inputEmail).sendKeys(getData.email);
        driver.findElement(inputCrtAddress).sendKeys(getData.crtAdress);
        driver.findElement(inputPrmtAddress).sendKeys(getData.prmtAdress);

        WebElement btnSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
        js.executeScript("arguments[0].click();", btnSubmit);
    }
}
