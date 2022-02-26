package co.henry.web;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class PasswordTest {
	
	@Test
	public void encodingTest() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4); //시간지연장치
		String result = encoder.encode("1234");
		String result2 = encoder.encode("1234");
		log.info(result);
		log.info(result2);
		assertTrue(encoder.matches("1234", result));
	}
}
