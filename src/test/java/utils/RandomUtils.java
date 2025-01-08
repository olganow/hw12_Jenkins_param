package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RandomUtils {

    private String firstName;
    private String lastName;
    private String gender;
    private String userEmail;
    private String userPhone;
    private String yearOfBirth;
    private String monthOfBirth;
    private String dayOfBirth;
    private String subject;
    private String hobby;
    private String picture;
    private String streetAddress;
    private String state;
    private String city;

    private String[] states = new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    private Map<String, List<String>> citiesMap = new HashMap<>() {{
        put("NCR", List.of("Delhi", "Gurgaon", "Noida"));
        put("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"));
        put("Haryana", List.of("Karnal", "Panipat"));
        put("Rajasthan", List.of("Jaipur", "Jaiselmer"));
    }};

    Faker faker = new Faker(new Locale("en-GB"));

    public String getFirstName() {
        firstName = faker.name().firstName();
        return firstName;
    }

    public String getLastName() {
        lastName = faker.name().lastName();
        return lastName;
    }

    public String getGender() {
        gender = faker.options().option("Male", "Female", "Other");
        return gender;
    }

    public String getUserEmail() {
        userEmail = faker.internet().emailAddress();
        return userEmail;
    }

    public String getUserPhone() {
        userPhone = faker.number().digits(10);
        return userPhone;
    }

    public String getYearOfBirth() {
        int year = getRandomNumber(2020, 2024);
        yearOfBirth = String.valueOf(year);
        return yearOfBirth;
    }


    public String getMonthOfBirth() {
        monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December");
        return monthOfBirth;
    }

    public String getDayOfBirth() {
        int day = getRandomNumber(10, 16);
        dayOfBirth = String.valueOf(day);
        return dayOfBirth;
    }

    public String getSubject() {
        subject = faker.options().option("Accounting", "Arts", "Biology",
                "Chemistry", "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies");
        return subject;
    }

    public String getHobby() {
        hobby = faker.options().option("Sports", "Reading", "Music");
        return hobby;
    }

    public String getPicture() {
        picture = faker.options().option("mypict.png", "mypictsecond.png");
        return picture;
    }

    public String getStreetAddress() {
        streetAddress = faker.address().streetAddress();
        return streetAddress;
    }

    public String getState() {
        int randomNumber = getRandomNumber(0, states.length);
        state = states[randomNumber];
        return state;
    }

    public String getCity(String state) {
        List<String> cities = citiesMap.get(state);
        if (cities != null && !cities.isEmpty()) {
            int randomNumber = getRandomNumber(0, cities.size());
            city = cities.get(randomNumber);
            return city;
        }
        return null;
    }

    private int getRandomNumber(int numberStart, int numberEnd) {
        return faker.number().numberBetween(numberStart, numberEnd);
    }
}
