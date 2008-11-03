package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.UnidadeSaude;
import negocio.NegocioUnidadeSaude;

/**
 * Servlet implementation class ConsultarUnidadeSaude
 * 
 * @param <Uscnpj>
 */
public class ConsultarUnidadeSaude<usCnes> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/consultarUS.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultarUnidadeSaude() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UnidadeSaude unidadeSaudeParam = criarUnidadeSaude(request);
		
		ArrayList<UnidadeSaude> encontradas = null;
		
		if (!erros.isEmpty()) {
			request.setAttribute("erros", erros);
		} else {

			encontradas = NegocioUnidadeSaude.listar(unidadeSaudeParam);
			mensagens.add("Foram encontradas " + encontradas.size()
					+ " Unidade de Saude");
		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);

		request.setAttribute("usEncontrada", encontradas);

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	private UnidadeSaude criarUnidadeSaude(HttpServletRequest request) {

		UnidadeSaude unidadeSaudeNova = new UnidadeSaude();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("usCnes")))
			
		unidadeSaudeNova.setUsCnes(Integer.valueOf(request.getParameter("usCnes")));
		
		
		return unidadeSaudeNova;
	}

}
