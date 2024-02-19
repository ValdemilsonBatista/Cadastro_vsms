package Tela_InfPessoal;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import Tela_InfPessoal.ConnOracle;
import Tela_InfPessoal.validaCPF;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Inc_DadosPessoais extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textNome;
	private JTextField textPai;
	private JTextField textMae;
	private JFormattedTextField formattedTextDataNasc;
	private JTextField EstadoCivil;
	private JTextField Sexo;
	private JFormattedTextField formattedTextTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inc_DadosPessoais frame = new Inc_DadosPessoais();
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
	public Inc_DadosPessoais() throws ParseException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Inclus\u00E3o Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCPF.setBounds(29, 27, 45, 13);
		contentPane.add(lblCPF);

		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.BOLD, 12));
		textCPF.setBounds(94, 26, 155, 19);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(29, 55, 45, 13);
		contentPane.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(94, 54, 320, 22);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblPai = new JLabel("Pai");
		lblPai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPai.setBounds(29, 84, 45, 13);
		contentPane.add(lblPai);

		textPai = new JTextField();
		textPai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPai.setBounds(94, 83, 320, 22);
		contentPane.add(textPai);
		textPai.setColumns(10);

		JLabel lblMae = new JLabel("Mae");
		lblMae.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMae.setBounds(29, 113, 45, 13);
		contentPane.add(lblMae);

		textMae = new JTextField();
		textMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMae.setBounds(95, 112, 320, 22);
		contentPane.add(textMae);
		textMae.setColumns(10);

		JLabel lblDataNasc = new JLabel("Data Nasc.");
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataNasc.setBounds(29, 151, 85, 13);
		contentPane.add(lblDataNasc);
		
		formattedTextDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
        formattedTextDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextDataNasc.setBounds(114, 147, 70, 22);
		contentPane.add(formattedTextDataNasc);

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
		lblSexo.setBounds(10, 180, 86, 13);
		contentPane.add(lblSexo);

		Sexo = new JTextField();
		Sexo.setBounds(114, 178, 20, 22);
		contentPane.add(Sexo);
		Sexo.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(254, 180, 65, 13);
		contentPane.add(lblTelefone);

		formattedTextTelefone = new JFormattedTextField(new MaskFormatter("(##)#########"));
		formattedTextTelefone.setBounds(329, 178, 85, 22);
		contentPane.add(formattedTextTelefone);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection conexao = ConnOracle.obterconexao();
					String query = "insert into admin.vsms_tb02 (cpf, nome, pai, mae, data_nasc, estado_civil, sexo, telefone) values (?,?,?,?,?,?,?,?)";
					PreparedStatement statement = conexao.prepareStatement(query);
					statement.setString(1, textCPF.getText());
					if (validaCPF.isCPF(textCPF.getText()) == true) {
						String sql = "Select CPF FROM admin.vsms_tb02 where CPF = ?";
						PreparedStatement stm = conexao.prepareStatement(sql);
						stm.setString(1, textCPF.getText());
						
						// O ResultSet rs recebe os dados da consulta
						ResultSet rs = null;
						String cp = textCPF.getText();
						rs = stm.executeQuery("Select CPF FROM admin.vsms_tb02");
						
						while (rs.next())
							if (cp.equals(rs.getString("CPF"))) {
								JOptionPane.showMessageDialog(null, "CPF ja esta cadastrado.");
								return;
							} else
						
						// Inserindo dados na tabela	
								
						statement.setString(2, textNome.getText());
						statement.setString(3, textPai.getText());
						statement.setString(4, textMae.getText());
						statement.setString(5, formattedTextDataNasc.getText());
						statement.setString(6, EstadoCivil.getText());
						statement.setString(7, Sexo.getText());
						statement.setString(8, formattedTextTelefone.getText());
						statement.execute();
						statement.close();
						conexao.close();
						JOptionPane.showInternalMessageDialog(null, "Cadastrado");
						limparcampos();

					} else
						JOptionPane.showInternalMessageDialog(null, "Erro, CPF invalido !!!\n");

				} catch (SQLException R) {
					R.printStackTrace();
				}
				return;
			}
		});

		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalvar.setBounds(29, 303, 85, 21);
		contentPane.add(btnSalvar);

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

	public void limparcampos() {

		textCPF.setText("");
		textNome.setText("");
		textPai.setText("");
		textMae.setText("");
		formattedTextDataNasc.setValue(null);
		EstadoCivil.setText("");
		Sexo.setText("");
		formattedTextTelefone.setValue(null);

	}
}
