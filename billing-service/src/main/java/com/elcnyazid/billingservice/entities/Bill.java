package com.elcnyazid.billingservice.entities;

import com.elcnyazid.billingservice.model.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItemList;
    private Long customerId;
    @Transient
    private Customer customer;

}
