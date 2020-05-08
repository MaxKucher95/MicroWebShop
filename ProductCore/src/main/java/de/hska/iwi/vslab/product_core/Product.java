package de.hska.iwi.vslab.product_core;

@javax.persistence.Entity
public class Product {
  @javax.persistence.Id
  @javax.persistence.GeneratedValue
  @javax.persistence.Column(name="PRODUCT_ID")
  private Long id;

  @javax.persistence.Column(name="PRODUCT_NAME")
  private String name;

  @javax.persistence.Column(name="PRODUCT_DETAILS")
  private String details;

  @javax.persistence.Column(name="PRODUCT_PRICE")
  private double price;

  @javax.persistence.Column(name="PRODUCT_CATEGORY")
  private int category;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
  
}