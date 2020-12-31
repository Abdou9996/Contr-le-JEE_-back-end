package org.sid.inventoryservice.web;


import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceImp implements service {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> pr() {
        return productRepository.findAll();
    }

    @Override
    public Product add(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product listId(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product modifier(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product supprimer(Long id) {
        Product product = productRepository.findById(id).get();
        if (product != null)
            productRepository.delete(product);

            return product;
    }

    @Override
    public Page<Product> showPage(int page) {
        return productRepository.findAll(PageRequest.of(page,5));
    }
}
