package com.bridgelabz.springsecurityjwt.service.user;

import com.bridgelabz.springsecurityjwt.entity.AddressBookDTO;
import com.bridgelabz.springsecurityjwt.entity.AddressBookData;

import java.util.List;

public interface IAddressBookService {

    AddressBookData loginAddressBookData(AddressBookDTO addressBookDTO);

    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);


    Boolean verifyOtp(String username, String otp);

    Boolean isVerified(String username);
}

