package Tela_InfPessoal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnOracle {

	//

	public static void main(String[] args) throws SQLException {

		Connection conexao = obterconexao();

		Statement statement = conexao.createStatement();
		String query = "SELECT instance_name FROM v$instance";

		ResultSet resultSet = statement.executeQuery(query);

/*
		if (resultSet.next()) {
			System.out.println(resultSet.getNString("instance_name"));

		}
*/
	}

	public static Connection obterconexao() {
		try {
			// Connection conexao = null;
			String driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			//return DriverManager.getConnection("jdbc:oracle:thin:@VSMS-7851C7EL:1521:XE", "vsms", "vsms0132");
			return DriverManager.getConnection("jdbc:oracle:thin:@vsmsdb_high", "admin", "VsMs%%0132%%");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return obterconexao();

	}

	//
}
