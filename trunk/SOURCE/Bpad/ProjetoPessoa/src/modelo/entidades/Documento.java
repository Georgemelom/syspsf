package modelo.entidades;

import java.util.Date;

public class Documento {
 
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public _Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(_Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	private String numero;
	 
	/**
	 *1 - RG
	 *2 - CPF
	 *3 - CNH
	 *4 - Cateira Militar
	 *5 - Certidição de nascimento
	 *
	 */
	private int tipo;
	 
	private Date dataValidade;
	 
	private String complemento;
	 
	private _Pessoa pessoa;
	 
}
 
