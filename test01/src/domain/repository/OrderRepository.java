package domain.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.entity.Member;
import domain.entity.Order;

public class OrderRepository {
	
	private static Long nextId = 0L;

	private Map<Long, Order> map = new HashMap<>();
	
	public void save(Order order) {
		order.setId(++nextId);
		map.put(order.getId(), order);
	}
	public Order findOne(Long id) {
		return map.get(id);
	}
	public Collection<Order> findAll() {
		return map.values();
	}
	public List<Order> findByName(String name) {
		return Collections.emptyList();
	}
}
