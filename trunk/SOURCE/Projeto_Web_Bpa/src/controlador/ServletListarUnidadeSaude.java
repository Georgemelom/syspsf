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
 * Servlet implementation class ServletListarUnidadeSaude
 * @param <Uscnpj>
 */
public class ServletListarUnidadeSaude<Uscnpj> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/listarUnidadeSaude.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListarUnidadeSaude() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		UnidadeSaude unidadeSaudeParam = criarUnidadeSaude(request);
		ArrayList<UnidadeSaude> encontradas = null;
		if (!erros.isEmpty()) {
			request.setAttribute("erros", erros);
		} else {

			encontradas = NegocioUnidadeSaude.listar(unidadeSaudeParam);
			mensagens.add("Foram encontradas " + encontradas.size()+ " Unidade de Saude");
		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);

		request.setAttribute("Unidade de Saude Encontradas", encontradas);

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	private UnidadeSaude criarUnidadeSaude(HttpServletRequest request) {

		UnidadeSaude unidadeSaudeNova = new UnidadeSaude();
		
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("nome")))
			unidadeSaudeNova.setUsNome(request.getParameter("nome"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("sigla")))
			unidadeSaudeNova.setUsSigla(request.getParameter("sigla"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("razaosocial")))
			unidadeSaudeNova.setUsRazaoSocial(request.getParameter("razaosocial"));

	//	if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("cnpj")))
			//unidadeSaudeNova.setUsCnpj(request.getParameter("usCnpj"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("nomesecretaria")))
			unidadeSaudeNova.setUsNomeSecretaria(request.getParameter("nomesecretaria"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("tipoorgao")))
			unidadeSaudeNova.setUsTipoOrgao(request.getParameter("tipoorgao"));

//		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("estado")))
//			unidadeSaudeNova.setUsEstado(request.getParameter("estado"));
//
//		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("cidade")))
//			unidadeSaudeNova.setUsCidade(request.getParameter("cidade"));
//
//		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("bairro")))
//			unidadeSaudeNova.setUsBairro(request.getParameter("bairro"));
//
//		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("logradouro")))
//			unidadeSaudeNova.setUsLogradouro(request.getParameter("logradouro"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("cnes")))
			unidadeSaudeNova.setUsCnes(request.getParameter("cnes"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("cep")))
			unidadeSaudeNova.setUsCep(request.getParameter("cep"));

		
		return unidadeSaudeNova;
	}

}
