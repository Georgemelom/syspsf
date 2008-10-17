package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.entidades.Paciente;

public class PersistenciaPaciente {

	public static Paciente incluir(Paciente pacienteNovo) {
		Connection con = GerenciadorConexao.getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into pessoa(" 
					+ "nome, sexo, dataNascimento) values (?,?,?)");
			stmt.setString(1, pacienteNovo.getNome());
			stmt.setInt(2, pacienteNovo.getSexo());
			stmt.setDate(3, new java.sql.Date(
					pacienteNovo.getDataNascimento().getTime()));
			
			stmt.execute();
			stmt.close();
			
			pacienteNovo.setIdPaciente(obterUltimoId(con));
			
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pacienteNovo;
		
	}

	private static Integer obterUltimoId(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT MAX(IDPESSOA) AS ULTIMO FROM PESSOA");
		rs.next();
		return rs.getInt("ULTIMO");
	}

	public static ArrayList<Paciente> listar(Paciente pacienteParam) {
		Connection con = GerenciadorConexao.getConexao();
		ArrayList<Paciente> pacientesEncontrados = new ArrayList<Paciente>();
		try {
			String sql = "Select * from pessoa";
			String where = "";
			ArrayList<Object> params = new ArrayList<Object>();
			if (pacienteParam.getNome() != null ){
				where += " where nome like '" + pacienteParam.getNome()+ "%'";
				params.add(pacienteParam.getNome());
			}
			
			if (pacienteParam.getSexo() != null) {
				if (where == "") {
					where =" where sexo = "+ pacienteParam.getSexo();
				} else {
					where += " and sexo = "+ pacienteParam.getSexo();
				}
				params.add(pacienteParam.getSexo());
			}
			if (pacienteParam.getDataNascimento() != null) {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				if (where == "") {
					where =" where datanascimento = '" + formato.format(
							pacienteParam.getDataNascimento()) + "'";
				} else {
					where += " and datanascimento = '" + formato.format(
							pacienteParam.getDataNascimento()) + "'";
				}
				params.add(new java.sql.Date(
						pacienteParam.getDataNascimento().getTime()));
			}
			Statement stmt = con.createStatement();
			

			ResultSet rs =  stmt.executeQuery(sql+where);
			
			while (rs.next()){
				Paciente paciente =  recuperarPacienteDoResultSet(rs);
				pacientesEncontrados.add(paciente);
			}
			
			stmt.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pacientesEncontrados;
	}

	public static Paciente detalhar(Integer idPaciente) {
		Connection con = GerenciadorConexao.getConexao();
		Paciente paciente = null;
		
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * from pessoa where idPessoa = ?");
			stmt.setInt(1, idPaciente);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			paciente =  recuperarPacienteDoResultSet(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}

	private static Paciente recuperarPacienteDoResultSet(ResultSet rs) throws SQLException {
		Paciente paciente =  new Paciente();
		paciente.setIdPaciente(rs.getInt("idPaciente"));
		paciente.setNome(rs.getString("nome"));
		paciente.setDataNascimento(new java.util.Date(
				rs.getDate("dataNascimento").getTime()));
		paciente.setSexo(rs.getInt("sexo"));
		return paciente;
	}

}
