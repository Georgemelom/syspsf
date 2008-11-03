package modelo.entidades;

public class Profissional {

	private Integer psCns; //varchar 6
	private String cbo_Cbo; //varchar 6
	private String conselhos_conselho; // varchar 10
	private String unidadeSaude_usCnes; // varchar 10
	private String psNome;	//varchar 50
	private String psCpf;	//varchar 12
	private String psTelefone;	//varchar 15
	
	public  Integer getPsCns() {
		return psCns;
	}
	public  void setPsCns(Integer psCns) {
		this.psCns = psCns;
	}
	public  String getCbo_Cbo() {
		return cbo_Cbo;
	}
	public  void setCbo_Cbo(String cbo_Cbo) {
		this.cbo_Cbo = cbo_Cbo;
	}
	public  String getConselhos_conselho() {
		return conselhos_conselho;
	}
	public  void setConselhos_conselho(String conselhos_conselho) {
		this.conselhos_conselho = conselhos_conselho;
	}
	public void setUnidadeSaude_usCnes(String unidadeSaude_usCnes) {
		this.unidadeSaude_usCnes = unidadeSaude_usCnes;
	}
	public String getUnidadeSaude_usCnes() {
		return unidadeSaude_usCnes;
	}
	public  String getPsNome() {
		return psNome;
	}
	public  void setPsNome(String psNome) {
		this.psNome = psNome;
	}
	public  String getPsCpf() {
		return psCpf;
	}
	public  void setPsCpf(String psCpf) {
		this.psCpf = psCpf;
	}
	public  String getPsTelefone() {
		return psTelefone;
	}
	public  void setPsTelefone(String psTelefone) {
		this.psTelefone = psTelefone;
	}
	
	
	

}
 
