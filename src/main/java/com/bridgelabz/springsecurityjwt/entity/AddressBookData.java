package com.bridgelabz.springsecurityjwt.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    private long personId;
    public String role;

    @GeneratedValue(strategy = GenerationType.AUTO)
    public boolean verified;
    private String username;
    private String password;
    private String email;

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.email=addressBookDTO.getEmail();
        this.password=addressBookDTO.password;
        this.username=addressBookDTO.getUsername();
        this.role=addressBookDTO.getRole();
        this.verified=addressBookDTO.isVerified();

    }

}
