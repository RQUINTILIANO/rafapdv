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

public class frmFornecedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtID;
	private JTextField txtSite;
	private JButton btnAdicionar;

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
		setBounds(100, 100, 640, 480);

		// criar o objeto controller
		// controller = new FornecedorController(); //sintaxe moderna
		FornecedorController controller = new FornecedorController();

		// Criar o objeto fornecedor
		Fornecedor fornecedor = new Fornecedor();

		// iniciar centralizado
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(53, 101, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fone");
		lblNewLabel_1.setBounds(55, 155, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setBounds(53, 208, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtNome = new JTextField();
		txtNome.setBounds(109, 95, 352, 28);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		// validação do número máximo de caracteres
		txtNome.setDocument(new Validador(50));

		txtFone = new JTextField();
		txtFone.setBounds(109, 148, 208, 28);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);
		// validação do número máximo de caracteres
		txtFone.setDocument(new Validador(20));

		txtEmail = new JTextField();
		txtEmail.setBounds(109, 200, 459, 28);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		// validação do número máximo de caracteres
		txtEmail.setDocument(new Validador(50));

		btnAdicionar = new JButton("");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/create.png")));

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
		// Fim - CRUD Create ====================================

		btnAdicionar.setBounds(36, 334, 64, 64);
		getContentPane().add(btnAdicionar);

		JButton btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar");
		btnEditar.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/update.png")));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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

		btnEditar.setBounds(108, 334, 64, 64);
		getContentPane().add(btnEditar);
		JButton btnExcluir = new JButton("");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/delete.png")));
		btnExcluir.setToolTipText("Excluir");

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

		btnExcluir.setBounds(181, 334, 64, 64);
		getContentPane().add(btnExcluir);

		JButton btnRelatorio = new JButton("");
		
		// Gerar relatório de fornecedores ======================
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.gerarRelatorioFornecedores();
			}
		});
		// ======================================================
		btnRelatorio.setToolTipText("Gerar relatório");
		btnRelatorio.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/pdf_forn.png")));
		btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorio.setBounds(274, 334, 64, 64);
		getContentPane().add(btnRelatorio);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(53, 54, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(109, 51, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
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

		btnBuscar.setBounds(478, 93, 100, 30);
		getContentPane().add(btnBuscar);

		JLabel lblNewLabel_4 = new JLabel("Site");
		lblNewLabel_4.setBounds(65, 259, 46, 14);
		getContentPane().add(lblNewLabel_4);

		txtSite = new JTextField();
		txtSite.setBounds(109, 252, 352, 28);
		getContentPane().add(txtSite);
		txtSite.setColumns(10);

		JButton btnAcessar = new JButton("Acessar");
		
		// Acessar link externo =========================
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String site = txtSite.getText();
				// Executar o método passando o site
				link(site);
				
			}
		});
		// ==============================================
		
		btnAcessar.setBounds(471, 254, 71, 25);
		getContentPane().add(btnAcessar);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(frmFornecedor.class.getResource("/img/supliers.png")));
		lblNewLabel_5.setBounds(489, 319, 113, 96);
		getContentPane().add(lblNewLabel_5);
		
		//Definir um botão padrão (Associar o Enter a este botão)
		getRootPane().setDefaultButton(btnBuscar);		
		
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

