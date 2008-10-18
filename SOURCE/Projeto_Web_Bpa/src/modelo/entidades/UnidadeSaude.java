package modelo.entidades;

public class UnidadeSaude {

	private Integer usCnes;
	private String usNome;
	private String usSigla;
	private String usRazaoSocial;
	private String usCnpj;
	private String usEndereco;
	
	public synchronized Integer getUsCnes() {
		return usCnes;
	}
	public synchronized void setUsCnes(Integer usCnes) {
		this.usCnes = usCnes;
	}
	public synchronized String getUsNome() {
		return usNome;
	}
	public synchronized void setUsNome(String usNome) {
		this.usNome = usNome;
	}
	public synchronized String getUsSigla() {
		return usSigla;
	}
	public synchronized void setUsSigla(String usSigla) {
		this.usSigla = usSigla;
	}
	public synchronized String getUsRazaoSocial() {
		return usRazaoSocial;
	}
	public synchronized void setUsRazaoSocial(String usRazaoSocial) {
		this.usRazaoSocial = usRazaoSocial;
	}
	public synchronized String getUsCnpj() {
		return usCnpj;
	}
	public synchronized void setUsCnpj(String usCnpj) {
		this.usCnpj = usCnpj;
	}
	public synchronized String getUsEndereco() {
		return usEndereco;
	}
	public synchronized void setUsEndereco(String usEndereco) {
		this.usEndereco = usEndereco;
	}
	
	

}
 
