package com.app.dependencyinjection.services;

import java.util.List;

import com.app.dependencyinjection.models.Product;
import com.app.dependencyinjection.repositories.ProductRepository;

public class ProductService {
  private ProductRepository productRepository;

  public ProductService() {
    this.productRepository = new ProductRepository();
  }

  public List<Product> getProducts() {
    return productRepository.getProducts();
  }

  public Product getProductById(Integer id) {
    return productRepository.getProductById(id);
  }
}
