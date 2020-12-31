package org.sid.inventoryservice.web;


import org.sid.inventoryservice.entities.Product;
import org.springframework.data.domain.Page;

import javax.ws.rs.Produces;
import java.util.List;

public interface service {
    List<Product> pr();
    Product add(Product p);
    Product listId(Long id);
    Product modifier(Product p);
    Product supprimer(Long id);
    Page<Product> showPage(int page);
}
