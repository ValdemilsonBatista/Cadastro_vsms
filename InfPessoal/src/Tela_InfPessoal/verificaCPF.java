package InfPessoalClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import InfPessoalClasses.validaCPF;



	public class verificaCPF {
	
		

	public static void main(String[] args) {
		
		Connection conexao = ConnOracle.obterconexao();

		String query = "select cpf from vsms_tb02 where cpf=?";

		PreparedStatement stm;
		try {
			stm = conexao.prepareStatement(query);
			ResultSet rs = null;
			rs = stm.executeQuery();
			//String cp = (rs.getString("cpf"));
			//cp = (rs.getString("cpf"));
			
			conexao.close();
			stm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
		public static void isCPF(String cp) {
			if (cp.isBlank()) {
				JOptionPane.showMessageDialog(null, "Informe CPF!!!.");
			} else

			//if (cp != (rs.getString("cpf"))) {
			//	JOptionPane.showMessageDialog(null, "CPF não cadastrado.");
			//} else
			
			return;
	}
}

