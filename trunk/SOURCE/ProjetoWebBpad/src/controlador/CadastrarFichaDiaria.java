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

import modelo.entidades.FichaDiaria;
import modelo.entidades.Paciente;
import modelo.entidades.Procedimento;
import modelo.entidades.Profissional;
import negocio.NegocioFichaDiaria;
import persistencia.PersistenciaFichaDiaria;
import persistencia.PersistenciaPaciente;
import persistencia.PersistenciaProcedimento;
import persistencia.PersistenciaProfissional;
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
		if (acao.equals("adicionarFichaDiaria")) {

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
				mensagens.add("Ficha inclu�da com sucesso!");
			}
		} else if (acao.equals("montar")) {
			request.setAttribute("listaFicha", PersistenciaFichaDiaria
					.listar(new FichaDiaria()));
			request.setAttribute("listaPaciente", PersistenciaPaciente
					.listar(new Paciente()));
			request.setAttribute("listaProcediemnto", PersistenciaProcedimento
					.listar(new Procedimento()));
			request.setAttribute("listaProcediemnto", PersistenciaProfissional.
					listar(new Profissional()));
		} 

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}


	private FichaDiaria criarFichaDiaria(HttpServletRequest request) {

		FichaDiaria fichaDiariaNova = new FichaDiaria();

		fichaDiariaNova.setFdID(Integer.valueOf(request.getParameter("fdID")));
		fichaDiariaNova.setProcedimentos_proCodigo(request
				.getParameter("procedimentos_proCodigo"));
		fichaDiariaNova.setPacientes_pcCns(request
				.getParameter("pacientes_pcCns"));
		fichaDiariaNova.setProfissionalSaude_psCns(request
				.getParameter("profissionalSaude_psCns"));

		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			fichaDiariaNova.setFdDtProducao(formato.parse(request
					.getParameter("fdDtProducao")));
		} catch (ParseException e) {
			e.printStackTrace();
			erros.add("Formato da data de producao inv�lido. Use DD/MM/AAAA.");
		}
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
