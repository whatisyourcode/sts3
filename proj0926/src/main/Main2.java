package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Member;
import spring.Order;
import spring.OrderDao;
import spring.OrderItemRequest;
import spring.OrderResult;

public class Main2 {
	
	private static ApplicationContext ctx = null; 
	static Long num = 0L;
	
	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if (command.startsWith("newOrder ")) {
				processOrderCommand(command.split(" "));
				continue;
			} else if (command.startsWith("newMember ")) {
				processMemberCommand(command.split(" "));
				continue;
			} else if (command.startsWith("newOrderItem ")) {
				processOrderItemCommand(command.split(" "));
				continue;
			} else if (command.startsWith("newOrderTwoItem ")) {
				processOrderTwoItemCommand(command.split(" "));
				continue;
			} 
			printHelp();
		}
	}
	
	public static void processMemberCommand(String[] arg) {
		OrderDao dbQuery = ctx.getBean(OrderDao.class);
		Member member = new Member(999L,arg[1],arg[2],arg[3],arg[4]);
		Long id = dbQuery.insertMember(member);
		System.out.println("Member가 생성되었습니다.");
	}
	
	public static void processOrderCommand(String[] arg) {
		// 주문 생성
		OrderDao dbQuery = ctx.getBean(OrderDao.class);
		Order order = new Order(999L, Long.valueOf(arg[1]), arg[2], arg[3], arg[4], null);
		num = dbQuery.insertOrder(order);
		System.out.println(num + "번 주문이 생성되었습니다.");
	}
	
	public static void processOrderItemCommand(String[] arg) {
		// 상품 주문
		OrderDao dbQuery = ctx.getBean(OrderDao.class);
		OrderItemRequest orderItemRequest = new OrderItemRequest(2L, num, Integer.parseInt(arg[1]), Integer.parseInt(arg[2]));
		Long oii = dbQuery.insertOrderItemRequest(orderItemRequest);
	}
	
	public static void processOrderTwoItemCommand(String[] arg) {
		Long num2 = 2L;
		OrderDao dbQuery = ctx.getBean(OrderDao.class);
		OrderItemRequest orderItemRequest = new OrderItemRequest(2L, num2, 1400, 2);
		
		orderItemRequest = new OrderItemRequest(2L, num, 1400, 2);
		dbQuery.insertOrderItemRequest(orderItemRequest);
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("newOrder member_id street street zip");
		System.out.println("newMember 이름 도시 길 집코드");
		System.out.println("newOrderItem 가격 개수");
		System.out.println("newOrderTwoItem 이름 가격 개수"); 
		System.out.println();
	}
}
