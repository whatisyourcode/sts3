package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import service.ItemService;
import service.MemberService;
import service.OrderItemService;
import service.OrderService;
import spring.Order;
import spring.OrderDao;
import spring.OrderItemRequest;
import spring.OrderResult;

public class Main4 {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext ctx 
		     = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		
		// 서비스
		MemberService memberService = ctx.getBean(MemberService.class);
		ItemService itemService = ctx.getBean(ItemService.class);
		OrderService orderService = ctx.getBean(OrderService.class);
		OrderItemService orderItemService = ctx.getBean(OrderItemService.class);
		
		
		while (true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			if(command.equals("showMember")) {
				memberService.processShowMember();
				continue;
			} else if(command.equals("showItems")){
				itemService.processShowItems();
				continue;
			} else if(command.startsWith("showOrders ")){
				orderService.processOrderList(command.split(" "));
				continue;
			} else if(command.startsWith("showOrderItems ")){
				orderItemService.processOrderItemList(command.split(" "));
				continue;
			} else if (command.startsWith("newOrder ")) {
				orderService.processNewOrder(command.split(" "));
				continue;
			} else if (command.startsWith("newOrderItem ")) {
				orderItemService.processOrderCommand(command.split(" "));
				continue;
			} else if (command.startsWith("cancelOrder ")) {
				if(orderItemService.processCancelOrderItemCheck(command.split(" ")) > 0) {
					System.out.println("order_item 항목에 order가 존재합니다.");
					continue;
				}
				orderService.processCancelOrder(command.split(" "));
				continue;
			} else if(command.startsWith("cancelOrderItem ")) {
				orderItemService.processCancelOrderItemCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	
		ctx.close();
	}
	
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("showMember");
		System.out.println("showItems");
		System.out.println("showOrders 이름");
		System.out.println("showOrderItems order_id");
		System.out.println("newOrder member_id street street zip");
		System.out.println("newOrderItem order_id item_id 개수");
		System.out.println("cancelOrder id");
		System.out.println("cancelOrderItem id");
		System.out.println();
	}
}
