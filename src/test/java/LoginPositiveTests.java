import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTests extends TestBase {

    @Test
    public void loginExistedUserPositiveTest1() {
        clickLoginLink();
        fillInRegistrationForm("admin_de@gmail.com", "Password7@");
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginExistedUserPositiveTest2() {
        login("admin_de@gmail.com", "Password7@");
    }
}
