package Tela_InfPessoal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Tela_InfPessoal.ConnOracle;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_Acesso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Acesso frame = new Tela_Acesso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			};
		});
	};

	/**
	 * Create the frame.
	 */
	public Tela_Acesso() {
		setFont(new Font("Tahoma", Font.BOLD, 16));
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textUsuario.setColumns(10);

		passSenha = new JPasswordField();
		passSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//				
				Connection conexao = ConnOracle.obterconexao();

				try {
					String query = "SELECT * FROM admin.vsms_tb01 where usuario=? and senha=?";
					PreparedStatement statement = conexao.prepareStatement(query);
					statement.setString(1, textUsuario.getText());
					statement.setString(2, new String(passSenha.getPassword()));

					ResultSet resultSet = statement.executeQuery();

					if (resultSet.next()) {
						//JOptionPane.showInternalMessageDialmilsonilsonog(null,"Conectado" );
						Tela_Principal tPrincipal = new Tela_Principal();
						tPrincipal.setVisible(true);
						setVisible(false);

					} else {
						JOptionPane.showInternalMessageDialog(null, "N�o Conectado");
					}

				}
				// catch (ClassNotFoundException R) {

				// R.printStackTrace();

				// }
				catch (SQLException R) {

					R.printStackTrace();

				}

				return;

				//				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(52)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnEntrar)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passSenha)
										.addComponent(textUsuario, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
						.addContainerGap(102, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(34)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblUsuario).addComponent(
						textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(passSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(56).addComponent(btnEntrar).addContainerGap(59, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}
}
