package Tela_InfPessoal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;

public class Tela_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal frame = new Tela_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Principal() {
		setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14));
		setTitle("Informações Pessoais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Dados Pessoais");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmInclusao = new JMenuItem("Inclusão");
		mnNewMenu.add(mntmInclusao);
		mntmInclusao.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {	
				Inc_DadosPessoais inc_DadosPessoais;
				try {
					inc_DadosPessoais = new Inc_DadosPessoais();
					inc_DadosPessoais.setVisible(true);
					dispose();
				} catch (ParseException ev) {
					// TODO Auto-generated catch block
					ev.printStackTrace();
				}
		    }
		});
		
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mnNewMenu.add(mntmConsulta);
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
					Con_DadosPessoais con_DadosPessoais;
					try {
						con_DadosPessoais = new Con_DadosPessoais();
						con_DadosPessoais.setVisible(true);
						dispose();
					} catch (ParseException ev) {
						// TODO Auto-generated catch block
						ev.printStackTrace();
					}
			    }
			});
		
		
		
		JMenuItem mntmExclusao = new JMenuItem("Exclusão");
		mnNewMenu.add(mntmExclusao);
		
		JMenu mnNewMenu_2 = new JMenu("Documento");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Inclusão");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Consulta");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Exclusão");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_1 = new JMenu("Endereço");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Inclusão");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Consulta");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Inclusão");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_Encerrar = new JMenu("Encerrar");
		menuBar.add(mnNewMenu_Encerrar);
		
		JMenuItem mntmNewMenuItem_Sair = new JMenuItem("Sair");
		mnNewMenu_Encerrar.add(mntmNewMenuItem_Sair);
		mntmNewMenuItem_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
					Tela_Principal frame = new Tela_Principal();
					frame.setVisible(false);
					dispose();
			    }
			});
		
		
		
	}
}
