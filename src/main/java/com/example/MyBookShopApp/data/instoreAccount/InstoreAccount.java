package com.example.MyBookShopApp.data.instoreAccount;

import com.example.MyBookShopApp.security.BookstoreUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instore_accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InstoreAccount {

    @Id
    private Integer id;
    @OneToOne
    private BookstoreUser bookstoreUser;
    private Double currentAmount;
}
