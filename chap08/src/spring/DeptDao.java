package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DeptDao {
private JdbcTemplate jdbcTemplate;
	
	public DeptDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Dept selectDept(String dname) {
		List<Dept> results = jdbcTemplate.query(
				"select * from DEPT where dname = ?", 
				new RowMapper<Dept>() {
					@Override
					public Dept mapRow(ResultSet rs,int rowNum) throws SQLException {
						Dept dept = new Dept(
								rs.getString("dname"),
								rs.getString("loc"));
							dept.setDeptno(rs.getLong("deptno"));
							return dept;			
					}
				},dname);
		return results.isEmpty() ? null : results.get(0);
	}
}
