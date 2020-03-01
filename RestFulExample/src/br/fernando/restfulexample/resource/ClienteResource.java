/**
 * Classe responsável por conter os métodos REST de acesso ao webservice
 * 
 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
 * @since 29 de fev de 2020
 * @version 1.0
 */
package br.fernando.restfulexample.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.fernando.restfulexample.controller.ClienteController;
import br.fernando.restfulexample.model.Cliente;

@Path("/cliente")
public class ClienteResource {

	/**
	 * Método responsável por fazer a chamada ao controller
	 * 
	 * @return ArrayList<Cliente>
	 * @author Fernando Nascimento <fernando_dev@outlook.com.br>
	 */

	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Cliente> listarTodos() {
		return new ClienteController().listarTodos();
	}

}
