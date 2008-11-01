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

public class Profissional extends MIDlet implements CommandListener {
	Command addCmd = new Command("Novo Profissional", Command.SCREEN, 1);
	Command selectCmd = new Command("Visualizar", Command.ITEM, 1);
	Command exitCmd = new Command("Sair", Command.EXIT, 1);

	Command saveCmd = new Command("Salvar", Command.SCREEN, 1);
	Command deleteCmd = new Command("Remover", Command.SCREEN, 1);
	Command cancelCmd = new Command("Cancelar", Command.SCREEN, 1);

	Command searchCmd = new Command("Buscar", Command.SCREEN, 1);

	List list = new List("Profissionais", List.IMPLICIT);
	EditFormPs form = new EditFormPs();
	SearchFormPs searchForm = new SearchFormPs();

	NameComparatorPs orderby = new NameComparatorPs();
	NameFilterPs nameFilter = new NameFilterPs(orderby);

	private Professional[] currentUnitList;

	public Profissional() {
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
		currentUnitList = Professional.list(orderby, nameFilter);
		for (int ccnt = 0; ccnt < currentUnitList.length; ccnt++) {
			String name = currentUnitList[ccnt].psCns;
			list.append(name + " " + currentUnitList[ccnt].psNome, null);
		}
		Display.getDisplay(this).setCurrent(list);
	}

	private void showForm(Professional c) {
		form.setProfessional(c);
		Display.getDisplay(this).setCurrent(form);
	}

	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
			destroyApp(true);
			notifyDestroyed();
		} else if ((d == list) && (cmd == addCmd)) {
			form.setProfessional(new Professional());
			Display.getDisplay(this).setCurrent(form);
		} else if ((d == form) && (cmd == saveCmd)) {
			Professional c = form.getProfessional();
			c.store();
			refreshList();
		} else if ((d == list) && (cmd == selectCmd)) {
			showForm(currentUnitList[list.getSelectedIndex()]);
		} else if ((d == form) && (cmd == deleteCmd)) {
			form.getProfessional().delete();
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

class NameFilterPs implements RecordFilter {
	String criteria;
	NameComparatorPs orderby;

	NameFilterPs(NameComparatorPs orderby) {
		this.orderby = orderby;
	}

	public boolean matches(byte[] candidate) {
		if ((criteria == null) || (criteria.length() == 0)) {
			return true;
		} else
			return new Professional(candidate).psCns.startsWith(criteria);
	}
}

class NameComparatorPs implements RecordComparator {

	public int compare(byte[] rec1, byte[] rec2) {
		Professional c1 = new Professional(rec1);
		Professional c2 = new Professional(rec2);

		String s1 = c1.psCns;
		String s2 = c2.psCns;

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

class ChangeNotifierPs implements RecordListener {
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

class SearchFormPs extends Form {
	private TextField searchField = new TextField("Buscar: ", "", 6,TextField.ANY);

	public SearchFormPs() {
		super("Criterio de Busca");
		append(searchField);
	}

	public String getCriteria() {
		return searchField.getString();
	}
}

class EditFormPs extends Form {
	private Professional professional;
	private TextField psCnsFld = new TextField("CNS : ", "", 6,TextField.ANY);
	private TextField cbo_CboFld = new TextField("CBO : ", "", 6,TextField.ANY);
	private TextField conselhos_ConselhoFld = new TextField("CR : ", "", 10,TextField.ANY);
	private TextField unidadeSaude_usCnesFld = new TextField("PSF : ", "", 6,TextField.ANY);
	private TextField psNomeFld = new TextField("Nome : ", "", 20,TextField.ANY);
	private TextField psCpfFld = new TextField("CPF : ", "", 14,TextField.ANY);
	private TextField psTelefoneFld = new TextField("Telefone : ", "", 10,TextField.ANY);

	
	public EditFormPs() {
		super("Editar Profissional");
		append(psCnsFld);
		append(cbo_CboFld);
		append(conselhos_ConselhoFld);
		append(unidadeSaude_usCnesFld);
		append(psNomeFld);
		append(psCpfFld);
		append(psTelefoneFld);
		}

	public void setProfessional(Professional c)// envia para a classe conta
	{
		professional = c;
		psCnsFld.setString(professional.psCns);
		cbo_CboFld.setString(professional.cbo_Cbo);
		conselhos_ConselhoFld.setString(professional.conselhos_Conselho);
		unidadeSaude_usCnesFld.setString(professional.unidadeSaude_usCnes);
		psNomeFld.setString(professional.psNome);
		psCpfFld.setString(professional.psCpf);
		psTelefoneFld.setString(professional.psTelefone);
	}

	public Professional getProfessional()// atribui para a classe conta
	{
		professional.psCns = psCnsFld.getString();
		professional.cbo_Cbo = cbo_CboFld.getString();
		professional.conselhos_Conselho = conselhos_ConselhoFld.getString();
		professional.unidadeSaude_usCnes = unidadeSaude_usCnesFld.getString();
		professional.psNome = psNomeFld.getString();
		professional.psCpf = psCpfFld.getString();
		professional.psTelefone = psTelefoneFld.getString();
		
		return professional;
	}
}

class Professional// cria o arquivo,le,
{
	private static final String storeName = "ProfissionalDB";

	String psCns;
	String cbo_Cbo;
	String conselhos_Conselho;
	String unidadeSaude_usCnes;
	String psNome;
	String psCpf;
	String psTelefone;
		
	private int id = -1;// uma variavel para armazenar a
	// posição,ou seja, na hora de ler o registro

	public Professional() {
		id = -1;
	}

	public Professional(int id) {
		this.id = id;
	}

	public Professional(byte[] data)// cria um registro por dados em bytes
	{
		populate(data);
	}

	public static Professional[] list(RecordComparator orderby,
			RecordFilter nameFilter) {
		Vector v = new Vector();
		try {
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			RecordEnumeration e = rs.enumerateRecords(nameFilter, orderby,
					false);
			while (e.hasNextElement()) {
				int id = e.nextRecordId();
				Professional c = new Professional(id);
				c.populate(rs.getRecord(id));
				v.addElement(c);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
			return null;
		}
		Professional[] rtn = new Professional[v.size()];
		v.copyInto(rtn);
		return rtn;
	}

	public static Professional[] listByPcNome() {
		return null;
	}

	public static Professional[] list() {
		return null;
	}

	public void store() {
		try {
			byte[] data = toBytes();
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			rs.addRecordListener(new ChangeNotifierPs());
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
		psCns = s.substring(0, idx);

		int idx2 = s.indexOf("/", idx + 1);
		cbo_Cbo = s.substring(idx + 1, idx2);
		
		int idx3 = s.indexOf("/", idx2 + 1);
		conselhos_Conselho = s.substring(idx2 + 1);
		
		int idx4 = s.indexOf("/", idx3 + 1);
		unidadeSaude_usCnes = s.substring(idx3 + 1);
		
		int idx5 = s.indexOf("/", idx4 + 1);
		psNome = s.substring(idx4 + 1);
		
		int idx6 = s.indexOf("/", idx5 + 1);
		psCpf = s.substring(idx5 + 1);
		
		//int idx7 = s.indexOf("/", idx6 + 1);
		psTelefone = s.substring(idx4 + 1);
	}

	public String toString() {
		return (psCns+ "/" +cbo_Cbo+ "/" +conselhos_Conselho+ "/" +unidadeSaude_usCnes+ "/" +psNome+ "/" +psCpf+ "/" + psTelefone);
	}
}
