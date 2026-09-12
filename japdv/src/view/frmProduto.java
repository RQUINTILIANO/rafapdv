package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

//importar o fornecedorController (como box)
import controller.FornecedorController;
//importar o ProdutoController (CRUD produtos)
import controller.ProdutoController;
//Importar os modelos de dados
import model.Fornecedor;
import model.Produto;

public class frmProduto extends JDialog {
	
	//Criar os obejtos controller (fornecedores e produtos)
	FornecedorController controllerFornecedor = new FornecedorController();
    ProdutoController controllerProduto = new ProdutoController();
    
    
    //Criar os objetos fornecedor e produto
    Fornecedor fornecedor = new Fornecedor();
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
		
		fornecedor = new Fornecedor();
		
		setModal(true);
		setResizable(false);
		setTitle("Produtos");
		setBounds(100, 100, 640, 480);
		
		setLocationRelativeTo(null); //centralizar
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(31, 38, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtIDProduto = new JTextField();
		txtIDProduto.setEnabled(false);
		txtIDProduto.setBounds(63, 35, 86, 20);
		getContentPane().add(txtIDProduto);
		txtIDProduto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(frmProduto.class.getResource("/img/barcode.png")));
		lblNewLabel_1.setBounds(525, 11, 64, 64);
		getContentPane().add(lblNewLabel_1);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(178, 31, 325, 28);
		getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Produto");
		lblNewLabel_2.setBounds(31, 91, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(87, 84, 416, 28);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fornecedor");
		lblNewLabel_3.setBounds(345, 142, 74, 14);
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
		cboFornecedor.setBounds(419, 135, 179, 28);
		getContentPane().add(cboFornecedor);
		
		JLabel lblNewLabel_4 = new JLabel("ID Fornecedor");
		lblNewLabel_4.setBounds(523, 220, 86, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtIDFornecedor = new JTextField();
		txtIDFornecedor.setEnabled(false);
		txtIDFornecedor.setBounds(513, 191, 86, 20);
		getContentPane().add(txtIDFornecedor);
		txtIDFornecedor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Custo");
		lblNewLabel_5.setBounds(31, 197, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtPrecoCusto = new JTextField();
		txtPrecoCusto.setBounds(79, 188, 102, 28);
		getContentPane().add(txtPrecoCusto);
		txtPrecoCusto.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Venda");
		lblNewLabel_6.setBounds(232, 197, 64, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtPrecoVenda = new JTextField();
		txtPrecoVenda.setColumns(10);
		txtPrecoVenda.setBounds(281, 188, 102, 28);
		getContentPane().add(txtPrecoVenda);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(107, 241, 74, 28);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Quantidade");
		lblNewLabel_7.setBounds(31, 248, 74, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Estoque mínimo");
		lblNewLabel_8.setBounds(205, 248, 102, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtEstoqueMinimo = new JTextField();
		txtEstoqueMinimo.setBounds(306, 241, 74, 28);
		getContentPane().add(txtEstoqueMinimo);
		txtEstoqueMinimo.setColumns(10);
		
		JButton btnAdicionarProduto = new JButton("");
		btnAdicionarProduto.setToolTipText("Adicionar");
		btnAdicionarProduto.setIcon(new ImageIcon(frmProduto.class.getResource("/img/boxadd.png")));
		btnAdicionarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarProduto.setBounds(31, 332, 64, 64);
		getContentPane().add(btnAdicionarProduto);
		
		JButton btnEditarProduto = new JButton("");
		btnEditarProduto.setIcon(new ImageIcon(frmProduto.class.getResource("/img/boxupdate.png")));
		btnEditarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarProduto.setToolTipText("Editar");
		btnEditarProduto.setBounds(101, 332, 64, 64);
		getContentPane().add(btnEditarProduto);
		
		JButton btnExcluirProduto = new JButton("");
		btnExcluirProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirProduto.setToolTipText("Excluir");
		btnExcluirProduto.setIcon(new ImageIcon(frmProduto.class.getResource("/img/boxdel.png")));
		btnExcluirProduto.setBounds(171, 332, 64, 64);
		getContentPane().add(btnExcluirProduto);
		
		JButton btnRelatorioProdutos = new JButton("");
		btnRelatorioProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorioProdutos.setToolTipText("Gerar Relatório");
		btnRelatorioProdutos.setIcon(new ImageIcon(frmProduto.class.getResource("/img/pdf_forn.png")));
		btnRelatorioProdutos.setBounds(261, 332, 64, 64);
		getContentPane().add(btnRelatorioProdutos);
		
		JLabel lblNewLabel_9 = new JLabel("Categoria");
		lblNewLabel_9.setBounds(31, 142, 64, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(92, 135, 216, 28);
		getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(frmProduto.class.getResource("/img/products.png")));
		lblNewLabel_10.setBounds(470, 291, 128, 128);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(frmProduto.class.getResource("/img/search.png")));
		lblNewLabel_11.setBounds(513, 86, 24, 24);
		getContentPane().add(lblNewLabel_11);
		
		//Executar o metodo para carregar o ID dos fornecedores
		carregarFornecedor();
	

	}// fim do construtor
	
	//=================================================
	//preencher o como box com a lista de fornecedores 
	//=================================================
	 private void carregarFornecedor(){
		 //limpar o como box
		 cboFornecedor.removeAllItems();
		 //Opção padrão
		 cboFornecedor.addItem("selecione");
		 //Executar o método para buscar a lista de fornecedores(array)
		 ArrayList<Fornecedor> lista = controllerFornecedor.listaFornecedores();
		 //Percorrer o vetor e adicionar os fornecedores ao comobox
		 for (Fornecedor fornecedor : lista) {
	     Object cbo;
		 //Exibir o ID e nome do fornecedor no comobox
		 cboFornecedor.addItem(fornecedor.getIdFornecedor() + " - " + fornecedor.getNome());
		 }
	 }
	//=================================================
	
	
}

