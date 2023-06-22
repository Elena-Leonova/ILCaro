package tests;

import models.User;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @Test
    public void registrationPositive(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("Sasha")
                .withLastName("Petrov")
                .withEmail("sasha" + i + "@gmai.com")
                .withPassword("Mynameislena1!");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitForm();
    }

}
