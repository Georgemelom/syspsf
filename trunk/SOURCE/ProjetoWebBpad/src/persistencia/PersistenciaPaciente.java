package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.entidades.Paciente;
import excecoes.PadraoException;

public class PersistenciaPaciente {

	public static Paciente cadastrar(Paciente pacienteNovo) {
		Connection con = GerenciadorConexao.getConexao();
		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO bpad.pacientes"
							+ "(pcCns, pcNome, pcDataNascimento, pcSexo, pcEndereco) "
							+ "VALUES (?,?,?,?,?)");

			stmt.setString(1, String.valueOf(pacienteNovo.getPcCns()));
			// Integer i = Integer.parseInt("123");
			stmt.setString(2, pacienteNovo.getPcNome());
			stmt.setDate(3, new java.sql.Date(pacienteNovo
					.getPcDataNascimento().getTime()));
			stmt.setString(4, pacienteNovo.getPcSexo());
			stmt.setString(5, pacienteNovo.getPcEndereco());

			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pacienteNovo;

	}

	public static ArrayList<Paciente> listar(Paciente pacienteParam) {
		Connection con = GerenciadorConexao.getConexao();
		ArrayList<Paciente> pacienteEncontrado = new ArrayList<Paciente>();
		try {
			String sql = "SELECT * FROM bpad.pacientes ";
			String where = "";
			ArrayList<Object> params = new ArrayList<Object>();
			if ((pacienteParam.getPcCns() != null)
					|| (pacienteParam.getPcNome() != null)
					|| (pacienteParam.getPcSexo() != null)) {
				where = "WHERE";

				if (pacienteParam.getPcCns() != null) {
					where += " pcCns LIKE '" + pacienteParam.getPcCns() + "%'";

				}
				if (pacienteParam.getPcNome() != null) {
					where += " getPcNome LIKE '" + pacienteParam.getPcNome()

					+ "%'";
				}
				if (pacienteParam.getPcSexo() != null) {
					where += " getPcSexo LIKE '" + pacienteParam.getPcSexo()
							+ "%'";
				}

			}

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql + where);

			while (rs.next()) {
				Paciente paciente = recuperarPacienteDoResultSet(rs);
				pacienteEncontrado.add(paciente);
			}

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pacienteEncontrado;
	}

	public static Paciente detalhar(Paciente psCnsPaciente)
			throws PadraoException {
		Connection con = GerenciadorConexao.getConexao();
		Paciente paciente = null;

		try {
			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM bpad.pacientes WHERE pcCns = ?");
			stmt.setString(1, psCnsPaciente.getPcCns().toString());

			ResultSet rs = stmt.executeQuery();
			rs.next();
			paciente = recuperarPacienteDoResultSet(rs);

		} catch (SQLException e) {
			throw new PadraoException(
					"Erro na consulta de detalhar pacientes: " + e.getMessage());
		}
		return paciente;
	}

	private static Paciente recuperarPacienteDoResultSet(ResultSet rs)
			throws SQLException {
		Paciente paciente = new Paciente();

		paciente.setPcCns(Integer.valueOf(rs.getString("pcCns")));
		paciente.setPcNome(rs.getString("pcNome"));
		paciente.setPcDataNascimento(new java.util.Date(rs.getDate(
				"pcDataNascimento").getTime()));
		paciente.setPcSexo(rs.getString("pcSexo"));
		paciente.setPcEndereco(rs.getString("pcEndereco"));

		return paciente;
	}

	public static Paciente atualizar(Paciente pcUpdate) {
		Connection con = GerenciadorConexao.getConexao();
		
		try {
			PreparedStatement stmt = con
					.prepareStatement
					("UPDATE bpad.pacientes SET " +
							"pcCns = ?, " +
							"pcNome = ?, " +
							"pcDataNascimento = ?, " +
							"pcSexo = ?, " +
							"pcEndereco = ? " +
							"WHERE pcCns = ?");

			stmt.setString(1, String.valueOf(pcUpdate.getPcCns()));
			// Integer i = Integer.parseInt("123");
			stmt.setString(2, pcUpdate.getPcNome());
			stmt.setDate(3, new java.sql.Date(pcUpdate
					.getPcDataNascimento().getTime()));
			stmt.setString(4, pcUpdate.getPcSexo());
			stmt.setString(5, pcUpdate.getPcEndereco());
			stmt.setString(6, String.valueOf(pcUpdate.getPcCns()));


			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pcUpdate;

	}

}
