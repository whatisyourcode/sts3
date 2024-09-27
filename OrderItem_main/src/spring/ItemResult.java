package spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ItemResult {
	private Long id;
	private String name; 
	private int price;
	private int stockQuantity;
}
