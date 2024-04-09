package com.app.dependencyinjection.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.dependencyinjection.models.Product;
import com.app.dependencyinjection.services.ProductServiceInterface;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductServiceInterface productServiceInterface;

  @GetMapping("")
  public List<Product> getProducts() {
    return productServiceInterface.getProducts();
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable Integer id) {
    return productServiceInterface.getProductById(id);
  }
}
