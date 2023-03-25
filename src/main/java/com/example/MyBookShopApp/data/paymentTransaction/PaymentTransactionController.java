package com.example.MyBookShopApp.data.paymentTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/payment_transactions")
public class PaymentTransactionController {

    private PaymentTransactionService paymentTransactionService;

    @Autowired
    public PaymentTransactionController(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentTransaction>> getAllTransactions(){
        return ResponseEntity.ok(paymentTransactionService.getAllTransactions());
    }

    @GetMapping("/user_transaction_history/{user_id}")
    public ResponseEntity<List<PaymentTransaction>> getAllUserTransactions(@PathVariable("user_id") Integer id){
        return ResponseEntity.ok(paymentTransactionService.getAllUserTransactions(id));
    }

    @GetMapping("/transaction/{transaction_id}")
    public ResponseEntity<PaymentTransaction> getCertainTransaction(@PathVariable("transaction_id") Integer id){
        return ResponseEntity.ok(paymentTransactionService.getPaymentTransactionById(id));
    }
}
