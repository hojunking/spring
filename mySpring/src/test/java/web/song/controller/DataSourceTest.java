package web.song.controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/*-context.xml",
	"file:src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml"})
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	@Test
	public void test() {
		try {
			Connection conn = dataSource.getConnection();
			log.info(conn.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

}
