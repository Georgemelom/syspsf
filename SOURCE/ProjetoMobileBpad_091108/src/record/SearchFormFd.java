package record;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public class SearchFormFd extends Form {
	private TextField searchField = new TextField("Buscar: ", "", 15,TextField.ANY);

	public SearchFormFd() {
		super("Criterio de Busca");
		append(searchField);
	}

	public String getCriteria() {
		return searchField.getString();
	}
}
