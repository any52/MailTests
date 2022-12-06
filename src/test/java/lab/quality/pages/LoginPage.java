package lab.quality.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.resplash-btn")
    private WebElement loginBtn;

    @FindBy(css = "[class='ag-popup__frame__layout__iframe']")
    private WebElement loginForm;

    @FindBy(css = "[name= 'username']")
    private WebElement inputLogin;

    @FindBy(css = "[data-test-id='next-button']")
    private WebElement passwordBtn;

    @FindBy(css = "[name='password']")
    private WebElement inputPassword;

    @FindBy(css = "[data-test-id='submit-button']")
    private WebElement loginBtnInIframe;

    public void clickLoginBtn() {
        loginBtn.click(); }

    public void switchToFrame(){
        driver.switchTo().frame(loginForm);
    }

    public void inputLogin(String login) {
        inputLogin.sendKeys(login); }

    public void inputPasswd(String passwd) {
        inputPassword.sendKeys(passwd); }

    public void clickLoginBtnInFrame() {
        loginBtnInIframe.click(); }

    public void clickPasswordBtn(){
        passwordBtn.click();
    }

    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }

    public void open(){
        driver.get("https://mail.ru/");
    }
}
