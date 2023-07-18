package woo.siksin.mybatis.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 메타어노테이션을 선언해준거임
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ConnectionDAOTest {
	@Autowired
	DataSource dataSource;

	@Test
	public void test() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
