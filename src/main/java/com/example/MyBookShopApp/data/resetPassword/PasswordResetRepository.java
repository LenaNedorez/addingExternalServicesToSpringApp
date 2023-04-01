package com.example.MyBookShopApp.data.resetPassword;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetRepository extends JpaRepository<PasswordResetToken, Integer> {
}
