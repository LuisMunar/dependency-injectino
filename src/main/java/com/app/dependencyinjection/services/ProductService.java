package com.app.dependencyinjection.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.dependencyinjection.models.Product;
import com.app.dependencyinjection.repositories.ProductRepositoryInterface;

@Service
public class ProductService implements ProductServiceInterface{
  @Qualifier("productRepositoryII")
  @Autowired
  private ProductRepositoryInterface productRepositoryInterface;

  @Override
  public List<Product> getProducts() {
    List<Product> products = productRepositoryInterface.getProducts();
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
    return productRepositoryInterface.getProductById(id);
  }
}
