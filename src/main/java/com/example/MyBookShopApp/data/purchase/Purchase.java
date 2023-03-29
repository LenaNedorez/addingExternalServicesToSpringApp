package com.example.MyBookShopApp.data.purchase;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.security.BookstoreUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private BookstoreUser bookstoreUser;
    private Date purchaseDate;
    private Double amount;
    private boolean status;
    @ManyToMany(mappedBy = "purchases")
    private List<Book> purchasedBooks;

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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(List<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }
}
