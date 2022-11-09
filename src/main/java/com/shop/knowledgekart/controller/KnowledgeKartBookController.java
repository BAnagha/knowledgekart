package com.shop.knowledgekart.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.knowledgekart.model.Book;
import com.shop.knowledgekart.model.Books;
import com.shop.knowledgekart.service.BookService;
/**
 * 
 * @author anaghabhide
 * 
 * 
 * Controller for Book related functionalities
 *
 */
@RestController
@RequestMapping("/api/books")
public class KnowledgeKartBookController {

	@Autowired
	BookService bookService;

	@GetMapping(value = { "", "/" })
	public @NotNull Iterable<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping(value = { "", "/" })
	public @NotNull Iterable<Book> saveBooks(@RequestBody Books books){
		return bookService.save(books);
	}
}