package com.shop.knowledgekart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.shop.knowledgekart.model.Book;
import com.shop.knowledgekart.model.BookOrder;
import com.shop.knowledgekart.model.BookOrderPK;
import com.shop.knowledgekart.model.Order;
import com.shop.knowledgekart.repository.BookOrderRepository;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@AutoConfigureMockMvc
class BookOrderServiceTest {
	
	@InjectMocks
	BookOrderService bookOrderService;
	
	@Mock
	BookOrderRepository bookOrderRepository;

	@Test
	void testCreate() {
		Book book = new Book();
		Order order = new Order();
		BookOrderPK bookOrderPK = new BookOrderPK();
		bookOrderPK.setBook(book);
		bookOrderPK.setOrder(order);
		BookOrder bookOrder = new BookOrder();
		bookOrder.setPk(bookOrderPK);
		when(bookOrderRepository.save(ArgumentMatchers.any())).thenReturn(bookOrder);
		BookOrder bo = bookOrderService.create(bookOrder);
		assertNotNull(bo);
		assertEquals(bookOrder.getBook().getIsbn13(), bo.getBook().getIsbn13());
	}

}
