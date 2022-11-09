package com.shop.knowledgekart.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.knowledgekart.model.Book;
import com.shop.knowledgekart.model.Books;
import com.shop.knowledgekart.repository.BookRepository;

@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    /**
     * Gets all books for catalog
     * @return
     */
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    
    public Book getBook(long id) {
        Optional<Book> book =  bookRepository.findById(id);
        return book.isPresent() ? book.get() : null;
    }

    /**
     * Saves book to the persistent layer
     * @param books
     * @return
     */
    public List<Book> save(Books books) {
    	List<Book> savedBooks = null;
		savedBooks =  bookRepository.saveAllAndFlush(books.getBooks());
		return savedBooks;
    }
}