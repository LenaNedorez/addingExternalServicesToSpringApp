package com.example.MyBookShopApp.data.purchase;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.security.BookstoreUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private BookstoreUser bookstoreUser;
    private LocalDateTime purchaseDate;
    private Double amount;
    private boolean status;
    @ManyToMany(mappedBy = "purchases")
    private List<Book> purchasedBooks;

}
