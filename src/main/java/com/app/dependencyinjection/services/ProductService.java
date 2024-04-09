package com.app.dependencyinjection.services;

import java.util.List;
import java.util.stream.Collectors;

import com.app.dependencyinjection.models.Product;
import com.app.dependencyinjection.repositories.ProductRepository;

public class ProductService {
  private ProductRepository productRepository;

  public ProductService() {
    this.productRepository = new ProductRepository();
  }

  public List<Product> getProducts() {
    List<Product> products = productRepository.getProducts();
    return products.stream().map(product -> {
      Integer price = product.getPrice().intValue() * 2;
      Product newProduct = (Product) product.clone();
      newProduct.setPrice(price.doubleValue());
      return newProduct;
    })
    .collect(Collectors.toList());
  }

  public Product getProductById(Integer id) {
    return productRepository.getProductById(id);
  }
}
