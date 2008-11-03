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

public class RmsPaciente extends MIDlet implements CommandListener {
	Command addCmd = new Command("Novo Paciente", Command.SCREEN, 1);
	Command selectCmd = new Command("Visualizar", Command.ITEM, 1);
	Command exitCmd = new Command("Sair", Command.EXIT, 1);

	Command saveCmd = new Command("Salvar", Command.SCREEN, 1);
	Command deleteCmd = new Command("Remover", Command.SCREEN, 1);
	Command cancelCmd = new Command("Cancelar", Command.SCREEN, 1);

	Command searchCmd = new Command("Buscar", Command.SCREEN, 1);

	List listaPc = new List("Pacientes", List.IMPLICIT);
	EditFormPc formPc = new EditFormPc();
	SearchFormPc searchFormPc = new SearchFormPc();

	NameComparatorPc orderby = new NameComparatorPc();
	NameFilterPc nameFilter = new NameFilterPc(orderby);

	private Paciente[] currentPacienteList;
	private static RmsPaciente instance;

	public RmsPaciente() {
		formPc.addCommand(saveCmd);
		formPc.addCommand(cancelCmd);
		formPc.addCommand(deleteCmd);
		formPc.setCommandListener(this);

		searchFormPc.addCommand(searchCmd);
		searchFormPc.setCommandListener(this);

		listaPc.addCommand(searchCmd);
		listaPc.addCommand(addCmd);
		listaPc.addCommand(exitCmd);
		listaPc.setSelectCommand(selectCmd);
		listaPc.setCommandListener(this);

	}

	public void startApp() {
		refreshList();
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unc) {
	}

	private void refreshList() {
		listaPc.deleteAll();
		currentPacienteList = Paciente.listaPc(orderby, nameFilter);
		for (int ccnt = 0; ccnt < currentPacienteList.length; ccnt++) {
			String name = currentPacienteList[ccnt].pcCns;
			listaPc.append(name + " " + currentPacienteList[ccnt].pcNome,null);
		}
		Display.getDisplay(this).setCurrent(listaPc);
	}

	private void showForm(Paciente c) {
		formPc.setPaciente(c);
		Display.getDisplay(this).setCurrent(formPc);
	}

	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
			destroyApp(true);
			notifyDestroyed();
		} else if ((d == listaPc) && (cmd == addCmd)) {
			formPc.setPaciente(new Paciente());
			Display.getDisplay(this).setCurrent(formPc);
		} else if ((d == formPc) && (cmd == saveCmd)) {
			Paciente c = formPc.getPaciente();
			c.store();
			refreshList();
		} else if ((d == listaPc) && (cmd == selectCmd)) {
			showForm(currentPacienteList[listaPc.getSelectedIndex()]);
		} else if ((d == formPc) && (cmd == deleteCmd)) {
			formPc.getPaciente().delete();
			refreshList();
		} else if ((d == formPc) && (cmd == deleteCmd)) {
			refreshList();
		} else if ((d == listaPc) && (cmd == searchCmd)) {
			Display.getDisplay(this).setCurrent(searchFormPc);
		} else if ((d == searchFormPc) && (cmd == searchCmd)) {
			nameFilter.criteria = searchFormPc.getCriteria();
			refreshList();
		} else if ((d == formPc) && (cmd == cancelCmd)) {
			refreshList();
		}
	}

	public static RmsPaciente getInstance(String title) {
		if (instance == null) {
			instance = new RmsPaciente();
		}
		return instance;
	}
}

class NameFilterPc implements RecordFilter {
	String criteria;
	NameComparatorPc orderby;

	NameFilterPc(NameComparatorPc orderby) {
		this.orderby = orderby;
	}

	public boolean matches(byte[] candidate) {
		if ((criteria == null) || (criteria.length() == 0)) {
			return true;
		} else
			return new Paciente(candidate).pcCns.startsWith(criteria);
	}
}

class NameComparatorPc implements RecordComparator {

	public int compare(byte[] rec1, byte[] rec2) {
		Paciente c1 = new Paciente(rec1);
		Paciente c2 = new Paciente(rec2);

		String s1 = c1.pcCns;
		String s2 = c2.pcCns;

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

class ChangeNotifierPc implements RecordListener {
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

class SearchFormPc extends Form {
	private TextField searchField = new TextField("Buscar: ", "", 15,TextField.ANY);

	public SearchFormPc() {
		super("Criterio de Busca");
		append(searchField);
	}

	public String getCriteria() {
		return searchField.getString();
	}
}

class EditFormPc extends Form {
	private Paciente paciente;
	private TextField pcCnsFld = new TextField("CNS: ", "", 6,	TextField.ANY);
	private TextField pcNomeFld = new TextField("Paciente: ", "", 20,TextField.ANY);
	private TextField pcDtNascFld = new TextField("Data Nasc.: ", "", 10,TextField.ANY);
	private TextField pcSexoFld = new TextField("Sexo:", "", 1,TextField.ANY);
	private TextField pcEnderecoFld = new TextField("Endereco: ", "", 20,TextField.ANY);
	

	public EditFormPc() {
		super("Editar Paciente");
		append(pcCnsFld);
		append(pcNomeFld);
		append(pcDtNascFld);
		append(pcSexoFld);
		append(pcEnderecoFld);
		
	}

	public void setPaciente(Paciente c)// envia para a classe conta
	{
		paciente = c;
		pcCnsFld.setString(paciente.pcCns);
		pcNomeFld.setString(paciente.pcNome);
		pcDtNascFld.setString(paciente.pcDtNasc);
		pcSexoFld.setString(paciente.pcSexo);
		pcEnderecoFld.setString(paciente.pcEndereco);
	}

	public Paciente getPaciente()// atribui para a classe conta
	{
		paciente.pcCns = pcCnsFld.getString();
		paciente.pcNome = pcNomeFld.getString();
		paciente.pcDtNasc = pcDtNascFld.getString();
		paciente.pcSexo = pcSexoFld.getString();
		paciente.pcEndereco = pcEnderecoFld.getString();
		return paciente;
	}
}

class Paciente// cria o arquivo,le,
{
	private static final String storeName = "RecordPc";

	String pcCns;
	String pcNome;
	String pcDtNasc;
	String pcSexo;
	String pcEndereco;
	private int id = -1;// uma variavel para armazenar a
	// posição,ou seja, na hora de ler o registro

	public Paciente() {
		id = -1;
	}

	public Paciente(int id) {
		this.id = id;
	}

	public Paciente(byte[] dataPc)// cria um registro por dados em bytes
	{
		populateFd(dataPc);
	}

	public static Paciente[] listaPc(RecordComparator orderby,
			RecordFilter nameFilter) {
		Vector v = new Vector();
		try {
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			RecordEnumeration e = rs.enumerateRecords(nameFilter, orderby,
					false);
			while (e.hasNextElement()) {
				int id = e.nextRecordId();
				Paciente c = new Paciente(id);
				c.populateFd(rs.getRecord(id));
				v.addElement(c);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
			return null;
		}
		Paciente[] rtn = new Paciente[v.size()];
		v.copyInto(rtn);
		return rtn;
	}

	public static Paciente[] listByLastName() {
		return null;
	}

	public static Paciente[] listaPc() {
		return null;
	}

	public void store() {
		try {
			byte[] dataPc = toBytes();
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			rs.addRecordListener(new ChangeNotifierPc());
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

	private void populateFd(byte[] dataPc) {

		String s = new String(dataPc);

		int idx = s.indexOf("|");
		pcCns = s.substring(0, idx);

		int idx2 = s.indexOf("|", idx + 1);
		pcNome = s.substring(idx + 1, idx2);

		int idx3 = s.indexOf("|", idx2 + 1);
		pcDtNasc = s.substring(idx2 + 1,idx3);
		
		int idx4 = s.indexOf("|", idx3 + 1);
		pcSexo = s.substring(idx3 + 1,idx4);
		
		pcEndereco = s.substring(idx4 + 1);
		
	}

	public String toString() {
		return (pcCns + "|" + pcNome+ "|" + pcDtNasc +"|"+pcSexo+"|"+pcEndereco );
	}
}
