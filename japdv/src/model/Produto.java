package model;

public class Produto {

    private int idProduto;
    private String codigoBarras;
    private String descricao;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int quantidade;
    private int estoqueMinimo;
    private int idFornecedor;

    // =========================
    // ID PRODUTO
    // =========================

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    // =========================
    // CÓDIGO DE BARRAS
    // =========================

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    // =========================
    // DESCRIÇÃO
    // =========================

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // =========================
    // CATEGORIA
    // =========================

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // =========================
    // PREÇO DE CUSTO
    // =========================

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    // =========================
    // PREÇO DE VENDA
    // =========================

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    // =========================
    // QUANTIDADE
    // =========================

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // =========================
    // ESTOQUE MÍNIMO
    // =========================

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    // =========================
    // ID FORNECEDOR
    // =========================

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
}