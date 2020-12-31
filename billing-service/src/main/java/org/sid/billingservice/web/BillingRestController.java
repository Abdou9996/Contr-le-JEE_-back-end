package org.sid.billingservice.web;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.feign.CustomerRestClient;
import org.sid.billingservice.feign.ProductItemRestClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepositpry;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillingRestController {
    private BillRepository billRepository;
    private ProductItemRepositpry productItemRepositpry;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepositpry productItemRepositpry, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepositpry = productItemRepositpry;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        PagedModel<Product> productPagedModel = productItemRestClient.pageProduct();
        bill.getProductItems().forEach(pi -> {
            Product product = productItemRestClient.getProductById(pi.getProductID());
            pi.setProductName(product.getName());
        });
        return bill;
    }

    @GetMapping(path = "/fullBill")
    public List<Bill> Bill() {
        return billRepository.findAll();
    }
    @GetMapping(path = "/fullB")
    public List<ProductItem> BillProduct() {
        return productItemRepositpry.findAll();
    }

}
