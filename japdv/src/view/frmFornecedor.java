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

public class frmFornecedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtID;
	private JTextField txtSite;

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
		lblNewLabel.setBounds(52, 93, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fone");
		lblNewLabel_1.setBounds(52, 151, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setBounds(52, 207, 46, 14);
		getContentPane().add(lblNewLabel_2);

		txtNome = new JTextField();
		txtNome.setBounds(108, 87, 352, 28);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		// validação do número máximo de caracteres
		txtNome.setDocument(new Validador(50));

		txtFone = new JTextField();
		txtFone.setBounds(108, 145, 208, 28);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);
		// validação do número máximo de caracteres
		txtFone.setDocument(new Validador(20));

		txtEmail = new JTextField();
		txtEmail.setBounds(108, 201, 459, 28);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		// validação do número máximo de caracteres
		txtEmail.setDocument(new Validador(50));

		JButton btnAdicionar = new JButton("Adicionar");

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
					controller.adicionar(fornecedor);
					// Mensagem de confirmação
					JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso.");
					// Limpar campos
					limparCampos();
				}
			}
		});
		// Fim - CRUD Create ====================================

		btnAdicionar.setBounds(69, 342, 89, 23);
		getContentPane().add(btnAdicionar);

		JButton btnEditar = new JButton("Editar");

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
					fornecedor.setIdFornecedor(Integer.parseInt(txtID.getText()));
					fornecedor.setNome(txtNome.getText());
					fornecedor.setFone(txtFone.getText());
					fornecedor.setEmail(txtEmail.getText());
					fornecedor.setSite(txtSite.getText());
					
					// Enviar o objeto para o Controller
					controller.editarFornecedor(fornecedor);

					// Mensagem para o usuário
					JOptionPane.showMessageDialog(null, "Dados do fornecedor alterados");

					// limpar campos
					limparCampos();
				}
			}
		});
		// ======================================================

		btnEditar.setBounds(203, 342, 89, 23);
		getContentPane().add(btnEditar);
		JButton btnExcluir = new JButton("Excluir");

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
						controller.excluir(idFornecedor);
						// limpar os campos
						limparCampos();
						// mensagem para o usuário
						JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso.");
					}
				}
			}
		});
		// ======================================================

		btnExcluir.setBounds(334, 342, 89, 23);
		getContentPane().add(btnExcluir);

		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.setBounds(463, 342, 89, 23);
		getContentPane().add(btnRelatorio);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(52, 46, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(108, 43, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");

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

					} else {
						JOptionPane.showMessageDialog(null, "Fornecedor não cadastrado");
						limparCampos();
					}
				}
			}
		});
		// Fim CRUD Read ====================================

		btnBuscar.setBounds(486, 90, 89, 23);
		getContentPane().add(btnBuscar);

		JLabel lblNewLabel_4 = new JLabel("Site");
		lblNewLabel_4.setBounds(52, 264, 46, 14);
		getContentPane().add(lblNewLabel_4);

		txtSite = new JTextField();
		txtSite.setBounds(108, 257, 352, 28);
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
		
		btnAcessar.setBounds(486, 260, 89, 23);
		getContentPane().add(btnAcessar);

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
			System.out.println(e);
		}
	}

}
