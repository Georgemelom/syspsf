package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.AuxilioServlets;

import modelo.entidades.Paciente;
import negocio.NegocioPaciente;

/**
 * Servlet implementation class ConsultarPaciente
 * 
 * @param <Uscnpj>
 */
public class ConsultarPaciente<pcCns> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/consultarPC.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultarPaciente() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Paciente pacienteParam = criarPaciente(request);
		
		ArrayList<Paciente> encontrados = null;
		
		if (!erros.isEmpty()) {
			request.setAttribute("erros", erros);
		} else {

			encontrados = NegocioPaciente.listar(pacienteParam);
			mensagens.add("Foram encontrados " + encontrados.size()
					+ " Paciente");
		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);

		request.setAttribute("pcEncontrado", encontrados);

		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}

	private Paciente criarPaciente(HttpServletRequest request) {

		Paciente pacienteNovo = new Paciente();

		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("pcCns")))
			
		pacienteNovo.setPcCns(Integer.valueOf(request.getParameter("pcCns")));
		
		
		return pacienteNovo;
	}

}
