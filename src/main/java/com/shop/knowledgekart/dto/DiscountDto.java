package com.shop.knowledgekart.dto;

public class DiscountDto {

	private Long id;

	private int transactionMultiplier;
	
	private int percentDiscount;

	private String discountCode;
	
	private boolean isValid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTransactionMultiplier() {
		return transactionMultiplier;
	}

	public void setTransactionMultiplier(int transactionMultiplier) {
		this.transactionMultiplier = transactionMultiplier;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public boolean isIdValid() {
		return isValid;
	}

	public void setIdValid(boolean idValid) {
		this.isValid = idValid;
	}

	public DiscountDto(Long id, int transactionMultiplier, int percentDiscount, String discountCode, boolean idValid) {
		super();
		this.id = id;
		this.transactionMultiplier = transactionMultiplier;
		this.percentDiscount = percentDiscount;
		this.discountCode = discountCode;
		this.isValid = idValid;
	}

	@Override
	public String toString() {
		return "DiscountDto [id=" + id + ", transactionMultiplier=" + transactionMultiplier + ", percentDiscount="
				+ percentDiscount + ", discountCode=" + discountCode + ", idValid=" + isValid + "]";
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public DiscountDto() {
		super();
	}
	
	
}
