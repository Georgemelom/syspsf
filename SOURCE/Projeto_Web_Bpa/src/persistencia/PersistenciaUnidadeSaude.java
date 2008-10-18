package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.entidades.UnidadeSaude;

public class PersistenciaUnidadeSaude {

	public static UnidadeSaude incluir(UnidadeSaude unidadeSaudeNova) {
		Connection con = GerenciadorConexao.getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into unidadesaude("+" nome, sexo, dataNascimento) values (?,?,?)");
			
			stmt.setString(1, unidadeSaudeNova.getUsNome());
			stmt.setString(2, unidadeSaudeNova.getUsSigla());
			//stmt.setString(2, unidadeSaudeNova.getUsCnpj());
			stmt.setString(2, unidadeSaudeNova.getUsNomeSecretaria());
			stmt.setString(2, unidadeSaudeNova.getUsTipoOrgao());
			stmt.setString(1, unidadeSaudeNova.getUsNome());
			stmt.setString(1, unidadeSaudeNova.getUsNome());
			
			
			stmt.execute();
			stmt.close();
			
			unidadeSaudeNova.setIdUnidadeSaude(obterUltimoId(con));
			
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return unidadeSaudeNova;
		
	}

	private static Integer obterUltimoId(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT MAX(IDPESSOA) AS ULTIMO FROM PESSOA");
		rs.next();
		return rs.getInt("ULTIMO");
	}

	public static ArrayList<UnidadeSaude> listar(UnidadeSaude unidadeSaudeParam) {
		Connection con = GerenciadorConexao.getConexao();
		ArrayList<UnidadeSaude> unidadeSaudeEncontradas = new ArrayList<UnidadeSaude>();
		try {
			String sql = "Select * from pessoa";
			String where = "";
			ArrayList<Object> params = new ArrayList<Object>();
			if (unidadeSaudeParam.getUsNome() != null ){
				where += " where nome like '" + unidadeSaudeParam.getUsNome()+ "%'";
				params.add(unidadeSaudeParam.getUsNome());
			}
			
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery(sql+where);
			
			while (rs.next()){
				UnidadeSaude unidadeSaude =  recuperarUnidadeSaudeDoResultSet(rs);
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

	public static UnidadeSaude detalhar(Integer idUnidadeSaude) {
		Connection con = GerenciadorConexao.getConexao();
		UnidadeSaude paciente = null;
		
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * from pessoa where idPessoa = ?");
			stmt.setInt(1, idUnidadeSaude);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			paciente =  recuperarUnidadeSaudeDoResultSet(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}

	private static UnidadeSaude recuperarUnidadeSaudeDoResultSet(ResultSet rs) throws SQLException {
		UnidadeSaude unidadeSaude =  new UnidadeSaude();
		
		unidadeSaude.setIdUnidadeSaude(rs.getInt("idUnidadeSaude"));
		unidadeSaude.setUsNome(rs.getString("nome"));
		unidadeSaude.setUsNome(rs.getString("nome"));
		unidadeSaude.setUsNome(rs.getString("nome"));
		unidadeSaude.setUsNome(rs.getString("nome"));
		
		return unidadeSaude;
	}

}
