package com.example.MyBookShopApp.data.instoreAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstoreAccountService {

    private InstoreAccountRepository instoreAccountRepository;

    @Autowired
    public InstoreAccountService(InstoreAccountRepository instoreAccountRepository) {
        this.instoreAccountRepository = instoreAccountRepository;
    }

    public synchronized void putMoneyIntoInstoreAccount(Integer userId, Double amount){
        InstoreAccount instoreAccount = instoreAccountRepository.findInstoreAccountByBookstoreUser_Id(userId);
        instoreAccount.setCurrentAmount(instoreAccount.getCurrentAmount() + amount);
        instoreAccountRepository.save(instoreAccount);
    }

    public synchronized void withdrawMoneyFromInstoreAccount(Integer userId, Double amount) {
        InstoreAccount instoreAccount = instoreAccountRepository.findInstoreAccountByBookstoreUser_Id(userId);
        instoreAccount.setCurrentAmount(instoreAccount.getCurrentAmount() - amount);
        instoreAccountRepository.save(instoreAccount);
    }
}
