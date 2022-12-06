package lab.quality.pages;

import lab.quality.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class MainMailPage extends Page {

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    private final String EXPECTED_RESULT = "Письмо отправлено";

    public MainMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".compose-button")
    private WebElement newMailBtn;

    @FindBy(css = "input.container--H9L5q")
    private WebElement InputWhom;

    @FindBy(css = "[role='textbox']>div")
    private WebElement inputText;

    @FindBy(css = "[data-test-id='send']")
    private WebElement sendBtn;

    public void clickNewMailBtn(){

        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".compose-button"))));
        newMailBtn.click();
    }

    public void clickSendBtn(){
        sendBtn.click();
    }

    public void inputWhom(String whom){
        InputWhom.sendKeys(whom);
    }

    public void inputText(String text){
        inputText.sendKeys(text);
    }

    public void checkSendedMail(){
        wait.until(textToBePresentInElement(driver.findElement(By.cssSelector(".layer__link")), EXPECTED_RESULT));
    }
}
