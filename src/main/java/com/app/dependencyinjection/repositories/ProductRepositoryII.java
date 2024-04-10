package com.app.dependencyinjection.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.app.dependencyinjection.models.Product;

@Primary
@Repository
public class ProductRepositoryII implements ProductRepositoryInterface {
  @Override
  public List<Product> getProducts() {
    return Collections.singletonList(new Product(4, "Product 4", 400.0));
  }

  @Override
  public Product getProductById(Integer id) {
    return new Product(id, "Product dynamic id", 500.0);
  }
}
