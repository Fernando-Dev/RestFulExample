/**
 * Classe responsável por conter os métodos do CRUD
 * 
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 29 de fev de 2020
 * @version 1.0
 */
package br.fernando.restfulexample.dao;

import br.fernando.restfulexample.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.fernando.restfulexample.factory.ConnectionFactory;

public class ClienteDAO extends ConnectionFactory {

	private static ClienteDAO instance;
	
	/**
	 * Método responsável por criar uma instancia da classe ClienteDAO (Singleton)
	 * 
	 * @return instance
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 */

	public static ClienteDAO getInstance() {
		if (instance == null)
			instance = new ClienteDAO();
		return instance;
	}

	/**
	 * Método responsável por listar todos os clientes do banco
	 * 
	 * @return ArrayList<Cliente> clientes
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 */

	public ArrayList<Cliente> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = null;
		clientes = new ArrayList<Cliente>();
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement("select * from cliente order by nome");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));

				clientes.add(cliente);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}

		return clientes;
	}

}
