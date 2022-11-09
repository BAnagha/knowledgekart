package com.shop.knowledgekart.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.shop.knowledgekart.dto.BookOrderDto;
import com.shop.knowledgekart.dto.OrderFormDto;
import com.shop.knowledgekart.exception.ResourceNotFoundException;
import com.shop.knowledgekart.model.BookOrder;
import com.shop.knowledgekart.model.Order;
import com.shop.knowledgekart.model.OrderStatus;
import com.shop.knowledgekart.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	BookOrderService bookOrderService;
	
	@Autowired
	BookService bookService;

	public Iterable<Order> getAllOrders() {
		return this.orderRepository.findAll();
	}

	/**
	 * 
	 * Service method to handle/create object for saving to the persistent layer
	 * 
	 * @param orderFormDto
	 * @return saved Order
	 * @throws ResourceNotFoundException
	 */
	public Order create(OrderFormDto orderFormDto) throws ResourceNotFoundException {


		List<BookOrderDto> orderFormDtoDtos = orderFormDto.getBookOrders();
		checkIfBookExists(orderFormDtoDtos);

		Order order = new Order();
		order.setStatus(OrderStatus.PAID.name());
		order.setDiscountCode(orderFormDto.getDiscountCode());
		order.setDiscountApplied(orderFormDto.isDiscountApplied());
		order.setTotal(orderFormDto.getTotalPrice());
		order.setDateCreated(LocalDate.now());
		order = this.orderRepository.save(order);

		// saving entity book and order data 
		List<BookOrder> bookOrders = new ArrayList<>();
		for (BookOrderDto dto : orderFormDtoDtos) {
			bookOrders.add(bookOrderService
					.create(new BookOrder(order, bookService.getBook(dto.getBook().getId()), dto.getQuantity())));
		}

		order.setBookOrders(bookOrders);
		update(order);
		
		return this.orderRepository.save(order);
	}

	public void update(Order order) {
		this.orderRepository.save(order);
	}
	
	public long getLatestOrderId() {
		return this.orderRepository.findLatestOrderId() != null ? this.orderRepository.findLatestOrderId().longValue() : 0;
	}
	
	public Order getLatestOrder() {
		return this.orderRepository.findLatestOrder();
	}
	
	private void checkIfBookExists(List<BookOrderDto> orderProducts) throws ResourceNotFoundException {
		List<BookOrderDto> list = orderProducts.stream().filter(op -> {
			return Objects.isNull(bookService.getBook(op.getBook().getId()));
		}).collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(list)) {
			throw new ResourceNotFoundException("Product not found");
		}

	}

}