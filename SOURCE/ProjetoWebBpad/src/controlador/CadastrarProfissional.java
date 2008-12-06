package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Profissional;
import negocio.NegocioProfissional;
import excecoes.ExistePessoaException;

/**
 * Servlet implementation class ServletIncluirProfissional
 */
public class CadastrarProfissional extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String urlDestino = "/protegida/cadastrarPS.jsp";
	private ArrayList<String> erros = new ArrayList<String>();
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarProfissional() {
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
		if (acao.equals("adicionarProfissional")) {

			Profissional profissionalNovo = criarProfissional(request);

			if (!erros.isEmpty()) {
				request.setAttribute("erros", erros);
			} else {

				try {
					request.setAttribute("profissional", NegocioProfissional
							.cadastrar(profissionalNovo));

				} catch (ExistePessoaException e) {
					e.printStackTrace();
					erros.add(e.getMessage());
				}
				mensagens.add("Profissional incluído com sucesso!");
			}
		}

		if (!mensagens.isEmpty())
			request.setAttribute("mensagens", mensagens);
	}

	private Profissional criarProfissional(HttpServletRequest request) {

		Profissional profissionalNovo = new Profissional();

		profissionalNovo.setPsCns(request.getParameter("psCns"));
		profissionalNovo.setCbo_Cbo(request.getParameter("cbo_Cbo"));
		profissionalNovo.setConselhos_conselho(request
				.getParameter("conselhos_conselho"));
		profissionalNovo.setUnidadeSaude_usCnes(request
				.getParameter("unidadeSaude_usCnes"));
		profissionalNovo.setPsNome(request.getParameter("psNome"));
		profissionalNovo.setPsCpf(request.getParameter("psCpf"));
		profissionalNovo.setPsTelefone(request.getParameter("psTelefone"));

		return profissionalNovo;

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
