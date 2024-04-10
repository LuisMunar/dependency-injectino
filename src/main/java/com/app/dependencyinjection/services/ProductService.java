package com.app.dependencyinjection.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.app.dependencyinjection.models.Product;
import com.app.dependencyinjection.repositories.ProductRepositoryInterface;

@Service
public class ProductService implements ProductServiceInterface{
  @Autowired
  private Environment environment;

  @Qualifier("productRepository")
  @Autowired
  private ProductRepositoryInterface productRepositoryInterface;

  @Override
  public List<Product> getProducts() {
    List<Product> products = productRepositoryInterface.getProducts();
    return products.stream().map(product -> {
      Integer price = (int) (product.getPrice().intValue() + (int) product.getPrice().intValue() * environment.getProperty("config.tax", Float.class));
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
