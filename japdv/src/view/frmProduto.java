package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//importar o ProdutoController (CRUD produtos)
import controller.ProdutoController;
import model.Produto;

public class frmProduto extends JDialog {
	
	//Criar os obejtos controller (produtos)
	ProdutoController controllerProduto = new ProdutoController();
     
    //Criar os objetos fornecedor e produto
    Produto produto = new Produto();
   	
	private static final long serialVersionUID = 1L;
	private JTextField txtIDProduto;
	private JTextField txtBarcode;
	private JTextField txtDescricao;
	private JTextField txtIDFornecedor;
	private JTextField txtPrecoCusto;
	private JTextField txtPrecoVenda;
	private JTextField txtQuantidade;
	private JTextField txtEstoqueMinimo;
	private JTextField txtCategoria;
	private JComboBox<String>cboFornecedor;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProduto dialog = new frmProduto();
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
	public frmProduto() {
		
		produto = new Produto();
		
		setModal(true);
		setResizable(false);
		setTitle("Produtos");
		setBounds(100, 100, 1000, 600);
		
		setLocationRelativeTo(null); //centralizar
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setBounds(37, 146, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtIDProduto = new JTextField();
		txtIDProduto.setEnabled(false);
		txtIDProduto.setBounds(138, 144, 86, 20);
		getContentPane().add(txtIDProduto);
		txtIDProduto.setColumns(10);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(407, 140, 365, 28);
		getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUTO");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(32, 178, 170));
		lblNewLabel_2.setBounds(37, 194, 119, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(138, 188, 312, 28);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("FORNECEDOR");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(32, 178, 170));
		lblNewLabel_3.setBounds(485, 267, 108, 14);
		getContentPane().add(lblNewLabel_3);
		
		cboFornecedor = new JComboBox();
		//=========================================================
		//Evento que seleciona um item da lista (id do fornecedor)
		cboFornecedor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//Obter o intem selecionado do comobox
		String selecionado= (String) cboFornecedor.getSelectedItem();
		
		
	    // SE item for selecionado 
			if(selecionado != null && !selecionado.equals("selecione")){
		//separar o ID	do nome (Indice [0] do vetor)
			String id = selecionado.split(" - ")[0];
		//setar (preencher) o id do fornecedor
			txtIDFornecedor.setText(id);
			} else {
	    //Nenhum forncedor adicionado
			txtIDFornecedor.setText("");
				
				
			}
			}
		});
		//=========================================================
		cboFornecedor.setBounds(593, 261, 179, 28);
		getContentPane().add(cboFornecedor);
		
		JLabel lblNewLabel_4 = new JLabel("ID Fornecedor");
		lblNewLabel_4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(32, 178, 170));
		lblNewLabel_4.setBounds(488, 311, 133, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtIDFornecedor = new JTextField();
		txtIDFornecedor.setEnabled(false);
		txtIDFornecedor.setBounds(593, 309, 86, 20);
		getContentPane().add(txtIDFornecedor);
		txtIDFornecedor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CUSTO");
		lblNewLabel_5.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_5.setForeground(new Color(32, 178, 170));
		lblNewLabel_5.setBounds(37, 311, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtPrecoCusto = new JTextField();
		txtPrecoCusto.setBounds(138, 305, 102, 28);
		getContentPane().add(txtPrecoCusto);
		txtPrecoCusto.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("VENDA");
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(32, 178, 170));
		lblNewLabel_6.setBounds(256, 311, 64, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtPrecoVenda = new JTextField();
		txtPrecoVenda.setColumns(10);
		txtPrecoVenda.setBounds(319, 305, 133, 28);
		getContentPane().add(txtPrecoVenda);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(137, 386, 74, 28);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("QUANTIDADE");
		lblNewLabel_7.setForeground(new Color(32, 178, 170));
		lblNewLabel_7.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_7.setBounds(37, 392, 119, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("ESTOQUE MÍNIMO");
		lblNewLabel_8.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_8.setForeground(new Color(32, 178, 170));
		lblNewLabel_8.setBounds(244, 392, 141, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtEstoqueMinimo = new JTextField();
		txtEstoqueMinimo.setBounds(376, 386, 74, 28);
		getContentPane().add(txtEstoqueMinimo);
		txtEstoqueMinimo.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("CATEGORIA");
		lblNewLabel_9.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_9.setForeground(new Color(32, 178, 170));
		lblNewLabel_9.setBounds(37, 267, 119, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(138, 261, 312, 28);
		getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 442, 984, 119);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAdicionarProduto = new JButton("ADICIONAR");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarProduto.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnAdicionarProduto.setForeground(new Color(32, 178, 170));
		btnAdicionarProduto.setBounds(99, 24, 145, 64);
		panel.add(btnAdicionarProduto);
		btnAdicionarProduto.setToolTipText("Adicionar");
		btnAdicionarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnEditarProduto = new JButton("EDITAR");
		btnEditarProduto.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnEditarProduto.setForeground(new Color(32, 178, 170));
		btnEditarProduto.setBounds(302, 24, 151, 64);
		panel.add(btnEditarProduto);
		btnEditarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarProduto.setToolTipText("Editar");
		
		JButton btnExcluirProduto = new JButton("EXCLUIR");
		btnExcluirProduto.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnExcluirProduto.setForeground(new Color(32, 178, 170));
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirProduto.setBounds(497, 24, 170, 64);
		panel.add(btnExcluirProduto);
		btnExcluirProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirProduto.setToolTipText("Excluir");
		
		JButton btnRelatorioProdutos = new JButton("GERAR RELATÓRIO");
		btnRelatorioProdutos.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnRelatorioProdutos.setForeground(new Color(32, 178, 170));
		btnRelatorioProdutos.setBounds(715, 24, 170, 64);
		panel.add(btnRelatorioProdutos);
		btnRelatorioProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorioProdutos.setToolTipText("GERAR RELATÓRIO");
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 0, 984, 124);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("CENTRAL DE PRODUTOS");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setIcon(new ImageIcon(frmProduto.class.getResource("/img/PRODUTOS.png")));
		lblNewLabel_10.setBounds(34, 25, 596, 77);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(841, 307, 133, 124);
		getContentPane().add(lblNewLabel_12);
		lblNewLabel_12.setIcon(new ImageIcon(frmProduto.class.getResource("/img/LOGO2.png")));
		
		JLabel lblNewLabel_13_1 = new JLabel("______________________________________________________________________________________________________________");
		lblNewLabel_13_1.setForeground(SystemColor.scrollbar);
		lblNewLabel_13_1.setBounds(40, 350, 817, 14);
		getContentPane().add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_13_1_1 = new JLabel("______________________________________________________________________________________________________________");
		lblNewLabel_13_1_1.setForeground(SystemColor.scrollbar);
		lblNewLabel_13_1_1.setBounds(37, 219, 817, 14);
		getContentPane().add(lblNewLabel_13_1_1);
		
		JLabel lblCodBarras = new JLabel("CÓDIGO DE BARRAS");
		lblCodBarras.setForeground(new Color(32, 178, 170));
		lblCodBarras.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblCodBarras.setBounds(256, 146, 228, 14);
		getContentPane().add(lblCodBarras);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(485, 191, 108, 23);
		getContentPane().add(btnNewButton);
		
		//Executar o metodo para carregar o ID dos fornecedores
		carregarFornecedor();
	
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// validação de campos obrigatórios
				if (txtNome.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do produto");
					txtNome.requestFocus();
				} else if (txtFone.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do produto");
					txtFone.requestFocus();
				} else {
					// lógica principal se os os campos obrigatórios estiverem preenchidos

					// Transferir os dados da tela para o objeto
					produto.setIdProduto(txtIdProduto.getText());
					produto.setDescricao(txtDescricao.getText());
					produto.setCategoria(txtCategoria.getText());
					produto.setIdFornecedor(txtIdFornecedor.getText());
					produto.setPrecoCusto(txtPrecoCusto.getText());
					produto.setPrecoVenda(txtPrecoVenda.getText());
					produto.setQuantidade(txtQuantidade.getText());
					produto.setEstoqueMinimo(txtEstoqueMinimo.getText());
					// Enviar o objeto para o controller
					controller.Adicionar(produto);
					// Mensagem de confirmação
					JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso.");
					// Limpar campos
					limparCampos();
				}
			}
		});

	}// fim do construtor
	
	//=================================================
	//preencher o como box com a lista de clientes 
	//=================================================
	 private void carregarProduto(){
		 //limpar o como box
		 cboProduto.removeAllItems();
		 //Opção padrão
		 cboProduto.addItem("selecione");
		 //Executar o método para buscar a lista de produtos(array)
		 ArrayList<Produto> lista = controllerProduto.listaproduto();
		 //Percorrer o vetor e adicionar os fornecedores ao comobox
		 for (Produto produto : lista) {
	     Object cbo;
		 //Exibir o ID e nome do fornecedor no comobox
		 cboProduto.addItem(produto.getIdProduto() + " - " + produto.getNome());
		 }
	 }
	//=================================================
		// CRUD Delete - Excluir produto =====================
		// ======================================================
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// validação
				if (txtNome.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Digite o nome do produto");
					txtNome.requestFocus();
				} else {
					// capturar o id do produto
					int idProduto = Integer.parseInt(txtID.getText());

					// confirmação de exclusão
					int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir\neste produto?",
							"Atenção!", JOptionPane.YES_OPTION);
					if (resposta == JOptionPane.YES_OPTION) {
						// excluir através do controller
						controller.Excluir(idProduto);
						// limpar os campos
						limparCampos();
						// mensagem para o usuário
						JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
					}
				}
			}
		});
	
}

