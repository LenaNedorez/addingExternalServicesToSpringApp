package com.example.MyBookShopApp.data.purchase;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.instoreAccount.InstoreAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;
    private InstoreAccountService instoreAccountService;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, InstoreAccountService instoreAccountService) {
        this.purchaseRepository = purchaseRepository;
        this.instoreAccountService = instoreAccountService;
    }

    public Purchase performInstorePurchase(Integer userId, List<Book> purchasedBooks){
        Double paymentSumTotal = purchasedBooks.stream().mapToDouble(Book::disсountPrice).sum();
        instoreAccountService.withdrawMoneyFromInstoreAccount(userId, paymentSumTotal);
        return new Purchase();
    }

}
