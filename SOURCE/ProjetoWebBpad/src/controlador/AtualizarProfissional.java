package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.AuxilioServlets;

import modelo.entidades.Profissional;
import negocio.NegocioProfissional;
import excecoes.PadraoException;

/**
 * Servlet implementation class ServletListarProfissional
 * 
 * @param <psCns>
 */
public class AtualizarProfissional<Uscnpj> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/atualizarPS.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarProfissional() {
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
		Profissional profissionalParam = criarProfissional(request);

		if (acao.equals("atualizarProfissional")) {

			try {
				request.setAttribute("profissionalsaude", NegocioProfissional
						.atualizar(profissionalParam));


				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else if (acao.equals("detalharProfissional")) {

			try {
				request.setAttribute("profissionalsaude", NegocioProfissional
						.detalhar(profissionalParam));

				// request.getSession().setAttribute("profissionalsaude",
				// NegocioProfissional.detalhar(
				// profissionalParam));

				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else {

		}

	}

	private Profissional criarProfissional(HttpServletRequest request) {

		Profissional profissionalNovo = new Profissional();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("psCns")))

			profissionalNovo.setPsCns(request.getParameter("psCns"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("cbo_Cbo")))

			profissionalNovo.setCbo_Cbo(request.getParameter("cbo_Cbo"));

		if (AuxilioServlets.naoEhNuloOuVazio(request
				.getParameter("conselhos_conselho")))

			profissionalNovo.setConselhos_conselho(request
					.getParameter("conselhos_conselho"));

		if (AuxilioServlets.naoEhNuloOuVazio(request
				.getParameter("unidadeSaude_usCnes")))

			profissionalNovo.setUnidadeSaude_usCnes(request
					.getParameter("unidadeSaude_usCnes"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("psNome")))

			profissionalNovo.setPsNome(request.getParameter("psNome"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("psCpf")))

			profissionalNovo.setPsCpf(request.getParameter("psCpf"));

		if (AuxilioServlets
				.naoEhNuloOuVazio(request.getParameter("psTelefone")))

			profissionalNovo.setPsTelefone(request.getParameter("psTelefone"));

		return profissionalNovo;
	}

}
