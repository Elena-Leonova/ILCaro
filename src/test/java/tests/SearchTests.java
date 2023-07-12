package tests;

import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    // fillSearchForm with location
    // fillSearchForm with date
    // submit

    @Test
    public void searchPositiveTest(){
        app.getSearch().fillSearchForm("Haifa", "7/10/2023 " , "7/20/2023");
        app.getSearch().submitForm();
    }

    @Test
    public void searchPositiveTestDatePickerDays(){
        app.getSearch().fillSearchFormDatePickerDays("Haifa", "7/12/2023 " , "7/20/2023");
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
