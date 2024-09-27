package spring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItemRequest {
	private Long itemId;
	private Long orderId;
	private int orderPrice;
	private int count;

}
