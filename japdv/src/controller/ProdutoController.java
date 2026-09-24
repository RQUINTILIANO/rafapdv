package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
 
import javax.swing.JOptionPane;
 
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
 


import database.Database;
import model.Produto;
public class ProdutoController {

    private Database database;

    public ProdutoController() {
        database = new Database();
    }

    // =========================
    // ADICIONAR PRODUTO
    // =========================
    public boolean Adicionar(Produto produto) throws Exception {

        String sql = """
            INSERT INTO produtos
            (codigoBarras, descricao, categoria, precoCusto,
             precoVenda, quantidade, estoqueMinimo, idFornecedor)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        Connection con = database.conectar();

        if (con == null) {
            throw new Exception("Não foi possível conectar ao banco de dados.");
        }

        System.out.println("=================================");
        System.out.println("CONEXÃO REALIZADA");
        System.out.println("Banco: " + con.getCatalog());
        System.out.println("URL: " + con.getMetaData().getURL());
        System.out.println("AutoCommit: " + con.getAutoCommit());
        System.out.println("=================================");

        PreparedStatement stmt = con.prepareStatement(
            sql,
            java.sql.Statement.RETURN_GENERATED_KEYS
        );

        stmt.setString(1, produto.getCodigoBarras());
        stmt.setString(2, produto.getDescricao());
        stmt.setString(3, produto.getCategoria());
        stmt.setDouble(4, produto.getPrecoCusto());
        stmt.setDouble(5, produto.getPrecoVenda());
        stmt.setInt(6, produto.getQuantidade());
        stmt.setInt(7, produto.getEstoqueMinimo());
        stmt.setInt(8, produto.getIdFornecedor());

        System.out.println("Tentando inserir:");
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Categoria: " + produto.getCategoria());
        System.out.println("ID Fornecedor: " + produto.getIdFornecedor());

        int resultado = stmt.executeUpdate();

        System.out.println("=================================");
        System.out.println("RESULTADO DO INSERT: " + resultado);
        System.out.println("=================================");

        if (resultado == 0) {
            throw new Exception("O INSERT não inseriu nenhuma linha.");
        }

        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            System.out.println("ID GERADO: " + rs.getInt(1));
        }

        rs.close();
        stmt.close();
        con.close();

        System.out.println("PRODUTO INSERIDO COM SUCESSO!");

        return resultado > 0;
    }
    // =========================
    // EDITAR PRODUTO
    // =========================
    public void Editar(Produto produto) throws Exception {

        String sql = """
            UPDATE produtos
            SET codigoBarras = ?,
                descricao = ?,
                categoria = ?,
                precoCusto = ?,
                precoVenda = ?,
                quantidade = ?,
                estoqueMinimo = ?,
                idFornecedor = ?
            WHERE idProdutos = ?
        """;

        Connection con = database.conectar();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, produto.getCodigoBarras());
        stmt.setString(2, produto.getDescricao());
        stmt.setString(3, produto.getCategoria());
        stmt.setDouble(4, produto.getPrecoCusto());
        stmt.setDouble(5, produto.getPrecoVenda());
        stmt.setInt(6, produto.getQuantidade());
        stmt.setInt(7, produto.getEstoqueMinimo());
        stmt.setInt(8, produto.getIdFornecedor());
        stmt.setInt(9, produto.getIdProduto());

        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    // =========================
    // EXCLUIR PRODUTO
    // =========================
    public boolean Excluir(int idProduto) throws Exception {

        String sql = """
            DELETE FROM produtos
            WHERE idProdutos = ?
        """;

        Connection con = database.conectar();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, idProduto);

        int linhasAfetadas = stmt.executeUpdate();

        stmt.close();
        con.close();

        return linhasAfetadas > 0;
    }

    // =========================
    // BUSCAR PRODUTO
    // =========================
    public Produto buscar(String descricao) throws Exception {

        String sql = """
            SELECT
                idProdutos,
                codigoBarras,
                descricao,
                categoria,
                precoCusto,
                precoVenda,
                quantidade,
                estoqueMinimo,
                idFornecedor
            FROM produtos
            WHERE descricao LIKE ?
            LIMIT 1
        """;

        Connection con = database.conectar();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, "%" + descricao + "%");

        ResultSet rs = stmt.executeQuery();

        Produto produto = null;

        if (rs.next()) {

            produto = new Produto();

            produto.setIdProduto(
                rs.getInt("idProdutos")
            );

            produto.setCodigoBarras(
                rs.getString("codigoBarras")
            );

            produto.setDescricao(
                rs.getString("descricao")
            );

            produto.setCategoria(
                rs.getString("categoria")
            );

            produto.setPrecoCusto(
                rs.getDouble("precoCusto")
            );

            produto.setPrecoVenda(
                rs.getDouble("precoVenda")
            );

            produto.setQuantidade(
                rs.getInt("quantidade")
            );

            produto.setEstoqueMinimo(
                rs.getInt("estoqueMinimo")
            );

            produto.setIdFornecedor(
                rs.getInt("idFornecedor")
            );
        }

        rs.close();
        stmt.close();
        con.close();

        return produto;
    }

    // =========================
    // LISTAR PRODUTOS
    // =========================
    public ArrayList<Produto> listaproduto() throws Exception {

        ArrayList<Produto> lista = new ArrayList<>();

        String sql = """
            SELECT
                idProdutos,
                codigoBarras,
                descricao,
                categoria,
                precoCusto,
                precoVenda,
                quantidade,
                estoqueMinimo,
                idFornecedor
            FROM produtos
            ORDER BY descricao
        """;

        Connection con = database.conectar();
        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto produto = new Produto();

            produto.setIdProduto(
                rs.getInt("idProdutos")
            );

            produto.setCodigoBarras(
                rs.getString("codigoBarras")
            );

            produto.setDescricao(
                rs.getString("descricao")
            );

            produto.setCategoria(
                rs.getString("categoria")
            );

            produto.setPrecoCusto(
                rs.getDouble("precoCusto")
            );

            produto.setPrecoVenda(
                rs.getDouble("precoVenda")
            );

            produto.setQuantidade(
                rs.getInt("quantidade")
            );

            produto.setEstoqueMinimo(
                rs.getInt("estoqueMinimo")
            );

            produto.setIdFornecedor(
                rs.getInt("idFornecedor")
            );

            lista.add(produto);
        }

        rs.close();
        stmt.close();
        con.close();

        return lista;
    }
}