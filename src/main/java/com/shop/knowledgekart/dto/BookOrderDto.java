package com.shop.knowledgekart.dto;

import com.shop.knowledgekart.model.Book;

public class BookOrderDto {

    private Book book;
    private Integer quantity;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}