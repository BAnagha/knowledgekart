package com.shop.knowledgekart.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.knowledgekart.dto.DiscountDto;
import com.shop.knowledgekart.model.Discount;
import com.shop.knowledgekart.service.DiscountService;
/**
 * 
 * @author anaghabhide
 * 
 * Controller to handle discount related functionalities
 *
 */
@RestController
@RequestMapping("/api/discount")
public class KnowledgeKartDiscountController {
	
	@Autowired
	DiscountService discountService;
	
	@GetMapping(value = { "", "/" })
	public @NotNull Discount getAvailableDiscount() {
		return discountService.fetchAvailableDiscount();
	}
	
	@PostMapping(value = { "", "/" })
	public @NotNull Discount create(@RequestBody DiscountDto discount) {
		return discountService.create(discount);
	}


}
