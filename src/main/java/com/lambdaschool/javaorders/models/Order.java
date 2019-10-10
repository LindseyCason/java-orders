package com.lambdaschool.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double ordamount;
    private double advanceamount;


    @ManyToOne
    @JoinColumn(name = "customers", nullable = false)
    private Customer custcode;

    private String orddescription;

    public Order() {
    }

    public Order(double ordamount, double advanceamount, Customer custcode, String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orddescription = orddescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public Customer getCustcode() {
        return custcode;
    }

//    public void setCustcode(long custcode) {
//        this.custcode = custcode;
//    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }
}
