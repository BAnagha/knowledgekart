package com.shop.knowledgekart.controller;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shop.knowledgekart.dto.OrderFormDto;
import com.shop.knowledgekart.exception.ResourceNotFoundException;
import com.shop.knowledgekart.model.Order;
import com.shop.knowledgekart.service.BookOrderService;
import com.shop.knowledgekart.service.BookService;
import com.shop.knowledgekart.service.OrderService;
/**
 * 
 * @author anaghabhide
 * 
 * Controller to handle Order related functionalities
 *
 */
@RestController
@RequestMapping("/api/orders")
public class KnowledgeKartOrderController {

	BookService bookService;
	OrderService orderService;
	BookOrderService bookOrderService;

	public KnowledgeKartOrderController(BookService bookService, OrderService orderService,
			BookOrderService bookOrderService) {
		this.bookService = bookService;
		this.orderService = orderService;
		this.bookOrderService = bookOrderService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Iterable<Order> list() {
		return this.orderService.getAllOrders();
	}

	/**
	 * Method to get the latest orderId to check for discount eligibility
	 * 
	 * @return orderId
	 */
	@GetMapping(value = "latestOrderId")
	@ResponseStatus(HttpStatus.OK)
	public @NotNull long getLatestOrderId() {
		return this.orderService.getLatestOrderId();
	}

	@GetMapping(value = "latestOrder")
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Order getLatestOrder() {
		return this.orderService.getLatestOrder();
	}

	/**
	 * Method to create order in the database
	 * 
	 * @param Orderform data
	 * @return Order saved to persistent layer
	 * @throws ResourceNotFoundException
	 */
	@PostMapping(value = { "", "/" })
	public ResponseEntity<Order> create(@RequestBody OrderFormDto form) throws ResourceNotFoundException {
		Order order = orderService.create(form);

		String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/orders/{id}")
				.buildAndExpand(order.getId()).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}
}
