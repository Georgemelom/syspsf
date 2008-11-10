package br.com.unibratec.core;

import java.util.Date;

import javax.microedition.lcdui.List;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

public class Record {

	// coleção de registros
	private static RecordStore rs;

	// registros
	private static int idLogin;
	private static int idSenha;

	private static int idUsCnes;
	private static int idCidade_ciSigla;
	private static int idUsNome;
	private static int idUsSigla;
	private static int idUsRazaoSocial;
	private static int idUsCnpj;
	private static int idUsEndereco;

	private static int idPcCns;
	private static int idPcNome;
	private static int idPcDtNasc;
	private static int idPcSexo;
	private static int idPcEndereco;

	private static int idPsCns;
	private static int idPsNome;
	private static int idPsCbo;
	private static int idPsCr;

	private static int idFdDtProducao;
	private static int idFdID;
	private static int idFolha_folID;
	private static int idProcedimentos_proCodigo;
	private static int idPacientes_pcCns;
	private static int idProfissinalSaude_psCns;

	private static int idArrayDeNomes;

	/**
	 * Método que abre o record store "dados"
	 * 
	 * @throws RecordStoreFullException
	 * @throws RecordStoreNotFoundException
	 * @throws RecordStoreException
	 */
	private static void openRecord() throws RecordStoreFullException,
			RecordStoreNotFoundException, RecordStoreException {
		rs = RecordStore.openRecordStore("dados", true);
	}

	/**
	 * Método que fecha o record store "dados" se ele tiver sido aberto
	 * corretamente
	 * 
	 * @throws RecordStoreNotOpenException
	 * @throws RecordStoreException
	 */
	private static void closeRecord() throws RecordStoreNotOpenException,
			RecordStoreException {
		if (rs != null) {
			rs.closeRecordStore();
		}
	}

	/**
	 * Indexa o record store
	 */
	public static void startUp() {
		try {
			openRecord();
			RecordEnumeration re = rs.enumerateRecords(null, null, false);
			while (re.hasNextElement()) {
				int idRegistro = re.nextRecordId();
				String rec = new String(rs.getRecord(idRegistro));
				if (rec.indexOf("login=") != -1) {
					idLogin = idRegistro;
				} else if (rec.indexOf("senha=") != -1) {
					idSenha = idRegistro;
				} else if (rec.indexOf("uscnes=") != -1) {
					idUsCnes = idRegistro;
				} else if (rec.indexOf("cidade_ciSilga=") != -1) {
					idCidade_ciSigla = idRegistro;
				} else if (rec.indexOf("usnome=") != -1) {
					idUsNome = idRegistro;
				} else if (rec.indexOf("ussigla=") != -1) {
					idUsSigla = idRegistro;
				} else if (rec.indexOf("usrazaoSocial=") != -1) {
					idUsRazaoSocial = idRegistro;
				} else if (rec.indexOf("uscnpj=") != -1) {
					idUsCnpj = idRegistro;
				} else if (rec.indexOf("usendereeco=") != -1) {
					idUsEndereco = idRegistro;
				} else if (rec.indexOf("pcCns=") != -1) {
					idPcCns = idRegistro;
				} else if (rec.indexOf("pcNome=") != -1) {
					idPcNome = idRegistro;
				} else if (rec.indexOf("pcDtNasc=") != -1) {
					idPcDtNasc = idRegistro;
				} else if (rec.indexOf("pcSexo=") != -1) {
					idPcSexo = idRegistro;
				} else if (rec.indexOf("pcEndereco=") != -1) {
					idPcEndereco = idRegistro;
				} else if (rec.indexOf("psCns=") != -1) {
					idPsCns = idRegistro;
				} else if (rec.indexOf("psNome=") != -1) {
					idPsNome = idRegistro;
				} else if (rec.indexOf("psCbo=") != -1) {
					idPsCbo = idRegistro;
				} else if (rec.indexOf("psCr=") != -1) {
					idPsCr = idRegistro;
				}
			}

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Salva o login
	 * 
	 * @param login
	 */
	public static void setLogin(String login) {
		try {
			openRecord();
			String rec = "login=" + login;
			byte[] data = rec.getBytes();
			if (idLogin != 0) {// registro já existe
				rs.setRecord(idLogin, data, 0, data.length);
			} else {
				idLogin = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void setSenha(String senha) {
		try {
			openRecord();
			String rec = "senha=" + senha;
			byte[] data = rec.getBytes();
			if (idSenha != 0) {// registro já existe
				rs.setRecord(idSenha, data, 0, data.length);
			} else {
				idSenha = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void setUsCnes(String usCnes) {
		try {
			openRecord();
			String rec = "uscnes=" + usCnes;
			byte[] data = rec.getBytes();
			if (idUsCnes != 0) {// registro já existe
				rs.setRecord(idUsCnes, data, 0, data.length);
			} else {
				idUsCnes = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void setCidade_ciSigla(String cidade_ciSigla) {
		try {
			openRecord();
			String rec = "cidade_ciSigla=" + cidade_ciSigla;
			byte[] data = rec.getBytes();
			if (idCidade_ciSigla != 0) {// registro já existe
				rs.setRecord(idCidade_ciSigla, data, 0, data.length);
			} else {
				idCidade_ciSigla = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void setUsNome(String usNome) {
		try {
			openRecord();
			String rec = "usnome=" + usNome;
			byte[] data = rec.getBytes();
			if (idUsNome != 0) {// registro já existe
				rs.setRecord(idUsNome, data, 0, data.length);
			} else {
				idUsNome = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setUsSigla(String usSigla) {
		try {
			openRecord();
			String rec = "ussigla=" + usSigla;
			byte[] data = rec.getBytes();
			if (idUsSigla != 0) {// registro já existe
				rs.setRecord(idUsSigla, data, 0, data.length);
			} else {
				idUsSigla = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setUsRazaoSocial(String usRazaoSocial) {
		try {
			openRecord();
			String rec = "usrazaoSocial=" + usRazaoSocial;
			byte[] data = rec.getBytes();
			if (idUsRazaoSocial != 0) {// registro já existe
				rs.setRecord(idUsRazaoSocial, data, 0, data.length);
			} else {
				idUsRazaoSocial = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setUsCnpj(String usCnpj) {
		try {
			openRecord();
			String rec = "uscnpj=" + usCnpj;
			byte[] data = rec.getBytes();
			if (idUsCnpj != 0) {// registro já existe
				rs.setRecord(idUsCnpj, data, 0, data.length);
			} else {
				idUsCnpj = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setUsEndereco(String usEndereco) {
		try {
			openRecord();
			String rec = "usendereco=" + usEndereco;
			byte[] data = rec.getBytes();
			if (idUsEndereco != 0) {// registro já existe
				rs.setRecord(idUsEndereco, data, 0, data.length);
			} else {
				idUsEndereco = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPcCns(String pcCns) {
		try {
			openRecord();
			String rec = "pccns=" + pcCns;
			byte[] data = rec.getBytes();
			if (idPcCns != 0) {// registro já existe
				rs.setRecord(idPcCns, data, 0, data.length);
			} else {
				idPcCns = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPcNome(String pcNome) {
		try {
			openRecord();
			String rec = "pcnome=" + pcNome;
			byte[] data = rec.getBytes();
			if (idPcNome != 0) {// registro já existe
				rs.setRecord(idPcNome, data, 0, data.length);
			} else {
				idPcNome = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPcDtNasc(String pcDtNasc) {
		try {
			openRecord();
			String rec = "pcdtnasc=" + pcDtNasc;
			byte[] data = rec.getBytes();
			if (idPcDtNasc != 0) {// registro já existe
				rs.setRecord(idPcDtNasc, data, 0, data.length);
			} else {
				idPcDtNasc = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPcSexo(String pcSexo) {
		try {
			openRecord();
			String rec = "pcsexo=" + pcSexo;
			byte[] data = rec.getBytes();
			if (idPcSexo != 0) {// registro já existe
				rs.setRecord(idPcSexo, data, 0, data.length);
			} else {
				idPcSexo = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPcEndereco(String pcEndereco) {
		try {
			openRecord();
			String rec = "pcendereco=" + pcEndereco;
			byte[] data = rec.getBytes();
			if (idPcEndereco != 0) {// registro já existe
				rs.setRecord(idPcEndereco, data, 0, data.length);
			} else {
				idPcEndereco = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPsCns(String psCns) {
		try {
			openRecord();
			String rec = "pscns=" + psCns;
			byte[] data = rec.getBytes();
			if (idPsCns != 0) {// registro já existe
				rs.setRecord(idPsCns, data, 0, data.length);
			} else {
				idPsCns = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPsNome(String psNome) {
		try {
			openRecord();
			String rec = "psnome=" + psNome;
			byte[] data = rec.getBytes();
			if (idPsNome != 0) {// registro já existe
				rs.setRecord(idPsNome, data, 0, data.length);
			} else {
				idPsNome = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPsCbo(String psCbo) {
		try {
			openRecord();
			String rec = "pscbo=" + psCbo;
			byte[] data = rec.getBytes();
			if (idPsCbo != 0) {// registro já existe
				rs.setRecord(idPsCbo, data, 0, data.length);
			} else {
				idPsCbo = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPsCr(String psCr) {
		try {
			openRecord();
			String rec = "pscr=" + psCr;
			byte[] data = rec.getBytes();
			if (idPsCr != 0) {// registro já existe
				rs.setRecord(idPsCr, data, 0, data.length);
			} else {
				idPsCr = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void setFdDtProducao(Date fdDtProducao) {
		try {
			openRecord();
			String rec = "fdDtProducao=" + fdDtProducao;
			byte[] data = rec.getBytes();
			if (idFdDtProducao != 0) {// registro já existe
				rs.setRecord(idFdDtProducao, data, 0, data.length);
			} else {
				idFdDtProducao = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setFdID(String fdID) {
		try {
			openRecord();
			String rec = "fdID=" + fdID;
			byte[] data = rec.getBytes();
			if (idFdID != 0) {// registro já existe
				rs.setRecord(idFdID, data, 0, data.length);
			} else {
				idFdID = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setFolha_folID(String folha_folID) {
		try {
			openRecord();
			String rec = "folha_folID=" + folha_folID;
			byte[] data = rec.getBytes();
			if (idFolha_folID != 0) {// registro já existe
				rs.setRecord(idFolha_folID, data, 0, data.length);
			} else {
				idFolha_folID = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setProcedimentos_proCodigo(String procedimentos_proCodigo) {
		try {
			openRecord();
			String rec = "procedimentos_proCodigo=" + procedimentos_proCodigo;
			byte[] data = rec.getBytes();
			if (idProcedimentos_proCodigo != 0) {// registro já existe
				rs.setRecord(idProcedimentos_proCodigo, data, 0, data.length);
			} else {
				idProcedimentos_proCodigo = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setPacientes_pcCns(String pacientes_pcCns) {
		try {
			openRecord();
			String rec = "pacientes_pcCns=" + pacientes_pcCns;
			byte[] data = rec.getBytes();
			if (idPacientes_pcCns != 0) {// registro já existe
				rs.setRecord(idPacientes_pcCns, data, 0, data.length);
			} else {
				idPacientes_pcCns = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void setProfissinalSaude_psCns(String profissinalSaude_psCns) {
		try {
			openRecord();
			String rec = "profissinalSaude_psCns=" + profissinalSaude_psCns;
			byte[] data = rec.getBytes();
			if (idProfissinalSaude_psCns != 0) {// registro já existe
				rs.setRecord(idProfissinalSaude_psCns, data, 0, data.length);
			} else {
				idProfissinalSaude_psCns = rs.addRecord(data, 0, data.length);
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Procura o login no record store
	 * 
	 * @return
	 */
	public static String getLogin() {
		String login = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idLogin));
			login = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return login;
	}

	public static String getSenha() {
		String senha = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idSenha));
			senha = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return senha;
	}

	public static String getUsCnes() {
		String usCnes = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idUsCnes));
			usCnes = rec.substring(rec.indexOf('=') + 1, rec.length());
			for (int i = 0; i < rec.length(); i++) {

			}

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return usCnes;
	}

	public static String getCidade_ciSigla() {
		String cidade_ciSigla = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idCidade_ciSigla));
			cidade_ciSigla = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cidade_ciSigla;
	}

	public static String getUsNome() {
		String usNome = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idUsNome));
			usNome = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return usNome;
	}

	public static String getUsSigla() {
		String usSigla = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idUsSigla));
			usSigla = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return usSigla;
	}

	public static String getUsRazaoSocial() {
		String usRazaoSocial = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idUsRazaoSocial));
			usRazaoSocial = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return usRazaoSocial;
	}

	public static String getUsCnpj() {
		String usCnpj = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idUsCnpj));
			usCnpj = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return usCnpj;
	}

	public static String getUsEndereco() {
		String usEndereco = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idUsEndereco));
			usEndereco = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return usEndereco;
	}

	public static String getPcCns() {
		String pcCns = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPcCns));
			pcCns = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pcCns;
	}

	public static String getPcNome() {
		String pcNome = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPcNome));
			pcNome = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pcNome;
	}

	public static String getPcDtNasc() {
		String pcDtNasc = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPcDtNasc));
			pcDtNasc = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pcDtNasc;
	}

	public static String getPcSexo() {
		String pcSexo = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPcSexo));
			pcSexo = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pcSexo;
	}

	public static String getPcEndereco() {
		String pcEndereco = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPcEndereco));
			pcEndereco = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pcEndereco;
	}

	public static String getPsCns() {
		String psCns = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPsCns));
			psCns = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return psCns;
	}

	public static String getPsNome() {
		String psNome = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPsNome));
			psNome = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return psNome;
	}

	public static String getPsCbo() {
		String psCbo = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPsCbo));
			psCbo = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return psCbo;
	}

	public static String getPsCr() {
		String psCr = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPsCr));
			psCr = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return psCr;
	}

	public static String getFdDtProducao() {
		String fdDtProducao = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idFdDtProducao));
			fdDtProducao = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return fdDtProducao;
	}

	public static String getFdID() {
		String fdID = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idFdID));
			fdID = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return fdID;
	}

	public static String getFolha_folID() {
		String folha_folID = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idFolha_folID));
			folha_folID = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return folha_folID;
	}

	public static String getProcedimentos_proCodigo() {
		String procedimentos_proCodigo = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idProcedimentos_proCodigo));
			procedimentos_proCodigo = rec.substring(rec.indexOf('=') + 1, rec
					.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return procedimentos_proCodigo;
	}

	public static String getPacientes_pcCns() {
		String pacientes_pcCns = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idPacientes_pcCns));
			pacientes_pcCns = rec.substring(rec.indexOf('=') + 1, rec.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return pacientes_pcCns;
	}

	public static String getProfissinalSaude_psCns() {
		String profissinalSaude_psCns = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idProfissinalSaude_psCns));
			profissinalSaude_psCns = rec.substring(rec.indexOf('=') + 1, rec
					.length());

		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return profissinalSaude_psCns;
	}

	// private static int idProcedimentos_proCodigo;
	// private static int idPacientes_pcCns;
	// private static int idProfissinalSaude_psCns;

	/**
	 * Procura o login no record store
	 * 
	 * @return
	 */
	public static String getArrayDeNomes() {
		String nomes = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idArrayDeNomes));
			nomes = rec.substring(rec.indexOf('=') + 1, rec.length());
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeRecord();
			} catch (RecordStoreNotOpenException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RecordStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return nomes;
	}

	public void setParametros(List lista) {
		// TODO Auto-generated method stub

	}

}
