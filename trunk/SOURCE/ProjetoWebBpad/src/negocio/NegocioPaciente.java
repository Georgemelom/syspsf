package negocio;

import java.util.ArrayList;

import modelo.entidades.Paciente;
import persistencia.PersistenciaPaciente;
import excecoes.ExistePessoaException;
import excecoes.PadraoException;

public class NegocioPaciente {

	public static Paciente cadastrar(Paciente pacienteNovo) throws ExistePessoaException {
		if (!existePaciente(pacienteNovo)){
			return PersistenciaPaciente.cadastrar(pacienteNovo);
		} else {
			throw new ExistePessoaException();
		}
		
	}
	private static boolean existePaciente(Paciente pacienteNovo) {
		return false;
	}

	public static ArrayList<Paciente> listar(Paciente pacienteParam) {
		return PersistenciaPaciente.listar(pacienteParam);
	}

	public static Paciente detalhar(Paciente pcCns) throws PadraoException{
		return PersistenciaPaciente.detalhar(pcCns);
	}
	
	public static Paciente atualizar(Paciente pacienteNovo) throws ExistePessoaException {
		if (!existePaciente(pacienteNovo)){
			return PersistenciaPaciente.atualizar(pacienteNovo);
		} else {
			throw new ExistePessoaException();
		}
		
	}		
}
