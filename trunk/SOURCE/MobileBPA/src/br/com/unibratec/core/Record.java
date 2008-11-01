package br.com.unibratec.core;

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
			if (idUsCnes!= 0) {// registro já existe
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
			if (idCidade_ciSigla!= 0) {// registro já existe
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
			if (idUsNome!= 0) {// registro já existe
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
			if (idUsSigla!= 0) {// registro já existe
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
			if (idUsRazaoSocial!= 0) {// registro já existe
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
			if (idUsCnpj!= 0) {// registro já existe
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
			if (idUsEndereco!= 0) {// registro já existe
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

	public static  String getIdUsCnes() {
		String usCnes = "";
		try {
			// abre o registro
			openRecord();
			String rec = new String(rs.getRecord(idUsCnes));
			usCnes = rec.substring(rec.indexOf('=') + 1, rec.length());

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

	public static  String getIdCidade_ciSigla() {
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

	public static  String getIdUsNome() {
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

	public static  String getIdUsSigla() {
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

	public static  String getIdUsRazaoSocial() {
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

	public static  String getIdUsCnpj() {
		String usCnpj= "";
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

	public static  String getIdUsEndereco() {
		String usEndereco= "";
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
