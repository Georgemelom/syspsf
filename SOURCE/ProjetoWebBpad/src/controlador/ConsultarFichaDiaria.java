package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.AuxilioServlets;

import modelo.entidades.FichaDiaria;
import negocio.NegocioFichaDiaria;

/**
 * Servlet implementation class ConsultarFichaDiaria
 * 
 * @param <Uscnpj>
 */
public class ConsultarFichaDiaria<fdID> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/consultarFD.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultarFichaDiaria() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FichaDiaria fichaDiariaParam = criarFichaDiaria(request);
		
		ArrayList<FichaDiaria> encontradas = null;
		
		if (!erros.isEmpty()) {
			request.setAttribute("erros", erros);
		} else {

			encontradas = NegocioFichaDiaria.listar(fichaDiariaParam);
			mensagens.add("Foram encontradas " + encontradas.size()
					+ " Ficha Diaria");
		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);

		request.setAttribute("fdEncontrada", encontradas);

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	private FichaDiaria criarFichaDiaria(HttpServletRequest request) {

		FichaDiaria fichaDiariaNova = new FichaDiaria();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("fdID")))
			
			fichaDiariaNova.setFdID(Integer.valueOf(request.getParameter("fdID")));
		
		
		return fichaDiariaNova;
	}

}
