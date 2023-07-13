package tests;

import manager.NgListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgListener.class)

public class LoginTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }

    @Test(enabled = false)
    public void positiveLoginTest(){
//        app.getUser().clickLogin();
//        app.getUser().fillLoginForm("lena.postrash@gmail.com", "Mynameislena1!");
//        app.getUser().clickSubmit();
//        app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[text()='Logged in success']")));
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("lena.postrash@gmail.com", "Mynameislena1!");
        app.getUser().submitForm();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }



    @Test(groups = {"smokeGroup", "sanityGroup", "regressionGroup"})
    public void positiveLoginUser(){
//        app.getUser().clickLogin();
//        app.getUser().fillLoginForm("lena.postrash@gmail.com", "Mynameislena1!");
//        app.getUser().clickSubmit();
//        app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[text()='Logged in success']")));
        User user = new User().withEmail("lena.postrash@gmail.com").withPassword("Mynameislena1!");
        //user.setName("John");
        //user.setLastName("Silver");

        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm("lena.postrash@gmail.com", "Mynameislena1!");
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
        app.getUser().clickOkButton();

    }

    @Test(dataProvider = "userModelListDTO", dataProviderClass = ProviderData.class)
    public void positiveLoginUserDTO(User user){
        logger.info("User: " + user.toString() + " is provided");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
//        app.getUser().pause(5000);
//        Assert.assertTrue(app.getUser().isLoggedSuccess());
       app.getUser().clickOkButton();
    }

    @Test
    public void negativeLoginWrongEmail(){
        User user = new User().withEmail("lena.postrashgmail.com").withPassword("Mynameislena1!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
        logger.info("Registration test starts with data : " + user.getEmail()
                + " & " + user.getPassword()
        );
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[.=\"It'snot look like email\"]")));
       //Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@ng-reflect-router-link='login']")));

    }

    @Test
    public void negativeLoginWrongPassword(){
        User user = new User().withEmail("lena.postrash@gmail.com").withPassword("Mynameislena1");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@ng-reflect-router-link='login']")));
        app.getUser().clickOkButton();
    }
//    @AfterMethod(alwaysRun = true)
//    public void postCondition(){
//        app.getUser().clickOkButton();
//    }
}
