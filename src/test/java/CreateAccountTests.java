import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest1() {
        clickLoginLink();
        fillInRegistrationForm("admin_de@gmail.com", "Password7@");
        clickRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void createAccountPositiveTest2() {
        register("admin_de@gmail.com", "Password7@");
    }

    @Test
    public void createAccountLoginPositiveTest() {
        register("Murka_044katze@gmal.com", "Password8@");
        logout();
        login("Mika_0423katze@gmal.com", "Password9@");
    }

    @Test
    public void createAccountNegativeTest() {
        clickLoginLink();
        fillInRegistrationForm("admin_de@gmail.com", "Password7@");
        clickRegistrationButton();
        //Assert.assertFalse(isSignOutButtonPresent());
        Assert.assertTrue(isAlertPresent());
    }

    private boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }
}
