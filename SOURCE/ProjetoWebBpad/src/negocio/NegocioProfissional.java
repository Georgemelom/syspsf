package negocio;

import java.util.ArrayList;

import modelo.entidades.Profissional;
import persistencia.PersistenciaProfissional;
import excecoes.ExistePessoaException;
import excecoes.PadraoException;

public class NegocioProfissional {

	public static Profissional cadastrar(Profissional profissionalNovo) throws ExistePessoaException {
		if (!existeProfissional(profissionalNovo)){
			return PersistenciaProfissional.cadastrar(profissionalNovo);
		} else {
			throw new ExistePessoaException();
		}
		
	}
	private static boolean existeProfissional(Profissional profissionalNovo) {
		return false;
	}

	public static ArrayList<Profissional> listar(Profissional profissionalParam) {
		return PersistenciaProfissional.listar(profissionalParam);
	}

	public static Profissional detalhar(Profissional psCns) throws PadraoException{
		return PersistenciaProfissional.detalhar(psCns);
	}
	
	public static Profissional atualizar(Profissional profissionalNovo) throws ExistePessoaException {
		if (!existeProfissional(profissionalNovo)){
			return PersistenciaProfissional.atualizar(profissionalNovo);
		} else {
			throw new ExistePessoaException();
		}
		
	}		
}
