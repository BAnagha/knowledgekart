package com.shop.knowledgekart.dto;

import java.time.LocalDate;

public class OrderDetailsDto {
	private long order_id;
	private LocalDate date_created;
	private String discount_code;
	private boolean is_discount_applied;
	private String status;
	private double total;
	private int quantity;
	private long id;
	private String name;
	private long isbn13;
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public LocalDate getDate_created() {
		return date_created;
	}
	public void setDate_created(LocalDate date_created) {
		this.date_created = date_created;
	}
	public String getDiscount_code() {
		return discount_code;
	}
	public void setDiscount_code(String discount_code) {
		this.discount_code = discount_code;
	}
	public boolean isIs_discount_applied() {
		return is_discount_applied;
	}
	public void setIs_discount_applied(boolean is_discount_applied) {
		this.is_discount_applied = is_discount_applied;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(long isbn13) {
		this.isbn13 = isbn13;
	}
	@Override
	public String toString() {
		return "OrderDetailsDto [order_id=" + order_id + ", date_created=" + date_created + ", discount_code="
				+ discount_code + ", is_discount_applied=" + is_discount_applied + ", status=" + status + ", total="
				+ total + ", quantity=" + quantity + ", id=" + id + ", name=" + name + ", isbn13=" + isbn13 + "]";
	}
	public OrderDetailsDto(long order_id, LocalDate date_created, String discount_code, boolean is_discount_applied,
			String status, double total, int quantity, long id, String name, long isbn13) {
		super();
		this.order_id = order_id;
		this.date_created = date_created;
		this.discount_code = discount_code;
		this.is_discount_applied = is_discount_applied;
		this.status = status;
		this.total = total;
		this.quantity = quantity;
		this.id = id;
		this.name = name;
		this.isbn13 = isbn13;
	}
	
}
