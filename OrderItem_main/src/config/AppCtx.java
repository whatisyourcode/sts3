package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.ItemService;
import service.MemberService;
import service.OrderItemService;
import service.OrderService;
import spring.OrderDao;

@Configuration
public class AppCtx {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/spring5db2?characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public OrderDao orderDao() {
		return new OrderDao(dataSource());
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService();
	}
	
	@Bean 
	public OrderItemService orderItemService() {
		return new OrderItemService();
	}
	
	@Bean 
	public OrderService orderService() {
		return new OrderService();
	}
	
	@Bean
	public ItemService itemService() {
		return new ItemService();
	}
}
