package com.example.MyBookShopApp.data.resetPassword;

import com.example.MyBookShopApp.security.BookstoreUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_tokens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = BookstoreUser.class)
    @JoinColumn(nullable = false, name = "id")
    private UserDetails userDetails;

    private LocalDateTime expiryTime;

    public PasswordResetToken(UserDetails userDetails, String token, Integer expiryTime) {
        this.token = token;
        this.userDetails = userDetails;
        this.expiryTime = LocalDateTime.now().plusSeconds(expiryTime);
    }
}
