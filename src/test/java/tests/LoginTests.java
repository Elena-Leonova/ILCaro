package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void positiveLoginTest(){
        app.getUser().clickLogin();
        app.getUser().fillLoginForm("lena.postrash@gmail.com", "Mynameislena1!");
        app.getUser().clickSubmit();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[text()='Logged in success']")));

    }

}
