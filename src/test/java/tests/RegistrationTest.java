package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ConfirmationPage;
import pages.RegistrationPage;
import utils.RandomUtils;

@Tag("actual")
public class RegistrationTest extends TestBase {
    private String
            firstNameUser,
            lastNameUser,
            email,
            gender,
            phone,
            yearOfBirth,
            monthOfbirth,
            dayOfbirth,
            subjectOne,
            hobby,
            picture,
            street,
            state,
            city;

    private String
            fullNameCellName = "Student Name",
            emailCellName = "Student Email",
            genderCellName = "Gender",
            phoneCellName = "Mobile",
            birthdayCellName = "Date of Birth",
            subjectCellName = "Subjects",
            hobbyCellName = "Hobbies",
            pictureCellName = "Picture",
            addressCellName = "Address",
            stateAndCityCellName = "State and City";

    RegistrationPage registrationPage = new RegistrationPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();
    RandomUtils randomUtils = new RandomUtils();

    @BeforeEach
    public void setUp() {
        firstNameUser = randomUtils.getFirstName();
        lastNameUser = randomUtils.getLastName();
        gender = randomUtils.getGender();
        email = randomUtils.getUserEmail();
        phone = randomUtils.getUserPhone();
        yearOfBirth = randomUtils.getYearOfBirth();
        monthOfbirth = randomUtils.getMonthOfBirth();
        dayOfbirth = randomUtils.getDayOfBirth();
        subjectOne = randomUtils.getSubject();
        hobby = randomUtils.getHobby();
        picture = randomUtils.getPicture();
        street = randomUtils.getStreetAddress();
        state = randomUtils.getState();
        city = randomUtils.getCity(state);
    }


    @Test
    void successfulFillInAndSubmitFullFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubjects(subjectOne)
                .setHobby(hobby)
                .setAvatar(picture)
                .setAddress(street, state, city)
                .submitForm();

        confirmationPage
                .confirmPage()
                .confirmResult(fullNameCellName, firstNameUser + " " + lastNameUser)
                .confirmResult(emailCellName, email)
                .confirmResult(genderCellName, gender)
                .confirmResult(phoneCellName, phone)
                .confirmResult(birthdayCellName, dayOfbirth + " " + monthOfbirth + "," + yearOfBirth)
                .confirmResult(subjectCellName, subjectOne)
                .confirmResult(hobbyCellName, hobby)
                .confirmResult(pictureCellName, picture)
                .confirmResult(addressCellName, street)
                .confirmResult(stateAndCityCellName, state + " " + city);
    }

    @Test
    void successfulFillInAndSubmitShortFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setGender(gender)
                .setUserNumber(phone)
                .submitForm();

        confirmationPage
                .confirmPage()
                .confirmResult(fullNameCellName, firstNameUser + " " + lastNameUser)
                .confirmResult(genderCellName, gender)
                .confirmResult(phoneCellName, phone);
    }


    @Test
    void unsuccessfulFillInAndSubmitShortFormTestWithEmptySecondNameFieldNegative() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName(firstNameUser)
                .setGender(gender)
                .setUserNumber(phone)
                .submitForm()
                .validateLastUserField();
    }

}

