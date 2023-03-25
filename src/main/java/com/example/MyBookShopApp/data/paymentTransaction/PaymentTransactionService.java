package com.example.MyBookShopApp.data.paymentTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTransactionService {

    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    public PaymentTransactionService(PaymentTransactionRepository paymentTransactionRepository) {
        this.paymentTransactionRepository = paymentTransactionRepository;
    }

    public List<PaymentTransaction> getAllTransactions(){
        return paymentTransactionRepository.getAll();
    }

    public List<PaymentTransaction> getAllUserTransactions(Integer id){
        return paymentTransactionRepository.getAllByBookstoreUser_Id(id);
    }

    public PaymentTransaction getPaymentTransactionById(Integer id) {
        return paymentTransactionRepository.getPaymentTransactionById(id);
    }
}
