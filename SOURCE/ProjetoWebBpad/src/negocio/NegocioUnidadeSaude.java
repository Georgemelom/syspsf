package negocio;

import java.util.ArrayList;

import modelo.entidades.UnidadeSaude;
import persistencia.PersistenciaUnidadeSaude;
import excecoes.ExistePessoaException;
import excecoes.PadraoException;

public class NegocioUnidadeSaude {

	public static UnidadeSaude cadastrar(UnidadeSaude unidadeSaudeNova) throws ExistePessoaException {
		if (!existeUnidadeSaude(unidadeSaudeNova)){
			return PersistenciaUnidadeSaude.cadastrar(unidadeSaudeNova);
		} else {
			throw new ExistePessoaException();
		}
		
	}
	private static boolean existeUnidadeSaude(UnidadeSaude unidadeSaudeNova) {
		return false;
	}

	public static ArrayList<UnidadeSaude> listar(UnidadeSaude unidadeSaudeParam) {
		return PersistenciaUnidadeSaude.listar(unidadeSaudeParam);
	}

	public static UnidadeSaude detalhar(UnidadeSaude usCnes) throws PadraoException{
		return PersistenciaUnidadeSaude.detalhar(usCnes);
	}
	
	public static UnidadeSaude atualizar(UnidadeSaude unidadeSaudeNova) throws ExistePessoaException {
		if (!existeUnidadeSaude(unidadeSaudeNova)){
			return PersistenciaUnidadeSaude.atualizar(unidadeSaudeNova);
		} else {
			throw new ExistePessoaException();
		}
		
	}		
}
