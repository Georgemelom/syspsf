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
import persistencia.PersistenciaFichaDiaria;
import persistencia.PersistenciaPaciente;
import persistencia.PersistenciaProcedimento;
import excecoes.ExistePessoaException;

/**
 * Servlet implementation class ServletIncluirUnidadeSaude
 */
public class CadastrarUnidadeSaude extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/cadastrarUS.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarUnidadeSaude() {
		super();
	}

	void doAcao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		tratarAcao(request, response);

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	protected void tratarAcao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("hidAcao");
		if (acao.equals("adicionarUnidadeSaude")) {

			UnidadeSaude unidadeSaudeNova = criarUnidadeSaude(request);

			if (!erros.isEmpty()) {
				request.setAttribute("erros", erros);
			} else {

				try {
					request.setAttribute("unidadeSaude", NegocioUnidadeSaude
							.cadastrar(unidadeSaudeNova));

				} catch (ExistePessoaException e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Unidade incluída com sucesso!");
			}
		} 

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}

	private UnidadeSaude criarUnidadeSaude(HttpServletRequest request) {

		UnidadeSaude unidadeSaudeNova = new UnidadeSaude();

		unidadeSaudeNova.setUsCnes(Integer.valueOf(request
				.getParameter("usCnes")));
		unidadeSaudeNova.setCidade_ciSigla(request
				.getParameter("cidade_ciSigla"));
		unidadeSaudeNova.setUsNome(request.getParameter("usNome"));
		unidadeSaudeNova.setUsSigla(request.getParameter("usSigla"));
		unidadeSaudeNova
				.setUsRazaoSocial(request.getParameter("usRazaoSocial"));
		unidadeSaudeNova.setUsCnpj(request.getParameter("usCnpj"));
		unidadeSaudeNova.setUsEndereco(request.getParameter("usEndereco"));

		return unidadeSaudeNova;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// doAcao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAcao(request, response);
	}

}
