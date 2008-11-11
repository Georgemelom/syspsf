package midlet;

import java.util.Vector;

import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

import record.ChangeNotifierFd;

public class Ficha// cria o arquivo,le,
{
	private static final String storeName = "RecordFd1";

	public String fdID;
	public String folha_FolID;
	public String procedimentos_proCodigo;
	public String pacientes_pcCns;
	public String profissionaisSaude_psCns;
	private int id = -1;// uma variavel para armazenar a
	// posição,ou seja, na hora de ler o registro

	public Ficha() {
		id = -1;
	}

	public Ficha(int id) {
		this.id = id;
	}

	public Ficha(byte[] dataFd)// cria um registro por dados em bytes
	{
		populateFd(dataFd);
	}

	public static Ficha[] listaFd(RecordComparator orderby,
			RecordFilter nameFilter) {
		Vector v = new Vector();
		try {
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			RecordEnumeration e = rs.enumerateRecords(nameFilter, orderby,
					false);
			while (e.hasNextElement()) {
				int id = e.nextRecordId();
				Ficha c = new Ficha(id);
				c.populateFd(rs.getRecord(id));
				v.addElement(c);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
			return null;
		}
		Ficha[] rtn = new Ficha[v.size()];
		v.copyInto(rtn);
		return rtn;
	}

	public static Ficha[] listByLastName() {
		return null;
	}

	public static Ficha[] listaFd() {
		return null;
	}

	public void store() {
		try {
			byte[] dataFd = toBytes();
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			rs.addRecordListener(new ChangeNotifierFd());
			if (id < 0) {
				rs.addRecord(dataFd, 0, dataFd.length);
			} else {
				rs.setRecord(id, dataFd, 0, dataFd.length);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
		}
	}

	public void delete() {
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

	private byte[] toBytes() {
		return toString().getBytes();
	}

	private void populateFd(byte[] dataFd) {

		String s = new String(dataFd);

		int idx = s.indexOf("|");
		fdID = s.substring(0, idx);

		int idx2 = s.indexOf("|", idx + 1);
		folha_FolID = s.substring(idx + 1, idx2);

		int idx3 = s.indexOf("|", idx2 + 1);
		procedimentos_proCodigo = s.substring(idx2 + 1,idx3);
		
		int idx4 = s.indexOf("|", idx3 + 1);
		pacientes_pcCns = s.substring(idx3 + 1,idx4);
		
		profissionaisSaude_psCns = s.substring(idx4 + 1);
		
	}

	public String toString() {
		return (fdID + "|" + folha_FolID+ "|" + procedimentos_proCodigo +"|"+pacientes_pcCns+"|"+profissionaisSaude_psCns );
	}
}
