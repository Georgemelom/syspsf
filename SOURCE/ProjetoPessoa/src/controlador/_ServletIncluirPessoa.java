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
import negocio.NegocioPessoa;
import excecoes.ExistePessoaException;

/**
 * Servlet implementation class ServletIncluirPessoa
 */
public class _ServletIncluirPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/incluirPessoa.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _ServletIncluirPessoa() {
        super();
    }
   
	
	void doAcao(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		tratarAcao(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher(urlDestino);
		rd.forward(request, response);
	}   
	
	protected void tratarAcao(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		String acao = request.getParameter("hidAcao");
		if(acao.equals("adicionarDocumento")){
			
		} else if(acao.equals("excluirDocumento")){
			
		} else if(acao.equals("alterarDocumento")){
			
		}else if(acao.equals("adicionarTelefone")){
			
		}else if(acao.equals("excluirTelefone")){
			
		}else if(acao.equals("alterarTelefone")){
			
		}else if(acao.equals("adicionarPessoa")){
			
			_Pessoa pessoaNova = criarPessoa(request);
			
			if (!erros.isEmpty()){
				request.setAttribute("erros", erros);
			} else {
				
				try {
					request.setAttribute("pessoa", NegocioPessoa.incluir(
							pessoaNova));
					
				} catch (ExistePessoaException e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Pessoa incluída com sucesso!");
			}
		} else if (acao.equals("detalharPessoa")){
			
			Integer idPessoa = null;
			
			try {
				idPessoa = new Integer(request.getParameter("idPessoa"));
				
			} catch(Exception ex){
				erros.add("O código identificador da pessoa deve ser numérico!");
			}
			
			if (!erros.isEmpty()){
				request.setAttribute("erros", erros);
			} else {
				
				try {
					request.setAttribute("pessoa", NegocioPessoa.detalhar(
							idPessoa));
					
				} catch (Exception e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Pessoa detalhada com sucesso!");
			}
			
			
		}
		
		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}

	private _Pessoa criarPessoa(HttpServletRequest request)  {
		
		_Pessoa pessoaNova = new _Pessoa();
		pessoaNova.setNome(request.getParameter("nome"));
		
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			pessoaNova.setDataNascimento(formato.parse(request.getParameter(
					"dataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
			erros.add("Formato da data de nascimento inválido. Use DD/MM/AAAA.");
		}
		
		pessoaNova.setSexo(Integer.parseInt(request.getParameter("sexo")));
		
		//TODO AINDA FALTA OS OUTROS CAMPOS. VOU FAZER A PARTE DE PERSISTÊNCIA AGORA.
		
		return pessoaNova;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAcao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAcao(request, response);
	}

}
