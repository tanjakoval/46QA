import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(isHomeComponentPresent(),"Element not found on page");
        System.out.println("Element 'HomeComponent' found on home page");
    }

    public boolean isHomeComponentPresent(){
        System.out.println("We are looking for'HomeComponent' on the home page");
        return isElementPresent(By.xpath("//html/body/div/div/div/div/h1"));
    }
}