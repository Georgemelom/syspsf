package record;

import javax.microedition.lcdui.List;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

public class RecordLogin {

	// coleção de registros
	private static RecordStore rs;

	// registros
	private static int idLogin;
	private static int idSenha;

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
