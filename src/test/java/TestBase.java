import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;
    WebDriverWait;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(2500, 0));
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        System.out.println("Check if an element exists [" + locator +"] on the page");
        return driver.findElements(locator).size()>0;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void login(String email, String password) {
        // click on login link
        click(By.xpath("//a[.='LOGIN']"));
        // enter email
        type(By.name("email"), email.toLowerCase());
        // enter password
        type(By.name("password"), password);
        // click on Login button
        click(By.name("login"));
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    /**
     * Метод для <code>регистрации нового пользователя<code/> на сайте.
     *
     * @param email    Электронная почта, используемая для регистрации.
     * @param password Пароль, который будет установлен для аккаунта.
     *
     * В процессе регистрации выполняются следующие шаги:
     * 1. Клик по ссылке "LOGIN".
     * 2. Ввод электронной почты в поле для email.
     * 3. Ввод пароля в соответствующее поле.
     * 4. Нажатие на кнопку регистрации.
     * 5. Проверка того, что кнопка "Sign Out" отображается после успешной регистрации.
     *
     * Исключение: Если элемент "Sign Out" не найден, то утверждение выбросит исключение.
     */
    protected void register(String email, String password) {
        // click on Login link //a[.='LOGIN']
        click(By.xpath("//a[.='LOGIN']"));
        // enter email in input By.name("email")
        type(By.name("email"), email);
        // enter password in input By.name("password")
        type(By.name("password"), password);
        // click on registration button By.name("registration")
        click(By.name("registration"));
        // Assert that button //button[.='Sign Out'] is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    protected void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    protected void fillInRegistrationForm(String email, String password) {
        type(By.name("email"), email);
        type(By.name("password"), password);
    }

    protected void clickRegistrationButton() {
        click(By.name("registration"));
    }

    protected void clickLoginLink() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    protected boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    protected void clickOnLoginButton() {
        click(By.name("login"));
    }
}