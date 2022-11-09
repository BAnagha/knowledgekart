package com.shop.knowledgekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.knowledgekart.dto.OrderDetailsDto;
import com.shop.knowledgekart.model.BookCountStatus;
import com.shop.knowledgekart.model.DiscountOrderCount;
import com.shop.knowledgekart.service.AdminService;

/**
 * 
 * @author anaghabhide
 * 
 * 
 * Controller for admin related functionalities
 */
@RestController
@RequestMapping("api/admin")
public class KnowledgeKartAdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(value = {"/orderDetails" })
	public List<OrderDetailsDto> getAllOrderDetails() {
		return adminService.getAllOrderDetails();
	}
	
	@GetMapping(value = {"/orderCountByBook" })
	public List<BookCountStatus> getCountByBook() {
		return adminService.getCountByBook();
	}
	
	@GetMapping(value = {"/countOfOrdersByDiscount" })
	public List<DiscountOrderCount> getCountOfOrdersByDiscount() {
		return adminService.getCountOfOrdersByDiscount();
	}

}
