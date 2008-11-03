package modelo.entidades;

import java.util.Date;

public class Paciente {

	private Integer pcCns; //varchar 6
	private String pcNome;	//varchar 50
	private Date pcDataNascimento; //date
	private String pcSexo;	//varchar 1
	private String pcEndereco;	//varchar 100
	
	
	public void setPcCns(Integer pcCns) {
		this.pcCns = pcCns;
	}
	public Integer getPcCns() {
		return pcCns;
	}
	public  String getPcNome() {
		return pcNome;
	}
	public  void setPcNome(String pcNome) {
		this.pcNome = pcNome;
	}
	public  Date getPcDataNascimento() {
		return pcDataNascimento;
	}
	public  void setPcDataNascimento(Date pcDataNascimento) {
		this.pcDataNascimento = pcDataNascimento;
	}
	public  String getPcSexo() {
		return pcSexo;
	}
	public  void setPcSexo(String pcSexo) {
		this.pcSexo = pcSexo;
	}
	public  String getPcEndereco() {
		return pcEndereco;
	}
	public  void setPcEndereco(String pcEndereco) {
		this.pcEndereco = pcEndereco;
	}
	
		
}
 
