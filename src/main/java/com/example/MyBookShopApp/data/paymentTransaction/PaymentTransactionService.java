package com.example.MyBookShopApp.data.paymentTransaction;

import com.example.MyBookShopApp.data.instoreAccount.InstoreAccountService;
import com.example.MyBookShopApp.security.BookstoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentTransactionService {

    @Value("${robokassa.merchant.login}")
    private String merchantLogin;

    @Value("${robokassa.pass.first.test}")
    private String firstTestPass;

    private PaymentTransactionRepository paymentTransactionRepository;
    private BookstoreUserRepository bookstoreUserRepository;
    private InstoreAccountService instoreAccountService;

    @Autowired
    public PaymentTransactionService(PaymentTransactionRepository paymentTransactionRepository, BookstoreUserRepository bookstoreUserRepository, InstoreAccountService instoreAccountService) {
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.bookstoreUserRepository = bookstoreUserRepository;
        this.instoreAccountService = instoreAccountService;
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

    public String handlePaymentTransaction(Integer userId, Double paymentAmount) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setBookstoreUser(bookstoreUserRepository.findBookstoreUserById(userId));
        paymentTransaction.setTimeStamp(LocalDateTime.now());
        paymentTransaction.setAmount(paymentAmount);
        paymentTransaction.setStatus(true);

        paymentTransactionRepository.save(paymentTransaction);
        instoreAccountService.putMoneyIntoInstoreAccount(userId, paymentAmount);

        Integer invId = paymentTransaction.getId();
        md.update((merchantLogin + ":" + paymentAmount.toString() + ":" + invId + ":" + firstTestPass).getBytes());
        return "https://auth.robokassa.ru/Merchant/Index.aspx"+
                "?MerchantLogin="+merchantLogin+
                "&IndId="+invId+
                "&Culture=ru"+
                "&Encoding=utf-8"+
                "&OutSum="+paymentAmount+
                "&SignatureValue="+ DatatypeConverter.printHexBinary(md.digest()).toUpperCase()+
                "&IsTest=1";
    }
}
