package modelo.entidades;

import java.util.Date;

public class Paciente {

	private Integer idPaciente;
	private String pcNome;
	private Date pcDataNascimento;
	private String pcSexo;
	private String pcEndereco;
	
	public synchronized Integer getIdPaciente() {
		return idPaciente;
	}
	public synchronized void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public synchronized String getPcNome() {
		return pcNome;
	}
	public synchronized void setPcNome(String pcNome) {
		this.pcNome = pcNome;
	}
	public synchronized Date getPcDataNascimento() {
		return pcDataNascimento;
	}
	public synchronized void setPcDataNascimento(Date pcDataNascimento) {
		this.pcDataNascimento = pcDataNascimento;
	}
	public synchronized String getPcSexo() {
		return pcSexo;
	}
	public synchronized void setPcSexo(String pcSexo) {
		this.pcSexo = pcSexo;
	}
	public synchronized String getPcEndereco() {
		return pcEndereco;
	}
	public synchronized void setPcEndereco(String pcEndereco) {
		this.pcEndereco = pcEndereco;
	}
	
		
}
 
