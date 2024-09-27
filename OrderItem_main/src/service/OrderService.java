package service;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.Order;
import spring.OrderDao;
import spring.OrderResult;

@Service
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	public void processNewOrder(String[] arg) {
		Order order = new Order(999L, Long.valueOf(arg[1]), arg[2], arg[3], arg[4], null);
		Long num = orderDao.insertOrder(order);
		System.out.println(num + "번 주문이 생성되었습니다.");
	}
	
	public void processOrderList(String[] name) {
		List<OrderResult> results = orderDao.selectByOrder(name[1]);
		for(OrderResult or : results) {
			System.out.println(or); 
		}
	}
	
	public void processCancelOrder(String[] id) {
		orderDao.cancelOrder(Long.valueOf(id[1]));
		System.out.println(id[1]+"번 주문이 삭제되었습니다,");
	}
}
