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
import excecoes.ExistePessoaException;

/**
 * Servlet implementation class ServletIncluirUnidadeSaude
 */
public class ServletIncluirUnidadeSaude extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/incluirUnidadeSaude.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIncluirUnidadeSaude() {
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
					request.setAttribute("unidadeSaude", NegocioUnidadeSaude.incluir(unidadeSaudeNova));

				} catch (ExistePessoaException e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Unidade de Saude incluída com sucesso!");
			}
		} else if (acao.equals("detalharUnidadeSaude")) {

			Integer idUnidadeSaude = null;

			try {
				idUnidadeSaude = new Integer(request.getParameter("idUnidadeSaude"));

			} catch (Exception ex) {
				erros.add("O código identificador da unidade de saude deve ser numérico!");
			}

			if (!erros.isEmpty()) {
				request.setAttribute("erros", erros);
			} else {

				try {
					request.setAttribute("unidadeSaude", NegocioUnidadeSaude.detalhar(idUnidadeSaude));

				} catch (Exception e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Unidade de Saude detalhada com sucesso!");
			}

		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}

	private UnidadeSaude criarUnidadeSaude(HttpServletRequest request) {

		UnidadeSaude unidadeSaudeNova = new UnidadeSaude();
		
		unidadeSaudeNova.setUsNome(request.getParameter("nome"));
		unidadeSaudeNova.setUsSigla(request.getParameter("sigla"));
		unidadeSaudeNova.setUsCnpj(converterDocumento(request));
		unidadeSaudeNova.setUsNomeSecretaria(request.getParameter("secretaria"));
		unidadeSaudeNova.setUsTipoOrgao(request.getParameter("tipoOrgao"));

		
		
		return unidadeSaudeNova;
	}

	private Documento[] converterDocumento(HttpServletRequest request) {
		Documento[] converteDoc;
		String[] cnpjs = request.getParameterValues("usCnpj");
		for (int i = 0; i < cnpjs.length; i++) {
			Documento dc = new Documento();
			dc.setNumero(cnpjs[i]);
			dc.setTipo()
			
			converteDoc[i] = cnpjs[i];
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doAcao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAcao(request, response);
	}

}
