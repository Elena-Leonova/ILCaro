package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarsTests extends TestBase{

    // isLogged?
    // open form
    // fill form
    // attach photo
    // submit form

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()==false){
            app.getUser()
                    .login(new User()
                    .withEmail("lena.postrash@gmail.com")
                    .withPassword("Mynameislena1!"));
        }

    }

    @Test
    public void addNewCarPositive(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder()
                .location("Haifa")
                .make("KIA")
                .model("Sportage")
                .year("2023")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-200-" + i)
                .price("500")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);

    }
}
