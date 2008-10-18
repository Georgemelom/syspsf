package modelo.entidades;

public class Profissional {

	private String psCodigo;
	private String psNome;
	private String psCpf;
	private String psTelefone;
	
	
	public synchronized String getPsCodigo() {
		return psCodigo;
	}
	public synchronized void setPsCodigo(String psCodigo) {
		this.psCodigo = psCodigo;
	}
	public synchronized String getPsNome() {
		return psNome;
	}
	public synchronized void setPsNome(String psNome) {
		this.psNome = psNome;
	}
	public synchronized String getPsCpf() {
		return psCpf;
	}
	public synchronized void setPsCpf(String psCpf) {
		this.psCpf = psCpf;
	}
	public synchronized String getPsTelefone() {
		return psTelefone;
	}
	public synchronized void setPsTelefone(String psTelefone) {
		this.psTelefone = psTelefone;
	}
	


}
 
