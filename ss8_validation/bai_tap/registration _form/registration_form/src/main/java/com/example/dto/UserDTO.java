package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class UserDTO implements Validator {
    @NotEmpty(message = "Cannot be left blank please enter")
    private String firstName;
    @NotEmpty(message = "Cannot be left blank please enter")
    private String lastName;
    @NotEmpty(message = "Cannot be left blank please enter")
    private String phoneNumber;
    @Min(18)
    private int age;
    @NotEmpty(message = "Cannot be left blank please enter")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        if (!userDTO.getFirstName().matches("^.{5,45}$")) {
            errors.rejectValue("firstName", "firstName.format", "firstName has a minimum of 5 characters and a maximum of 45 characters.");
        }
        if (!userDTO.getLastName().matches("^.{5,45}$")) {
            errors.rejectValue("lastName", "lastName.format", "lastName has a minimum of 5 characters and a maximum of 45 characters.");
        }
        if (!userDTO.getPhoneNumber().matches("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.format", "You entered wrong, please re-enter.");
        }
        if (!userDTO.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", "email.format", "You entered wrong, please re-enter.");
        }
    }
}
// sdt "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$"