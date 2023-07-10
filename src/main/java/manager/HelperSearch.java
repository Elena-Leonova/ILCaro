package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDays(dateFrom, dateTo);
    }

    public void fillSearchFormDatePickerDays(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDaysDatePicker(dateFrom, dateTo);
    }

    private void selectPeriodDays(String dateFrom, String dateTo) {
       // click(By.id("dates"));
        type(By.id("dates"), dateFrom + " - " + dateTo);
        pause(2000);
    }

    private void selectPeriodDaysDatePicker(String dateFrom, String dateTo) {
         //       7/10/2023
        // index  0  1  2
        String[] startDate = dateFrom.split("/");
        String[] endDateTo = dateTo.split("/");
         click(By.id("dates"));
//         click(By.xpath("//div[.=' "+ startDate[1] + " ']"));
//         click(By.xpath("//div[.=' "+ endDateTo[1] + " ']"));
        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDateTo[1]);
        click(By.xpath(locatorStartDate));
        click(By.xpath(locatorEndDate));
       // type(By.id("dates"), dateFrom + " - " + dateTo);
        pause(2000);
    }


    private void fillCity(String city) {
        type(By.id("city"), city);
        pause(2000);
        click(By.cssSelector("div.pac-item"));
        pause(2000);
    }

    public void submitForm(){
        wd.findElement(By.cssSelector("[type='submit']")).click();
    }

}
