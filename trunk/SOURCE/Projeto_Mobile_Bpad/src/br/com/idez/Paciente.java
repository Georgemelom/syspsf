package br.com.idez;

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

public class Paciente extends MIDlet implements CommandListener {
	Command addCmd = new Command("Novo Paciente", Command.SCREEN, 1);
	Command selectCmd = new Command("Visualizar", Command.ITEM, 1);
	Command exitCmd = new Command("Sair", Command.EXIT, 1);

	Command saveCmd = new Command("Salvar", Command.SCREEN, 1);
	Command deleteCmd = new Command("Remover", Command.SCREEN, 1);
	Command cancelCmd = new Command("Cancelar", Command.SCREEN, 1);

	Command searchCmd = new Command("Buscar", Command.SCREEN, 1);

	List list = new List("Pacientes", List.IMPLICIT);
	EditFormPc form = new EditFormPc();
	SearchFormPc searchForm = new SearchFormPc();

	NameComparatorPc orderby = new NameComparatorPc();
	NameFilterPc nameFilter = new NameFilterPc(orderby);

	private Patient[] currentUnitList;

	public Paciente() {
		form.addCommand(saveCmd);
		form.addCommand(cancelCmd);
		form.addCommand(deleteCmd);
		form.setCommandListener(this);

		searchForm.addCommand(searchCmd);
		searchForm.setCommandListener(this);

		list.addCommand(searchCmd);
		list.addCommand(addCmd);
		list.addCommand(exitCmd);
		list.setSelectCommand(selectCmd);
		list.setCommandListener(this);

	}

	public void startApp() {
		refreshList();
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unc) {
	}

	private void refreshList() {
		list.deleteAll();
		currentUnitList = Patient.list(orderby, nameFilter);
		for (int ccnt = 0; ccnt < currentUnitList.length; ccnt++) {
			String name = currentUnitList[ccnt].pcCns;
			list.append(name + " " + currentUnitList[ccnt].pcNome, null);
		}
		Display.getDisplay(this).setCurrent(list);
	}

	private void showForm(Patient c) {
		form.setPatient(c);
		Display.getDisplay(this).setCurrent(form);
	}

	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
			destroyApp(true);
			notifyDestroyed();
		} else if ((d == list) && (cmd == addCmd)) {
			form.setPatient(new Patient());
			Display.getDisplay(this).setCurrent(form);
		} else if ((d == form) && (cmd == saveCmd)) {
			Patient c = form.getPatient();
			c.store();
			refreshList();
		} else if ((d == list) && (cmd == selectCmd)) {
			showForm(currentUnitList[list.getSelectedIndex()]);
		} else if ((d == form) && (cmd == deleteCmd)) {
			form.getPatient().delete();
			refreshList();
		} else if ((d == form) && (cmd == deleteCmd)) {
			refreshList();
		} else if ((d == list) && (cmd == searchCmd)) {
			Display.getDisplay(this).setCurrent(searchForm);
		} else if ((d == searchForm) && (cmd == searchCmd)) {
			nameFilter.criteria = searchForm.getCriteria();
			refreshList();
		} else if ((d == form) && (cmd == cancelCmd)) {
			refreshList();
		}
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
			return new Patient(candidate).pcCns.startsWith(criteria);
	}
}

class NameComparatorPc implements RecordComparator {

	public int compare(byte[] rec1, byte[] rec2) {
		Patient c1 = new Patient(rec1);
		Patient c2 = new Patient(rec2);

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
			System.out.println("Added a record to " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}

	public void recordChanged(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Changed a record in " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}

	public void recordDeleted(RecordStore recordStore, int recordId) {
		try {
			System.out.println("Deleted record from " + recordStore.getName()
					+ " id=" + recordId);
		} catch (RecordStoreNotOpenException x) {
			x.printStackTrace();
		}
	}
}

class SearchFormPc extends Form {
	private TextField searchField = new TextField("Buscar: ", "", 6,TextField.ANY);

	public SearchFormPc() {
		super("Criterio de Busca");
		append(searchField);
	}

	public String getCriteria() {
		return searchField.getString();
	}
}

class EditFormPc extends Form {
	private Patient patient;
	private TextField usCnesFld = new TextField("CNS: ", "", 6,TextField.ANY);
	private TextField pcNomeFld = new TextField("Nome: ", "", 20,TextField.ANY);
	private TextField pcDataNascimentoFld = new TextField("Dt. Nasc.: ", "", 10,TextField.ANY);
	private TextField pcSexoFld = new TextField("Sexo: ", "", 1,TextField.ANY);
	private TextField pcEnderecoFld = new TextField("Endereço: ", "", 20,TextField.ANY);

	
	public EditFormPc() {
		super("Editar Paciente");
		append(usCnesFld);
		append(pcNomeFld);
		append(pcDataNascimentoFld);
		append(pcSexoFld);
		append(pcEnderecoFld);
	}

	public void setPatient(Patient c)// envia para a classe conta
	{
		patient = c;
		usCnesFld.setString(patient.pcCns);
		pcNomeFld.setString(patient.pcNome);
		pcDataNascimentoFld.setString(patient.pcDataNascimento);
		pcSexoFld.setString(patient.pcSexo);
		pcEnderecoFld.setString(patient.pcEndereco);
	}

	public Patient getPatient()// atribui para a classe conta
	{
		patient.pcCns = usCnesFld.getString();
		patient.pcNome = pcNomeFld.getString();
		patient.pcDataNascimento = pcDataNascimentoFld.getString();
		patient.pcSexo = pcSexoFld.getString();
		patient.pcEndereco = pcEnderecoFld.getString();
		
		return patient;
	}
}

class Patient// cria o arquivo,le,
{
	private static final String storeName = "PacienteDB";

	String pcCns;
	String pcNome;
	String pcDataNascimento;
	String pcSexo;
	String pcEndereco;

	
	private int id = -1;// uma variavel para armazenar a
	// posição,ou seja, na hora de ler o registro

	public Patient() {
		id = -1;
	}

	public Patient(int id) {
		this.id = id;
	}

	public Patient(byte[] data)// cria um registro por dados em bytes
	{
		populate(data);
	}

	public static Patient[] list(RecordComparator orderby,
			RecordFilter nameFilter) {
		Vector v = new Vector();
		try {
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			RecordEnumeration e = rs.enumerateRecords(nameFilter, orderby,
					false);
			while (e.hasNextElement()) {
				int id = e.nextRecordId();
				Patient c = new Patient(id);
				c.populate(rs.getRecord(id));
				v.addElement(c);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
			return null;
		}
		Patient[] rtn = new Patient[v.size()];
		v.copyInto(rtn);
		return rtn;
	}

	public static Patient[] listByPcNome() {
		return null;
	}

	public static Patient[] list() {
		return null;
	}

	public void store() {
		try {
			byte[] data = toBytes();
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			rs.addRecordListener(new ChangeNotifierPc());
			if (id < 0) {
				rs.addRecord(data, 0, data.length);
			} else {
				rs.setRecord(id, data, 0, data.length);
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
			throw new RuntimeException("Invalid record id " + id);
		}
	}

	private byte[] toBytes() {
		return toString().getBytes();
	}

	private void populate(byte[] data) {

		String s = new String(data);

		int idx = s.indexOf("/");
		pcCns = s.substring(0, idx);

		int idx2 = s.indexOf("/", idx + 1);
		pcNome = s.substring(idx + 1, idx2);
		
		int idx3 = s.indexOf("/", idx2 + 1);
		pcDataNascimento = s.substring(idx2 + 1);
		
		int idx4 = s.indexOf("/", idx3 + 1);
		pcSexo = s.substring(idx3 + 1);
		
		//int idx5 = s.indexOf("/", idx4 + 1);
		pcEndereco = s.substring(idx4 + 1);
	}

	public String toString() {
		return (pcCns + "/" + pcNome + "/" + pcDataNascimento + "/" + pcSexo + "/" + pcEndereco);
	}
}
