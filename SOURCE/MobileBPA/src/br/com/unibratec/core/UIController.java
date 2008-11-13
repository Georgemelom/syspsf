package br.com.unibratec.core;

import java.util.Date;
import java.util.Stack;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

import br.com.unibratec.ProjetoMIDLet;
import br.com.unibratec.menus.MenuPrincipal;
import br.com.unibratec.telas.Alerta;
import br.com.unibratec.telas.FichaDiaria;
import br.com.unibratec.telas.Login;
import br.com.unibratec.telas.Paciente;
import br.com.unibratec.telas.ProfissionalSaude;
import br.com.unibratec.telas.UnidadeSaude;

public class UIController {

	private ProjetoMIDLet midLet;
	private Display disp;

	private Stack telas;
	private int recID = -1;
	private static UIController instance;

	private UIController(ProjetoMIDLet midLet) {
		this.midLet = midLet;
		this.disp = Display.getDisplay(midLet);
		telas = new Stack();
		startUp();
	}

	public void startUp() {
		RecordStore rs = null;
		int currentId = 0;
		try {
			rs = RecordStore.openRecordStore("dados", true);
			RecordEnumeration re = rs.enumerateRecords(null, null, false);
			while (re.hasNextElement()) {
				currentId = re.nextRecordId();
				String registro = new String(re.nextRecord());
				// verifica a chave do registro
				if (registro.indexOf("login=") != -1) {
					recID = currentId;
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao recuperar login no Record Store...");
			// tratamento de excessão
		} finally {
			if (rs != null) {
				try {
					System.out.println("Fechando Record Store...");
					rs.closeRecordStore();
				} catch (RecordStoreNotOpenException e) {
					e.printStackTrace();
				} catch (RecordStoreException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static UIController createInstance(ProjetoMIDLet midLet) {
		if (instance == null) {
			instance = new UIController(midLet);
		}
		return instance;
	}

	public static UIController getInstance() {
		return instance;
	}

	public void salvarLogin(String login, String passwd) {
		Record.setLogin(login);
		Record.setSenha(passwd);
	}

	public void salvarUs(String usCnes, String cidade_ciSigla, String usNome,
			String usSigla, String usRazaoSocial, String usCnpj,
			String usEndereco) {
		Record.setUsCnes(usCnes);
		Record.setCidade_ciSigla(cidade_ciSigla);
		Record.setUsNome(usNome);
		Record.setUsSigla(usSigla);
		Record.setUsRazaoSocial(usRazaoSocial);
		Record.setUsCnpj(usCnpj);
		Record.setUsEndereco(usEndereco);
	}

	public void salvarPc(String pcCns, String pcNome, String pcDtNasc,
			String pcSexo, String pcEndereco) {
		Record.setPcCns(pcCns);
		Record.setPcNome(pcNome);
		Record.setPcDtNasc(pcDtNasc);
		Record.setPcSexo(pcSexo);
		Record.setPcEndereco(pcEndereco);
	}

	public void salvarPs(String psCns, String psNome, String psCbo, String psCr) {
		Record.setPsCns(psCns);
		Record.setPsNome(psNome);
		Record.setPsCbo(psCbo);
		Record.setPsCr(psCr);

	}

	public void salvarFd(Date fdDtProducao, String fdID, String folha_folID,
			String procedimentos_proCodigo, String pacientes_pcCns,
			String profissinalSaude_psCns) {

		Record.setFdDtProducao(fdDtProducao);
		Record.setFdID(fdID);
		Record.setFolha_folID(folha_folID);
		Record.setProcedimentos_proCodigo(procedimentos_proCodigo);
		Record.setPacientes_pcCns(pacientes_pcCns);
		Record.setProfissinalSaude_psCns(profissinalSaude_psCns);

	}

	public void exibirLogin() {
		Alert alert = new Alert("Seu Login  é:", Record.getLogin(), null,
				AlertType.CONFIRMATION);
		disp.setCurrent(alert);
	}

	public void exibirUs() {
		Alert alert = new Alert("Unidade de Saude:", Record.getUsCnes() + " | "
				+ Record.getUsNome() + " | " + Record.getUsCnpj() + " | "
				+ Record.getUsEndereco() + " | " + Record.getUsRazaoSocial()
				+ " | " + Record.getUsSigla(), null, AlertType.INFO);
		disp.setCurrent(alert);
	}

	public void exibirPc() {
		Alert alert = new Alert("Paciente:", Record.getPcCns() + " | "
				+ Record.getPcNome() + " | " + Record.getPcDtNasc() + " | "
				+ Record.getPcSexo() + " | " + Record.getPcEndereco(), null,
				AlertType.INFO);
		disp.setCurrent(alert);
	}

	public void exibirPs() {
		Alert alert = new Alert("Profissional:", Record.getPsCns() + " | "
				+ Record.getPsNome() + " | " + Record.getPsCbo() + " | "
				+ Record.getPsCr(), null, AlertType.INFO);
		disp.setCurrent(alert);
	}

	public void exibirFd() {
		Alert alert = new Alert("Ficha Diaria:", Record.getFdDtProducao()
				+ " | " + Record.getFdID() + " | " + Record.getFolha_folID(),
				null, AlertType.INFO);
		disp.setCurrent(alert);
	}

	public void login(String login, String passwd) {

		if (login.equals(Record.getLogin()) && passwd.equals(Record.getSenha())) { // conecata
																					// ao
																					// servidor
																					// e
																					// realiza
																					// login
			setCurrent(MenuPrincipal.getInstance("Menu Principal")); // encaminha
																		// para
																		// MENU

		} else {
			setCurrent(Alerta.getInstance("ERRO"), Login.getInstance("LOGIN"));
		}
	}

	public void unidadeSaude() {

		setCurrent(UnidadeSaude.getInstance("Unidade de Saude"));

	}

	public void profissionalSaude() {
		setCurrent(ProfissionalSaude.getInstance("Profissional de Saude"));

	}

	public void paciente() {
		setCurrent(Paciente.getInstance("Paciente"));

	}

	public void MenuFichaDiaria() {
		setCurrent(FichaDiaria.getInstance("Ficha Diaria"));

	}

	public void sair() {
		midLet.destroyApp(true);
		midLet.notifyDestroyed();
	}

	public void setCurrent(Displayable paciente) {
		telas.push(paciente);
		disp.setCurrent(paciente);
	}

	public void setCurrent(Alert alerta, Displayable tela) {
		telas.push(tela);
		disp.setCurrent(alerta, tela);
	}

	public void voltar() {
		telas.pop();
		Displayable anterior = (Displayable) telas.pop();
		setCurrent(anterior);
	}

	// public void ok(int x) {
	//		
	// switch (x) {
	// case 0 : setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
	// break;
	// case 1 : setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
	// break;
	// case 2 : setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
	// break;
	// case 3 : setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
	// break;
	//		
	// }
	// }
	// public void telas(int x) {
	//		
	// switch (x) {
	// case 0 :
	// setCurrent(UnidadeSaude.getInstance("Cadastrar Unidade de Saude"));
	// break;
	// case 1 :
	// setCurrent(ProfissionalSaude.getInstance("Cadstrar Profissional"));
	// break;
	// case 2 : setCurrent(Paciente.getInstance("Cadastrar Paciente"));
	// break;
	// case 3 : setCurrent(FichaDiaria.getInstance("Registar Atendimento"));
	// break;
	//		
	// }
	// }

	public void cadastrar(int cad) {

		switch (cad) {
		case 0:
			setCurrent(UnidadeSaude.getInstance("Cadastrar Unidade de Saude"));
			break;
		case 1:
			setCurrent(ProfissionalSaude.getInstance("Cadstrar Profissional"));
			break;
		case 2:
			setCurrent(Paciente.getInstance("Cadastrar Paciente"));
			break;
		case 3:
			setCurrent(FichaDiaria.getInstance("Registar Atendimento"));
			break;

		}

	}

	public void atualizar() {
		// TODO Auto-generated method stub

	}

	public void excluir() {
		// TODO Auto-generated method stub

	}

	public void consultar() {
		// TODO Auto-generated method stub

	}
}
