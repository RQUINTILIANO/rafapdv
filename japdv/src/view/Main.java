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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import controller.ProdutoController;
//importar a classe Database do pacote database
import database.Database;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;

	//Criação de um objeto para lidar com a conexão
	Database db = new Database();
	private JLabel lblStatus;
	private JLabel lblMysql;
	private JLabel lblDashQuantidade;
	
	//Criação de um objeto para acessar o controller e atualizar o dashboard
	ProdutoController controllerProduto = new ProdutoController();
	private JLabel lblDashRepor;
	private JPanel panelCard5_1_1_2;
	private JPanel panelCard5_1_1_1_1;
	private JLabel lblEstoqueZero;
	private JLabel lblVendasDia;
	 
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
                //Atualizar o dashboard depois quea janela produtos for fechada(JDialog - quando ativamos um modal (modal true) o Java "espera" o fechamento da janela para encerrar o processamento-
		        atualizarDashboard();
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
		panelCard5.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		panelCard5.setForeground(Color.WHITE);
		panelCard5.setLayout(null);
		panelCard5.setBackground(Color.WHITE);
		panelCard5.setBounds(283, 149, 217, 160);
		contentPane.add(panelCard5);
		
		lblDashQuantidade = new JLabel("0");
		lblDashQuantidade.setFont(new Font("Arial Narrow", Font.BOLD, 50));
		lblDashQuantidade.setForeground(new Color(128, 128, 128));
		lblDashQuantidade.setBounds(89, 94, 103, 43);
		panelCard5.add(lblDashQuantidade);
		
		panelCard5_1_1_2 = new JPanel();
		panelCard5_1_1_2.setLayout(null);
		panelCard5_1_1_2.setBackground(new Color(32, 178, 170));
		panelCard5_1_1_2.setBounds(0, 0, 217, 83);
		panelCard5.add(panelCard5_1_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUTOS");
		lblNewLabel_2.setBounds(88, 11, 184, 36);
		panelCard5_1_1_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_6 = new JLabel(" CADASTRADOS");
		lblNewLabel_6.setBounds(85, 43, 122, 14);
		panelCard5_1_1_2.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 0, 72, 83);
		panelCard5_1_1_2.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(Main.class.getResource("/img/QuantidadeProdutos.png")));

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
		panelCard5_1.setBorder(new LineBorder(new Color(255, 204, 0), 2, true));
		panelCard5_1.setBounds(510, 149, 217, 160);
		contentPane.add(panelCard5_1);
		panelCard5_1.setLayout(null);
		panelCard5_1.setBackground(SystemColor.window);
		
		lblDashRepor = new JLabel("2");
		lblDashRepor.setForeground(new Color(128, 128, 128));
		lblDashRepor.setFont(new Font("Arial Narrow", Font.BOLD, 50));
		lblDashRepor.setBounds(84, 95, 100, 43);
		panelCard5_1.add(lblDashRepor);
		
		panelCard5_1_1_1_1 = new JPanel();
		panelCard5_1_1_1_1.setLayout(null);
		panelCard5_1_1_1_1.setBackground(new Color(255, 204, 0));
		panelCard5_1_1_1_1.setBounds(0, 0, 217, 84);
		panelCard5_1.add(panelCard5_1_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(10, 0, 76, 84);
		panelCard5_1_1_1_1.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(Main.class.getResource("/img/ALERTA.png")));
		
		JLabel lblNewLabel_2_2 = new JLabel("ESTOQUE");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel_2_2.setBounds(86, 11, 184, 36);
		panelCard5_1_1_1_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("BAIXO");
		lblNewLabel_2_1.setBounds(86, 39, 148, 20);
		panelCard5_1_1_1_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		
		JPanel panelCard5_1_1 = new JPanel();
		panelCard5_1_1.setBorder(new LineBorder(new Color(178, 34, 34), 2, true));
		panelCard5_1_1.setForeground(new Color(178, 34, 34));
		panelCard5_1_1.setLayout(null);
		panelCard5_1_1.setBackground(SystemColor.window);
		panelCard5_1_1.setBounds(737, 149, 217, 160);
		contentPane.add(panelCard5_1_1);
		
		JPanel panelCard5_1_1_3 = new JPanel();
		panelCard5_1_1_3.setLayout(null);
		panelCard5_1_1_3.setBackground(new Color(178, 34, 34));
		panelCard5_1_1_3.setBounds(0, 0, 217, 83);
		panelCard5_1_1.add(panelCard5_1_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Main.class.getResource("/img/SemEstoque.png")));
		lblNewLabel_3.setBounds(10, 0, 72, 83);
		panelCard5_1_1_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("ESTOQUE");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel_2_2_1.setBounds(88, 11, 184, 36);
		panelCard5_1_1_3.add(lblNewLabel_2_2_1);
		
		JLabel lblEstoqueZerado = new JLabel("ZERADO");
		lblEstoqueZerado.setForeground(Color.WHITE);
		lblEstoqueZerado.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		lblEstoqueZerado.setBounds(88, 40, 148, 20);
		panelCard5_1_1_3.add(lblEstoqueZerado);
		
		lblEstoqueZero = new JLabel("0");
		lblEstoqueZero.setForeground(Color.GRAY);
		lblEstoqueZero.setFont(new Font("Arial Narrow", Font.BOLD, 50));
		lblEstoqueZero.setBounds(93, 94, 103, 43);
		panelCard5_1_1.add(lblEstoqueZero);
		
		JPanel panelCard5_1_1_1 = new JPanel();
		panelCard5_1_1_1.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		panelCard5_1_1_1.setLayout(null);
		panelCard5_1_1_1.setBackground(SystemColor.window);
		panelCard5_1_1_1.setBounds(510, 320, 217, 160);
		contentPane.add(panelCard5_1_1_1);
		
		JPanel panelCard5_1_1_1_2 = new JPanel();
		panelCard5_1_1_1_2.setLayout(null);
		panelCard5_1_1_1_2.setBackground(new Color(32, 178, 170));
		panelCard5_1_1_1_2.setBounds(0, 0, 217, 82);
		panelCard5_1_1_1.add(panelCard5_1_1_1_2);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("ITENS ");
		lblNewLabel_2_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel_2_2_1_1_1.setBounds(87, 11, 184, 36);
		panelCard5_1_1_1_2.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("VENDIDOS HOJE");
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		lblNewLabel_2_1_1_1_1.setBounds(87, 39, 148, 20);
		panelCard5_1_1_1_2.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Main.class.getResource("/img/ItensVendidosHoje.png")));
		lblNewLabel_7.setBounds(10, 0, 77, 82);
		panelCard5_1_1_1_2.add(lblNewLabel_7);
		
		JLabel lblItensVendidos = new JLabel("2");
		lblItensVendidos.setForeground(Color.GRAY);
		lblItensVendidos.setFont(new Font("Arial Narrow", Font.BOLD, 50));
		lblItensVendidos.setBounds(88, 93, 103, 43);
		panelCard5_1_1_1.add(lblItensVendidos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/img/DASHBOARD.png")));
		lblNewLabel_1.setBounds(283, 76, 64, 49);
		contentPane.add(lblNewLabel_1);
		
		JPanel panelCard5_1_1_4 = new JPanel();
		panelCard5_1_1_4.setLayout(null);
		panelCard5_1_1_4.setForeground(new Color(32, 178, 170));
		panelCard5_1_1_4.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		panelCard5_1_1_4.setBackground(SystemColor.window);
		panelCard5_1_1_4.setBounds(283, 320, 217, 160);
		contentPane.add(panelCard5_1_1_4);
		
		JPanel panelCard5_1_1_3_1 = new JPanel();
		panelCard5_1_1_3_1.setLayout(null);
		panelCard5_1_1_3_1.setBackground(new Color(32, 178, 170));
		panelCard5_1_1_3_1.setBounds(0, 0, 217, 83);
		panelCard5_1_1_4.add(panelCard5_1_1_3_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Main.class.getResource("/img/VendasHoje.png")));
		lblNewLabel_3_1.setBounds(10, 0, 72, 83);
		panelCard5_1_1_3_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("VENDAS");
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel_2_2_1_1.setBounds(88, 11, 184, 36);
		panelCard5_1_1_3_1.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("HOJE");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		lblNewLabel_2_1_1_1.setBounds(88, 40, 148, 20);
		panelCard5_1_1_3_1.add(lblNewLabel_2_1_1_1);
		
		lblVendasDia = new JLabel("0");
		lblVendasDia.setForeground(Color.GRAY);
		lblVendasDia.setFont(new Font("Arial Narrow", Font.BOLD, 50));
		lblVendasDia.setBounds(87, 94, 103, 43);
		panelCard5_1_1_4.add(lblVendasDia);
		
		JPanel panelCard5_1_1_1_3 = new JPanel();
		panelCard5_1_1_1_3.setLayout(null);
		panelCard5_1_1_1_3.setBorder(new LineBorder(new Color(32, 178, 170), 2, true));
		panelCard5_1_1_1_3.setBackground(SystemColor.window);
		panelCard5_1_1_1_3.setBounds(737, 320, 217, 160);
		contentPane.add(panelCard5_1_1_1_3);
		
		JPanel panelCard5_1_1_1_2_1 = new JPanel();
		panelCard5_1_1_1_2_1.setLayout(null);
		panelCard5_1_1_1_2_1.setBackground(new Color(32, 178, 170));
		panelCard5_1_1_1_2_1.setBounds(0, 0, 217, 82);
		panelCard5_1_1_1_3.add(panelCard5_1_1_1_2_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("FATURAMENTO");
		lblNewLabel_2_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel_2_2_1_1_1_1.setBounds(70, 11, 184, 36);
		panelCard5_1_1_1_2_1.add(lblNewLabel_2_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("HOJE");
		lblNewLabel_2_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		lblNewLabel_2_1_1_1_1_1.setBounds(70, 39, 148, 20);
		panelCard5_1_1_1_2_1.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(Main.class.getResource("/img/FaturamentoDia.png")));
		lblNewLabel_7_1.setBounds(0, 0, 77, 82);
		panelCard5_1_1_1_2_1.add(lblNewLabel_7_1);
		
		JLabel lblFaturamento = new JLabel("2");
		lblFaturamento.setForeground(Color.GRAY);
		lblFaturamento.setFont(new Font("Arial Narrow", Font.BOLD, 50));
		lblFaturamento.setBounds(93, 93, 103, 43);
		panelCard5_1_1_1_3.add(lblFaturamento);

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
		
		//Atualizar o dashboard
        atualizarDashboard();
        
		
	}   // FIM do construtor
	
	    // Função (método) para atualizar a data do sistema
	    private void atualizarData() {
		// obter a data do sistema operacional
		LocalDate hoje = LocalDate.now();
		// formatar a data dia/mês/ano(4 dígitos)
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// alterar o texto de lblData
		lblData.setText(hoje.format(formato));
	}
	
	   //Metodo(Função) para atualizar o dashboard
	    //Card quantidade de produtos
	    private void atualizarDashboard() {
		int totalProdutos = controllerProduto.contarProdutos();
		lblDashQuantidade.setText(String.valueOf(totalProdutos));
		
		//Card produtos com estoque baixo
		int estoqueBaixo = controllerProduto.contarEstoqueBaixo();
		lblDashRepor.setText(String.valueOf(estoqueBaixo));
		
		//card estoque zerado
		int estoqueZero = controllerProduto.contarEstoqueBaixo();
		lblEstoqueZero.setText(String.valueOf(estoqueZero));
		
		//Card Vendas do dia
		int vendasDia = controllerProduto.VendasDia();
		lblVendasDia.setText(String.valueOf(vendasDia));
		
	}
}// FIM da classe Main (principal)
