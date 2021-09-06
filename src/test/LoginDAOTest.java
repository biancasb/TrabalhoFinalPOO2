package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.ConexaoMySQL;
import dao.LoginDAO;

public class LoginDAOTest {
	@Test
	public void loginDeveSerTrue() {
		ConexaoMySQL.configConnection("localhost", "trabalhofinal", "java", "123", 3306);
		boolean success = LoginDAO.checkLogin("moyses","123");
		assertTrue(success);
	}
}
