package com.app.dependencyinjection.repositories;

import java.util.List;

import com.app.dependencyinjection.models.Product;

public interface ProductRepositoryInterface {
  List<Product> getProducts();
  Product getProductById(Integer id);
}
