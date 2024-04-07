package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserAccount extends Account {
    private int iD;
    private  int age;
    private  String gender;
    private String address;
    private String phoneNumber;

    public UserAccount() {
        super();
    }

    public UserAccount(String username, String password, int iD, int age, String gender, String address, String phoneNumber) {
        super(username, password);
        this.iD = iD;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username = '" + getUsername() + '\'' +
                ", password = '" + getPassword() + '\'' +
                ", iD = '" + iD + '\'' +
                ", age= '" + age + '\'' +
                ", gender = '" + gender + '\'' +
                ", address = '" + address + '\'' +
                ", phoneNumber = '" + phoneNumber + '\'' +
                '}';
    }
}
