package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import config.DbConfig;
import spring.DeptDao;
import spring.MemberDao;

public class Main3 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
			= new AnnotationConfigApplicationContext(DbConfig.class);
		
		DeptDao dbQuery = ctx.getBean(DeptDao.class);
		System.out.println(dbQuery.selectDept("영업"));
		ctx.close();
	}
}
