package modelo.entidades;

import java.util.Date;

public class _Pessoa {
	private Integer idPessoa;
	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
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

	public _Pessoa getPai() {
		return pai;
	}

	public void setPai(_Pessoa pai) {
		this.pai = pai;
	}

	public _Pessoa getMae() {
		return mae;
	}

	public void setMae(_Pessoa mae) {
		this.mae = mae;
	}

	public _Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(_Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Telefone[] getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone[] telefone) {
		this.telefone = telefone;
	}

	private Integer sexo;
	 
	private _Pessoa pai;
	 
	private _Pessoa mae;
	 
	private _Pessoa pessoa;
	 
	private Telefone[] telefone;
	 
}
 
