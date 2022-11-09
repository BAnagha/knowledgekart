package com.shop.knowledgekart.model;

import java.beans.Transient;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BookOrder {

    public BookOrder() {
		super();
	}

	@EmbeddedId
    @JsonIgnore
    private BookOrderPK pk;

    @Column(nullable = false)
	private Integer quantity;

    // default constructor

    public BookOrder(Order order, Book Book, Integer quantity) {
        pk = new BookOrderPK();
        pk.setOrder(order);
        pk.setBook(Book);
        this.quantity = quantity;
    }

    @Transient
    public Book getBook() {
        return this.pk.getBook();
    }

    @Transient
    public Double getTotalPrice() {
        return getBook().getPrice() * getQuantity();
    }

	public BookOrderPK getPk() {
		return pk;
	}

	public void setPk(BookOrderPK pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pk, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookOrder other = (BookOrder) obj;
		return Objects.equals(pk, other.pk) && Objects.equals(quantity, other.quantity);
	}

   
}