package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		// AppContext 컨테이너를 생성하여 AppContxt 컨테이너 내부의 빈 객체들을 생성 및 관리 
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class); 
							//	 빈 이름 ,  반환타입 클래스
		Greeter g1 = ctx.getBean("greeter1",Greeter.class);
		Greeter g2 = ctx.getBean("greeter2",Greeter.class);
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
	}
}
