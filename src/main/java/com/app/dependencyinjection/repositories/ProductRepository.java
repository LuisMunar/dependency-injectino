package com.app.dependencyinjection.repositories;

import java.util.List;

import com.app.dependencyinjection.models.Product;

public class ProductRepository {
  List<Product> products;

  public ProductRepository() {
    this.products = List.of(
      new Product(1, "Product 1", 100.0),
      new Product(2, "Product 2", 200.0),
      new Product(3, "Product 3", 300.0)
    );
  }

  public List<Product> getProducts() {
    return products;
  }
}
