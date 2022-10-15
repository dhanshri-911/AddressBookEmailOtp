package com.bridgelabz.springsecurityjwt.controller;


import com.bridgelabz.springsecurityjwt.dto.ResponseDTO;
import com.bridgelabz.springsecurityjwt.dto.UserNameOtpDTO;
import com.bridgelabz.springsecurityjwt.entity.AddressBookDTO;
import com.bridgelabz.springsecurityjwt.entity.AddressBookData;
import com.bridgelabz.springsecurityjwt.entity.JwtResponse;
import com.bridgelabz.springsecurityjwt.service.user.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Home {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAddressBookService userService;

    final static String SUCCESS = "Entered Otp is valid, and Registration was successful.";
    final static String FAIL = "Entered OTP was not valid! , Registration failed!, please try again";


    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody AddressBookDTO addressBookDTO){
        ResponseDTO responseDTO = new ResponseDTO("User registration Successful" , userService.createAddressBookData(addressBookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }



    //registration api permitted to be accessed by all the users
    @PostMapping("/login")
    public ResponseEntity<AddressBookData> addUser(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        addressBookDTO.setPassword(passwordEncoder.encode(addressBookDTO.getPassword()));
        AddressBookData user = userService.loginAddressBookData(addressBookDTO);
        return ResponseEntity.ok(user);
    }


    @PostMapping({"/verifyotp"})
    public String verifyOtp(@Valid @RequestBody UserNameOtpDTO userNameOtpDTO) {
        String username = userNameOtpDTO.getUsername();
        String otp = userNameOtpDTO.getOtp();
        Boolean isVerifyOtp = userService.verifyOtp(username, otp);
        if (!isVerifyOtp)
            return FAIL;
        return SUCCESS;
    }



}
