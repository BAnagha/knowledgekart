package com.shop.knowledgekart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.knowledgekart.dto.DiscountDto;
import com.shop.knowledgekart.model.Discount;
import com.shop.knowledgekart.repository.DiscountRepository;

@Service
@Transactional
public class DiscountService {
	
	@Autowired
	DiscountRepository discountRepository;
	
	public Discount create(DiscountDto discountDto) {
		Discount discount = mapDiscount(discountDto);
		this.discountRepository.invalidateDiscounts();
		return this.discountRepository.save(discount);
	}

	private Discount mapDiscount(DiscountDto discountDto) {
		Discount discount = new Discount();
		discount.setDiscountCode(discountDto.getDiscountCode());
		discount.setTransactionMultiplier(discountDto.getTransactionMultiplier());
		discount.setPercentDiscount(discountDto.getPercentDiscount());
		discount.setIdValid(true);
		return discount;
	}
	/**
	 * Method to fetch the available discount
	 * @return
	 */
	public Discount fetchAvailableDiscount() {
		return this.discountRepository.findValidDiscount();
	}

}
