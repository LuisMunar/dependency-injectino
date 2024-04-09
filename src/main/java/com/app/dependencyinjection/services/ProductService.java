package com.app.dependencyinjection.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dependencyinjection.models.Product;
import com.app.dependencyinjection.repositories.ProductRepository;

@Component
public class ProductService implements ProductServiceInterface{
  @Autowired
  private ProductRepository productRepository;

  @Override
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

  @Override
  public Product getProductById(Integer id) {
    return productRepository.getProductById(id);
  }
}
