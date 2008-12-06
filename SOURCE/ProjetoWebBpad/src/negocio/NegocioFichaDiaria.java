package negocio;

import java.util.ArrayList;

import modelo.entidades.FichaDiaria;
import persistencia.PersistenciaFichaDiaria;
import excecoes.ExistePessoaException;
import excecoes.PadraoException;

public class NegocioFichaDiaria {

	public static FichaDiaria cadastrar(FichaDiaria fichaDiariaNova) throws ExistePessoaException {
		if (!existeFichaDiaria(fichaDiariaNova)){
			return PersistenciaFichaDiaria.cadastrar(fichaDiariaNova);
		} else {
			throw new ExistePessoaException();
		}
		
	}
	private static boolean existeFichaDiaria(FichaDiaria fichaDiariaNova) {
		return false;
	}

	public static ArrayList<FichaDiaria> listar(FichaDiaria unidadeSaudeParam) {
		return PersistenciaFichaDiaria.listar(unidadeSaudeParam);
	}

	public static FichaDiaria detalhar(FichaDiaria fdID) throws PadraoException{
		return PersistenciaFichaDiaria.detalhar(fdID);
	}
	
	public static FichaDiaria atualizar(FichaDiaria fichaDiariaNova) throws ExistePessoaException {
		if (!existeFichaDiaria(fichaDiariaNova)){
			return PersistenciaFichaDiaria.atualizar(fichaDiariaNova);
		} else {
			throw new ExistePessoaException();
		}
		
	}		
}
