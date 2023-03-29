package com.example.MyBookShopApp.data.instoreAccount;

import com.example.MyBookShopApp.security.BookstoreUser;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instore_accounts")
public class InstoreAccount {

    @Id
    private Integer id;
    @OneToOne
    private BookstoreUser bookstoreUser;
    private Double currentAmount;

    public InstoreAccount() {
    }

    public InstoreAccount(Integer id, BookstoreUser bookstoreUser, Double currentAmount) {
        this.id = id;
        this.bookstoreUser = bookstoreUser;
        this.currentAmount = currentAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookstoreUser getBookstoreUser() {
        return bookstoreUser;
    }

    public void setBookstoreUser(BookstoreUser bookstoreUser) {
        this.bookstoreUser = bookstoreUser;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }
}
