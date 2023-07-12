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
        pause(2000);
        click(By.xpath(locatorEndDate));
       // type(By.id("dates"), dateFrom + " - " + dateTo);
        pause(3000);
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

    public void fillSearchFormDatePickerMonths(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodMonthsDatePicker(dateFrom, dateTo);
    }


    private void selectPeriodMonthsDatePicker(String dateFrom, String dateTo) {
        String currentDate = "07/12/2023";
        click(By.id("dates"));
        numberOfClickStart(dateFrom, currentDate);
        String locatorStartDate = String.format("//div[.=' %s ']", (dateFrom.split("/"))[1]);
        click(By.xpath(locatorStartDate));
        pause(3000);
        numberOfClickEnd(dateFrom, dateTo);
        String locatorEndDate = String.format("//div[.=' %s ']", (dateTo.split("/"))[1]);
        click(By.xpath(locatorEndDate));


    }

    private void numberOfClickStart(String dateFrom, String currentDate){
        String[] startDate = dateFrom.split("/");
        String[] curDate = currentDate.split("/");
        int numberClick = Integer.parseInt(startDate[0])-Integer.parseInt(curDate[0]);
        int i = 1;
        while (i<=numberClick){
            click(By.xpath("//button[@aria-label='Next month']"));
            i++;
        }


    }

    private void numberOfClickEnd(String dateFrom, String dateTo){
        String[] endDateTo = dateTo.split("/");
        String[] startDate = dateFrom.split("/");
        int numberClick = Integer.parseInt(endDateTo[0])-Integer.parseInt(startDate[0]);
        int i = 1;
        while (i<=numberClick){
            click(By.xpath("//button[@aria-label='Next month']"));
            i++;
        }

    }
    public void fillSearchFormDatePickerYears(String city, String dateFrom, String dateTo) {
        fillCity(city);
        selectPeriodYearsDatePicker(dateFrom, dateTo);
    }

    private void selectPeriodYearsDatePicker(String dateFrom, String dateTo) {
        String currentDate = "07/12/2023";
        click(By.id("dates"));
        numberOfClickStart(dateFrom, currentDate);
        String locatorStartDate = String.format("//div[.=' %s ']", (dateFrom.split("/"))[1]);
        click(By.xpath(locatorStartDate));
        pause(2000);
        click(By.xpath("//button[@aria-label='Choose month and year']"));
        click(By.xpath("//td[.=' 2024 ']"));
        String[] endDateTo = dateTo.split("/");
        switch (endDateTo[0]) {
            case "1": click(By.xpath("//div[.=' JAN ']")); break;
            case "2": click(By.xpath("//div[.=' FEB ']")); break;
            case "3": click(By.xpath("//div[.=' MAR ']")); break;
            case "4": click(By.xpath("//div[.=' APR ']")); break;
            case "5": click(By.xpath("//div[.=' MAY ']")); break;
            case "6": click(By.xpath("//div[.=' JUN ']")); break;
            case "7": click(By.xpath("//div[.=' JUL ']")); break;
            case "8": click(By.xpath("//div[.=' AUG ']")); break;
            case "9": click(By.xpath("//div[.=' SEP ']")); break;
            case "10": click(By.xpath("//div[.=' OCT ']")); break;
            case "11": click(By.xpath("//div[.=' NOV ']")); break;
            case "12": click(By.xpath("//div[.=' DEC ']")); break;
        }

        String locatorEndDate = String.format("//div[.=' %s ']", endDateTo[1]);
        click(By.xpath(locatorEndDate));
        pause(2000);

    }
}
