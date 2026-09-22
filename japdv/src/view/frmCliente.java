package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ClienteController;
import model.Cliente;

public class frmCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtContato;
	private JTextField txtEndereco;
	private JTextField txtCEP;
	private JTextField txtBairro;
	private JTextField textCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmCliente dialog = new frmCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmCliente() {
		
		ClienteController controller = new ClienteController();

		// Criar o objeto fornecedor
		Cliente cliente = new Cliente();

		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		contentPanel.setForeground(Color.ORANGE);
		contentPanel.setBounds(0, 0, 784, 461);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(100, 99, 488, 30);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(100, 140, 488, 30);
		contentPanel.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 181, 279, 30);
		contentPanel.add(txtEmail);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(452, 181, 279, 30);
		contentPanel.add(txtContato);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(100, 237, 631, 30);
		contentPanel.add(txtEndereco);
		
		txtCEP = new JTextField();
		txtCEP.setColumns(10);
		txtCEP.setBounds(100, 278, 279, 30);
		contentPanel.add(txtCEP);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(100, 319, 279, 30);
		contentPanel.add(txtBairro);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblID.setForeground(new Color(32, 178, 170));
		lblID.setToolTipText("");
		lblID.setBounds(34, 107, 46, 14);
		contentPanel.add(lblID);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(new Color(32, 178, 170));
		lblNome.setToolTipText("");
		lblNome.setBounds(34, 148, 46, 14);
		contentPanel.add(lblNome);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContato.setForeground(new Color(32, 178, 170));
		lblContato.setToolTipText("");
		lblContato.setBounds(396, 189, 46, 14);
		contentPanel.add(lblContato);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(new Color(32, 178, 170));
		lblEmail.setBackground(new Color(32, 178, 170));
		lblEmail.setToolTipText("");
		lblEmail.setBounds(34, 189, 46, 14);
		contentPanel.add(lblEmail);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereo.setForeground(new Color(32, 178, 170));
		lblEndereo.setToolTipText("");
		lblEndereo.setBounds(34, 245, 76, 14);
		contentPanel.add(lblEndereo);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setForeground(new Color(32, 178, 170));
		lblCep.setToolTipText("");
		lblCep.setBounds(34, 286, 46, 14);
		contentPanel.add(lblCep);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(452, 319, 279, 30);
		contentPanel.add(textCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setForeground(new Color(32, 178, 170));
		lblBairro.setToolTipText("");
		lblBairro.setBounds(34, 327, 46, 14);
		contentPanel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("cidade");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setForeground(new Color(32, 178, 170));
		lblCidade.setToolTipText("");
		lblCidade.setBounds(406, 327, 46, 14);
		contentPanel.add(lblCidade);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 784, 76);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCentralClientes = new JLabel("Central Clientes");
		lblCentralClientes.setBackground(Color.WHITE);
		lblCentralClientes.setIcon(new ImageIcon(frmCliente.class.getResource("/img/CLIENTES.png")));
		lblCentralClientes.setToolTipText("");
		lblCentralClientes.setForeground(SystemColor.textHighlightText);
		lblCentralClientes.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblCentralClientes.setBounds(39, 11, 416, 46);
		panel.add(lblCentralClientes);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(100, 222, 641, 22);
		contentPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(100, 360, 641, 22);
		contentPanel.add(separator_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(220, 220, 220));
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBounds(0, 376, 784, 85);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBounds(48, 26, 137, 43);
		panel_1.add(btnAdicionar);
		btnAdicionar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// validação de campos obrigatórios
				if (txtNome.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor");
					txtNome.requestFocus();
				} else if (txtContato.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor");
					txtContato.requestFocus();
				} else {
					// lógica principal se os os campos obrigatórios estiverem preenchidos

					// Transferir os dados da tela para o objeto
					cliente.setNome(txtNome.getText());
					cliente.setCpf(txtCEP.getText());
					cliente.setContato(txtContato.getText());
					cliente.setEmail(txtEmail.getText());
					
					cliente.setEndereco(txtEndereco.getText());
					// Enviar o objeto para o controller
					controller.Adicionar(cliente);
					// Mensagem de confirmação
					JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso.");
					// Limpar campos
					limparCampos();
				}	
			}
		});
		btnAdicionar.setIconTextGap(12);
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setBackground(new Color(32, 178, 170));
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setIconTextGap(12);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setBorderPainted(false);
		btnEditar.setBackground(new Color(32, 178, 170));
		btnEditar.setBounds(237, 26, 129, 43);
		panel_1.add(btnEditar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setIconTextGap(12);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBackground(new Color(32, 178, 170));
		btnExcluir.setBounds(429, 26, 129, 43);
		panel_1.add(btnExcluir);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setIconTextGap(12);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(new Color(32, 178, 170));
		btnVoltar.setBounds(604, 26, 129, 43);
		panel_1.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(614, 81, 113, 89);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(frmCliente.class.getResource("/img/LOGO2.png")));
	}
	
	// ==================================================
	// Limpar campos ====================================
	// ==================================================
	void limparCampos() {
		//txtID.setText(null);
		txtNome.setText(null);
		txtEndereco.setText(null);
		txtEmail.setText(null);
		txtContato.setText(null);
		txtCEP.setText(null);
		txtNome.requestFocus(); // posicionar o cursor no nome
		//btnAdicionar.setEnabled(true);
	}

	
}
