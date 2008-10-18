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

import modelo.entidades._Pessoa;
import negocio._NegocioPessoa;

/**
 * Servlet implementation class ServletListarPessoas
 */
public class _ServletListarPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/listarPessoas.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _ServletListarPessoas() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		_Pessoa pessoaParam = criarPessoa(request);
		ArrayList<_Pessoa> encontradas =  null;
		if (!erros.isEmpty()){
			request.setAttribute("erros", erros);
		} else {
			
			encontradas = _NegocioPessoa.listar(pessoaParam);
			mensagens.add("Foram encontradas " + encontradas.size() + " pessoas");
		}
		
		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
		
		request.setAttribute("pessoasEncontradas", encontradas);
		
		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}
	
	private _Pessoa criarPessoa(HttpServletRequest request)  {
		
		_Pessoa pessoaNova = new _Pessoa();
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("nome")))
			pessoaNova.setNome(request.getParameter("nome"));
		
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter(
				"dataNascimento"))){
			try {
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				pessoaNova.setDataNascimento(formato.parse(request.getParameter(
						"dataNascimento")));
			} catch (ParseException e) {
				e.printStackTrace();
				erros.add("Formato da data de nascimento inválido. Use DD/MM/AAAA.");
			}
		}
		
		if (AuxilioServlets.naoEhNuloOuVazio(request.getParameter("sexo")))
			pessoaNova.setSexo(Integer.parseInt(request.getParameter("sexo")));
		
		return pessoaNova;
	}

}
