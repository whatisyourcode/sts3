package domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	public Order(Long id) {
		this.id = id;
	}
	
	private Long id;
	private Member member;
	private Delivery delivery;
	private Date orderDate;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
}
