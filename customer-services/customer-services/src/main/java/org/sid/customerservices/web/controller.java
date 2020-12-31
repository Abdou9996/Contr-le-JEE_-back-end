package org.sid.customerservices.web;

import com.google.inject.internal.cglib.core.$Customizer;
import org.sid.customerservices.entities.Customer;
import org.sid.customerservices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @CrossOrigin(origins = "*",allowedHeaders = "*") @RequestMapping({"/custo"})
public class controller {
    @Autowired
    service service;
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping
    List<Customer> pr() {
        return service.pr();
    }
    @PostMapping
    Customer add(@RequestBody Customer p) {
        return service.add(p);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Customer listId(@PathVariable("id") Long id) {
        return service.listId(id);
    }
    @CrossOrigin(origins = { "localhost:4200"}, allowedHeaders={"Accept"})
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    Customer modifier(@RequestBody Customer customer, @PathVariable("id") Long id) {
        customer.setId(id);
        return service.modifier(customer);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    Customer supprimer(@PathVariable("id") Long id) {
        return service.supprimer(id);
    }
    @GetMapping("/ss")
    public Page<Customer> showPage(@RequestParam(defaultValue = "5") int page) {
        return service.showPage(page);
    }
}
