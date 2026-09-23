package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import model.Fornecedor;
import model.Produto;

public class ProdutoController {

    private Database database;

    public ProdutoController() {
        database = new Database();
    }

    // =====================================================
    // ADICIONAR PRODUTO
    // =====================================================

    public boolean Adicionar(Produto produto) {

        try {

            String sql = """
                INSERT INTO produto
                (descricao, categoria, idFornecedor, precoCusto, precoVenda, quantidade, estoqueMinimo)
                VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

            Connection con = database.conectar();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getCategoria());
            stmt.setInt(3, produto.getIdFornecedor());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setInt(6, produto.getQuantidade());
            stmt.setInt(7, produto.getEstoqueMinimo());

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            con.close();

            return linhasAfetadas > 0;

        } catch (Exception e) {

            System.out.println("Erro ao adicionar produto:");
            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // BUSCAR PRODUTO PELA DESCRIÇÃO
    // =====================================================

    public Produto buscar(String descricao) {

        Produto produto = null;

        try {

            String sql = """
                SELECT idProdutos,
                       descricao,
                       categoria,
                       idFornecedor,
                       precoCusto,
                       precoVenda,
                       quantidade,
                       estoqueMinimo
                FROM produto
                WHERE descricao LIKE ?
                ORDER BY descricao
            """;

            Connection con = database.conectar();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, "%" + descricao + "%");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                produto = new Produto();

                produto.setIdProduto(
                        rs.getInt("idProdutos")
                );

                produto.setDescricao(
                        rs.getString("descricao")
                );

                produto.setCategoria(
                        rs.getString("categoria")
                );

                produto.setIdFornecedor(
                        rs.getInt("idFornecedor")
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
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Erro ao buscar produto:");
            e.printStackTrace();
        }

        return produto;
    }

    // =====================================================
    // LISTAR TODOS OS PRODUTOS
    // =====================================================

    public ArrayList<Produto> listaproduto() {

        ArrayList<Produto> lista = new ArrayList<>();

        try {

            String sql = """
                SELECT idProdutos,
                       descricao,
                       categoria,
                       idFornecedor,
                       precoCusto,
                       precoVenda,
                       quantidade,
                       estoqueMinimo
                FROM produto
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

                produto.setDescricao(
                        rs.getString("descricao")
                );

                produto.setCategoria(
                        rs.getString("categoria")
                );

                produto.setIdFornecedor(
                        rs.getInt("idFornecedor")
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

                lista.add(produto);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Erro ao listar produtos:");
            e.printStackTrace();
        }

        return lista;
    }

    // =====================================================
    // EDITAR PRODUTO
    // =====================================================

    public boolean Editar(Produto produto) {

        try {

            String sql = """
                UPDATE produto
                SET descricao = ?,
                    categoria = ?,
                    idFornecedor = ?,
                    precoCusto = ?,
                    precoVenda = ?,
                    quantidade = ?,
                    estoqueMinimo = ?
                WHERE idProdutos = ?
            """;

            Connection con = database.conectar();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, produto.getDescricao());
            stmt.setString(2, produto.getCategoria());
            stmt.setInt(3, produto.getIdFornecedor());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setInt(6, produto.getQuantidade());
            stmt.setInt(7, produto.getEstoqueMinimo());
            stmt.setInt(8, produto.getIdProduto());

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            con.close();

            return linhasAfetadas > 0;

        } catch (Exception e) {

            System.out.println("Erro ao editar produto:");
            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // EXCLUIR PRODUTO
    // =====================================================

    public boolean Excluir(int idProduto) {

        try {

            String sql = """
                DELETE FROM produto
                WHERE idProdutos = ?
            """;

            Connection con = database.conectar();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idProduto);

            int linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            con.close();

            return linhasAfetadas > 0;

        } catch (Exception e) {

            System.out.println("Erro ao excluir produto:");
            e.printStackTrace();

            return false;
        }
    }

    // =====================================================
    // LISTAR FORNECEDORES
    // =====================================================

    public ArrayList<Fornecedor> listaFornecedores() {

        ArrayList<Fornecedor> lista = new ArrayList<>();

        try {

            String sql = """
                SELECT idFornecedor, nome
                FROM fornecedores
                ORDER BY nome
            """;

            Connection con = database.conectar();

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(
                        rs.getInt("idFornecedor")
                );

                fornecedor.setNome(
                        rs.getString("nome")
                );

                lista.add(fornecedor);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Erro ao listar fornecedores:");
            e.printStackTrace();
        }

        return lista;
    }
}