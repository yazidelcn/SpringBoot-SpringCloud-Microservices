package com.elcnyazid.billingservice.web;

import com.elcnyazid.billingservice.entities.Bill;
import com.elcnyazid.billingservice.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
    @Autowired
    BillRepository billRepository;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        System.out.println(bill);
        return bill;
    }
}
