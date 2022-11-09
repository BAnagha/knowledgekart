package com.shop.knowledgekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.knowledgekart.model.BookOrder;
/**
 * Repository class for BookOrder Entity
 * 
 * @author anaghabhide
 *
 */
@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long>{

}
