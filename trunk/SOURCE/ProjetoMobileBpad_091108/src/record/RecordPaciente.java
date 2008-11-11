package record;

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.List;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

import list.ListaPc;

import form.PacienteForm;

public class RecordPaciente {

	// coleção de registros
	private static RecordStore rs;
	private static RecordPaciente paciente;
	private static final String storeName = "RecordPc1";

	public static String pcCns;
	public static String pcNome;
	public static String pcDtNasc;
	public static String pcSexo;
	public static String pcEndereco;
	private static int id = -1;// uma variavel para armazenar a

	// posição,ou seja, na hora de ler o registro
	// registros

	/**
	 * Método que abre o record store "dadosPc"
	 * 
	 * @throws RecordStoreFullException
	 * @throws RecordStoreNotFoundException
	 * @throws RecordStoreException
	 */
	private static void openRecord() throws RecordStoreFullException,
			RecordStoreNotFoundException, RecordStoreException {
		rs = RecordStore.openRecordStore("RecordPc1", true);
	}

	/**
	 * Método que fecha o record store "dadosPc" se ele tiver sido aberto
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
			listaPc();
			store();
			populatePc(null);
			delete();
			openRecord();

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

	public void setParametros(List lista) {
		// TODO Auto-generated method stub

	}

	public void setPaciente(RecordPaciente c)// envia para a classe conta
	{
		paciente = c;
		PacienteForm.pcCnsFld.setString(c.pcCns);
		PacienteForm.pcNomeFld.setString(c.pcNome);
		PacienteForm.pcDtNasFld.setString(c.pcDtNasc);
		PacienteForm.pcSexoFld.setString(c.pcSexo);
		PacienteForm.pcEnderecoFld.setString(c.pcEndereco);
	}

	public static RecordPaciente getPaciente()// atribui para a classe conta
	{
		pcCns = PacienteForm.pcCnsFld.getString();
		pcNome = PacienteForm.pcNomeFld.getString();
		pcDtNasc = PacienteForm.pcDtNasFld.getString();
		pcSexo = PacienteForm.pcSexoFld.getString();
		pcEndereco = PacienteForm.pcEnderecoFld.getString();
		return paciente;
	}

	public RecordPaciente() {
		id = -1;
	}

	public RecordPaciente(int id) {
		RecordPaciente.id = id;
	}

	public RecordPaciente(byte[] dataPc)// cria um registro por dados em bytes
	{
		populatePc(dataPc);
	}

	public static RecordPaciente[] listaPc(RecordComparator orderby,
			RecordFilter nameFilter) {
		Vector v = new Vector();
		try {
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			RecordEnumeration e = rs.enumerateRecords(nameFilter, orderby,
					false);
			while (e.hasNextElement()) {
				int id = e.nextRecordId();
				RecordPaciente c = new RecordPaciente(id);
				RecordPaciente.populatePc(rs.getRecord(id));
				v.addElement(c);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
			return null;
		}
		RecordPaciente[] rtn = new RecordPaciente[v.size()];
		v.copyInto(rtn);
		return rtn;
	}

	public static RecordPaciente[] listByLastName() {
		return null;
	}

	public static RecordPaciente[] listaPc() {
		return null;
	}

	public static void store() {
		try {
			byte[] dataPc = toBytes();
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			rs.addRecordListener(new ChangeNotifierFd());
			if (id < 0) {
				rs.addRecord(dataPc, 0, dataPc.length);
			} else {
				rs.setRecord(id, dataPc, 0, dataPc.length);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
		}
	}

	public static void delete() {
		if (id >= 0) {
			try {
				RecordStore rs = RecordStore.openRecordStore(storeName, false);
				rs.deleteRecord(id);
				rs.closeRecordStore();
			} catch (RecordStoreException x) {
				x.printStackTrace();
			}
		} else {
			throw new RuntimeException("Registro Invalido id " + id);
		}
	}

	private static byte[] toBytes() {
		return separaCampos().getBytes();
	}

	private static void populatePc(byte[] dataPc) {

		String s = new String(dataPc);

		int idx = s.indexOf("|");
		pcCns = s.substring(0, idx);

		int idx2 = s.indexOf("|", idx + 1);
		pcNome = s.substring(idx + 1, idx2);

		int idx3 = s.indexOf("|", idx2 + 1);
		pcDtNasc = s.substring(idx2 + 1, idx3);

		int idx4 = s.indexOf("|", idx3 + 1);
		pcSexo = s.substring(idx3 + 1, idx4);

		pcEndereco = s.substring(idx4 + 1);

	}

	public static String separaCampos() {
		return (pcCns + "|" + pcNome + "|" + pcDtNasc + "|" + pcSexo + "|" + pcEndereco);
	}

}
