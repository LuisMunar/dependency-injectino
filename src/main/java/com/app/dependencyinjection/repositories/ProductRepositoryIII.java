package com.app.dependencyinjection.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.app.dependencyinjection.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Primary
public class ProductRepositoryIII implements ProductRepositoryInterface{
  List<Product> products;

  public ProductRepositoryIII() {
    Resource productsResource = new ClassPathResource("data/products.json");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      products = Arrays.asList(objectMapper.readValue(productsResource.getInputStream(), Product[].class));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Product> getProducts() {
    return products;
  }

  @Override
  public Product getProductById(Integer id) {
    return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
  }
}
