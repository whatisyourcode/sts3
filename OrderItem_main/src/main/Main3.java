package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Order;
import spring.OrderDao;
import spring.OrderItemRequest;
import spring.OrderResult;

public class Main3 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
		     = new AnnotationConfigApplicationContext(AppCtx.class);

		OrderDao dbQuery = ctx.getBean(OrderDao.class);
		
		// 주문 결과
		for (OrderResult orderResult : dbQuery.selectByOrder("홍길동")) {
			System.out.println(orderResult);
		}
		ctx.close();
	}
}
