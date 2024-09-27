package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.OrderDao;
import spring.OrderItemRequest;
import spring.OrderItemResult;

@Service
public class OrderItemService {

	@Autowired
	OrderDao orderDao;
	
	public void processOrderCommand(String[] arg) {
		int price = orderDao.selectItem(Long.valueOf(arg[2]));
		int orderPrice = Integer.parseInt(arg[3])*price;
		System.out.println(orderPrice);
		OrderItemRequest orderItemRequest = new OrderItemRequest(Long.valueOf(arg[2]),Long.valueOf(arg[1]),orderPrice,Integer.parseInt(arg[3]));
		orderDao.insertOrderItemRequest(orderItemRequest);
	}
	
	public void processOrderItemList(String[] arg) {
		List<OrderItemResult> results = orderDao.showOrderItem(Long.valueOf(arg[1]));
		for(OrderItemResult oir : results) {
			System.out.println(oir);
		}
	}
	
	public void processCancelOrderItemCommand(String[] id) {
		orderDao.cancelOrderItem(Long.valueOf(id[1]));
		System.out.println(id[1] + "상품이 취소 되었습니다.");
	}
	
	public int processCancelOrderItemCheck(String[] id) {
		return orderDao.countOrderItemByOrderId(Long.valueOf(id[1]));
	}
}
