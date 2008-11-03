package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excecoes.PadraoException;

import modelo.entidades.UnidadeSaude;
import negocio.NegocioUnidadeSaude;

/**
 * Servlet implementation class ServletListarUnidadeSaude
 * 
 * @param <usCnes>
 */
public class AtualizarUnidadeSaude<Uscnpj> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/atualizarUS.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarUnidadeSaude() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		tratarAcao(request, response);

		if (!erros.isEmpty()) {
			request.setAttribute("msgErros", erros);
		}

		if (!mensagens.isEmpty()) {
			request.setAttribute("msgInfo", erros);
		}

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		tratarAcao(request, response);

		if (!erros.isEmpty()) {
			request.setAttribute("msgErros", erros);
		}

		if (!mensagens.isEmpty()) {
			request.setAttribute("msgInfo", erros);
		}

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	private void tratarAcao(HttpServletRequest request,
			HttpServletResponse response) {

		String acao = request.getParameter("hidAcao");
		UnidadeSaude unidadeSaudeParam = criarUnidadeSaude(request);

		if (acao.equals("atualizarUnidade")) {

			try {
				request.setAttribute("unidadesaude", NegocioUnidadeSaude
						.atualizar(unidadeSaudeParam));


				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else if (acao.equals("detalharUnidade")) {

			try {
				request.setAttribute("unidadesaude", NegocioUnidadeSaude
						.detalhar(unidadeSaudeParam));

				// request.getSession().setAttribute("unidadesaude",
				// NegocioUnidadeSaude.detalhar(
				// unidadeSaudeParam));

				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else {

		}

	}

	private UnidadeSaude criarUnidadeSaude(HttpServletRequest request) {

		UnidadeSaude unidadeSaudeNova = new UnidadeSaude();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("usCnes")))

			unidadeSaudeNova.setUsCnes(Integer.valueOf(request
					.getParameter("usCnes")));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("usCnes")))

			unidadeSaudeNova.setCidade_ciSigla(request
					.getParameter("cidade_ciSigla"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("usCnes")))

			unidadeSaudeNova.setUsCnpj(request.getParameter("usCnpj"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("usCnpj")))

			unidadeSaudeNova.setUsCnpj(request.getParameter("usCnpj"));

		if (AuxilioServlets
				.naoEhNuloOuVazio(request.getParameter("usEndereco")))

			unidadeSaudeNova.setUsEndereco(request.getParameter("usEndereco"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("usNome")))

			unidadeSaudeNova.setUsNome(request.getParameter("usNome"));

		if (AuxilioServlets.naoEhNuloOuVazio(request
				.getParameter("usRazaoSocial")))

			unidadeSaudeNova.setUsRazaoSocial(request
					.getParameter("usRazaoSocial"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("usSigla")))

			unidadeSaudeNova.setUsSigla(request.getParameter("usSigla"));

		return unidadeSaudeNova;
	}

}
