package com.example.MyBookShopApp.data.resetPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PasswordResetService {

    private PasswordResetRepository passwordResetRepository;

    @Autowired
    public PasswordResetService(PasswordResetRepository passwordResetRepository) {
        this.passwordResetRepository = passwordResetRepository;
    }

    public void createPasswordResetTokenForUser(UserDetails userDetails, String token, Integer expiryTime) {
        PasswordResetToken myToken = new PasswordResetToken(userDetails, token, expiryTime);
        passwordResetRepository.save(myToken);
    }

    public String validatePasswordResetToken(String token){
        final PasswordResetToken passToken = passwordResetRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }

    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        return passToken.getExpiryTime().isBefore(LocalDateTime.now());
    }
}
