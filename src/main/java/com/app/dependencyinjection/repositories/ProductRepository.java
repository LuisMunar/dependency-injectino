package com.app.dependencyinjection.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.dependencyinjection.models.Product;

@Component
public class ProductRepository implements ProductRepositoryInterface {
  List<Product> products;

  public ProductRepository() {
    this.products = List.of(
      new Product(1, "Product 1", 100.0),
      new Product(2, "Product 2", 200.0),
      new Product(3, "Product 3", 300.0)
    );
  }

  @Override
  public List<Product> getProducts() {
    return products;
  }

  @Override
  public Product getProductById(Integer id) {
    return products.stream()
      .filter(product -> product.getId().equals(id))
      .findFirst()
      .orElse(null);
  }
}
