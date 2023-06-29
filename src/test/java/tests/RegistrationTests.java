package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @Test
    public void registrationPositive(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("Sasha")
                .withLastName("Petrov")
                .withEmail("sasha" + i + "@gmail.com")
                .withPassword("Mynameislena1!");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitForm();
        logger.info("Registration test strats with data : " + user.getEmail()
        + " & " + user.getPassword()
        );
        Assert.assertTrue(app.getUser().isRegistered());
    }

    @Test
    public void registrationNegativeWrongPassword(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("Sasha")
                .withLastName("Petrov")
                .withEmail("sasha" + i + "@gmai.com")
                .withPassword("Mynameislena1");
        app.getUser().openRegistrationForm();
        logger.info("Method openRegistrationForm() invoked ");
        app.getUser().fillRegistrationForm(user);
        logger.info("Method fillRegistrationForm() invoked ");
        app.getUser().submitForm();
        logger.info("Method submitForm()invoked ");
        logger.info("Registration test strats with data : " + user.getEmail()
                + " & " + user.getPassword()
        );
        //Assert.assertTrue(app.getUser().isRegistered());
    }

}
