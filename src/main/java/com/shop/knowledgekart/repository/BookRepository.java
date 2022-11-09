package com.shop.knowledgekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.knowledgekart.model.Book;
/**
 * Repositoy class for Book Entity
 * 
 * @author anaghabhide
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
