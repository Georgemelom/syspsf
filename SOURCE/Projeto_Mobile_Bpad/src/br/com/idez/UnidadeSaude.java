package br.com.idez;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;

import java.util.*;

public class UnidadeSaude extends MIDlet implements CommandListener {
	Command addCmd = new Command("Nova Unidade", Command.SCREEN, 1);
	Command selectCmd = new Command("Visualizar", Command.ITEM, 1);
	Command exitCmd = new Command("Sair", Command.EXIT, 1);

	Command saveCmd = new Command("Salvar", Command.SCREEN, 1);
	Command deleteCmd = new Command("Remover", Command.SCREEN, 1);
	Command cancelCmd = new Command("Cancelar", Command.SCREEN, 1);

	Command searchCmd = new Command("Buscar", Command.SCREEN, 1);

	List list = new List("Unidades", List.IMPLICIT);
	EditFormUs form = new EditFormUs();
	SearchFormUs searchForm = new SearchFormUs();

	NameComparatorUs orderby = new NameComparatorUs();
	NameFilterUs nameFilter = new NameFilterUs(orderby);

	private Unit[] currentUnitList;

	public UnidadeSaude() {
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
		currentUnitList = Unit.list(orderby, nameFilter);
		for (int ccnt = 0; ccnt < currentUnitList.length; ccnt++) {
			String name = currentUnitList[ccnt].usCnes;
			list.append(name + " " + currentUnitList[ccnt].usNome, null);
		}
		Display.getDisplay(this).setCurrent(list);
	}

	private void showForm(Unit c) {
		form.setUnit(c);
		Display.getDisplay(this).setCurrent(form);
	}

	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
			destroyApp(true);
			notifyDestroyed();
		} else if ((d == list) && (cmd == addCmd)) {
			form.setUnit(new Unit());
			Display.getDisplay(this).setCurrent(form);
		} else if ((d == form) && (cmd == saveCmd)) {
			Unit c = form.getUnit();
			c.store();
			refreshList();
		} else if ((d == list) && (cmd == selectCmd)) {
			showForm(currentUnitList[list.getSelectedIndex()]);
		} else if ((d == form) && (cmd == deleteCmd)) {
			form.getUnit().delete();
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

class NameFilterUs implements RecordFilter {
	String criteria;
	NameComparatorUs orderby;

	NameFilterUs(NameComparatorUs orderby) {
		this.orderby = orderby;
	}

	public boolean matches(byte[] candidate) {
		if ((criteria == null) || (criteria.length() == 0)) {
			return true;
		} else
			return new Unit(candidate).usCnes.startsWith(criteria);
	}
}

class NameComparatorUs implements RecordComparator {

	public int compare(byte[] rec1, byte[] rec2) {
		Unit c1 = new Unit(rec1);
		Unit c2 = new Unit(rec2);

		String s1 = c1.usCnes;
		String s2 = c2.usCnes;

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

class ChangeNotifier implements RecordListener {
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

class SearchFormUs extends Form {
	private TextField searchField = new TextField("Buscar: ", "", 6,
			TextField.ANY);

	public SearchFormUs() {
		super("Criterio de Busca");
		append(searchField);
	}

	public String getCriteria() {
		return searchField.getString();
	}
}

class EditFormUs extends Form {
	private Unit unit;
	private TextField usCnesFld = new TextField("CNES: ", "", 6,TextField.ANY);
	private TextField cidade_ciSilgaFld = new TextField("Cidade: ", "", 4,TextField.ANY);
	private TextField usNomeFld = new TextField("Nome: ", "", 20,TextField.ANY);
	private TextField usSiglaFld = new TextField("PSF: ", "", 4,TextField.ANY);
	private TextField usRazaoSocialFld = new TextField("Razao: ", "", 20,TextField.ANY);
	private TextField usCnpjFld = new TextField("CNPJ: ", "", 15,TextField.ANY);
	private TextField usEnderecoFld = new TextField("Endereço: ", "", 20,TextField.ANY);
	
	
	public EditFormUs() {
		super("Editar Unidade");
		append(usCnesFld);
		append(cidade_ciSilgaFld);
		append(usNomeFld);
		append(usSiglaFld);
		append(usRazaoSocialFld);
		append(usCnpjFld);
		append(usEnderecoFld);
	}

	public void setUnit(Unit c)// envia para a classe conta
	{
		unit = c;
		usCnesFld.setString(unit.usCnes);
		cidade_ciSilgaFld.setString(unit.cidade_ciSigla);
		usNomeFld.setString(unit.usNome);
		usSiglaFld.setString(unit.usSigla);
		usRazaoSocialFld.setString(unit.usRazaoSocial);
		usCnpjFld.setString(unit.usCnpj);
		usEnderecoFld.setString(unit.usEndereco);
	}

	public Unit getUnit()// atribui para a classe conta
	{
		unit.usCnes = usCnesFld.getString();
		unit.cidade_ciSigla = cidade_ciSilgaFld.getString();
		unit.usNome = usNomeFld.getString();
		unit.usSigla = usSiglaFld.getString();
		unit.usRazaoSocial = usRazaoSocialFld.getString();
		unit.usCnpj = usCnpjFld.getString();
		unit.usEndereco = usEnderecoFld.getString();
		
		return unit;
	}
}

class Unit// cria o arquivo,le,
{
	private static final String storeName = "UnidadeDB";

	String usCnes;
	String cidade_ciSigla;
	String usNome;
	String usSigla;
	String usRazaoSocial;
	String usCnpj;
	String usEndereco;
	
	private int id = -1;// uma variavel para armazenar a
	// posição,ou seja, na hora de ler o registro

	public Unit() {
		id = -1;
	}

	public Unit(int id) {
		this.id = id;
	}

	public Unit(byte[] data)// cria um registro por dados em bytes
	{
		populate(data);
	}

	public static Unit[] list(RecordComparator orderby,
			RecordFilter nameFilter) {
		Vector v = new Vector();
		try {
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			RecordEnumeration e = rs.enumerateRecords(nameFilter, orderby,
					false);
			while (e.hasNextElement()) {
				int id = e.nextRecordId();
				Unit c = new Unit(id);
				c.populate(rs.getRecord(id));
				v.addElement(c);
			}
			rs.closeRecordStore();
		} catch (RecordStoreException x) {
			x.printStackTrace();
			return null;
		}
		Unit[] rtn = new Unit[v.size()];
		v.copyInto(rtn);
		return rtn;
	}

	public static Unit[] listByUsNome() {
		return null;
	}

	public static Unit[] list() {
		return null;
	}

	public void store() {
		try {
			byte[] data = toBytes();
			RecordStore rs = RecordStore.openRecordStore(storeName, true);
			rs.addRecordListener(new ChangeNotifier());
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
		usCnes = s.substring(0, idx);

		int idx2 = s.indexOf("/", idx + 1);
		cidade_ciSigla = s.substring(idx + 1, idx2);
		
		int idx3 = s.indexOf("/", idx2 + 1);
		usNome = s.substring(idx2 + 1);
		
		int idx4 = s.indexOf("/", idx3 + 1);
		usSigla = s.substring(idx3 + 1);
		
		int idx5 = s.indexOf("/", idx4 + 1);
		usRazaoSocial = s.substring(idx4 + 1);
		
		int idx6 = s.indexOf("/", idx5 + 1);
		usCnpj = s.substring(idx5 + 1);
		
	//	int idx7 = s.indexOf("/", idx6 + 1);
		usEndereco = s.substring(idx6 + 1);
		
	}

	public String toString() {
		return (usCnes+ "/" + cidade_ciSigla + "/" + usNome + "/" + usSigla + "/" + usRazaoSocial + "/" + usCnpj + "/" + usEndereco);
	}
}
