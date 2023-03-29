package com.example.MyBookShopApp.data.paymentTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.NoSuchAlgorithmException;
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
    @ResponseBody
    public ResponseEntity<List<PaymentTransaction>> getAllTransactions(){
        return ResponseEntity.ok(paymentTransactionService.getAllTransactions());
    }

    @PostMapping("/user_transaction_history")
    @ResponseBody
    public ResponseEntity<List<PaymentTransaction>> getAllUserTransactions(@RequestParam("user_id") Integer id){
        return ResponseEntity.ok(paymentTransactionService.getAllUserTransactions(id));
    }

    @PostMapping("/user_transaction_history/transaction")
    @ResponseBody
    public ResponseEntity<PaymentTransaction> getCertainTransaction(@RequestParam("transaction_id") Integer id){
        return ResponseEntity.ok(paymentTransactionService.getPaymentTransactionById(id));
    }

    @PostMapping("/transaction")
    public RedirectView handlePaymentTransaction(@RequestParam("user_id") Integer id,
                                                 @RequestParam("payment_amount") Double paymentAmount) throws NoSuchAlgorithmException {
        String paymentUrl = paymentTransactionService.handlePaymentTransaction(id, paymentAmount);
        return new RedirectView(paymentUrl);
    }
}
