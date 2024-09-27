package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.ItemResult;
import spring.OrderDao;

@Service
public class ItemService {
	
	@Autowired
	OrderDao orderDao;
	
	public void processShowItems() {
		List<ItemResult> results = orderDao.showItems();
		for(ItemResult ir : results) {
			System.out.println(ir);
		}
	}
}
