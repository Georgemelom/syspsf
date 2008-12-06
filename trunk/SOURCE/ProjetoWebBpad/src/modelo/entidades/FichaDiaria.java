package modelo.entidades;

import java.util.Date;

public class FichaDiaria {

	private Integer fdID; //varchar 5
//	private String folha_FoID;//VARCHA3
	private String procedimentos_proCodigo;//VARCHAR5
	private String pacientes_pcCns;//VARCHAR6
	private String profissionalSaude_psCns;//VARCHAR6
	private Date fdDtProducao;//VARCHAR6
	
	public  Integer getFdID() {
		return fdID;
	}
	public  void setFdID(int fdID) {
		this.fdID = fdID;
	}
//	public  String getFolha_FoID() {
//		return folha_FoID;
//	}
//	public  void setFolha_FoID(String folha_FoID) {
//		this.folha_FoID = folha_FoID;
//	}
	public  String getProcedimentos_proCodigo() {
		return procedimentos_proCodigo;
	}
	public  void setProcedimentos_proCodigo(
			String procedimentos_proCodigo) {
		this.procedimentos_proCodigo = procedimentos_proCodigo;
	}
	public  String getPacientes_pcCns() {
		return pacientes_pcCns;
	}
	public  void setPacientes_pcCns(String pacientes_pcCns) {
		this.pacientes_pcCns = pacientes_pcCns;
	}
	public  String getProfissionalSaude_psCns() {
		return profissionalSaude_psCns;
	}
	public  void setProfissionalSaude_psCns(
			String profissionalSaude_psCns) {
		this.profissionalSaude_psCns = profissionalSaude_psCns;
	}
	public void setFdDtProducao(Date fdDtProducao) {
		this.fdDtProducao = fdDtProducao;
	}
	public Date getFdDtProducao() {
		return fdDtProducao;
	}
	
	
	
}
 
