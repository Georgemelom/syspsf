package negocio;

import java.util.ArrayList;

import excecoes.ExistePessoaException;
import persistencia._PersistenciaPessoa;
import modelo.entidades._Pessoa;

public class _NegocioPessoa {

	public static _Pessoa incluir(_Pessoa pessoaNova) throws ExistePessoaException {
		if (!existePessoa(pessoaNova)){
			return _PersistenciaPessoa.incluir(pessoaNova);
		} else {
			throw new ExistePessoaException();
		}
		
	}
	private static boolean existePessoa(_Pessoa pessoaNova) {
		return false;
	}

	public static ArrayList<_Pessoa> listar(_Pessoa pessoaParam) {
		return _PersistenciaPessoa.listar(pessoaParam);
	}

	public static _Pessoa detalhar(Integer idPessoa) {
		return _PersistenciaPessoa.detalhar(idPessoa);
	}

}
