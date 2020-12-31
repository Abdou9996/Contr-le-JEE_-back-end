package org.sid.customerservices.web;

import org.sid.customerservices.entities.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface service {
    List<Customer> pr();
    Customer add(Customer p);
    Customer listId(Long id);
    Customer modifier(Customer p);
    Customer supprimer(Long id);
    Page<Customer> showPage(int page);
}
