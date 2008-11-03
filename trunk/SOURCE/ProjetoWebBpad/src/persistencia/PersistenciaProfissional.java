package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.entidades.Profissional;
import excecoes.PadraoException;

public class PersistenciaProfissional {

	public static Profissional cadastrar(Profissional profissionalNovo) {
		Connection con = GerenciadorConexao.getConexao();
		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO bpad.profissionalsaude" +
							"(psCns, cbo_Cbo, conselhos_conselho, unidadeSaude_usCnes, psNome, psCpf, psTelefone) " +
							"VALUES (?,?,?,?,?,?,?)");

			stmt.setString(1, String.valueOf(profissionalNovo.getPsCns()));
			// Integer i = Integer.parseInt("123");
			stmt.setString(2, profissionalNovo.getCbo_Cbo());
			stmt.setString(3, profissionalNovo.getConselhos_conselho());
			stmt.setString(4, profissionalNovo.getUnidadeSaude_usCnes());
			stmt.setString(5, profissionalNovo.getPsNome());
			stmt.setString(6, profissionalNovo.getPsCpf());
			stmt.setString(7, profissionalNovo.getPsTelefone());

			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profissionalNovo;

	}

	public static ArrayList<Profissional> listar(Profissional profissionalParam) {
		Connection con = GerenciadorConexao.getConexao();
		ArrayList<Profissional> profissionalEncontrado = new ArrayList<Profissional>();
		try {
			String sql = "SELECT * FROM bpad.profissionalsaude ";
			String where = "";
			ArrayList<Object> params = new ArrayList<Object>();
			
			if ((profissionalParam.getPsCns() != null ) ||(profissionalParam.getPsNome() != null) || (profissionalParam.getPsCpf() != null) ){
				where = "WHERE";

				if (profissionalParam.getPsCns()!= null) {
					where += " psCns LIKE '" + profissionalParam.getPsCns()
							+ "%'";

				}
				if (profissionalParam.getPsNome() != null) {
					where += " psNome LIKE '" + profissionalParam.getPsNome()
							+ "%'";
				}
				if (profissionalParam.getPsCpf() != null) {
						where += " psCpf LIKE '" + profissionalParam.getPsCpf()
								+ "%'";
				}	
					
			}
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql + where);

			while (rs.next()) {
				Profissional profissional = recuperarProfissionalDoResultSet(rs);
				profissionalEncontrado.add(profissional);
			}

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return profissionalEncontrado;
	}

	public static Profissional detalhar(Profissional psCnsProfissional) throws PadraoException {
		Connection con = GerenciadorConexao.getConexao();
		Profissional profissional = null;
		
		try {
			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM bpad.profissionalsaude WHERE psCns = ?");
			stmt.setString(1, psCnsProfissional.getPsCns().toString());

			ResultSet rs = stmt.executeQuery();
			rs.next();
			profissional = recuperarProfissionalDoResultSet(rs);

		} catch (SQLException e) {
			throw new PadraoException("Erro na consulta de detalhar profissional: " 
					+ e.getMessage());
		}
		return profissional;
	}

	private static Profissional recuperarProfissionalDoResultSet(ResultSet rs)
			throws SQLException {
		Profissional profissional = new Profissional();

		profissional.setPsCns(Integer.valueOf(rs.getString("psCns")));
		profissional.setCbo_Cbo(rs.getString("cbo_Cbo"));
		profissional.setConselhos_conselho(rs.getString("conselhos_conselho"));
		profissional.setUnidadeSaude_usCnes(rs.getString("unidadeSaude_usCnes"));
		profissional.setPsNome(rs.getString("psNome"));
		profissional.setPsCpf(rs.getString("psCpf"));
		profissional.setPsTelefone(rs.getString("psTelefone"));

		return profissional;
	}

	
	public static Profissional atualizar(Profissional psUpdate) {
		Connection con = GerenciadorConexao.getConexao();

		try {
			PreparedStatement stmt = con
					.prepareStatement
					("UPDATE bpad.profissional SET "
							+ "psCns = ?, " + "cbo_Cbo = ?, "
							+ "conselhos_conselho = ?, " + "unidadeSaude_usCnes = ?, "
							+ "psNome = ?, " + "psCpf = ?, "
							+ "psTelefone = ? "
							+ "WHERE psCns = ?");
						
			stmt.setString(1, String.valueOf(psUpdate.getPsCns()));
			// Integer i = Integer.parseInt("123");
			stmt.setString(2, psUpdate.getCbo_Cbo());
			stmt.setString(3, psUpdate.getConselhos_conselho());
			stmt.setString(4, psUpdate.getUnidadeSaude_usCnes());
			stmt.setString(5, psUpdate.getPsNome());
			stmt.setString(6, psUpdate.getPsCpf());
			stmt.setString(7, psUpdate.getPsTelefone());
			stmt.setString(8, String.valueOf(psUpdate.getPsCns()));


			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return psUpdate;

	}

}
