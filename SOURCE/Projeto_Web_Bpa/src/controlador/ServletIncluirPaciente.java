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

import modelo.entidades.Paciente;
import negocio.NegocioPaciente;
import excecoes.ExistePessoaException;

/**
 * Servlet implementation class ServletIncluirPaciente
 */
public class ServletIncluirPaciente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/incluirPaciente.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIncluirPaciente() {
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
		if (acao.equals("adicionarDocumento")) {

		} else if (acao.equals("excluirDocumento")) {

		} else if (acao.equals("alterarDocumento")) {

		} else if (acao.equals("adicionarTelefone")) {

		} else if (acao.equals("excluirTelefone")) {

		} else if (acao.equals("alterarTelefone")) {

		} else if (acao.equals("adicionarPaciente")) {

			Paciente pacienteNovo = criarPaciente(request);

			if (!erros.isEmpty()) {
				request.setAttribute("erros", erros);
			} else {

				try {
					request.setAttribute("paciente", NegocioPaciente.incluir(pacienteNovo));

				} catch (ExistePessoaException e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Paciente incluído com sucesso!");
			}
		} else if (acao.equals("detalharPaciente")) {

			Integer idPaciente = null;

			try {
				idPaciente = new Integer(request.getParameter("idPaciente"));

			} catch (Exception ex) {
				erros
						.add("O código identificador da pessoa deve ser numérico!");
			}

			if (!erros.isEmpty()) {
				request.setAttribute("erros", erros);
			} else {

				try {
					request.setAttribute("paciente", NegocioPaciente
							.detalhar(idPaciente));

				} catch (Exception e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Paciente detalhada com sucesso!");
			}

		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}

	private Paciente criarPaciente(HttpServletRequest request) {

		Paciente pacienteNovo = new Paciente();
		pacienteNovo.setPcNome(request.getParameter("nome"));

		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			pacienteNovo.setPcDataNasc(formato.parse(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
			erros.add("Formato da data de nascimento inválido. Use DD/MM/AAAA.");
		}

		pacienteNovo.setPcSexo(Integer.parseInt(request.getParameter("sexo")));


		return pacienteNovo;
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
