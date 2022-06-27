package estudandoJDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;

public class principal {

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:estudandoJDBC")) {
//			var ps = conn.prepareStatement();// DOES NOT COMPILE

			criarTabelaPessoa(conn);

//			workingWithCommits(conn);

			fixedInsert(conn);

			parameterInsert(conn);

			select(conn);

//			procedures(conn);
//			proceduresOutParameter(conn);
//			proceduresINOUTParameter(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void workingWithCommits(Connection conn) throws SQLException {
		conn.setAutoCommit(false);
		conn.rollback();

		// You can only use savepoints when you are controlling the transaction.

		Savepoint sp1 = conn.setSavepoint();
		// database code
		Savepoint sp2 = conn.setSavepoint("second savepoint");
		// database code
		conn.rollback(sp2);
		// database code
		conn.rollback(sp1);
	}

	private static void proceduresOutParameter(Connection conn) throws SQLException {
		var sql = "{?= call magic_number(?) }";
//		we include two special characters (?=) to specify that the stored procedure
//		has an output value. This is optional since we have the OUT parameter, 
//		but it does aid in readability.
		CallableStatement cs = conn.prepareCall(sql);
		cs.registerOutParameter(1, Types.INTEGER);
		cs.execute();
		System.out.println(cs.getInt("num"));

	}

	private static void proceduresINOUTParameter(Connection conn) throws SQLException {

		var sql = "{call double_number(?)}";
		var cs = conn.prepareCall(sql);
		cs.setInt(1, 8);
		cs.registerOutParameter(1, Types.INTEGER);
		cs.execute();
		System.out.println(cs.getInt("num"));

	}

	private static void procedures(Connection conn) throws SQLException {
		// aparentemente H2 nao tem stored Procedure
		String sql = "{call batata()}";
		CallableStatement cs = conn.prepareCall(sql);
		ResultSet rs = cs.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(3));
		}
	}

	private static void select(Connection conn) throws SQLException {
		PreparedStatement selectPessoa = conn.prepareStatement(//
				"SELECT * FROM PESSOA");

		ResultSet resultSet = selectPessoa.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			int idade = resultSet.getInt("idade");// or index
			System.out.println(id + " " + nome + " " + idade);
		}
	}

	private static void parameterInsert(Connection conn) throws SQLException {
		String SQL = "INSERT INTO PESSOA VALUES (?,?,?)";

		PreparedStatement parameters = conn.prepareStatement(SQL);
		parameters.setInt(1, 2);
		parameters.setString(2, "maria");
		parameters.setInt(3, 16);
		parameters.executeUpdate();
	}

	private static void fixedInsert(Connection conn) throws SQLException {
		PreparedStatement insertPessoa = conn.prepareStatement(//
				"INSERT INTO PESSOA VALUES (1, 'joao', 15)");
		insertPessoa.executeUpdate();
//		insertPessoa.execute(); //tambem funciona
	}

	private static void criarTabelaPessoa(Connection conn) throws SQLException {
		PreparedStatement createTablePessoa = conn.prepareStatement(//
				"CREATE TABLE PESSOA ("//
						+ "id integer, "//
						+ "nome varchar2,"//
						+ "idade integer)");
		createTablePessoa.execute();
	}

}
