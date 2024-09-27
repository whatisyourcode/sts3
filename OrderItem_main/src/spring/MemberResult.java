package spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class MemberResult {
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
}
