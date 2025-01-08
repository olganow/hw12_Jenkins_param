package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.AUTOMATION_PRACTICE_FORM_URL;

public class RegistrationPage {
    private SelenideElement
            header = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            sublectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");

    private final static String REGISTRATION_FORM = "Student Registration Form";

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Open main page")
    public RegistrationPage openPage() {
        open(AUTOMATION_PRACTICE_FORM_URL);
        header.shouldHave(text(REGISTRATION_FORM));
        return this;
    }

    @Step("Remove banners")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set a first name")
    public RegistrationPage setFirstName(String firstNameUser) {
        firstNameInput.setValue(firstNameUser);
        return this;
    }

    @Step("Set a last name")
    public RegistrationPage setLastName(String lastNameUser) {
        lastNameInput.setValue(lastNameUser);
        return this;
    }

    @Step("Set a email")
    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    @Step("Set a gender")
    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    @Step("Set a phone number")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Set a date of birth")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Set a subject")
    public RegistrationPage setSubjects(String subjectOne) {
        sublectInput.setValue(subjectOne).pressEnter();
        return this;
    }

    @Step("Set a hobby")
    public RegistrationPage setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    @Step("Set an avatar")
    public RegistrationPage setAvatar(String picture) {
        uploadPictureInput.uploadFromClasspath(picture);
        return this;
    }

    @Step("Set a street")
    private RegistrationPage setStreet(String address) {
        addressInput.scrollIntoView(true).setValue(address);
        return this;
    }

    @Step("Set a state")
    private RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;
    }

    @Step("Set a city")
    private RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();

        return this;
    }

    @Step("Set an address")
    public RegistrationPage setAddress(String address, String state, String city) {
        setStreet(address);
        setState(state);
        setCity(city);
        return this;
    }

    @Step("Submit the form")
    public RegistrationPage submitForm() {
        submitButton.scrollIntoView(true).click();
        return this;
    }

    @Step("Validate last user field")
    public RegistrationPage validateLastUserField() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // Проверка на hex #dc3545 в формате rgb
        return this;
    }

}