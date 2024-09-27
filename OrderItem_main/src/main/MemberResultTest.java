package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ItemResult;
import spring.MemberResult;
import spring.OrderDao;
import spring.OrderItemResult;

public class MemberResultTest {
	
	private static ApplicationContext ctx = null; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ctx 
	     = new AnnotationConfigApplicationContext(AppCtx.class);

	OrderDao dbQuery = ctx.getBean(OrderDao.class);
//	List<MemberResult> results = dbQuery.showMember();
//	
//	for(MemberResult mr : results) {
//		System.out.println(mr);
//	}
//	
//	List<ItemResult> results2 = dbQuery.showItems();
//	
//	for(ItemResult mr : results2) {
//		System.out.println(mr);
//	}
//	
//	
//	List<OrderItemResult> results3 = dbQuery.showOrderItem(Long.valueOf(2));
//	
//	for(OrderItemResult mr : results3) {
//		System.out.println(mr);
//	}
	
	int count = dbQuery.countOrderItemByOrderId(Long.valueOf(0));
	System.out.println(count);
	
	
	
	}

}
