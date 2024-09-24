package domain.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.entity.Delivery;
import domain.entity.Member;

public class DeliveryRepository {
	private static Long nextId = 0L;

	private Map<Long, Delivery> map = new HashMap<>();
	
	public void save(Delivery delivery) {
		delivery.setId(++nextId);
		map.put(delivery.getId(), delivery);
	}
	public Delivery findOne(Long id) {
		return map.get(id);
	}
	public Collection<Delivery> findAll() {
		return map.values();
	}
	public List<Delivery> findByName(String name) {
		return Collections.emptyList();
	}
}
