package modelo.entidades;

import java.util.Date;

public class Paciente {
	private Integer idPaciente;
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	private String nome;
	 
	private Date dataNascimento;
	 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Documento[] getDocumento() {
		return documento;
	}

	public void setDocumento(Documento[] documento) {
		this.documento = documento;
	}

	public Paciente getPai() {
		return pai;
	}

	public void setPai(Paciente pai) {
		this.pai = pai;
	}

	public Paciente getMae() {
		return mae;
	}

	public void setMae(Paciente mae) {
		this.mae = mae;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Telefone[] getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone[] telefone) {
		this.telefone = telefone;
	}

	private Integer sexo;
	 
	private Endereco endereco;
	 
	private Documento[] documento;
	 
	private Paciente pai;
	 
	private Paciente mae;
	 
	private Paciente paciente;
	 
	private Telefone[] telefone;
	 
}
 
