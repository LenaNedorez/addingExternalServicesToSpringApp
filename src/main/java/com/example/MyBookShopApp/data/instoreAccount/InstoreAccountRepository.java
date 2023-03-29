package com.example.MyBookShopApp.data.instoreAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstoreAccountRepository extends JpaRepository<InstoreAccount, Integer> {

    InstoreAccount findInstoreAccountByBookstoreUser_Id(Integer userId);
}
