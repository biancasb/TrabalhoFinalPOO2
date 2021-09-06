package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {

	public static boolean checkLogin(String username, String password) {
		PreparedStatement prepS = null;
		ResultSet rs;
		String query;

		Connection con =  ConexaoMySQL.abrirConexaoMySQL();

		query = "select * from Usuario";

		try {
			prepS = con.prepareStatement(query);
			rs = prepS.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getString("nomeUsuario")+"-"+rs.getString("senha"));
				if(rs.getString("nomeUsuario").equals(username) && rs.getString("senha").equals(password) ) {
					ConexaoMySQL.fecharConexao();
					return true;
				}
			}
			ConexaoMySQL.fecharConexao();
			return false;

		} catch (SQLException e1) {
			e1.printStackTrace();
			ConexaoMySQL.fecharConexao();
			return false;
		}

		

	}
/*
	public boolean consultaCPF(String c) {
		PreparedStatement prepS = null;
		String cpf = null;
		ResultSet res;
		String sql;

		ConexaoMySQL.abrirConexaoMySQL();
		con = ConexaoMySQL.getConnection();

		sql = "Select * from Empregado where cpf like ?";

		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, c);
			res = prepS.executeQuery();

			if (res.next())
			{
				ConexaoMySQL.fecharConexao();
				return true;
			}
				
			else
			{
				ConexaoMySQL.fecharConexao();
				return false;
			}
				

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	

	}

	public boolean atualizaEmpregado(Empregado e)
	{
		PreparedStatement prepS = null;
		String sql;
		
		ConexaoMySQL.abrirConexaoMySQL();
		con = ConexaoMySQL.getConnection();

		sql = "Update Empregado set nome=?, endereco=?, salario=? where cpf like ?";
		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, e.getNome());
			prepS.setString(2, e.getEndereco());
			prepS.setDouble(3, e.getSalario());
			prepS.setString(4, e.getCpf());
			
			prepS.executeUpdate();
			
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ConexaoMySQL.fecharConexao();
			return false;
		}
		
		
		ConexaoMySQL.fecharConexao();
		return true;
		
	}
	
	public boolean cadastraEmpregado(Empregado e)
	{
		PreparedStatement prepS = null;
		String sql;
		
		ConexaoMySQL.abrirConexaoMySQL();
		con = ConexaoMySQL.getConnection();
		
		sql = "Insert into Empregado values(?,?,?,?)";
		
		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, e.getCpf());
			prepS.setString(2, e.getNome());
			prepS.setString(3, e.getEndereco());
			prepS.setDouble(4, e.getSalario());
			
			prepS.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ConexaoMySQL.fecharConexao();
			return false;
		}
		ConexaoMySQL.fecharConexao();
		return true;
	}
	
	public boolean removeEmpregado(String c)
	{
		PreparedStatement prepS = null;
		String sql;
		int res;
		
		ConexaoMySQL.abrirConexaoMySQL();
		con = ConexaoMySQL.getConnection();
		
		sql = "Delete from Empregado where cpf like ?";
		
		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, c);
			res=prepS.executeUpdate();
			
			if(res==1)
			{
				ConexaoMySQL.fecharConexao();
				return true;
			}
				
			else
				return false;
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			ConexaoMySQL.fecharConexao();
			return false;
		}
		
	}
	*/

}
