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
    //GET http://localhost:2019/customer/order-WORDS
    @GetMapping(value="/order", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers(){
        List<Customer> myCustList= customerService.findCust();
        return new ResponseEntity<>(myCustList, HttpStatus.OK);
    }

    //POST http://localhost:2019/customer/new
    @PostMapping(value="/new", consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer)
    {
        customerService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




    //PUT http://localhost:2019/customer/update/{custcode}
    @PutMapping("/update/{custcode}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer updateCustomer, @PathVariable long custcode){
        customerService.updateCust(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //DELETE http://localhost:2019/customer/delete/{custcode} --WORDS
    @DeleteMapping("/delete/{custcode}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode)
    {
        customerService.deleteCust(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
