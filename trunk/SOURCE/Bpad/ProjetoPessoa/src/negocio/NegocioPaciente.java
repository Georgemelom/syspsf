package negocio;

import java.util.ArrayList;

import modelo.entidades.Paciente;
import persistencia.PersistenciaPaciente;
import persistencia.PersistenciaPessoa;
import excecoes.ExistePessoaException;

public class NegocioPaciente {

	public static Paciente incluir(Paciente pacienteNovo) throws ExistePessoaException {
		if (!existePessoa(pacienteNovo)){
			return PersistenciaPaciente.incluir(pacienteNovo);
		} else {
			throw new ExistePessoaException();
		}
		
	}
	private static boolean existePessoa(Paciente pacienteNovo) {
		return false;
	}

	public static ArrayList<Paciente> listar(Paciente pacienteParam) {
		return PersistenciaPaciente.listar(pacienteParam);
	}

	public static Paciente detalhar(Integer idPaciente) {
		return PersistenciaPaciente.detalhar(idPaciente);
	}

}
