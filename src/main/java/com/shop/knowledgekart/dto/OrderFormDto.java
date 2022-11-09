package com.shop.knowledgekart.dto;

import java.util.List;

public class OrderFormDto {

		private List<BookOrderDto> bookOrders;
		private String discountCode;
		private boolean isDiscountApplied;
		private double totalPrice = 0.0;

		public List<BookOrderDto> getBookOrders() {
			return bookOrders;
		}

		public void setBookOrders(List<BookOrderDto> bookOrders) {
			this.bookOrders = bookOrders;
		}

		public String getDiscountCode() {
			return discountCode;
		}

		public void setDiscountCode(String discountCode) {
			this.discountCode = discountCode;
		}

		public boolean isDiscountApplied() {
			return isDiscountApplied;
		}

		public void setIsDiscountApplied(boolean isDiscountApplied) {
			this.isDiscountApplied = isDiscountApplied;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

	}