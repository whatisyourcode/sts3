package test;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		 String nStr = null;
		 //						nstr이 null 이면.not null!로 변환하여 처리.
		 String oStr = Optional.ofNullable(nStr).orElse("not null!");
		 System.out.println(oStr);
		 
		 // -------------------------- 
		 String value = null;
		 Optional<String> optionalValue = Optional.ofNullable(value); 
		 
		 
		 if(optionalValue.isPresent()) {
			 System.out.println("Value is present: " + optionalValue.get());
		 }else {
			 System.out.println("Value is not present.");
		 }
	}
}
