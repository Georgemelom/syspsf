package midlet;

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordListener;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

public class RmsFicha extends MIDlet implements CommandListener {
	Command addCmd = new Command("Nova Ficha", Command.SCREEN, 1);
	Command selectCmd = new Command("Visualizar", Command.ITEM, 1);
	Command exitCmd = new Command("Sair", Command.EXIT, 1);

	Command saveCmd = new Command("Salvar", Command.SCREEN, 1);
	Command deleteCmd = new Command("Remover", Command.SCREEN, 1);
	Command cancelCmd = new Command("Cancelar", Command.SCREEN, 1);

	Command searchCmd = new Command("Buscar", Command.SCREEN, 1);

	List listaFd = new List("Fichas", List.IMPLICIT);
	EditFormFd formFd = new EditFormFd();
	SearchFormFd searchFormFd = new SearchFormFd();

	NameComparatorFd orderby = new NameComparatorFd();
	NameFilterFd nameFilter = new NameFilterFd(orderby);

	private Ficha[] currentFichaList;

	public RmsFicha() {
		formFd.addCommand(saveCmd);
		formFd.addCommand(cancelCmd);
		formFd.addCommand(deleteCmd);
		formFd.setCommandListener(this);

		searchFormFd.addCommand(searchCmd);
		searchFormFd.setCommandListener(this);

		listaFd.addCommand(searchCmd);
		listaFd.addCommand(addCmd);
		listaFd.addCommand(exitCmd);
		listaFd.setSelectCommand(selectCmd);
		listaFd.setCommandListener(this);

	}

	public void startApp() {
		refreshList();
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unc) {
	}

	private void refreshList() {
		listaFd.deleteAll();
		currentFichaList = Ficha.listaFd(orderby, nameFilter);
		for (int ccnt = 0; ccnt < currentFichaList.length; ccnt++) {
			String name = currentFichaList[ccnt].fdID;
			listaFd.append(name + " " + currentFichaList[ccnt].folha_FolID,null);
		}
		Display.getDisplay(this).setCurrent(listaFd);
	}

	private void showForm(Ficha c) {
		formFd.setFicha(c);
		Display.getDisplay(this).setCurrent(formFd);
	}

	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
			destroyApp(true);
			notifyDestroyed();
		} else if ((d == listaFd) && (cmd == addCmd)) {
			formFd.setFicha(new Ficha());
			Display.getDisplay(this).setCurrent(formFd);
		} else if ((d == formFd) && (cmd == saveCmd)) {
			Ficha c = formFd.getFicha();
			c.store();
			refreshList();
		} else if ((d == listaFd) && (cmd == selectCmd)) {
			showForm(currentFichaList[listaFd.getSelectedIndex()]);
		} else if ((d == formFd) && (cmd == deleteCmd)) {
			formFd.getFicha().delete();
			refreshList();
		} else if ((d == formFd) && (cmd == deleteCmd)) {
			refreshList();
		} else if ((d == listaFd) && (cmd == searchCmd)) {
			Display.getDisplay(this).setCurrent(searchFormFd);
		} else if ((d == searchFormFd) && (cmd == searchCmd)) {
			nameFilter.criteria = searchFormFd.getCriteria();
			refreshList();
		} else if ((d == formFd) && (cmd == cancelCmd)) {
			refreshList();
		}
	}

	public static Displayable getInstance(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

class NameFilterFd implements RecordFilter {
	String criteria;
	NameComparatorFd orderby;

	NameFilterFd(NameComparatorFd orderby) {
		this.orderby = orderby;
	}

	public boolean matches(byte[] candidate) {
		if ((criteria == null) || (criteria.length() == 0)) {
			return true;
		} else
			return new Ficha(candidate).fdID.startsWith(criteria);
	}
}

class NameComparatorFd implements RecordComparator {

	public int compare(byte[] rec1, byte[] rec2) {
		Ficha c1 = new Ficha(rec1);
		Ficha c2 = new Ficha(rec2);

		String s1 = c1.fdID;
		String s2 = c2.fdID;

		if (s1.compareTo(s2) == 0) {
			return RecordComparator.EQUIVALENT;
		} else if (s1.compareTo(s2) > 0) {
			System.out.println(c1 + " then " + c2);
			return RecordComparator.FOLLOWS;
		} else {
			System.out.println(c2 + " then " + c1);
			return RecordComparator.PRECEDES;
		}
	}
}

class ChangeNotifierFd implements RecordListener {
	public void recordAdded(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Adcionado registro para " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}

	public void recordChanged(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Alterado o registro no " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}

	public void recordDeleted(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Deletado registro de " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}
}

class SearchFormFd extends Form {
	private TextField searchField = new TextField("Buscar: ", "", 15,TextField.ANY);

	public SearchFormFd() {
		super("Criterio de Busca");
		append(searchField);
	}

	public String getCriteria() {
		return searchField.getString();
	}
}

class EditFormFd extends Form {
	private Ficha ficha;
	private TextField fdIDFld = new TextField("Ficha: ", "", 3,	TextField.ANY);
	private TextField folha_FolIDFld = new TextField("Folha: ", "", 3,TextField.ANY);
	private TextField procedimentos_proCodigoFld = new TextField("Cod.Proc: ", "", 6,TextField.ANY);
	private TextField pacientes_pcCnsFld = new TextField("Paciente:", "", 6,TextField.ANY);
	private TextField profissionaisSaude_psCnsFld = new TextField("Profissional: ", "", 6,TextField.ANY);
	

	public EditFormFd() {
		super("Editar Ficha");
		append(fdIDFld);
		append(folha_FolIDFld);
		append(procedimentos_proCodigoFld);
		append(pacientes_pcCnsFld);
		append(profissionaisSaude_psCnsFld);
		
	}

	public void setFicha(Ficha c)// envia para a classe conta
	{
		ficha = c;
		fdIDFld.setString(ficha.fdID);
		folha_FolIDFld.setString(ficha.folha_FolID);
		procedimentos_proCodigoFld.setString(ficha.procedimentos_proCodigo);
		pacientes_pcCnsFld.setString(ficha.pacientes_pcCns);
		profissionaisSaude_psCnsFld.setString(ficha.profissionaisSaude_psCns);
	}

	public Ficha getFicha()// atribui para a classe conta
	{
		ficha.fdID = fdIDFld.getString();
		ficha.folha_FolID = folha_FolIDFld.getString();
		ficha.procedimentos_proCodigo = procedimentos_proCodigoFld.getString();
		ficha.pacientes_pcCns = pacientes_pcCnsFld.getString();
		ficha.profissionaisSaude_psCns = profissionaisSaude_psCnsFld.getString();
		return ficha;
	}
}

class Ficha// cria o arquivo,le,
{
	private static final String storeName = "RecordFd1";

	String fdID;
	String folha_FolID;
	String procedimentos_proCodigo;
	String pacientes_pcCns;
	String profissionaisSaude_psCns;
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
