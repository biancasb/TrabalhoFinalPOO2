package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	private static Status status;
	private static Connection connection;
	private static String serverAddress;
	private static String database;
	private static int port;
	private static String url;
	private static String username;
	private static String password;

	public static Connection getConnection() {
		return connection;
	}

	public static void configConnection(String serverAddress, String database, String username, String password,
			int port) {
		ConexaoMySQL.serverAddress = serverAddress;
		ConexaoMySQL.database = database;
		ConexaoMySQL.username = username;
		ConexaoMySQL.password = password;
		ConexaoMySQL.port = port;
		ConexaoMySQL.url = "jdbc:mysql://" + serverAddress + ":" + port + "/" + database;
		ConexaoMySQL.status = Status.NOT_INITIALIZED;
	}

	public static Connection abrirConexaoMySQL() {
		try {
			connection = DriverManager.getConnection(url, username, password);
			status = Status.SUCCESS;

			return connection;

		} catch (SQLException e) {
			status = Status.FAIL;
			return null;
		}

	}

	public static Status getStatus() {
		System.out.println("Status: "+status);
		return status;
	}

	public static boolean fecharConexao() {
		status = Status.CLOSED;
		try {

			connection.close();

			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public static Connection ReiniciarConexao() {
		fecharConexao();
		return ConexaoMySQL.abrirConexaoMySQL();
	}

}