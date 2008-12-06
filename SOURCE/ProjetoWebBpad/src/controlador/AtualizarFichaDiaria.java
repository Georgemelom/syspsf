package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.AuxilioServlets;

import excecoes.PadraoException;

import modelo.entidades.FichaDiaria;
import negocio.NegocioFichaDiaria;

/**
 * Servlet implementation class ServletListarFichaDiaria
 * 
 * @param <fdID>
 */
public class AtualizarFichaDiaria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/atualizarFD.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarFichaDiaria() {
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
		FichaDiaria fichaDiariaParam = criarFichaDiaria(request);

		if (acao.equals("atualizarFichaDiaria")) {

			try {
				request.setAttribute("fichaDiaria", NegocioFichaDiaria
						.atualizar(fichaDiariaParam));

				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else if (acao.equals("detalharFichaDiaria")) {

			try {
				request.setAttribute("fichaDiaria", NegocioFichaDiaria
						.detalhar(fichaDiariaParam));

				// request.getSession().setAttribute("fichadiaria",
				// NegocioFichaDiaria.detalhar(
				// fichaDiariaParam));

				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else {

		}

	}

	private FichaDiaria criarFichaDiaria(HttpServletRequest request) {

		FichaDiaria fichaDiariaNova = new FichaDiaria();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("fdID")))

			fichaDiariaNova.setFdID(Integer.valueOf(request.getParameter("fdID")));

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("fdDtProducao")))
			try {
				fichaDiariaNova.setFdDtProducao(formato.parse(request.getParameter(
				"fdDtProducao")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("procedimentos_proCodigo")))

			fichaDiariaNova.setProcedimentos_proCodigo(request.getParameter("procedimentos_proCodigo"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("pacientes_pcCns")))

			fichaDiariaNova.setPacientes_pcCns(request.getParameter("pacientes_pcCns"));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("profissionalSaude_psCns")))

			fichaDiariaNova.setProfissionalSaude_psCns(request.getParameter("profissionalSaude_psCns"));

		
		return fichaDiariaNova;
	}

}
