package excecoes;

public class ExistePessoaException extends PadraoException {
	
	public ExistePessoaException(){
		super("J� existe uma pessoa na base de dados com as caracter�sticas " +
				"informadas");
	}

}
