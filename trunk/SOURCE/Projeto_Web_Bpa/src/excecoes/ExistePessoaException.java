package excecoes;

public class ExistePessoaException extends PadraoException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExistePessoaException(){
		super("J� existe uma pessoa na base de dados com as caracter�sticas " +
				"informadas");
	}

}
