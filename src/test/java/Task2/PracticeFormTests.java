import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        //User credentials
        String userName = "Ivan";
        String userSurname = "Ivanov";
        String userSex = "Male";
        String userEmail = "ivanov@test.com";
        String userPhone = "1234567890";
        String userBirthday = "01 May,1980";
        String userSubjects = "Computer Science, Physics";
        String userHobbies = "Sports, Music";
        String userImg = "robot.png";
        String filePath = "src/test/java/resources/robot.png";
        String stateCity = "Haryana Panipat";
        String userAddress = "USA, New York, 123 Piccadilly street, apt.77";
        String modalTitleText = "Thanks for submitting the form";

        //Open the URL
        open("https://demoqa.com/automation-practice-form");

        //Fill data in form
        $("#firstName").setValue(userName);
        $("#lastName").setValue(userSurname);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userPhone);
        $("#dateOfBirthInput").click();
        $("select[class='react-datepicker__month-select']").click();
        $("option[value='4']").click();
        $("select[class='react-datepicker__year-select']").click();
        $("option[value='1980']").click();
        $("div[aria-label='Choose Thursday, May 1st, 1980']").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("c");
        $x("//div[@id='subjectsContainer']//div[contains(text(),'Computer Science')]").click();
        $("#subjectsInput").setValue("p");
        $x("//div[@id='subjectsContainer']//div[contains(text(),'Physics')]").click();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File(filePath));
        $("#currentAddress").setValue("USA, New York, 123 Piccadilly street, apt.77");
        $("#state").click();
        $x("//div[@id='state']//div[contains(text(),'Haryana')]").click();
        $("#city").click();
        $x("//div[@id='city']//div[contains(text(),'Panipat')]").click();
        $("#submit").click();

        //Verify data from modal
        $(".modal-header").shouldHave(text(modalTitleText));
        $("tbody tr:nth-child(1)").shouldHave(text(userName + " " + userSurname));
        $("tbody tr:nth-child(2)").shouldHave(text(userEmail));
        $("tbody tr:nth-child(3)").shouldHave(text(userSex));
        $("tbody tr:nth-child(4)").shouldHave(text(userPhone));
        $("tbody tr:nth-child(5)").shouldHave(text(userBirthday));
        $("tbody tr:nth-child(6)").shouldHave(text(userSubjects));
        $("tbody tr:nth-child(7)").shouldHave(text(userHobbies));
        $("tbody tr:nth-child(8)").shouldHave(text(userImg));
        $("tbody tr:nth-child(9)").shouldHave(text(userAddress));
        $("tbody tr:nth-child(10)").shouldHave(text(stateCity));
        sleep(1000);
    }
}