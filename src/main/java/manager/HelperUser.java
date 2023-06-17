package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void clickLogin(){
        click(By.xpath("//a[@ng-reflect-router-link='login']"));

    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"), password);

    }

    public void clickSubmit(){
        click(By.xpath("//button[@type = 'submit']"));

    }

}
