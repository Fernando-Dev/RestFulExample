/**
 * Classe responsável por ser o controlador entre o resource e a camada DAO
 *  
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 29 de fev de 2020
 * @version 1.0
 */
package br.fernando.restfulexample.controller;

import java.util.ArrayList;

import br.fernando.restfulexample.dao.ClienteDAO;
import br.fernando.restfulexample.model.Cliente;

public class ClienteController {

	/**
	 * Método reponsável por retornar todos os clientes do banco
	 * 
	 * @return ArrayList<Cliente> clientes
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 */

	public ArrayList<Cliente> listarTodos() {
		return ClienteDAO.getInstance().listarTodos();
	}

}
