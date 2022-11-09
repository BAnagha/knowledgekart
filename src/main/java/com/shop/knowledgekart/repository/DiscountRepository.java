package com.shop.knowledgekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.knowledgekart.model.Discount;
/**
 * 
 * Repository class for Discount entity
 * 
 * @author anaghabhide
 *
 */
@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
	
	@Query("from Discount where isValid = true")
	Discount findValidDiscount();
	
	@Modifying
	@Query("update Discount set isValid = false")
	void invalidateDiscounts();

}
