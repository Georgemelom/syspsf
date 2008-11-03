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
 * 
 * */
public class CadastrarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/cadastrarPC.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarPaciente() {
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
		if (acao.equals("adicionarPaciente")) {

			Paciente pacienteNovo = criarPaciente(request);

			if (!erros.isEmpty()) {
				request.setAttribute("erros", erros);
			} else {

				try {
					request.setAttribute("paciente", NegocioPaciente
							.cadastrar(pacienteNovo));

				} catch (ExistePessoaException e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Paciente incluído com sucesso!");
			}
		} 

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}



	private Paciente criarPaciente(HttpServletRequest request) {

		
		Paciente pacienteNovo = new Paciente();
		
		pacienteNovo.setPcCns(Integer.valueOf(request.getParameter("pcCns")));
		pacienteNovo.setPcNome(request.getParameter("pcNome"));
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			pacienteNovo.setPcDataNascimento(formato.parse(request.getParameter(
					"pcDataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
			erros.add("Formato da data de nascimento inválido. Use DD/MM/AAAA.");
		}
		pacienteNovo.setPcSexo(request.getParameter("pcSexo"));
		pacienteNovo.setPcEndereco(request.getParameter("pcEndereco"));
		
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
		doAcao(request, response);
	}

}
