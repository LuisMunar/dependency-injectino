package com.app.dependencyinjection.models;

public class Product {
  private Number id;
  private String name;
  private Double price;

  public Product() {}

  public Product(Number id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Number getId() {
    return id;
  }

  public void setId(Number id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
