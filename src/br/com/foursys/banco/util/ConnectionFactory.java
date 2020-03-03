package br.com.foursys.banco.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * Classe responsável por efetuar conexão com o banco de dados
 * 
 * @author jgil
 * @since 27/02/2020 
 * @version 0.1
 *
 */
public class ConnectionFactory {
	
	public static Connection getConnection() {
		
		String local = "jdbc:mysql://localhost/turmas";
		String login = "root";
		String senha = "root";
		
		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = (Connection) DriverManager.getConnection(local, login, senha);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Falha ao carregar o driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao conectar");
		}
		
		return conexao;
	}

}
