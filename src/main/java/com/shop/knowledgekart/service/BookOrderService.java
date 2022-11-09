package com.shop.knowledgekart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.knowledgekart.model.BookOrder;
import com.shop.knowledgekart.repository.BookOrderRepository;

@Service
@Transactional
public class BookOrderService {

	@Autowired
	private BookOrderRepository bookOrderRepository;

	/**
	 * 
	 * Method to create order in relation to the book bought
	 * 
	 * @param bookOrder
	 * @return
	 */
	public BookOrder create(BookOrder bookOrder) {
		return this.bookOrderRepository.save(bookOrder);
	}
}
