package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    // fillSearchForm with location
    // fillSearchForm with date
    // submit
    @BeforeMethod(alwaysRun = true)
    public void preconditions(){
       app.getSearch().clickSearch();
    }
    @Test
    public void searchPositiveTest(){
        app.getSearch().fillSearchForm("Haifa", "7/10/2023 " , "7/20/2023");
        app.getSearch().submitForm();
    }

    @Test
    public void searchPositiveTestDatePickerDays(){
        app.getSearch().fillSearchFormDatePickerDays("Haifa", "7/23/2023 " , "7/20/2023");
        app.getSearch().submitForm();
    }


    @Test
    public void searchPositiveTestDatePickerMonthsCW(){
        app.getSearch().fillSearchFormDatePickerMonthsCW("Haifa", "7/23/2023 " , "9/20/2023");
        app.getSearch().submitForm();

    }

    @Test
    public void searchPositiveTestDatePickerYearsCW(){
        app.getSearch().fillSearchFormDatePickerYearsCW("Haifa", "03/13/2024 " , "07/12/2024");
        app.getSearch().submitForm();
    }

    @Test
    public void searchPositiveTestDatePickerMonths(){
        app.getSearch().fillSearchFormDatePickerMonths("Haifa", "8/19/2023 " , "12/17/2023");
        app.getSearch().submitForm();
    }

    @Test
    public void searchPositiveTestDatePickerYears(){
        app.getSearch().fillSearchFormDatePickerYears("Haifa", "11/19/2023 " , "7/10/2024");
        app.getSearch().submitForm();
    }
}
