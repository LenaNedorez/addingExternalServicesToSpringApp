package com.example.MyBookShopApp.data.paymentTransaction;

import com.example.MyBookShopApp.security.BookstoreUser;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment_transactions")
public class PaymentTransaction {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private BookstoreUser bookstoreUser;
    private Date date;
    private Double amount;
    private boolean status;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
