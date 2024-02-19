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



public class Con_DadosPessoais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textPai;
	private JTextField textMae;
	private JFormattedTextField formattedTextDataNasc;
	private JTextField textCPF;
	private JTextField TextEstadoCivil;
	private JTextField TextSexo;
	private JFormattedTextField formattedTextTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Con_DadosPessoais frame = new Con_DadosPessoais();
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
	public Con_DadosPessoais() throws ParseException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Consulta Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCPF.setBounds(23, 28, 45, 13);
		contentPane.add(lblCPF);

		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.BOLD, 12));
		textCPF.setBounds(110, 26, 155, 19);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 55, 45, 13);
		contentPane.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setBounds(110, 55, 320, 22);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblPai = new JLabel("Pai");
		lblPai.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPai.setBounds(23, 84, 45, 13);
		contentPane.add(lblPai);

		textPai = new JTextField();
		textPai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPai.setBounds(110, 83, 320, 22);
		contentPane.add(textPai);
		textPai.setColumns(10);

		JLabel lblMae = new JLabel("M\u00E3e");
		lblMae.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMae.setBounds(23, 113, 45, 13);
		contentPane.add(lblMae);

		textMae = new JTextField();
		textMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMae.setBounds(110, 112, 320, 22);
		contentPane.add(textMae);
		textMae.setColumns(10);

		JLabel lblDataNasc = new JLabel("Data_Nasc");
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataNasc.setBounds(23, 147, 86, 13);
		contentPane.add(lblDataNasc);

		formattedTextDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formattedTextDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextDataNasc.setBounds(110, 144, 76, 22);
		contentPane.add(formattedTextDataNasc);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstadoCivil.setBounds(186, 147, 86, 13);
		contentPane.add(lblEstadoCivil);
		;

		TextEstadoCivil = new JTextField();
		TextEstadoCivil.setBounds(282, 144, 132, 22);
		contentPane.add(TextEstadoCivil);
		TextEstadoCivil.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setBounds(23, 183, 35, 13);
		contentPane.add(lblSexo);

		TextSexo = new JTextField();
		TextSexo.setBounds(110, 181, 20, 22);
		contentPane.add(TextSexo);
		TextSexo.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(23, 215, 65, 13);
		contentPane.add(lblTelefone);

		formattedTextTelefone = new JFormattedTextField(new MaskFormatter("(##)#########"));
		formattedTextTelefone.setBounds(110, 213, 85, 22);
		contentPane.add(formattedTextTelefone);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textCPF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CPF para realizar a consulta!");
				} else

					try {
						Connection conexao = ConnOracle.obterconexao();
						String query = "Select * FROM admin.vsms_tb02 where cpf=?";
						PreparedStatement stmt = conexao.prepareStatement(query);
						stmt.setString(1, textCPF.getText());
						ResultSet rs = stmt.executeQuery();
						rs.next();
						if (textCPF.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "CPF nao Cadastrado");
						} else

							if (validaCPF.isCPF(textCPF.getText()) == true) {

								textNome.setText(rs.getString("nome"));
								textPai.setText(rs.getString("Pai"));
								textMae.setText(rs.getString("mae"));
								formattedTextDataNasc.setValue(rs.getString("Data_Nasc"));
							    TextEstadoCivil.setText(rs.getString("estado_civil"));
								TextSexo.setText(rs.getString("sexo"));
								formattedTextTelefone.setText(rs.getString("telefone"));
								stmt.execute();
								stmt.close();
								conexao.close();

							} else
								JOptionPane.showInternalMessageDialog(null, "\"Erro, CPF invalido !!!\n");
					} catch (SQLException R) {
						R.printStackTrace();
					}
				return;
			}
		});

		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(29, 303, 105, 21);
		contentPane.add(btnConsultar);

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