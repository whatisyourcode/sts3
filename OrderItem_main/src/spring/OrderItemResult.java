package spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class OrderItemResult {
	private Long id;
	private String name;
	private Long item_id;
	private Long order_id;
	private int orderPrice;
	private int count;
}	
