package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.ProdutoController;
import model.Produto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmProduto extends JDialog {

    private static final long serialVersionUID = 1L;

    // Controller da tela
    private ProdutoController controllerProduto = new ProdutoController();

    private JTextField txtIDProduto;
    private JTextField txtBarcode;
    private JTextField txtDescricao;
    private JTextField txtIDFornecedor;
    private JTextField txtPrecoCusto;
    private JTextField txtPrecoVenda;
    private JTextField txtQuantidade;
    private JTextField txtEstoqueMinimo;
    private JTextField txtCategoria;

    private JComboBox<String> cboProduto;

    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnLimpar;
    private JButton btnBuscar;

    private JPanel panel;

    public frmProduto(Frame parent, boolean modal) {
        super(parent, modal);

        inicializarComponentes();
        carregarProduto();
    }

    private void inicializarComponentes() {

        setTitle("Cadastro de Produtos");
        setSize(1000, 600);
        setLocationRelativeTo(getParent());
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(null);

        // =========================================================
        // ID DO PRODUTO
        // =========================================================

        JLabel lblIDProduto = new JLabel("ID PRODUTO:");
        lblIDProduto.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblIDProduto.setForeground(new Color(32, 178, 170));
        lblIDProduto.setBounds(30, 155, 100, 25);
        getContentPane().add(lblIDProduto);

        txtIDProduto = new JTextField();
        txtIDProduto.setBounds(130, 155, 100, 25);
        txtIDProduto.setEditable(false);
        getContentPane().add(txtIDProduto);

        // =========================================================
        // CÓDIGO DE BARRAS
        // =========================================================

        JLabel lblBarcode = new JLabel("CÓDIGO DE BARRAS:");
        lblBarcode.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblBarcode.setForeground(new Color(32, 178, 170));
        lblBarcode.setBounds(287, 155, 151, 25);
        getContentPane().add(lblBarcode);

        txtBarcode = new JTextField();
        txtBarcode.setBounds(430, 155, 301, 25);
        getContentPane().add(txtBarcode);

        // =========================================================
        // DESCRIÇÃO
        // =========================================================

        JLabel lblDescricao = new JLabel("DESCRIÇÃO:");
        lblDescricao.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblDescricao.setForeground(new Color(32, 178, 170));
        lblDescricao.setBounds(30, 203, 100, 25);
        getContentPane().add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(130, 203, 601, 25);
        getContentPane().add(txtDescricao);

        // =========================================================
        // CATEGORIA
        // =========================================================

        JLabel lblCategoria = new JLabel("CATEGORIA:");
        lblCategoria.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblCategoria.setForeground(new Color(32, 178, 170));
        lblCategoria.setBounds(30, 261, 100, 25);
        getContentPane().add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(130, 261, 200, 25);
        getContentPane().add(txtCategoria);

        // =========================================================
        // FORNECEDOR
        // =========================================================

        JLabel lblIDFornecedor = new JLabel("ID FORNECEDOR:");
        lblIDFornecedor.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblIDFornecedor.setForeground(new Color(32, 178, 170));
        lblIDFornecedor.setBounds(401, 261, 130, 25);
        getContentPane().add(lblIDFornecedor);

        txtIDFornecedor = new JTextField();
        txtIDFornecedor.setBounds(525, 262, 206, 25);
        getContentPane().add(txtIDFornecedor);

        // =========================================================
        // PREÇO DE CUSTO
        // =========================================================

        JLabel lblPrecoCusto = new JLabel("PREÇO CUSTO:");
        lblPrecoCusto.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblPrecoCusto.setForeground(new Color(32, 178, 170));
        lblPrecoCusto.setBounds(30, 311, 100, 25);
        getContentPane().add(lblPrecoCusto);

        txtPrecoCusto = new JTextField();
        txtPrecoCusto.setBounds(130, 311, 200, 25);
        getContentPane().add(txtPrecoCusto);

        // =========================================================
        // PREÇO DE VENDA
        // =========================================================

        JLabel lblPrecoVenda = new JLabel("PREÇO VENDA:");
        lblPrecoVenda.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblPrecoVenda.setForeground(new Color(32, 178, 170));
        lblPrecoVenda.setBounds(403, 311, 100, 25);
        getContentPane().add(lblPrecoVenda);

        txtPrecoVenda = new JTextField();
        txtPrecoVenda.setBounds(514, 311, 217, 25);
        getContentPane().add(txtPrecoVenda);

        // =========================================================
        // QUANTIDADE
        // =========================================================

        JLabel lblQuantidade = new JLabel("QUANTIDADE:");
        lblQuantidade.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblQuantidade.setForeground(new Color(32, 178, 170));
        lblQuantidade.setBounds(30, 363, 100, 25);
        getContentPane().add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(130, 364, 200, 25);
        getContentPane().add(txtQuantidade);

        // =========================================================
        // ESTOQUE MÍNIMO
        // =========================================================

        JLabel lblEstoqueMinimo = new JLabel("ESTOQUE MÍNIMO:");
        lblEstoqueMinimo.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblEstoqueMinimo.setForeground(new Color(32, 178, 170));
        lblEstoqueMinimo.setBounds(406, 363, 125, 25);
        getContentPane().add(lblEstoqueMinimo);

        txtEstoqueMinimo = new JTextField();
        txtEstoqueMinimo.setBounds(541, 363, 190, 25);
        getContentPane().add(txtEstoqueMinimo);

        // =========================================================
        // SELECIONAR PRODUTO
        // =========================================================

        JLabel lblSelecionar = new JLabel("SELECIONAR PRODUTO:");
        lblSelecionar.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        lblSelecionar.setForeground(new Color(32, 178, 170));
        lblSelecionar.setBounds(30, 410, 178, 25);
        getContentPane().add(lblSelecionar);

        cboProduto = new JComboBox<>();
        cboProduto.setBounds(201, 411, 530, 25);
        getContentPane().add(cboProduto);

        cboProduto.addActionListener(e -> selecionarProduto());

        // =========================================================
        // PAINEL DOS BOTÕES
        // =========================================================

        panel = new JPanel();
        panel.setBackground(SystemColor.scrollbar);
        panel.setForeground(UIManager.getColor("Button.light"));
        panel.setBounds(0, 462, 984, 99);
        panel.setLayout(null);
        getContentPane().add(panel);

        // =========================================================
        // BOTÃO ADICIONAR
        // =========================================================

        btnAdicionar = new JButton("ADICIONAR");
        btnAdicionar.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        btnAdicionar.setForeground(Color.WHITE);
        btnAdicionar.setBackground(new Color(32, 178, 170));
        btnAdicionar.setBounds(53, 25, 162, 35);
        panel.add(btnAdicionar);

        // =========================================================
        // BOTÃO EDITAR
        // =========================================================

        btnEditar = new JButton("EDITAR");
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnEditar.setBackground(new Color(32, 178, 170));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setBounds(229, 26, 162, 35);
        panel.add(btnEditar);

        // =========================================================
        // BOTÃO EXCLUIR
        // =========================================================

        btnExcluir = new JButton("EXCLUIR");
        btnExcluir.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        btnExcluir.setBackground(new Color(32, 178, 170));
        btnExcluir.setForeground(Color.WHITE);
        btnExcluir.setBounds(406, 26, 162, 35);
        panel.add(btnExcluir);

        // =========================================================
        // BOTÃO LIMPAR
        // =========================================================

        btnLimpar = new JButton("LIMPAR");
        btnLimpar.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        btnLimpar.setBackground(new Color(32, 178, 170));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setBounds(583, 26, 162, 35);
        panel.add(btnLimpar);

        // =========================================================
        // BOTÃO BUSCAR
        // =========================================================

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        btnBuscar.setBackground(new Color(32, 178, 170));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(759, 26, 162, 35);
        panel.add(btnBuscar);

        // =========================================================
        // CABEÇALHO
        // =========================================================

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(32, 178, 170));
        panel_1.setBounds(0, 0, 984, 92);
        panel_1.setLayout(null);
        getContentPane().add(panel_1);

        JLabel lblNewLabel = new JLabel("CENTRAL PRODUTOS");
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setIcon(
                new ImageIcon(
                        frmProduto.class.getResource("/img/PRODUTOS.png")
                )
        );
        lblNewLabel.setBounds(28, 0, 518, 90);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(
                new ImageIcon(
                        frmProduto.class.getResource("/img/LOGO2.png")
                )
        );
        lblNewLabel_1.setBounds(804, 229, 151, 105);
        getContentPane().add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		controllerProduto.gerarRelatorioProdutos();
        		
        		
        	}
        });
        btnNewButton.setBounds(795, 365, 89, 23);
        getContentPane().add(btnNewButton);

        // =========================================================
        // EVENTOS DOS BOTÕES
        // =========================================================

        btnBuscar.addActionListener(e -> buscarProduto());

        btnLimpar.addActionListener(e -> limparCampos());

        btnExcluir.addActionListener(e -> excluirProduto());

        btnEditar.addActionListener(e -> editarProduto());

        btnAdicionar.addActionListener(e -> adicionarProduto());
    }

    // =========================================================
    // ADICIONAR PRODUTO
    // =========================================================

    private void adicionarProduto() {

        try {

            if (txtDescricao.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe a descrição do produto."
                );
                txtDescricao.requestFocus();
                return;
            }

            if (txtCategoria.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe a categoria do produto."
                );
                txtCategoria.requestFocus();
                return;
            }

            if (txtIDFornecedor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o ID do fornecedor."
                );
                txtIDFornecedor.requestFocus();
                return;
            }

            if (txtPrecoCusto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o preço de custo."
                );
                txtPrecoCusto.requestFocus();
                return;
            }

            if (txtPrecoVenda.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o preço de venda."
                );
                txtPrecoVenda.requestFocus();
                return;
            }

            if (txtQuantidade.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe a quantidade."
                );
                txtQuantidade.requestFocus();
                return;
            }

            if (txtEstoqueMinimo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o estoque mínimo."
                );
                txtEstoqueMinimo.requestFocus();
                return;
            }

            // =====================================================
            // CRIAR PRODUTO
            // =====================================================

            Produto novoProduto = new Produto();

            novoProduto.setCodigoBarras(
                    txtBarcode.getText().trim()
            );

            novoProduto.setDescricao(
                    txtDescricao.getText().trim()
            );

            novoProduto.setCategoria(
                    txtCategoria.getText().trim()
            );

            novoProduto.setIdFornecedor(
                    Integer.parseInt(
                            txtIDFornecedor.getText().trim()
                    )
            );

            novoProduto.setPrecoCusto(
                    Double.parseDouble(
                            txtPrecoCusto.getText()
                                    .trim()
                                    .replace(",", ".")
                    )
            );

            novoProduto.setPrecoVenda(
                    Double.parseDouble(
                            txtPrecoVenda.getText()
                                    .trim()
                                    .replace(",", ".")
                    )
            );

            novoProduto.setQuantidade(
                    Integer.parseInt(
                            txtQuantidade.getText().trim()
                    )
            );

            novoProduto.setEstoqueMinimo(
                    Integer.parseInt(
                            txtEstoqueMinimo.getText().trim()
                    )
            );

            // =====================================================
            // AQUI ESTAVA O ERRO!
            // AGORA O PRODUTO É REALMENTE ENVIADO AO BANCO
            // =====================================================

            controllerProduto.Adicionar(novoProduto);

            // =====================================================
            // MENSAGEM DE SUCESSO
            // Só chega aqui se o INSERT não gerar exceção
            // =====================================================

            JOptionPane.showMessageDialog(
                    this,
                    "Produto adicionado com sucesso!"
            );

            limparCampos();
            carregarProduto();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Valor numérico inválido!\n\n"
                    + "ID Fornecedor: [" + txtIDFornecedor.getText() + "]\n"
                    + "Preço Custo: [" + txtPrecoCusto.getText() + "]\n"
                    + "Preço Venda: [" + txtPrecoVenda.getText() + "]\n"
                    + "Quantidade: [" + txtQuantidade.getText() + "]\n"
                    + "Estoque Mínimo: [" + txtEstoqueMinimo.getText() + "]\n\n"
                    + "Erro: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao adicionar produto:\n\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // EDITAR PRODUTO
    // =========================================================

    private void editarProduto() {

        try {

            if (txtIDProduto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Selecione um produto para editar."
                );
                return;
            }

            if (txtDescricao.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe a descrição do produto."
                );
                txtDescricao.requestFocus();
                return;
            }

            if (txtCategoria.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe a categoria do produto."
                );
                txtCategoria.requestFocus();
                return;
            }

            if (txtIDFornecedor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o ID do fornecedor."
                );
                txtIDFornecedor.requestFocus();
                return;
            }

            if (txtPrecoCusto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o preço de custo."
                );
                txtPrecoCusto.requestFocus();
                return;
            }

            if (txtPrecoVenda.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o preço de venda."
                );
                txtPrecoVenda.requestFocus();
                return;
            }

            if (txtQuantidade.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe a quantidade."
                );
                txtQuantidade.requestFocus();
                return;
            }

            if (txtEstoqueMinimo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Informe o estoque mínimo."
                );
                txtEstoqueMinimo.requestFocus();
                return;
            }

            Produto produtoEditar = new Produto();

            produtoEditar.setIdProduto(
                    Integer.parseInt(
                            txtIDProduto.getText().trim()
                    )
            );

            produtoEditar.setCodigoBarras(
                    txtBarcode.getText().trim()
            );

            produtoEditar.setDescricao(
                    txtDescricao.getText().trim()
            );

            produtoEditar.setCategoria(
                    txtCategoria.getText().trim()
            );

            produtoEditar.setIdFornecedor(
                    Integer.parseInt(
                            txtIDFornecedor.getText().trim()
                    )
            );

            produtoEditar.setPrecoCusto(
                    Double.parseDouble(
                            txtPrecoCusto.getText()
                                    .trim()
                                    .replace(",", ".")
                    )
            );

            produtoEditar.setPrecoVenda(
                    Double.parseDouble(
                            txtPrecoVenda.getText()
                                    .trim()
                                    .replace(",", ".")
                    )
            );

            produtoEditar.setQuantidade(
                    Integer.parseInt(
                            txtQuantidade.getText().trim()
                    )
            );

            produtoEditar.setEstoqueMinimo(
                    Integer.parseInt(
                            txtEstoqueMinimo.getText().trim()
                    )
            );

            controllerProduto.Editar(produtoEditar);

            JOptionPane.showMessageDialog(
                    this,
                    "Produto atualizado com sucesso!"
            );

            limparCampos();
            carregarProduto();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Verifique os campos numéricos.\n"
                    + "ID, fornecedor, preços, quantidade e "
                    + "estoque mínimo devem conter valores válidos.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao editar produto:\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // EXCLUIR PRODUTO
    // =========================================================

    private void excluirProduto() {

        try {

            if (txtIDProduto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Selecione um produto para excluir."
                );
                return;
            }

            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente excluir este produto?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta != JOptionPane.YES_OPTION) {
                return;
            }

            int idProduto = Integer.parseInt(
                    txtIDProduto.getText().trim()
            );

            boolean excluido =
                    controllerProduto.Excluir(idProduto);

            if (excluido) {

                JOptionPane.showMessageDialog(
                        this,
                        "Produto excluído com sucesso!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum produto foi excluído.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );
            }

            limparCampos();
            carregarProduto();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "ID do produto inválido.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao excluir produto:\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // BUSCAR PRODUTO
    // =========================================================

    private void buscarProduto() {

        try {

            String descricao =
                    txtDescricao.getText().trim();

            if (descricao.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Digite a descrição do produto para buscar."
                );

                txtDescricao.requestFocus();
                return;
            }

            Produto produtoEncontrado =
                    controllerProduto.buscar(descricao);

            if (produtoEncontrado == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum produto encontrado."
                );

                return;
            }

            preencherCampos(produtoEncontrado);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao buscar produto:\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // CARREGAR PRODUTOS
    // =========================================================

    private void carregarProduto() {

        try {

            cboProduto.removeAllItems();

            ArrayList<Produto> lista =
                    controllerProduto.listaproduto();

            if (lista == null) {
                return;
            }

            for (Produto produto : lista) {

                String item =
                        produto.getIdProduto()
                        + " - "
                        + produto.getDescricao();

                cboProduto.addItem(item);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao carregar produtos:\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // SELECIONAR PRODUTO
    // =========================================================

    private void selecionarProduto() {

        try {

            if (cboProduto.getSelectedItem() == null) {
                return;
            }

            String item =
                    cboProduto.getSelectedItem().toString();

            if (item.trim().isEmpty()) {
                return;
            }

            String[] partes =
                    item.split(" - ", 2);

            if (partes.length == 0) {
                return;
            }

            int idProduto =
                    Integer.parseInt(
                            partes[0].trim()
                    );

            ArrayList<Produto> lista =
                    controllerProduto.listaproduto();

            if (lista == null) {
                return;
            }

            for (Produto produto : lista) {

                if (produto.getIdProduto() == idProduto) {

                    preencherCampos(produto);
                    break;
                }
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "ID do produto inválido.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao selecionar produto:\n"
                    + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // PREENCHER CAMPOS
    // =========================================================

    private void preencherCampos(Produto produto) {

        if (produto == null) {
            return;
        }

        txtIDProduto.setText(
                String.valueOf(
                        produto.getIdProduto()
                )
        );

        txtDescricao.setText(
                produto.getDescricao()
        );

        txtCategoria.setText(
                produto.getCategoria()
        );

        txtIDFornecedor.setText(
                String.valueOf(
                        produto.getIdFornecedor()
                )
        );

        txtPrecoCusto.setText(
                String.valueOf(
                        produto.getPrecoCusto()
                )
        );

        txtPrecoVenda.setText(
                String.valueOf(
                        produto.getPrecoVenda()
                )
        );

        txtQuantidade.setText(
                String.valueOf(
                        produto.getQuantidade()
                )
        );

        txtEstoqueMinimo.setText(
                String.valueOf(
                        produto.getEstoqueMinimo()
                )
        );

        txtBarcode.setText(
                produto.getCodigoBarras()
        );
    }

    // =========================================================
    // LIMPAR CAMPOS
    // =========================================================

    private void limparCampos() {

        txtIDProduto.setText("");
        txtBarcode.setText("");
        txtDescricao.setText("");
        txtIDFornecedor.setText("");
        txtPrecoCusto.setText("");
        txtPrecoVenda.setText("");
        txtQuantidade.setText("");
        txtEstoqueMinimo.setText("");
        txtCategoria.setText("");

        if (cboProduto.getItemCount() > 0) {
            cboProduto.setSelectedIndex(-1);
        }

        txtDescricao.requestFocus();
    }
}