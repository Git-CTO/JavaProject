package model;

import util.eGender;

public abstract class Person {
    String firstName;
    String lastName;
    eGender gender;
    String address;
    String phoneNumber;
    String personalId;
    int age;

    public String toString(){
        return "\n--Personal Information-- " + "\n"
                + "#Gender: " + gender + "\n"
                + "#Address: " + address + "\n"
                + "#PhoneNumber: " + phoneNumber + "\n"
                + "#ID: " + personalId + "\n";
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Person setGender(eGender gender) {
        this.gender = gender;
        return this;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Person setPersonalId(String personalId) {
        this.personalId = personalId;
        return this;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getPersonalId() {
        return personalId;
    }

}
