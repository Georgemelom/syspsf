package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.entidades.FichaDiaria;
import excecoes.PadraoException;

public class PersistenciaFichaDiaria {

	public static FichaDiaria cadastrar(FichaDiaria fichaDiariaNova) {
		Connection con = GerenciadorConexao.getConexao();
		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO bpad.fichadiaria" +
							"(fdID, procedimentos_proCodigo, pacientes_pcCns, profissionalSaude_psCns, fdDtProducao) " +
							"VALUES (?,?,?,?,?)");

			stmt.setString(1, String.valueOf(fichaDiariaNova.getFdID()));
			// Integer i = Integer.parseInt("123");
//			stmt.setString(2, fichaDiariaNova.getFolha_FoID());
			stmt.setString(2, fichaDiariaNova.getProcedimentos_proCodigo());
			stmt.setString(3, fichaDiariaNova.getPacientes_pcCns());
			stmt.setString(4, fichaDiariaNova.getProfissionalSaude_psCns());
			stmt.setDate(5, new java.sql.Date(fichaDiariaNova
					.getFdDtProducao().getTime()));
		
			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fichaDiariaNova;

	}

	public static ArrayList<FichaDiaria> listar(FichaDiaria fichaDiariaParam) {
		Connection con = GerenciadorConexao.getConexao();
		ArrayList<FichaDiaria> fichaDiariaEncontradas = new ArrayList<FichaDiaria>();
		try {
			String sql = "SELECT * FROM bpad.fichadiaria ";
			String where = "";
			ArrayList<Object> params = new ArrayList<Object>();
			if ((fichaDiariaParam.getFdID() != null ) ||(fichaDiariaParam.getProcedimentos_proCodigo() != null)){
				where = "WHERE";

				if (fichaDiariaParam.getFdID() != null) {
					where += " fdID LIKE '" + fichaDiariaParam.getFdID()
							+ "%'";

				}
				if (fichaDiariaParam.getProcedimentos_proCodigo() != null) {
					where += " procedimentos_proCodigo LIKE '" + fichaDiariaParam.getProcedimentos_proCodigo()
							+ "%'";
				}
					
			}
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql + where);

			while (rs.next()) {
				FichaDiaria fichaDiaria = recuperarFichaDiariaDoResultSet(rs);
				fichaDiariaEncontradas.add(fichaDiaria);
			}

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fichaDiariaEncontradas;
	}

	public static FichaDiaria detalhar(FichaDiaria fdIDFichaDiaria) throws PadraoException {
		Connection con = GerenciadorConexao.getConexao();
		FichaDiaria fichaDiaria = null;

		try {
			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM bpad.fichadiaria WHERE fdID = ?");
			stmt.setString(1, fdIDFichaDiaria.getFdID().toString());

			ResultSet rs = stmt.executeQuery();
			rs.next();
			fichaDiaria = recuperarFichaDiariaDoResultSet(rs);

		} catch (SQLException e) {
			throw new PadraoException("Erro na consulta : " 
					+ e.getMessage());
		}
		return fichaDiaria;
	}

	private static FichaDiaria recuperarFichaDiariaDoResultSet(ResultSet rs)
			throws SQLException {
		FichaDiaria fichaDiaria = new FichaDiaria();

		fichaDiaria.setFdID(Integer.valueOf(rs.getString("fdID")));
		fichaDiaria.setProcedimentos_proCodigo(rs.getString("procedimentos_proCodigo"));
		fichaDiaria.setPacientes_pcCns(rs.getString("pacientes_pcCns"));
		fichaDiaria.setProfissionalSaude_psCns(rs.getString("profissionalSaude_psCns"));
		fichaDiaria.setFdDtProducao(new java.util.Date(rs.getDate(
		"fdDtProducao").getTime()));
	
		return fichaDiaria;
	}

	
	public static FichaDiaria atualizar(FichaDiaria usUpdate) {
		Connection con = GerenciadorConexao.getConexao();

		try {
			PreparedStatement stmt = con
					.prepareStatement
					("UPDATE bpad.fichadiaria SET "
							+ "fdID = ?, " 
							+ "procedimentos_proCodigo = ?, " 
							+ "pacientes_pcCns = ?, "
							+ "profissionalSaude_psCns = ?,"
							+ "fdDtProducao = ? " +
									"WHERE fdID = ?");
						
			stmt.setString(1, String.valueOf(usUpdate.getFdID()));
			// Integer i = Integer.parseInt("123");
			stmt.setString(2, usUpdate.getProcedimentos_proCodigo());
			stmt.setString(3, usUpdate.getPacientes_pcCns());
			stmt.setString(4, usUpdate.getProfissionalSaude_psCns());
			stmt.setDate(5, new java.sql.Date(usUpdate
					.getFdDtProducao().getTime()));
			stmt.setString(6, String.valueOf(usUpdate.getFdID()));
			

			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usUpdate;

	}

}
