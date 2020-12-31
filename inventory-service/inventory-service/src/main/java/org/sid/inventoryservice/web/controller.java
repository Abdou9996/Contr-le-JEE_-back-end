package org.sid.inventoryservice.web;


import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/produit")
public class controller {
    @Autowired
    service service;
    @Autowired
    ProductRepository productRepository;

    @GetMapping()
    List<Product> pr() {
        return service.pr();
    }

   @PostMapping
    Product add(@RequestBody Product p) {
        return service.add(p);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Product listId(@PathVariable("id") Long id) {

        return service.listId(id);
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/{id}")
    Product modifier(@RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
        return service.modifier(product);
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
    Product supprimer(@PathVariable("id") Long id) {
        return service.supprimer(id);
    }

    Page<Product> showPage(int page) {
        return null;
    }
}
