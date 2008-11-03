package excecoes;

public class ExistePessoaException extends PadraoException {
	
	public ExistePessoaException(){
		super("Já existe uma pessoa na base de dados com as características " +
				"informadas");
	}

}
