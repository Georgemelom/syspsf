package modelo.entidades;

public class UnidadeSaude {

	private Integer usCnes; //varchar 6
	private String cidade_ciSigla;//VARCHAR6
	private String usNome;//VARCHAR100
	private String usSigla;//VARCHAR20
	private String usRazaoSocial;//VARCHAR100
	private String usCnpj;//VARCHAR14
	private String usEndereco;	//VARCHAR100
	
	
	public  Integer getUsCnes() {
		return usCnes;
	}
	public  void setUsCnes(Integer usCnes) {
		this.usCnes = usCnes;
	}
	public  String getUsNome() {
		return usNome;
	}
	public  void setUsNome(String usNome) {
		this.usNome = usNome;
	}
	public  String getUsSigla() {
		return usSigla;
	}
	public  void setUsSigla(String usSigla) {
		this.usSigla = usSigla;
	}
	public  String getUsRazaoSocial() {
		return usRazaoSocial;
	}
	public  void setUsRazaoSocial(String usRazaoSocial) {
		this.usRazaoSocial = usRazaoSocial;
	}
	public  String getUsCnpj() {
		return usCnpj;
	}
	public  void setUsCnpj(String usCnpj) {
		this.usCnpj = usCnpj;
	}
	public  String getUsEndereco() {
		return usEndereco;
	}
	public  void setUsEndereco(String usEndereco) {
		this.usEndereco = usEndereco;
	}
	public void setCidade_ciSigla(String cidade_ciSigla) {
		this.cidade_ciSigla = cidade_ciSigla;
	}
	public String getCidade_ciSigla() {
		return cidade_ciSigla;
	}

}
 
