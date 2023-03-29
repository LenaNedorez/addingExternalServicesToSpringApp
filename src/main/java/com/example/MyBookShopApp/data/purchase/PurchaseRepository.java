package com.example.MyBookShopApp.data.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Override
    Purchase getById(Integer integer);

    List<Purchase> getAllByBookstoreUser_Id(Integer id);
}
