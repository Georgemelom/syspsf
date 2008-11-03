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
import excecoes.PadraoException;

/**
 * Servlet implementation class ServletListarPaciente
 * 
 * @param <pcCns>
 */
public class AtualizarPaciente<pcCns> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/atualizarPC.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarPaciente() {
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
		Paciente pacienteParam = criarPaciente(request);

		if (acao.equals("atualizarPaciente")) {

			try {
				request.setAttribute("paciente", NegocioPaciente
						.atualizar(pacienteParam));


				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else if (acao.equals("detalharPaciente")) {

			try {
				request.setAttribute("paciente", NegocioPaciente
						.detalhar(pacienteParam));

				// request.getSession().setAttribute("Paciente",
				// NegocioPaciente.detalhar(
				// pacienteParam));

				mensagens.add("Operação realizada com sucesso");

			} catch (NumberFormatException nf) {
				erros.add(nf.getMessage());
			} catch (PadraoException pe) {
				erros.add(pe.getMessage());
			}

		} else {

		}

	}

	private Paciente criarPaciente(HttpServletRequest request) {

		Paciente pacienteNovo = new Paciente();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("pcCns")))

			pacienteNovo.setPcCns(Integer.valueOf(request
					.getParameter("pcCns")));

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("pcNome")))

			pacienteNovo.setPcNome(request
					.getParameter("pcNome"));

		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("pcDataNascimento")))
			try {
				pacienteNovo.setPcDataNascimento(formato.parse(request.getParameter(
				"pcDataNascimento")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("pcSexo")))

			pacienteNovo.setPcSexo(request.getParameter("pcSexo"));

		if (AuxilioServlets
				.naoEhNuloOuVazio(request.getParameter("pcEndereco")))

			pacienteNovo.setPcEndereco(request.getParameter("pcEndereco"));

		
		return pacienteNovo;
	}

}
