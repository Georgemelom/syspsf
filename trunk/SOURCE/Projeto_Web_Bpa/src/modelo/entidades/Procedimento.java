package modelo.entidades;


public class Procedimento {
 
	private String proCodigo;
	private String proDigito;
	private String proDescricao;
	private String proSexo;
	
	
	public synchronized String getProCodigo() {
		return proCodigo;
	}
	public synchronized void setProCodigo(String proCodigo) {
		this.proCodigo = proCodigo;
	}
	public synchronized String getProDigito() {
		return proDigito;
	}
	public synchronized void setProDigito(String proDigito) {
		this.proDigito = proDigito;
	}
	public synchronized String getProDescricao() {
		return proDescricao;
	}
	public synchronized void setProDescricao(String proDescricao) {
		this.proDescricao = proDescricao;
	}
	public synchronized String getProSexo() {
		return proSexo;
	}
	public synchronized void setProSexo(String proSexo) {
		this.proSexo = proSexo;
	}
	
	

}
 
