package com.shop.knowledgekart.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.shop.knowledgekart.dto.OrderDetailsDto;
import com.shop.knowledgekart.model.BookCountStatus;
import com.shop.knowledgekart.model.DiscountOrderCount;
/**
 * Service class to handle any logic for Admin related functionalities
 * 
 * @author anaghabhide
 *
 */
@Service
public class AdminService {
	
	@Autowired
	EntityManager entityManager;

	/**
	 * Gets the order count by discount code
	 * @return
	 */
	public List<DiscountOrderCount> getCountOfOrdersByDiscount() {

		 Query nativeQuery = entityManager.createNativeQuery("select count(*) as count, o.discount_code from orders o group by o.discount_code", Tuple.class);
			
		 return toJson(nativeQuery.getResultList());

	}

	/**
	 * Gets data related to all orders
	 * @return
	 */
	public List<OrderDetailsDto> getAllOrderDetails() {
	
		Query nativeQuery = entityManager.createNativeQuery("select o.id as order_id, o.date_created, o.discount_code, o.is_discount_applied,o.status,o.total,bo.quantity, bo.id,b.name, b.isbn13 from orders o, book_order bo, book b where bo.id = b.id and bo.order_id = o.id", Tuple.class);
		

		 return toJson(nativeQuery.getResultList());

	}
	
	/**
	 * Gets number of copies of each book sold
	 * 
	 * @return
	 */
	public List<BookCountStatus> getCountByBook() {

        Query nativeQuery = entityManager.createNativeQuery("select count(*) as count, b.id, b.isbn13, b.name from book_order bo, book b where bo.id = b.id group by b.id", Tuple.class);
		
        return toJson(nativeQuery.getResultList());

	}
	
	private static List<ObjectNode> toJson(List<Tuple> results) {

	    List<ObjectNode> json = new ArrayList<>();

	    ObjectMapper mapper = new ObjectMapper();

	    for (Tuple tuple : results)
	    {
	        List<TupleElement<?>> cols = tuple.getElements();

	        ObjectNode node = mapper.createObjectNode();

	        for (TupleElement col : cols)
	            node.put(col.getAlias(), (tuple.get(col.getAlias()) != null ? tuple.get(col.getAlias()).toString() : null));

	        json.add(node);
	    }
	    return json;
	}

}
