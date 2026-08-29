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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLateral = new JPanel();
		panelLateral.setBackground(new Color(3, 36, 75));
		panelLateral.setBounds(0, 0, 197, 527);
		contentPane.add(panelLateral);
		panelLateral.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, 11, 64, 64);
		panelLateral.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Main.class.getResource("/img/japdv.png")));

		JLabel lblJAPDV = new JLabel("JA-PDV");
		lblJAPDV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblJAPDV.setForeground(new Color(255, 255, 255));
		lblJAPDV.setBounds(90, 26, 77, 23);
		panelLateral.add(lblJAPDV);

		JLabel lblSistema = new JLabel("Sistema de PDV");
		lblSistema.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSistema.setForeground(new Color(255, 255, 255));
		lblSistema.setBounds(86, 52, 91, 14);
		panelLateral.add(lblSistema);

		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFornecedor fornecedor = new frmFornecedor();
				fornecedor.setVisible(true);
			}
		});
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setBorderPainted(false);
		btnFornecedores.setForeground(new Color(255, 255, 255));
		btnFornecedores.setBackground(new Color(27, 52, 87));
		btnFornecedores.setIconTextGap(12);
		btnFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFornecedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/fornecedor.png")));
		btnFornecedores.setBounds(10, 86, 177, 54);
		panelLateral.add(btnFornecedores);

		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setBorderPainted(false);
		btnProdutos.setIconTextGap(12);
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/produto.png")));
		btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProdutos.setForeground(Color.WHITE);
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProdutos.setBackground(new Color(27, 52, 87));
		btnProdutos.setBounds(10, 151, 177, 54);
		panelLateral.add(btnProdutos);

		JButton btnPDV = new JButton("PDV");
		btnPDV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPDV.setBorderPainted(false);
		btnPDV.setIconTextGap(12);
		btnPDV.setIcon(new ImageIcon(Main.class.getResource("/img/pdv.png")));
		btnPDV.setHorizontalAlignment(SwingConstants.LEFT);
		btnPDV.setForeground(Color.WHITE);
		btnPDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPDV.setBackground(new Color(27, 52, 87));
		btnPDV.setBounds(10, 216, 177, 54);
		panelLateral.add(btnPDV);

		JButton btnVendas = new JButton("Vendas");
		btnVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVendas.setBorderPainted(false);
		btnVendas.setIconTextGap(12);
		btnVendas.setIcon(new ImageIcon(Main.class.getResource("/img/venda.png")));
		btnVendas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVendas.setForeground(Color.WHITE);
		btnVendas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVendas.setBackground(new Color(27, 52, 87));
		btnVendas.setBounds(10, 281, 177, 54);
		panelLateral.add(btnVendas);

		JButton btnSair = new JButton("Sair");
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
		btnSair.setIcon(new ImageIcon(Main.class.getResource("/img/sair.png")));
		btnSair.setHorizontalAlignment(SwingConstants.LEFT);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBackground(new Color(27, 52, 87));
		btnSair.setBounds(10, 346, 177, 54);
		panelLateral.add(btnSair);

		JButton btnSobre = new JButton("Sobre");
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
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/sobre.png")));
		btnSobre.setHorizontalAlignment(SwingConstants.LEFT);
		btnSobre.setForeground(Color.WHITE);
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSobre.setBackground(new Color(27, 52, 87));
		btnSobre.setBounds(10, 452, 177, 54);
		panelLateral.add(btnSobre);

		JLabel lblSeparador = new JLabel("------------------------");
		lblSeparador.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblSeparador.setForeground(SystemColor.textInactiveText);
		lblSeparador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeparador.setBounds(13, 420, 177, 14);
		panelLateral.add(lblSeparador);

		JPanel panelTabela = new JPanel();
		panelTabela.setBackground(SystemColor.window);
		panelTabela.setBounds(207, 314, 567, 201);
		contentPane.add(panelTabela);
		panelTabela.setLayout(null);

		JPanel panelCard1 = new JPanel();
		panelCard1.setBounds(207, 54, 180, 115);
		contentPane.add(panelCard1);
		panelCard1.setLayout(null);
		panelCard1.setBackground(SystemColor.window);

		JLabel lblVelocimetro = new JLabel("");
		lblVelocimetro.setIcon(new ImageIcon(Main.class.getResource("/img/dash.png")));
		lblVelocimetro.setBounds(222, 11, 32, 32);
		contentPane.add(lblVelocimetro);

		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDashboard.setBounds(266, 11, 109, 32);
		contentPane.add(lblDashboard);

		JPanel panelCard2 = new JPanel();
		panelCard2.setLayout(null);
		panelCard2.setBackground(SystemColor.window);
		panelCard2.setBounds(401, 54, 180, 115);
		contentPane.add(panelCard2);

		JPanel panelCard3 = new JPanel();
		panelCard3.setLayout(null);
		panelCard3.setBackground(SystemColor.window);
		panelCard3.setBounds(594, 54, 180, 115);
		contentPane.add(panelCard3);

		JPanel panelCard4 = new JPanel();
		panelCard4.setLayout(null);
		panelCard4.setBackground(SystemColor.window);
		panelCard4.setBounds(207, 185, 180, 115);
		contentPane.add(panelCard4);

		JPanel panelCard5 = new JPanel();
		panelCard5.setLayout(null);
		panelCard5.setBackground(SystemColor.window);
		panelCard5.setBounds(401, 185, 180, 115);
		contentPane.add(panelCard5);

		JPanel panelCard6 = new JPanel();
		panelCard6.setLayout(null);
		panelCard6.setBackground(SystemColor.window);
		panelCard6.setBounds(594, 185, 180, 115);
		contentPane.add(panelCard6);

		JLabel lblCalendario = new JLabel("");
		lblCalendario.setIcon(new ImageIcon(Main.class.getResource("/img/calendario.png")));
		lblCalendario.setBounds(644, 15, 24, 24);
		contentPane.add(lblCalendario);

		lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(678, 19, 90, 19);
		contentPane.add(lblData);

		JSeparator separatorInferior = new JSeparator();
		separatorInferior.setBounds(0, 526, 800, 2);
		contentPane.add(separatorInferior);

		JSeparator separatorSuperior = new JSeparator();
		separatorSuperior.setBounds(-16, -1, 800, 2);
		contentPane.add(separatorSuperior);

		JLabel lblDatabase = new JLabel("");
		lblDatabase.setBounds(10, 536, 16, 16);
		contentPane.add(lblDatabase);
		lblDatabase.setIcon(new ImageIcon(Main.class.getResource("/img/banco.png")));

		lblMysql = new JLabel("");
		lblMysql.setForeground(SystemColor.controlDkShadow);
		lblMysql.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMysql.setBounds(36, 537, 109, 14);
		contentPane.add(lblMysql);

		lblStatus = new JLabel("●");
		lblStatus.setForeground(Color.RED);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(144, 535, 16, 16);
		contentPane.add(lblStatus);

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
