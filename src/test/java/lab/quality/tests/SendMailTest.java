package lab.quality.tests;

import lab.quality.pages.LoginPage;
import lab.quality.pages.MainMailPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SendMailTest {

    public static LoginPage loginPage;
    public static MainMailPage mainMailPage;
    public static WebDriver driver;

    private final String LOGIN = "anna_moiseeva_test";
    private final String PASSWORD = "cj,tctljdfybt_10";
    private final String WHOM = "belova_al@mail.ru";
    private final String TEXT = "Hello!!!";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        mainMailPage = new MainMailPage(driver);

    }

    @Test
    public void sendMailTest() {
        loginPage.open();
        loginPage.clickLoginBtn();
        loginPage.switchToFrame();
        loginPage.inputLogin(LOGIN);
        loginPage.clickPasswordBtn();
        loginPage.inputPasswd(PASSWORD);
        loginPage.clickLoginBtnInFrame();
        loginPage.switchToDefaultWindow();
        mainMailPage.clickNewMailBtn();
        mainMailPage.inputWhom(WHOM);
        mainMailPage.inputText(TEXT);
        mainMailPage.clickSendBtn();
        mainMailPage.checkSendedMail();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }


}
