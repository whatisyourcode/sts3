package domain.entity;

import domain.value.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Setter
@NoArgsConstructor
public class Delivery {
	public Delivery(Long deliveryId) {
		this.id = deliveryId;
	}
	private Long id;
	private Order order;
	private Address address;
	

}
