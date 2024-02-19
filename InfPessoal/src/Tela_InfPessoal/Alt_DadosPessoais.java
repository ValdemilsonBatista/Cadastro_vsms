package Tela_InfPessoal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Tela_InfPessoal.ConnOracle;
import Tela_InfPessoal.validaCPF;


public class Alt_DadosPessoais extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textPai;
	private JTextField textMae;
	private JTextField textCPF;
	private JTextField EstadoCivil;
	private JTextField Sexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alt_DadosPessoais frame = new Alt_DadosPessoais();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public Alt_DadosPessoais() throws ParseException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Altera\u00E7\u00E3o Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCPF.setBounds(23, 27, 45, 13);
		contentPane.add(lblCPF);

		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.BOLD, 12));
		textCPF.setBounds(100, 26, 155, 19);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 55, 45, 13);
		contentPane.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(100, 54, 320, 22);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblPai = new JLabel("Pai");
		lblPai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPai.setBounds(23, 84, 45, 13);
		contentPane.add(lblPai);

		textPai = new JTextField();
		textPai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPai.setBounds(100, 83, 320, 22);
		contentPane.add(textPai);
		textPai.setColumns(10);

		JLabel lblM�e = new JLabel("M\u00E3e");
		lblM�e.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblM�e.setBounds(23, 113, 45, 13);
		contentPane.add(lblM�e);

		textMae = new JTextField();
		textMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMae.setBounds(100, 112, 320, 22);
		contentPane.add(textMae);
		textMae.setColumns(10);

		JLabel lblDataNasc = new JLabel("Data Nasc.");
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataNasc.setBounds(23, 151, 85, 13);
		contentPane.add(lblDataNasc);

		JFormattedTextField formattedDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formattedDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedDataNasc.setBounds(100, 147, 70, 22);
		contentPane.add(formattedDataNasc);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstadoCivil.setBounds(192, 151, 86, 13);
		contentPane.add(lblEstadoCivil);
		;

		EstadoCivil = new JTextField();
		EstadoCivil.setBounds(282, 147, 132, 22);
		contentPane.add(EstadoCivil);
		EstadoCivil.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setBounds(23, 180, 35, 13);
		contentPane.add(lblSexo);

		Sexo = new JTextField();
		Sexo.setBounds(100, 178, 20, 22);
		contentPane.add(Sexo);
		Sexo.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(192, 180, 65, 13);
		contentPane.add(lblTelefone);

		JFormattedTextField formattedTextTelefone = new JFormattedTextField(new MaskFormatter("(##)#########"));
		formattedTextTelefone.setBounds(282, 178, 85, 22);
		contentPane.add(formattedTextTelefone);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			verificaCPF.isCPF(textCPF.getText());

			try {
					Connection conexao = ConnOracle.obterconexao();
					String query = "update vsms_tb02 set cpf=?, nome=?, pai=?, mae=?, data_nasc=?, estado_civil=?, sexo=?, telefone=? where cpf=?";
					PreparedStatement statement = conexao.prepareStatement(query);
					statement.setString(1, textCPF.getText());
					if (validaCPF.isCPF(textCPF.getText()) == true) {
						String sql = "Select * FROM vsms_tb02 where cpf = ?";
						PreparedStatement stm = conexao.prepareStatement(sql);
						stm.setString(1, textCPF.getText());
						//O ResultSet rs recebe os dados da consulta
						ResultSet rs = null;
						String cp = textCPF.getText();
						rs = stm.executeQuery("Select cpf FROM vsms_tb02");
						rs.next();
						//
								statement.setString(2, textNome.getText());
								statement.setString(3, textPai.getText());
								statement.setString(4, textMae.getText());
								statement.setString(5, formattedDataNasc.getText());
								statement.setString(6, EstadoCivil.getText());
								statement.setString(7, Sexo.getText());
								statement.setString(8, formattedTextTelefone.getText());
								statement.execute();
								statement.close();
								conexao.close();
								JOptionPane.showInternalMessageDialog(null, "Cadastrado");
					} else
							JOptionPane.showInternalMessageDialog(null, "Erro, CPF invalido !!!\n");
					
			} catch (SQLException R) {
					R.printStackTrace();
				}
				return;
				}
		});
		
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(29, 303, 85, 21);
		contentPane.add(btnAlterar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
					Tela_Principal tPrincipal = new Tela_Principal();
					tPrincipal.setVisible(true);
					setVisible(false);
			}
		});
		
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBounds(329, 303, 97, 21);
		contentPane.add(btnSair);

		JSeparator separator = new JSeparator();
		separator.setBounds(296, 162, -81, 116);
		contentPane.add(separator);
	}
}
