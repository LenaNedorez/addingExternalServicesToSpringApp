package com.example.MyBookShopApp.data.paymentTransaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Integer> {

    PaymentTransaction getPaymentTransactionById(Integer id);

    List<PaymentTransaction> getAllByBookstoreUser_Id(Integer id);

    List<PaymentTransaction> getAll();
}
