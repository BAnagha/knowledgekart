package com.shop.knowledgekart.model;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreated;

	private double total;
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private String status;

	private boolean isDiscountApplied;

	private String discountCode;

	@JsonManagedReference
	@OneToMany(mappedBy = "pk.order")
	@Valid
	private List<BookOrder> bookOrders = new ArrayList<>();

	@Transient
	public Double getTotalOrderPrice() {
		double sum = 0D;
		List<BookOrder> bookOrders = getBookOrders();
		for (BookOrder op : bookOrders) {
			sum += op.getTotalPrice();
		}
		return sum;
	}

	@Transient
	public int getNumberOfProducts() {
		return this.bookOrders.size();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BookOrder> getBookOrders() {
		return bookOrders;
	}

	public void setBookOrders(List<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}

	public boolean isDiscountApplied() {
		return isDiscountApplied;
	}

	public void setDiscountApplied(boolean isDiscountAplied) {
		this.isDiscountApplied = isDiscountAplied;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	

	public Order(Long id, LocalDate dateCreated, double total, String status, boolean isDiscountApplied,
			String discountCode, @Valid List<BookOrder> bookOrders) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.total = total;
		this.status = status;
		this.isDiscountApplied = isDiscountApplied;
		this.discountCode = discountCode;
		this.bookOrders = bookOrders;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateCreated=" + dateCreated + ", total=" + total + ", status=" + status
				+ ", isDiscountApplied=" + isDiscountApplied + ", discountCode=" + discountCode + ", bookOrders="
				+ bookOrders + "]";
	}

	public Order() {
		super();
	}

}