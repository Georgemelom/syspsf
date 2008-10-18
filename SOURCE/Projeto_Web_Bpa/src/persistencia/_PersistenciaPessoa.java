package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.entidades._Pessoa;

public class _PersistenciaPessoa {

	public static _Pessoa incluir(_Pessoa pessoaNova) {
		Connection con = GerenciadorConexao.getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into pessoa(" 
					+ "nome, sexo, dataNascimento) values (?,?,?)");
			stmt.setString(1, pessoaNova.getNome());
			stmt.setInt(2, pessoaNova.getSexo());
			stmt.setDate(3, new java.sql.Date(
					pessoaNova.getDataNascimento().getTime()));
			
			stmt.execute();
			stmt.close();
			
			pessoaNova.setIdPessoa(obterUltimoId(con));
			
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pessoaNova;
		
	}

	private static Integer obterUltimoId(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT MAX(IDPESSOA) AS ULTIMO FROM PESSOA");
		rs.next();
		return rs.getInt("ULTIMO");
	}

	public static ArrayList<_Pessoa> listar(_Pessoa pessoaParam) {
		Connection con = GerenciadorConexao.getConexao();
		ArrayList<_Pessoa> pessoasEncontradas = new ArrayList<_Pessoa>();
		try {
			String sql = "Select * from pessoa";
			String where = "";
			ArrayList<Object> params = new ArrayList<Object>();
			if (pessoaParam.getNome() != null ){
				where += " where nome like '" + pessoaParam.getNome()+ "%'";
				params.add(pessoaParam.getNome());
			}
			
			if (pessoaParam.getSexo() != null) {
				if (where == "") {
					where =" where sexo = "+ pessoaParam.getSexo();
				} else {
					where += " and sexo = "+ pessoaParam.getSexo();
				}
				params.add(pessoaParam.getSexo());
			}
			if (pessoaParam.getDataNascimento() != null) {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				if (where == "") {
					where =" where datanascimento = '" + formato.format(
							pessoaParam.getDataNascimento()) + "'";
				} else {
					where += " and datanascimento = '" + formato.format(
							pessoaParam.getDataNascimento()) + "'";
				}
				params.add(new java.sql.Date(
						pessoaParam.getDataNascimento().getTime()));
			}
			Statement stmt = con.createStatement();
			

			ResultSet rs =  stmt.executeQuery(sql+where);
			
			while (rs.next()){
				_Pessoa pessoa =  recuperarPessoaDoResultSet(rs);
				pessoasEncontradas.add(pessoa);
			}
			
			stmt.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pessoasEncontradas;
	}

	public static _Pessoa detalhar(Integer idPessoa) {
		Connection con = GerenciadorConexao.getConexao();
		_Pessoa pessoa = null;
		
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * from pessoa where idPessoa = ?");
			stmt.setInt(1, idPessoa);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			pessoa =  recuperarPessoaDoResultSet(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoa;
	}

	private static _Pessoa recuperarPessoaDoResultSet(ResultSet rs) throws SQLException {
		_Pessoa pessoa =  new _Pessoa();
		pessoa.setIdPessoa(rs.getInt("idPessoa"));
		pessoa.setNome(rs.getString("nome"));
		pessoa.setDataNascimento(new java.util.Date(
				rs.getDate("dataNascimento").getTime()));
		pessoa.setSexo(rs.getInt("sexo"));
		return pessoa;
	}

}
