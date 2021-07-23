package br.com.ModuloConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Conection {
		
		public PreparedStatement pst;
	    public Statement stm;
	    public Connection conn;
	    public ResultSet rs;

	    public static Connection conectaMysql() {
	        Connection con = null;
	        String url = "jdbc:mysql://127.0.0.1:3306/dbCadastro?useTimezone=true&serverTimezone=UTC";
	        String usuario = "root";
	        String senha = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            try {
	                con = DriverManager.getConnection(url, usuario, senha);
	            } catch (SQLException ex) {
	                System.out.println("Url, senha ou usuario incorretos");
	            }
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Drive não encontrado");
	        }
	        return con;
	    }

}

