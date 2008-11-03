package controlador;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.FichaDiaria;
import negocio.NegocioFichaDiaria;
import excecoes.ExistePessoaException;

/**
 * Servlet implementation class ServletIncluirFichaDiaria
 */
public class CadastrarFichaDiaria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/cadastrarFD.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarFichaDiaria() {
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
		if (acao.equals("adicionarFicha")) {

			FichaDiaria fichaDiariaNova = criarFichaDiaria(request);

			if (!erros.isEmpty()) {
				request.setAttribute("erros", erros);
			} else {

				try {
					request.setAttribute("fichaDiaria", NegocioFichaDiaria
							.cadastrar(fichaDiariaNova));

				} catch (ExistePessoaException e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Ficha incluída com sucesso!");
			}
		} 

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}


	private FichaDiaria criarFichaDiaria(HttpServletRequest request) {

		FichaDiaria fichaDiariaNova = new FichaDiaria();

		fichaDiariaNova.setFdID(Integer.valueOf(request.getParameter("fdID")));
		fichaDiariaNova.setFolha_FoID(request.getParameter("folha_FoID"));
		fichaDiariaNova.setProcedimentos_proCodigo(request.getParameter("procedimentos_proCodigo"));
		fichaDiariaNova.setPacientes_pcCns(request.getParameter("pacientes_pcCns"));
		fichaDiariaNova.setProfissionalSaude_psCns(request.getParameter("profissionalSaude_psCns"));
		
		return fichaDiariaNova;
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
		doAcao(request, response);
	}

}
