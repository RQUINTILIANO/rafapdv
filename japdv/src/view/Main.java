package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//importar a classe Database do pacote database
import database.Database;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;

	//Criação de um objeto para lidar com a conexão
	Database db = new Database();
	private JLabel lblStatus;
	private JLabel lblMysql;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// Uso da biblioteca flatlaf (swing moderno)
		FlatLightLaf.setup();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setTitle("JA-PDV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLateral = new JPanel();
		panelLateral.setBackground(new Color(192, 192, 192));
		panelLateral.setBounds(0, 0, 324, 761);
		contentPane.add(panelLateral);
		panelLateral.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(42, 11, 120, 102);
		panelLateral.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/img/LOGO2.png")));

		JLabel lblSistema = new JLabel("Sistema de PDV");
		lblSistema.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSistema.setForeground(new Color(105, 105, 105));
		lblSistema.setBounds(52, 110, 91, 14);
		panelLateral.add(lblSistema);

		JButton btnFornecedores = new JButton("FORNECEDORES");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFornecedor fornecedor = new frmFornecedor();
				fornecedor.setVisible(true);
			}
		});
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setBorderPainted(false);
		btnFornecedores.setForeground(new Color(255, 255, 255));
		btnFornecedores.setBackground(new Color(32, 178, 170));
		btnFornecedores.setIconTextGap(12);
		btnFornecedores.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFornecedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/FORNECEDORES.png")));
		btnFornecedores.setBounds(34, 146, 254, 73);
		panelLateral.add(btnFornecedores);

		JButton btnPDV = new JButton("PDV");
		btnPDV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPDV.setBorderPainted(false);
		btnPDV.setIconTextGap(12);
		btnPDV.setIcon(new ImageIcon(Main.class.getResource("/img/PDV1.png")));
		btnPDV.setHorizontalAlignment(SwingConstants.LEFT);
		btnPDV.setForeground(Color.WHITE);
		btnPDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPDV.setBackground(new Color(32, 178, 170));
		btnPDV.setBounds(34, 402, 254, 73);
		panelLateral.add(btnPDV);

		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			// Quando clicar no botão
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?", "Confirmar saída", JOptionPane.YES_NO_OPTION);
				// apoio ao entendimento da lógica
				System.out.println(resposta);
				if (resposta == 0) {
					System.exit(0); // encerra o sistema					
				}
			}
		});
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setBorderPainted(false);
		btnSair.setIconTextGap(12);
		btnSair.setIcon(new ImageIcon(Main.class.getResource("/img/SAIR.png")));
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSair.setBackground(new Color(32, 178, 170));
		btnSair.setBounds(34, 570, 254, 73);
		panelLateral.add(btnSair);

		JButton btnSobre = new JButton("SOBRE");
		btnSobre.addActionListener(new ActionListener() {
			// Ativar a tela sobre
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorderPainted(false);
		btnSobre.setIconTextGap(12);
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/SOBRE.png")));
		btnSobre.setHorizontalAlignment(SwingConstants.LEFT);
		btnSobre.setForeground(Color.WHITE);
		btnSobre.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSobre.setBackground(new Color(32, 178, 170));
		btnSobre.setBounds(33, 677, 255, 73);
		panelLateral.add(btnSobre);

		JLabel lblSeparador = new JLabel("------------------------");
		lblSeparador.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblSeparador.setForeground(SystemColor.textInactiveText);
		lblSeparador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeparador.setBounds(75, 652, 177, 14);
		panelLateral.add(lblSeparador);
		
				JButton btnClientes = new JButton("CLIENTES");
				btnClientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnClientes.setBounds(34, 230, 254, 75);
				panelLateral.add(btnClientes);
				btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnClientes.setBorderPainted(false);
				btnClientes.setIconTextGap(12);
				btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/CLIENTES (1).png")));
				btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
				btnClientes.setForeground(Color.WHITE);
				btnClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
				btnClientes.setBackground(new Color(32, 178, 170));
				
						JButton btnVendas = new JButton("VENDAS");
						btnVendas.setBounds(34, 486, 254, 73);
						panelLateral.add(btnVendas);
						btnVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btnVendas.setBorderPainted(false);
						btnVendas.setIconTextGap(12);
						btnVendas.setIcon(new ImageIcon(Main.class.getResource("/img/VENDAS.png")));
						btnVendas.setHorizontalAlignment(SwingConstants.LEFT);
						btnVendas.setForeground(Color.WHITE);
						btnVendas.setFont(new Font("Tahoma", Font.BOLD, 16));
						btnVendas.setBackground(new Color(32, 178, 170));
						
						JButton btnProdutos = new JButton("PRODUTOS");
						btnProdutos.setIconTextGap(12);
						btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/PRODUTOS.png")));
						btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
						btnProdutos.setForeground(Color.WHITE);
						btnProdutos.setFont(new Font("Tahoma", Font.BOLD, 16));
						btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btnProdutos.setBorderPainted(false);
						btnProdutos.setBackground(new Color(32, 178, 170));
						btnProdutos.setBounds(34, 316, 254, 75);
						panelLateral.add(btnProdutos);

		JPanel panelTabela = new JPanel();
		panelTabela.setBackground(SystemColor.window);
		panelTabela.setBounds(334, 490, 940, 211);
		contentPane.add(panelTabela);
		panelTabela.setLayout(null);

		JLabel lblVelocimetro = new JLabel("");
		lblVelocimetro.setIcon(new ImageIcon(Main.class.getResource("/img/DASHBOARD.png")));
		lblVelocimetro.setBounds(241, 37, 32, 32);
		contentPane.add(lblVelocimetro);

		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(new Color(32, 178, 170));
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDashboard.setBounds(428, 24, 186, 66);
		contentPane.add(lblDashboard);

		JLabel lblCalendario = new JLabel("");
		lblCalendario.setIcon(new ImageIcon(Main.class.getResource("/img/CALENDARIO.png")));
		lblCalendario.setBounds(1026, 24, 64, 66);
		contentPane.add(lblCalendario);

		lblData = new JLabel("");
		lblData.setForeground(new Color(32, 178, 170));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblData.setBounds(1100, 35, 158, 48);
		contentPane.add(lblData);

		JSeparator separatorInferior = new JSeparator();
		separatorInferior.setBounds(352, 712, 800, 2);
		contentPane.add(separatorInferior);

		JSeparator separatorSuperior = new JSeparator();
		separatorSuperior.setBounds(-16, -1, 800, 2);
		contentPane.add(separatorSuperior);

		JLabel lblDatabase = new JLabel("");
		lblDatabase.setBounds(10, 734, 16, 16);
		contentPane.add(lblDatabase);
		lblDatabase.setIcon(new ImageIcon(Main.class.getResource("")));

		lblMysql = new JLabel("");
		lblMysql.setForeground(SystemColor.controlDkShadow);
		lblMysql.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMysql.setBounds(36, 537, 109, 14);
		contentPane.add(lblMysql);

		lblStatus = new JLabel("●");
		lblStatus.setForeground(Color.RED);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(565, 734, 16, 16);
		contentPane.add(lblStatus);
		
		JPanel panelCard4_1 = new JPanel();
		panelCard4_1.setBounds(656, 120, 296, 174);
		contentPane.add(panelCard4_1);
		panelCard4_1.setLayout(null);
		panelCard4_1.setBackground(SystemColor.window);
		
		JPanel panelCard4_2 = new JPanel();
		panelCard4_2.setBounds(334, 120, 312, 174);
		contentPane.add(panelCard4_2);
		panelCard4_2.setBackground(SystemColor.window);
		panelCard4_2.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
		
		JPanel panelCard4_1_2 = new JPanel();
		panelCard4_1_2.setBounds(962, 120, 312, 174);
		contentPane.add(panelCard4_1_2);
		panelCard4_1_2.setLayout(null);
		panelCard4_1_2.setBackground(SystemColor.window);
		
		JPanel panelCard4_2_1 = new JPanel();
		panelCard4_2_1.setLayout(null);
		panelCard4_2_1.setBackground(SystemColor.window);
		panelCard4_2_1.setBounds(334, 305, 312, 174);
		contentPane.add(panelCard4_2_1);
		
		JPanel panelCard4_1_1 = new JPanel();
		panelCard4_1_1.setLayout(null);
		panelCard4_1_1.setBackground(SystemColor.window);
		panelCard4_1_1.setBounds(656, 305, 296, 174);
		contentPane.add(panelCard4_1_1);
		
		JPanel panelCard4_1_2_1 = new JPanel();
		panelCard4_1_2_1.setLayout(null);
		panelCard4_1_2_1.setBackground(SystemColor.window);
		panelCard4_1_2_1.setBounds(962, 305, 312, 174);
		contentPane.add(panelCard4_1_2_1);
		
		JLabel lblCalendario_1 = new JLabel("");
		lblCalendario_1.setIcon(new ImageIcon(Main.class.getResource("/img/DASHBOARD.png")));
		lblCalendario_1.setBounds(354, 24, 64, 66);
		contentPane.add(lblCalendario_1);

		// iniciar centralizado
		setLocationRelativeTo(null);
		
		// atualizar a data
		atualizarData();
		
		// status do banco (mudar texto e cor da bolinha)
		if (db.testarConexao() == true) {
			System.out.println("Banco conectado");
			lblMysql.setText("MySQL Conectado");
			lblStatus.setForeground(Color.GREEN);
		} else {
			System.out.println("Erro na conexão");
			lblMysql.setText("MySQL Desconectado");
			lblStatus.setForeground(Color.RED);
		}

	}// FIM do construtor
	
	// Função (método) para atualizar a data do sistema
	private void atualizarData() {
		// obter a data do sistema operacional
		LocalDate hoje = LocalDate.now();
		// formatar a data dia/mês/ano(4 dígitos)
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// alterar o texto de lblData
		lblData.setText(hoje.format(formato));
	}
}// FIM da classe Main (principal)
