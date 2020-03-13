package Lesson_3;

public class Person {
    private String family;
    private String phone;
    private String email;

    public Person(String family, String phone, String email) {
        this.family = family;
        this.phone = phone;
        this.email = email;
    }

    public String getFamily() {
        return family;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
