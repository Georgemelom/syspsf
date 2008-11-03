package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import excecoes.PadraoException;

import modelo.entidades.UnidadeSaude;

public class PersistenciaUnidadeSaude {

	public static UnidadeSaude cadastrar(UnidadeSaude unidadeSaudeNova) {
		Connection con = GerenciadorConexao.getConexao();
		try {
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO bpad.unidadesaude" +
							"(usCnes, cidade_ciSigla, usNome, usSigla, usRazaoSocial, usCnpj, usEndereco) " +
							"VALUES (?,?,?,?,?,?,?)");

			stmt.setString(1, String.valueOf(unidadeSaudeNova.getUsCnes()));
			// Integer i = Integer.parseInt("123");
			stmt.setString(2, unidadeSaudeNova.getCidade_ciSigla());
			stmt.setString(3, unidadeSaudeNova.getUsNome());
			stmt.setString(4, unidadeSaudeNova.getUsSigla());
			stmt.setString(5, unidadeSaudeNova.getUsRazaoSocial());
			stmt.setString(6, unidadeSaudeNova.getUsCnpj());
			stmt.setString(7, unidadeSaudeNova.getUsEndereco());

			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return unidadeSaudeNova;

	}

	public static ArrayList<UnidadeSaude> listar(UnidadeSaude unidadeSaudeParam) {
		Connection con = GerenciadorConexao.getConexao();
		ArrayList<UnidadeSaude> unidadeSaudeEncontradas = new ArrayList<UnidadeSaude>();
		try {
			String sql = "SELECT * FROM bpad.unidadesaude ";
			String where = "";
			ArrayList<Object> params = new ArrayList<Object>();
			if ((unidadeSaudeParam.getUsCnes() != null ) ||(unidadeSaudeParam.getUsNome() != null) || (unidadeSaudeParam.getUsCnpj() != null) ){
				where = "WHERE";

				if (unidadeSaudeParam.getUsCnes() != null) {
					where += " usCnes LIKE '" + unidadeSaudeParam.getUsCnes()
							+ "%'";

				}
				if (unidadeSaudeParam.getUsNome() != null) {
					where += " usNome LIKE '" + unidadeSaudeParam.getUsNome()
				
							+ "%'";
				}
				if (unidadeSaudeParam.getUsCnpj() != null) {
						where += " usNome LIKE '" + unidadeSaudeParam.getUsCnpj()
								+ "%'";
				}	
					
			}
			
				
			
			

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql + where);

			while (rs.next()) {
				UnidadeSaude unidadeSaude = recuperarUnidadeSaudeDoResultSet(rs);
				unidadeSaudeEncontradas.add(unidadeSaude);
			}

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return unidadeSaudeEncontradas;
	}

	public static UnidadeSaude detalhar(UnidadeSaude usCnesUnidadeSaude) throws PadraoException {
		Connection con = GerenciadorConexao.getConexao();
		UnidadeSaude unidadeSaude = null;

		try {
			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM bpad.unidadesaude WHERE UsCnes = ?");
			stmt.setString(1, usCnesUnidadeSaude.getUsCnes().toString());

			ResultSet rs = stmt.executeQuery();
			rs.next();
			unidadeSaude = recuperarUnidadeSaudeDoResultSet(rs);

		} catch (SQLException e) {
			throw new PadraoException("Erro na consulta de detalhar empregado: " 
					+ e.getMessage());
		}
		return unidadeSaude;
	}

	private static UnidadeSaude recuperarUnidadeSaudeDoResultSet(ResultSet rs)
			throws SQLException {
		UnidadeSaude unidadeSaude = new UnidadeSaude();

		unidadeSaude.setUsCnes(Integer.valueOf(rs.getString("usCnes")));
		unidadeSaude.setCidade_ciSigla(rs.getString("cidade_ciSigla"));
		unidadeSaude.setUsNome(rs.getString("usNome"));
		unidadeSaude.setUsSigla(rs.getString("usSigla"));
		unidadeSaude.setUsRazaoSocial(rs.getString("usRazaoSocial"));
		unidadeSaude.setUsCnpj(rs.getString("usCnpj"));
		unidadeSaude.setUsEndereco(rs.getString("usEndereco"));

		return unidadeSaude;
	}

	
	public static UnidadeSaude atualizar(UnidadeSaude usUpdate) {
		Connection con = GerenciadorConexao.getConexao();

		try {
			PreparedStatement stmt = con
					.prepareStatement
					("UPDATE bpad.unidadesaude SET "
							+ "usCnes = ?, " + "cidade_ciSigla = ?, "
							+ "usNome = ?, " + "usSigla = ?, "
							+ "usRazaoSocial = ?, " + "usCnpj = ?, "
							+ "usEndereco = ? "
							+ "WHERE UsCnes = ?");
						
			stmt.setString(1, String.valueOf(usUpdate.getUsCnes()));
			// Integer i = Integer.parseInt("123");
			stmt.setString(2, usUpdate.getCidade_ciSigla());
			stmt.setString(3, usUpdate.getUsNome());
			stmt.setString(4, usUpdate.getUsSigla());
			stmt.setString(5, usUpdate.getUsRazaoSocial());
			stmt.setString(6, usUpdate.getUsCnpj());
			stmt.setString(7, usUpdate.getUsEndereco());
			stmt.setString(8, String.valueOf(usUpdate.getUsCnes()));


			stmt.executeUpdate();
			stmt.close();

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usUpdate;

	}

}
