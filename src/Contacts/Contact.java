package Contacts;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contact implements Serializable {
    private String Name;
    private String group;
    private String gender;
    private String address;
    private String email;
    private LocalDate birthDay;
    private String phoneNumber;

    public Contact(String name, String group, String gender, String address, String email, LocalDate birthDay, String phoneNumber) {
        Name = name;
        this.group = group;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = getBirthDay().format(dateTimeFormatter);
        return "contact{" +
                "Name='" + Name + '\'' +
                ", group='" + group + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", birthDay=" + formattedDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
