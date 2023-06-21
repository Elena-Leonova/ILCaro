package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }
    @Test
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



    @Test
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
//        app.getUser().pause(5000);
//        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }

    @Test
    public void negativeLoginWrongEmail(){
        User user = new User().withEmail("lena.postrashgmail.com").withPassword("Mynameislena1!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@ng-reflect-router-link='login']")));
    }

    @Test
    public void negativeLoginWrongPassword(){
        User user = new User().withEmail("lena.postrash@gmail.com").withPassword("Mynameislena1");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@ng-reflect-router-link='login']")));
    }
    @AfterMethod
    public void postCondition(){
        app.getUser().clickButton();
    }
}
