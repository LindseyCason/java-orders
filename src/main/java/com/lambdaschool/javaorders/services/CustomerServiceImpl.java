package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;
import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    public Customer save(Customer customer) {
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
    @Transactional
    public Customer updateCust(Customer customer, long id) {

        Customer currentCustomer = custrepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (customer.getCustname() != null){
            currentCustomer.setCustname(customer.getCustname());
        }
        if( customer.getCustcity() != null){
            currentCustomer.setCustcity(customer.getCustcity());
        }
        if(customer.getWorkingarea() != null){
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }
        if(customer.getCustcountry() != null){
            currentCustomer.setCustcountry(customer.getCustcountry());
        }
        if(customer.getGrade() != null){
            currentCustomer.setGrade(customer.getGrade());
        }
        if(customer.getOpeningamt() != 0){
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if(customer.getReceiveamt() != 0){
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if(customer.getPaymentamt() != 0){
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if(customer.getOutstandingamt() !=0){
            currentCustomer.setOutstandingamt(customer.getOutstandingamt());
        }
        if(customer.getPhone() != null){
            currentCustomer.setPhone(currentCustomer.getPhone());
        }

        return custrepo.save(currentCustomer);
    }

    @Override
    public void deleteCust(long id) {

        if (custrepo.findById(id).isPresent())
        {
            custrepo.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }

    }
}
