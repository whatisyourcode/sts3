package chap02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeter greeter = new Greeter();
		greeter.setFormat("%s,안녕하세요!");
		String spring = greeter.greet("스프링");
		System.out.println(spring);
	}

}
