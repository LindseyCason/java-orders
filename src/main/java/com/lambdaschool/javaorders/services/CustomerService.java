package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;

import java.util.List;

public interface CustomerService {

    //Return all customers with their orders
    List<Customer> findCust();

    //Adds a new customer including any new orders
    Customer addCust(Customer newCustomer);

    //Updates the customer based off of custcode. Does not have to do anything with Orders!
    Customer updateCust(Customer customer, long id);

    //Deletes the customer based off of custcode
    //this should also delete the orders of that customer
    void deleteCust(long id);
}
