package com.bridgelabz.springsecurityjwt.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {

    public String username;
    public String password;
    public String role;
    public String email;
    public boolean verified;
    private int personId;

}
