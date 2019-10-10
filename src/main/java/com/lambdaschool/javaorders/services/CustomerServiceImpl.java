package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService
{
   @Autowired
    private CustomerRepository custrepo;

    @Override
    public List<Customer> findCust() {

        List<Customer> rtncust = new ArrayList<>();
        custrepo.findAll()
                .iterator()
                .forEachRemaining(rtncust::add);
        return rtncust;
    }
    @Transactional
    @Override
    public Customer addCust(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());

        return custrepo.save(newCustomer);
    }

    @Override
    public Customer updateCust(Customer customer, long id) {
        return null;
    }

    @Override
    public void deleteCust(long id) {

    }
}
