package modelo.entidades;

public class Telefone {
 
	private int ddd;
	 
	private int numero;
	 
	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public _Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(_Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 *1 - residencial
	 *2 - comercial
	 *3 - celular
	 *4 - fax
	 */
	private int tipo;
	 
	private _Pessoa pessoa;
	 
}
 
