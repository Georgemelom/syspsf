//package form;
//
//import javax.microedition.lcdui.Form;
//import javax.microedition.lcdui.TextField;
//
//import list.ListaPc;
//
//import record.RecordPaciente;
//
//
//public class EditFormPc extends Form {
//		
//	private RecordPaciente paciente;
//	private TextField pcCnsFld = new TextField("Paciente: ", "", 3,	TextField.ANY);
//	private TextField pcNomeFld = new TextField("Folha: ", "", 3,TextField.ANY);
//	private TextField pcDtNasFld = new TextField("Cod.Proc: ", "", 6,TextField.ANY);
//	private TextField pcSexoFld = new TextField("Paciente:", "", 6,TextField.ANY);
//	private TextField pcEnderecoFld = new TextField("Profissional: ", "", 6,TextField.ANY);
//	
//	private static EditFormPc instance;
//	public static EditFormPc getInstance(String title) {
//		if (instance == null) {
//			instance = new EditFormPc(title);
//		}
//		return instance;
//	}
//
//	public EditFormPc(String title) {
//		super("Editar Paciente");
//		
//		append(pcCnsFld);
//		append(pcNomeFld);
//		append(pcDtNasFld);
//		append(pcSexoFld);
//		append(pcEnderecoFld);
//		
//	}
//
//	public void setPaciente(RecordPaciente c)// envia para a classe conta
//	{
//		paciente = c;
//		pcCnsFld.setString(paciente.pcCns);
//		pcNomeFld.setString(paciente.pcNome);
//		pcDtNasFld.setString(paciente.pcDtNasc);
//		pcSexoFld.setString(paciente.pcSexo);
//		pcEnderecoFld.setString(paciente.pcEndereco);
//	}
//
//	public RecordPaciente getPaciente()// atribui para a classe conta
//	{
//		paciente.pcCns = pcCnsFld.getString();
//		paciente.pcNome = pcNomeFld.getString();
//		paciente.pcDtNasc = pcDtNasFld.getString();
//		paciente.pcSexo = pcSexoFld.getString();
//		paciente.pcEndereco = pcEnderecoFld.getString();
//		return paciente;
//	}
//}
