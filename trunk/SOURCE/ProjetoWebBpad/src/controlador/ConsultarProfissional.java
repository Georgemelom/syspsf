package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Profissional;
import negocio.NegocioProfissional;

/**
 * Servlet implementation class ServletConsultarProfissional
 * 
 * @param <Uscnpj>
 */
public class ConsultarProfissional<psCns> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/consultarPS.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultarProfissional() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Profissional profissionalParam = criarProfissional(request);
		
		ArrayList<Profissional> encontrados = null;
		
		if (!erros.isEmpty()) {
			request.setAttribute("erros", erros);
		} else {

			encontrados = NegocioProfissional.listar(profissionalParam);
			mensagens.add("Foram encontrados " + encontrados.size()
					+ " Profissional");
		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);

		request.setAttribute("psEncontrado", encontrados);

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	private Profissional criarProfissional(HttpServletRequest request) {

		Profissional profissionalNovo = new Profissional();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("psCns")))
			
		profissionalNovo.setPsCns(Integer.valueOf(request.getParameter("psCns")));
		
		
		return profissionalNovo;
	}

}
