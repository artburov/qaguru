package automation.Task2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests_Parametrized {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @ParameterizedTest
    @MethodSource("userParams")
    void nameTest(String userName, String userSurname, String userPhone) {
        //User credentials

        /*String userName = "Ivan";
        String userSurname = "Ivanov";*/
        String userSex = "Male";
        String userEmail = "ivanov@test.com";
        /*String userPhone = "1234567890";*/
        String userBirthday = "01 May,1980";
        String subjectCScience = "Computer Science";
        String subjectPhysics = "Physics";
        String userHobbyOne = "Sports";
        String userHobbyTwo = "Music";
        String userImg = "robot.png";
        String userState = "Haryana";
        String userCity = "Panipat";
        String userAddress = "USA, New York, 123 Piccadilly street, apt.77";
        String modalTitleText = "Thanks for submitting the form";

        //Open the URL
        open("https://demoqa.com/automation-practice-form");

        //Fill data in form
        $("#firstName").setValue(userName);
        $("#lastName").setValue(userSurname);
        $("#userEmail").setValue(userEmail);
        $(byText(userSex)).click();
        $("#userNumber").setValue(userPhone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(byText("1")).click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("c");
        $(byText(subjectCScience)).click();
        $("#subjectsInput").setValue("p");
        $(byText(subjectPhysics)).click();
        $(byText(userHobbyOne)).click();
        $(byText(userHobbyTwo)).click();
        $("#uploadPicture").uploadFromClasspath("robot.png");
        $("#currentAddress").setValue("USA, New York, 123 Piccadilly street, apt.77");
        $("#state").click();
        $(byText(userState)).click();
        $("#city").click();
        $(byText(userCity)).click();
        $("#submit").click();

        sleep(2000);

        //Verify data from modal
        $(".modal-header").shouldHave(text(modalTitleText));
        $("tbody tr:nth-child(1)").shouldHave(text(userName + " " + userSurname));
        $("tbody tr:nth-child(2)").shouldHave(text(userEmail));
        $("tbody tr:nth-child(3)").shouldHave(text(userSex));
        $("tbody tr:nth-child(4)").shouldHave(text(userPhone));
        $("tbody tr:nth-child(5)").shouldHave(text(userBirthday));
        $("tbody tr:nth-child(6)").shouldHave(text(subjectCScience + ", " + subjectPhysics));
        $("tbody tr:nth-child(7)").shouldHave(text(userHobbyOne + ", " + userHobbyTwo));
        $("tbody tr:nth-child(8)").shouldHave(text(userImg));
        $("tbody tr:nth-child(9)").shouldHave(text(userAddress));
        $("tbody tr:nth-child(10)").shouldHave(text(userState + " " + userCity));
    }

    static Object[][] userParams() {
        return new Object[][]{
                {"Ivan", "Ivanov", "2345678901"},
                {"Alex", "Smirnov", "3456789012"},
                {"Oleg", "Popov", "4567890123"}
        };
    }
}