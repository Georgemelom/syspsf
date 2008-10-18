package negocio;

import java.util.ArrayList;

import modelo.entidades.UnidadeSaude;
import persistencia.PersistenciaUnidadeSaude;
import excecoes.ExistePessoaException;

public class NegocioUnidadeSaude {

	public static UnidadeSaude incluir(UnidadeSaude unidadeSaudeNova) throws ExistePessoaException {
		if (!existeUnidadeSaude(unidadeSaudeNova)){
			return PersistenciaUnidadeSaude.incluir(unidadeSaudeNova);
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

	public static UnidadeSaude detalhar(Integer idUnidadeSaude) {
		return PersistenciaUnidadeSaude.detalhar(idUnidadeSaude);
	}

}
