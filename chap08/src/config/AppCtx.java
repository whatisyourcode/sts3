package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dbquery.DbQuery;
import spring.MemberDao;

@Configuration
public class AppCtx {
		// 접속 해제시 커넥션 풀 close
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource(); // 커넥션 풀
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/spring5db?characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
}
