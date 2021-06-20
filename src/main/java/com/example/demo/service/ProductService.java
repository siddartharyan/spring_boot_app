package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public Product getProduct(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getByName(String name){
        return repository.findByName(name);
    }

    public String deleteById(int id){
        repository.deleteById(id);
        return "Deleted";
    }

    public Product updateProduct(Product product){
        Product old_record=repository.findById(product.getId()).orElse(null);
        if(old_record==null){
            return repository.save(product);
        }
        old_record.setName(product.getName());
        old_record.setQuatity(product.getQuatity());
        old_record.setPrice(product.getPrice());
        return repository.save(old_record);
    }
}
