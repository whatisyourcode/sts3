package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import config.AppCtx;
import spring.MemberResult;
import spring.OrderDao;

@Service
public class MemberService {
	
		@Autowired
		OrderDao orderDao;
		
		public void processShowMember() {
			List<MemberResult> results = orderDao.showMember();
			for(MemberResult mr : results) {
				System.out.println(mr);
			}
		}
		
}
