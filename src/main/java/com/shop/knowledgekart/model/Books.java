package com.shop.knowledgekart.model;

import java.util.ArrayList;
import java.util.List;

public class Books {
	
	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Books(List<Book> books) {
		super();
		this.books = books;
	}

	@Override
	public String toString() {
		return "Books [books=" + books + "]";
	}

	public Books() {
		super();
	}

}
