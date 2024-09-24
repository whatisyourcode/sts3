package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		// AppContext 컨테이너를 생성하여 AppContxt 컨테이너 내부의 빈 객체들을 생성 및 관리 
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class); 
		Greeter g = ctx.getBean("greeter",Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}

}
