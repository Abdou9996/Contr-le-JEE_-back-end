package org.sid.customerservices.web;

import org.sid.customerservices.entities.Customer;
import org.sid.customerservices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class serviceImp implements  service {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> pr() {
        return customerRepository.findAll();
    }
    @Override
    public Customer add(Customer p) {
        return customerRepository.save(p);
        }
        @Override
        public Customer listId(Long id) {
        return customerRepository.findById(id).get();
    }
    @Override
    public Customer modifier(Customer p) {
        return customerRepository.save(p);
    }
    @Override
    public Customer supprimer(Long id) {
        Customer customer=customerRepository.findById(id).get();
        if (customer!=null)
        {
            customerRepository.delete(customer);
        }
        return customer;
    }
    @Override
    public Page<Customer> showPage(int page) {
        return customerRepository.findAll(PageRequest.of(page,5));
    }
}
