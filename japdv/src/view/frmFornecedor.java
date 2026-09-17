package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// importar o fornecedorController
import controller.FornecedorController;
// importar o modelo de dados
import model.Fornecedor;
import utils.Validador;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class frmFornecedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtID;
	private JTextField txtSite;
	private JButton btnAdicionar;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFornecedor dialog = new frmFornecedor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public frmFornecedor() {
		setResizable(false);
		setTitle("Fornecedores");
		setBounds(100, 100, 1000, 600);

		// criar o objeto controller
		// controller = new FornecedorController(); //sintaxe moderna
		FornecedorController controller = new FornecedorController();

		// Criar o objeto fornecedor
		Fornecedor fornecedor = new Fornecedor();

		// iniciar centralizado
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setBounds(53, 227, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("FONE");
		lblNewLabel_1.setForeground(new Color(32, 178, 170));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 281, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("E-MAIL");
		lblNewLabel_2.setForeground(new Color(32, 178, 170));
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2.setBounds(53, 332, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtNome = new JTextField();
		txtNome.setBounds(108, 221, 367, 28);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		// validação do número máximo de caracteres
		txtNome.setDocument(new Validador(50));

		txtFone = new JTextField();
		txtFone.setBounds(108, 275, 208, 28);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);
		// validação do número máximo de caracteres
		txtFone.setDocument(new Validador(20));

		txtEmail = new JTextField();
		txtEmail.setBounds(109, 326, 514, 28);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		// validação do número máximo de caracteres
		txtEmail.setDocument(new Validador(50));

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(32, 178, 170));
		lblNewLabel_3.setBounds(53, 163, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(109, 161, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(32, 178, 170));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setIconTextGap(8);
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/search.png")));

		// ==================================================
		// CRUD Read - Buscar fornecedor
		// ==================================================
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// validação
				if (txtNome.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Informe o nome do fornecedor");
					txtNome.requestFocus();
				} else {
					// capturar o nome para busca
					String nome = txtNome.getText();

					// Instanciar o fornecedor executando a busca através do controller
					Fornecedor fornecedor = controller.buscar(nome);

					// se existir um fornecedor cadastrado
					if (fornecedor != null) {
						// setar os campos do formulário
						txtID.setText(String.valueOf(fornecedor.getIdFornecedor()));
						txtNome.setText(fornecedor.getNome());
						txtFone.setText(fornecedor.getFone());
						txtEmail.setText(fornecedor.getEmail());
						txtSite.setText(fornecedor.getSite());
						// desativar o botão adicionar
						btnAdicionar.setEnabled(false);

					} else {
						JOptionPane.showMessageDialog(null, "Fornecedor não cadastrado");
						limparCampos();
					}
				}
			}		
		});
		// Fim CRUD Read ====================================

		btnBuscar.setBounds(492, 220, 131, 30);
		getContentPane().add(btnBuscar);

		JLabel lblNewLabel_4 = new JLabel("SITE");
		lblNewLabel_4.setForeground(new Color(32, 178, 170));
		lblNewLabel_4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_4.setBounds(53, 391, 46, 14);
		getContentPane().add(lblNewLabel_4);

		txtSite = new JTextField();
		txtSite.setBounds(108, 385, 349, 28);
		getContentPane().add(txtSite);
		txtSite.setColumns(10);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBackground(new Color(32, 178, 170));
		btnAcessar.setForeground(new Color(255, 255, 255));
		
		// Acessar link externo =========================
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String site = txtSite.getText();
				// Executar o método passando o site
				link(site);
				
			}
		});
		// ==============================================
		
		btnAcessar.setBounds(492, 386, 131, 27);
		getContentPane().add(btnAcessar);
		
		//Definir um botão padrão (Associar o Enter a este botão)
		getRootPane().setDefaultButton(btnBuscar);		
		
		panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 453, 984, 108);
		getContentPane().add(panel);
		panel.setLayout(null);
		
				btnAdicionar = new JButton("ADICIONAR");
				btnAdicionar.setBounds(39, 16, 156, 62);
				panel.add(btnAdicionar);
				btnAdicionar.setBackground(new Color(255, 255, 255));
				btnAdicionar.setFont(new Font("Arial Narrow", Font.BOLD, 17));
				btnAdicionar.setForeground(new Color(32, 178, 170));
				btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnAdicionar.setToolTipText("");
				
						JButton btnEditar = new JButton("EDITAR");
						btnEditar.setFont(new Font("Arial Narrow", Font.BOLD, 17));
						btnEditar.setBounds(751, 16, 156, 62);
						panel.add(btnEditar);
						btnEditar.setBackground(new Color(255, 255, 255));
						btnEditar.setForeground(new Color(32, 178, 170));
						btnEditar.setToolTipText("");
						btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						JButton btnExcluir = new JButton("EXCLUIR");
						btnExcluir.setFont(new Font("Arial Narrow", Font.BOLD, 17));
						btnExcluir.setBounds(295, 16, 156, 62);
						panel.add(btnExcluir);
						btnExcluir.setBackground(new Color(255, 255, 255));
						btnExcluir.setForeground(new Color(32, 178, 170));
						btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btnExcluir.setToolTipText("");
						
								JButton btnRelatorio = new JButton("RELATÓRIO");
								btnRelatorio.setFont(new Font("Arial Narrow", Font.BOLD, 17));
								btnRelatorio.setBounds(523, 16, 156, 62);
								panel.add(btnRelatorio);
								btnRelatorio.setBackground(new Color(255, 255, 255));
								btnRelatorio.setForeground(new Color(32, 178, 170));
								
								// Gerar relatório de fornecedores ======================
								btnRelatorio.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										//controller.gerarRelatorioFornecedores();
									}
								});
								// ======================================================
								btnRelatorio.setToolTipText("Gerar relatório");
								btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								
								panel_1 = new JPanel();
								panel_1.setBackground(new Color(32, 178, 170));
								panel_1.setBounds(0, 0, 984, 133);
								getContentPane().add(panel_1);
								panel_1.setLayout(null);
								
								JLabel lblNewLabel_6 = new JLabel("CENTRAL FORNECEDORES");
								lblNewLabel_6.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/FORNECEDORES.png")));
								lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 30));
								lblNewLabel_6.setForeground(new Color(255, 255, 255));
								lblNewLabel_6.setBounds(32, 40, 448, 60);
								panel_1.add(lblNewLabel_6);
								
								JLabel lblNewLabel_5 = new JLabel("");
								lblNewLabel_5.setBounds(804, 0, 170, 133);
								panel_1.add(lblNewLabel_5);
								lblNewLabel_5.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/LOGO2.png")));
						
								// ======================================================
								// CRUD Delete - Excluir fornecedor =====================
								// ======================================================
								btnExcluir.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										// validação
										if (txtNome.getText().isBlank()) {
											JOptionPane.showMessageDialog(null, "Digite o nome do fornecedor");
											txtNome.requestFocus();
										} else {
											// capturar o id do fornecedor
											int idFornecedor = Integer.parseInt(txtID.getText());
						
											// confirmação de exclusão
											int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir\neste fornecedor?",
													"Atenção!", JOptionPane.YES_OPTION);
											if (resposta == JOptionPane.YES_OPTION) {
												// excluir através do controller
												controller.Excluir(idFornecedor);
												// limpar os campos
												limparCampos();
												// mensagem para o usuário
												JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso.");
											}
										}
									}
								});
						
								// ======================================================
								// CRUD Update - Editar fornecedor ======================
								// ======================================================
								btnEditar.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {	
										// validação de campos obrigatórios
										if (txtNome.getText().isBlank()) {
											JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor");
											txtNome.requestFocus();
										} else if (txtFone.getText().isBlank()) {
											JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor");
											txtFone.requestFocus();
										} else {
											// lógica principal se os os campos obrigatórios estiverem preenchidos
											// Transferir os dados da tela para o Model
											try {
											fornecedor.setIdFornecedor(Integer.parseInt(txtID.getText()));
											fornecedor.setNome(txtNome.getText());
											fornecedor.setFone(txtFone.getText());
											fornecedor.setEmail(txtEmail.getText());
											fornecedor.setSite(txtSite.getText());
											
											// Enviar o objeto para o Controller
											controller.Editar(fornecedor);
						
											// Mensagem para o usuário
											JOptionPane.showMessageDialog(null, "Dados do fornecedor alterados");
						
											// limpar campos
											limparCampos(); 
										} catch (Exception e2) {
											System.out.println(e2);
											return;
										}
									}
									}
									});
				
						// ======================================================
						// CRUD Create - Cadastrar fornecedor ===================
						// ======================================================
						btnAdicionar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// validação de campos obrigatórios
								if (txtNome.getText().isBlank()) {
									JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor");
									txtNome.requestFocus();
								} else if (txtFone.getText().isBlank()) {
									JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor");
									txtFone.requestFocus();
								} else {
									// lógica principal se os os campos obrigatórios estiverem preenchidos
				
									// Transferir os dados da tela para o objeto
									fornecedor.setNome(txtNome.getText());
									fornecedor.setFone(txtFone.getText());
									fornecedor.setEmail(txtEmail.getText());
									fornecedor.setSite(txtSite.getText());
									// Enviar o objeto para o controller
									controller.Adicionar(fornecedor);
									// Mensagem de confirmação
									JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso.");
									// Limpar campos
									limparCampos();
								}
							}
						});
		
	} // fim do construtor

	// ==================================================
	// Limpar campos ====================================
	// ==================================================
	void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		txtSite.setText(null);
		txtNome.requestFocus(); // posicionar o cursor no nome
		btnAdicionar.setEnabled(true);
	}

	// ==================================================
	// Abrir um link no navegador =======================
	// ==================================================
	private void link(String url) {
		// a linha abaixo obtem o desktop do cliente
		Desktop desktop = Desktop.getDesktop();
		// uso do try catch(tratamento de exceções)
		try {
			// objeto uri para acessar os métodos necessários para estabelecer uma conexão
			// com a url (link)
			URI uri = new URI(url);
			// abrir o link no navegador padrão do cliente
			desktop.browse(uri);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite um formato válido de site\nExemplo: https://www.joseassis.com.br");
			txtSite.requestFocus();
		}
	}
}

