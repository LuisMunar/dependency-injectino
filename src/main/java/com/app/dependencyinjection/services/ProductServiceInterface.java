package com.app.dependencyinjection.services;

import java.util.List;

import com.app.dependencyinjection.models.Product;

public interface ProductServiceInterface {
  List<Product> getProducts();
  Product getProductById(Integer id);
}
