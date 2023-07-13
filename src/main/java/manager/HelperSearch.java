package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void clickSearch(){
        click(By.id("0"));
    }
    public void fillSearchForm(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDays(dateFrom, dateTo);
    }


    public void fillSearchFormDatePickerDays(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDaysDatePicker(dateFrom, dateTo);
    }



    public void selectPeriodDays(String dateFrom, String dateTo) {
       // click(By.id("dates"));
        type(By.id("dates"), dateFrom + " - " + dateTo);
        pause(2000);
    }

    public void selectPeriodDaysDatePicker(String dateFrom, String dateTo) {
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


    public void fillCity(String city) {
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

    public void fillSearchFormDatePickerMonthsCW(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodMonthsDatePickerCW(dateFrom, dateTo);
    }
    public void selectPeriodMonthsDatePickerCW(String dateFrom, String dateTo) {
        int fromNowToStartMonth = 0, startToEndMonth = 0;
        String[] startDate = dateFrom.split("/");
        String[] endDateTo = dateTo.split("/");
        startToEndMonth = Integer.parseInt(endDateTo[0])-Integer.parseInt(startDate[0]);
        click(By.id("dates"));
        if(LocalDate.now().getMonthValue() != Integer.parseInt(startDate[0])){
            fromNowToStartMonth = Integer.parseInt(startDate[0]) - LocalDate.now().getMonthValue();
        }

        for(int i = 0; i<fromNowToStartMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDateTo[1]);
        click(By.xpath(locatorStartDate));
        for(int i = 0; i<startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEndDate));
        pause(3000);

    }

    public void fillSearchFormDatePickerYearsCW(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodYearsDatePickerCW(dateFrom, dateTo);
    }
    public void selectPeriodYearsDatePickerCW(String dateFrom, String dateTo) {
        LocalDate startDate = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
       // LocalDate startDate = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        //LocalDate endDate = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate nowDate = LocalDate.now();
        String locatorStartDate = String.format("//div[.=' %s ']", startDate.getDayOfMonth());
        String locatorEndDate = String.format("//div[.=' %s ']", endDate.getDayOfMonth());

        click(By.id("dates"));

        int startToEndMonth = startDate.getYear() - nowDate.getYear() == 0 ?
        startDate.getMonthValue() - nowDate.getMonthValue() :
        12 - nowDate.getMonthValue() + startDate.getMonthValue();

        for(int i = 0; i<startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorStartDate));

        startToEndMonth = endDate.getYear()-startDate.getYear() == 0 ?
                endDate.getMonthValue() - startDate.getMonthValue() :
                12 - startDate.getMonthValue() - endDate.getMonthValue();

        for(int i = 0; i<startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEndDate));
        pause(3000);
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
