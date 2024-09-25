package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
					// 적용 대상
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Myanno {
	String value() default "나의 어노테이션";
	int number() default 15;
}
