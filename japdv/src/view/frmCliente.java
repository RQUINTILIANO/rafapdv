package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class frmCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 140, 488, 30);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 181, 279, 30);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(452, 181, 279, 30);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(100, 237, 631, 30);
		contentPanel.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(100, 278, 279, 30);
		contentPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(100, 319, 279, 30);
		contentPanel.add(textField_7);
		
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
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(452, 319, 279, 30);
		contentPanel.add(textField_8);
		
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
		
		JButton btnAdicionar_1_1 = new JButton("EXCLUIR");
		btnAdicionar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar_1_1.setIconTextGap(12);
		btnAdicionar_1_1.setForeground(Color.WHITE);
		btnAdicionar_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionar_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar_1_1.setBorderPainted(false);
		btnAdicionar_1_1.setBackground(new Color(32, 178, 170));
		btnAdicionar_1_1.setBounds(429, 26, 129, 43);
		panel_1.add(btnAdicionar_1_1);
		
		JButton btnAdicionar_1_1_1 = new JButton("VOLTAR");
		btnAdicionar_1_1_1.setIconTextGap(12);
		btnAdicionar_1_1_1.setForeground(Color.WHITE);
		btnAdicionar_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionar_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar_1_1_1.setBorderPainted(false);
		btnAdicionar_1_1_1.setBackground(new Color(32, 178, 170));
		btnAdicionar_1_1_1.setBounds(604, 26, 129, 43);
		panel_1.add(btnAdicionar_1_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(614, 81, 113, 89);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(frmCliente.class.getResource("/img/LOGO2.png")));
	}
}
