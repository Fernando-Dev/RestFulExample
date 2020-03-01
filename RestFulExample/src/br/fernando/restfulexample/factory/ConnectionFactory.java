/**
 * Classe responsável por conter os métodos criar e fechar o banco de dados
 * 
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 29 de fev de 2020
 * @version 1.0
 */
package br.fernando.restfulexample.factory;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

	// private static final String DRIVE = "";
	private static final String URL = "jdbc:mysql://localhost:3306/restfulexample";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";

	/**
	 * Método responsável por criar uma conexão com o banco
	 * 
	 * @author Fernando Nascimento
	 */

	public Connection criarConexao() {

		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			throw new RuntimeException(e);
		}

	}

	/**
	 * Método responsável por fechar conexão com o banco
	 * 
	 * @author Fernando Nascimento
	 */
	public void fecharConexao(Connection conexao, PreparedStatement pstat, ResultSet rs) {
		try {
			if (conexao != null) {
				conexao.close();
			}
			if (pstat != null) {
				pstat.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao fechar conexão com o banco: " + URL);
		}

	}

}
