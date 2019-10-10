package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //GET http://localhost:2019/customer/order
    //POST http://localhost:2019/customer/new
    //PUT http://localhost:2019/customer/update/{custcode}
    //DELETE http://localhost:2019/customer/delete/{custcode}
    @GetMapping(value="/order", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers(){
        List<Customer> myCustList= customerService.findCust();
        return new ResponseEntity<>(myCustList, HttpStatus.OK);
    }

    @PostMapping(value="/new", consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer)
    {
        customerService.addCust(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
