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

/**
 * Servlet implementation class ServletListarPaciente
 */
public class ServletListarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/listarPaciente.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		Paciente pacienteParam = criarPaciente(request);
		ArrayList<Paciente> encontrados =  null;
		if (!erros.isEmpty()){
			request.setAttribute("erros", erros);
		} else {
			
			encontrados = NegocioPaciente.listar(pacienteParam);
			mensagens.add("Foram encontradas " + encontrados.size() + " pacientes");
		}
		
		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
		
		request.setAttribute("pacientesEncontrados", encontrados);
		
		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}
	
	private Paciente criarPaciente(HttpServletRequest request)  {
		
		Paciente pacienteNovo = new Paciente();
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("nome")))
			pacienteNovo.setPcNome(request.getParameter("nome"));
		
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("dataNascimento"))){
			try {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				pacienteNovo.setPcDataNasc(formato.parse(request.getParameter("dataNascimento")));
			} catch (ParseException e) {
				e.printStackTrace();
				erros.add("Formato da data de nascimento inválido. Use DD/MM/AAAA.");
			}
		}
		
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("sexo")))
			pacienteNovo.setPcSexo(Integer.parseInt(request.getParameter("sexo")));
		
		return pacienteNovo;
	}

}
