package com.shop.knowledgekart.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;
    
    private String subtitle;

    private Double price;
    
    private long isbn13;

    private String imageUrl;
    
    private String detailsUrl;
    
    private String quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(long isbn13) {
		this.isbn13 = isbn13;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetailsUrl() {
		return detailsUrl;
	}

	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", subtitle=" + subtitle + ", price=" + price + ", isbn13="
				+ isbn13 + ", imageUrl=" + imageUrl + ", detailsUrl=" + detailsUrl + ", quantity=" + quantity + "]";
	}

	public Book() {
		super();
	}

	public Book(Long id, @NotNull(message = "Product name is required.") String name, String subtitle, Double price,
			long isbn13, String imageUrl, String detailsUrl, String quantity) {
		super();
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.price = price;
		this.isbn13 = isbn13;
		this.imageUrl = imageUrl;
		this.detailsUrl = detailsUrl;
		this.quantity = quantity;
	}
}