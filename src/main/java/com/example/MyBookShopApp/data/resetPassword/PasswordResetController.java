package com.example.MyBookShopApp.data.resetPassword;

import com.example.MyBookShopApp.security.BookstoreUserDetails;
import com.example.MyBookShopApp.security.BookstoreUserDetailsService;
import com.example.MyBookShopApp.security.ContactConfirmationPayload;
import com.example.MyBookShopApp.security.ContactConfirmationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class PasswordResetController {

    private BookstoreUserDetailsService bookstoreUserDetailsService;
    private PasswordResetService passwordResetService;
    private final JavaMailSender javaMailSender;

    @Autowired
    public PasswordResetController(BookstoreUserDetailsService bookstoreUserDetailsService, PasswordResetService passwordResetService, JavaMailSender javaMailSender) {
        this.bookstoreUserDetailsService = bookstoreUserDetailsService;
        this.passwordResetService = passwordResetService;
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/user/resetPassword")
    @ResponseBody
    public ContactConfirmationResponse resetPassword(@RequestBody ContactConfirmationPayload payload) {
        ContactConfirmationResponse response = new ContactConfirmationResponse();
        UserDetails userDetails = bookstoreUserDetailsService.loadUserByUsername(payload.getContact());

        String token = UUID.randomUUID().toString();
        passwordResetService.createPasswordResetTokenForUser(userDetails, token, 300);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bookstore00@mail.ru");
        message.setTo(payload.getContact());
        message.setSubject("Bookstore reset password");
        message.setText("In order to reset your password, click the link:"
                        + "/user/changePassword?token=" + token);
        javaMailSender.send(message);
        response.setResult("true");
        return response;
    }
}