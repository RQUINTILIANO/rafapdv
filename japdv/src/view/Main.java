package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

//importar a classe Database do pacote database
import database.Database;
import model.Cliente;

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
		setBounds(100, 100, 1000 ,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLateral = new JPanel();
		panelLateral.setBackground(new Color(192, 192, 192));
		panelLateral.setBounds(-6, 0, 279, 721);
		contentPane.add(panelLateral);
		panelLateral.setLayout(null);

		JLabel lblSistema = new JLabel("Sistema de PDV");
		lblSistema.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		lblSistema.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSistema.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		lblSistema.setBounds(84, 106, 91, 14);
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
		btnFornecedores.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnFornecedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/FORNECEDORES.png")));
		btnFornecedores.setBounds(21, 131, 235, 67);
		panelLateral.add(btnFornecedores);

		JButton btnProdutos = new JButton("PRODUTOS");
		btnProdutos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        frmProduto produto = new frmProduto(Main.this, true);
		        produto.setLocationRelativeTo(Main.this);
		        produto.setVisible(true);

		    }
		});
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setBorderPainted(false);
		btnProdutos.setIconTextGap(12);
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/PRODUTOS.png")));
		btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProdutos.setForeground(Color.WHITE);
		btnProdutos.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnProdutos.setBackground(new Color(32, 178, 170));
		btnProdutos.setBounds(21, 209, 235, 67);
		panelLateral.add(btnProdutos);

		JButton btnPDV = new JButton("PDV");
		btnPDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPDV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPDV.setBorderPainted(false);
		btnPDV.setIconTextGap(12);
		btnPDV.setIcon(new ImageIcon(Main.class.getResource("/img/PDV1.png")));
		btnPDV.setHorizontalAlignment(SwingConstants.LEFT);
		btnPDV.setForeground(Color.WHITE);
		btnPDV.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnPDV.setBackground(new Color(32, 178, 170));
		btnPDV.setBounds(21, 443, 235, 67);
		panelLateral.add(btnPDV);

		JButton btnVendas = new JButton("VENDAS");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVendas.setBorderPainted(false);
		btnVendas.setIconTextGap(12);
		btnVendas.setIcon(new ImageIcon(Main.class.getResource("/img/VENDAS.png")));
		btnVendas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVendas.setForeground(Color.WHITE);
		btnVendas.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnVendas.setBackground(new Color(32, 178, 170));
		btnVendas.setBounds(21, 365, 235, 67);
		panelLateral.add(btnVendas);

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
		btnSair.setIcon(new ImageIcon(Main.class.getResource("/img/SAIR (1).png")));
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnSair.setBackground(new Color(32, 178, 170));
		btnSair.setBounds(21, 622, 235, 81);
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
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/SOBRE1.png")));
		btnSobre.setHorizontalAlignment(SwingConstants.LEFT);
		btnSobre.setForeground(Color.WHITE);
		btnSobre.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnSobre.setBackground(new Color(32, 178, 170));
		btnSobre.setBounds(21, 521, 235, 67);
		panelLateral.add(btnSobre);

		JLabel lblSeparador = new JLabel("------------------------");
		lblSeparador.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblSeparador.setForeground(SystemColor.textInactiveText);
		lblSeparador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeparador.setBounds(45, 599, 177, 14);
		panelLateral.add(lblSeparador);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(74, 0, 119, 112);
		panelLateral.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/img/LOGO2.png")));
		
		JButton btnCliente = new JButton("CLIENTES");

		btnCliente.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		    	frmCliente cliente = new frmCliente();
		    	cliente.setVisible(true);

		    }
		});
		//btnCliente.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
		//	}
		//});
		btnCliente.setIconTextGap(12);
		btnCliente.setIcon(new ImageIcon(Main.class.getResource("/img/CLIENTES.png")));
		btnCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCliente.setForeground(Color.WHITE);
		btnCliente.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.setBorderPainted(false);
		btnCliente.setBackground(new Color(32, 178, 170));
		btnCliente.setBounds(21, 287, 235, 67);
		panelLateral.add(btnCliente);

		JPanel panelTabela = new JPanel();
		panelTabela.setBackground(SystemColor.window);
		panelTabela.setBounds(283, 491, 671, 230);
		contentPane.add(panelTabela);
		panelTabela.setLayout(null);

		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(new Color(32, 178, 170));
		lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDashboard.setBounds(352, 82, 217, 32);
		contentPane.add(lblDashboard);

		JPanel panelCard5 = new JPanel();
		panelCard5.setLayout(null);
		panelCard5.setBackground(SystemColor.window);
		panelCard5.setBounds(283, 149, 217, 160);
		contentPane.add(panelCard5);

		JLabel lblCalendario = new JLabel("");
		lblCalendario.setIcon(new ImageIcon(Main.class.getResource("/img/CALENDARIO1.png")));
		lblCalendario.setBounds(748, 65, 67, 64);
		contentPane.add(lblCalendario);

		lblData = new JLabel("");
		lblData.setForeground(new Color(32, 178, 170));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblData.setBounds(815, 76, 128, 45);
		contentPane.add(lblData);

		JSeparator separatorInferior = new JSeparator();
		separatorInferior.setBounds(283, 136, 678, 2);
		contentPane.add(separatorInferior);

		JSeparator separatorSuperior = new JSeparator();
		separatorSuperior.setBounds(-16, -1, 800, 2);
		contentPane.add(separatorSuperior);

		lblMysql = new JLabel("");
		lblMysql.setForeground(SystemColor.controlDkShadow);
		lblMysql.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMysql.setBounds(10, 736, 109, 14);
		contentPane.add(lblMysql);

		lblStatus = new JLabel("●");
		lblStatus.setForeground(Color.RED);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(104, 734, 16, 16);
		contentPane.add(lblStatus);
		
		JPanel panelCard5_1 = new JPanel();
		panelCard5_1.setBounds(510, 149, 217, 160);
		contentPane.add(panelCard5_1);
		panelCard5_1.setLayout(null);
		panelCard5_1.setBackground(SystemColor.window);
		
		JPanel panelCard5_1_1 = new JPanel();
		panelCard5_1_1.setLayout(null);
		panelCard5_1_1.setBackground(SystemColor.window);
		panelCard5_1_1.setBounds(737, 149, 217, 160);
		contentPane.add(panelCard5_1_1);
		
		JPanel panelCard5_1_1_1 = new JPanel();
		panelCard5_1_1_1.setLayout(null);
		panelCard5_1_1_1.setBackground(SystemColor.window);
		panelCard5_1_1_1.setBounds(737, 320, 217, 160);
		contentPane.add(panelCard5_1_1_1);
		
		JPanel panelCard5_1_2 = new JPanel();
		panelCard5_1_2.setLayout(null);
		panelCard5_1_2.setBackground(SystemColor.window);
		panelCard5_1_2.setBounds(510, 320, 217, 160);
		contentPane.add(panelCard5_1_2);
		
		JPanel panelCard5_2 = new JPanel();
		panelCard5_2.setLayout(null);
		panelCard5_2.setBackground(SystemColor.window);
		panelCard5_2.setBounds(283, 320, 217, 160);
		contentPane.add(panelCard5_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/img/DASHBOARD.png")));
		lblNewLabel_1.setBounds(283, 76, 64, 49);
		contentPane.add(lblNewLabel_1);

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
