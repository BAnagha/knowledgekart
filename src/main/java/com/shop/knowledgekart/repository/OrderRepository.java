package com.shop.knowledgekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.knowledgekart.model.Order;
/**
 * 
 * Repository class for Order entity
 * @author anaghabhide
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long>{
	@Query("Select max(id) from Order")
	Long findLatestOrderId();
	
	@Query("from Order where id = (Select max(id) from Order)")
	Order findLatestOrder();

}
