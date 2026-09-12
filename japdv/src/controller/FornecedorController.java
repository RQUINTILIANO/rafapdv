package controller;
 
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.text.Document;
import javax.swing.text.Element;


// Importação de database
import database.Database;
// importação do modelo de dados
import model.Fornecedor;
 
public class FornecedorController {
 
	// Instanciar o banco de dados
	private Database database;
 
	// Construtor
	public FornecedorController() {
		// Reutilizar o database no CRUD
		database = new Database();
 
	} // fim do construtor
 
	// Métodos (Funções) CRUD
 
	// =====================================================
	// Adicionar Fornecedor (Crud Create)
	// =====================================================
 
	public void Adicionar(Fornecedor fornecedor) {
	    try {
	        String sql = """
	            insert into fornecedores (nome, fone, email, site)
	            values (?, ?, ?, ?)
	        """;
	        // 4 colunas ↔ 4 "?" ↔ 4 setString abaixo
 
	        Connection con = database.conectar();
	        PreparedStatement stmt = con.prepareStatement(sql);
 
	        stmt.setString(1, fornecedor.getNome());
	        stmt.setString(2, fornecedor.getFone());
	        stmt.setString(3, fornecedor.getEmail());
	        stmt.setString(4, fornecedor.getSite());
 
	        stmt.executeUpdate();
 
	        stmt.close();
	        con.close();
 
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	// Fim CRUD Create =========================================================
	
	// ==================================================================================
	// CRUD Read - Buscar fornecedor (PELO NOME) >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// ==================================================================================
	
	public Fornecedor buscar(String nome) {
		try {
			String sql = """
				select idFornecedor, nome, fone, email, site
				from fornecedores
				where nome like ?
			""";
			// Iniciar um objeto fornecedor como nulo
			Fornecedor fornecedor = null;
			
			//JDBC (connection e PreparedStatement)
			Connection con = database.conectar();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// setar a consulta
			stmt.setString(1, "%" + nome + "%");
			
			//JDBC (ResultSet) = "Trazer os dados do banco"
			ResultSet rs = stmt.executeQuery();
			
			// se existir um fornecedor com o nome pesquisado
			if (rs.next()) {
				// setar o model
				fornecedor = new Fornecedor();
				fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setFone(rs.getString("fone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setSite(rs.getString("site"));
			}
 
			// Fechar as conexões
			rs.close();
			stmt.close();
			con.close();
			
			return fornecedor;
			
			} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	// =====================================================
	// Editar Fornecedor (Crud Update)
	// =====================================================
 
	public void Editar(Fornecedor fornecedor) throws SQLException {
		// Comando sql (passo1)
		String sql = """	
				update fornecedores
					set nome = 	?, fone = ?, email = ?, site = ?
					where idFornecedor = ?
				""";
		// Abrir conexão com o banco (passo 2)
		Connection con = database.conectar();
		
		// executar o comando sql (passo 3)
		PreparedStatement stmt = con.prepareStatement(sql);
		// 1, 2, 3 = (?,?,?)
		stmt.setString(1, fornecedor.getNome());
		stmt.setString(2, fornecedor.getFone());
		stmt.setString(3, fornecedor.getEmail());
		stmt.setString(4, fornecedor.getSite());
		stmt.setInt(5, fornecedor.getIdFornecedor());
		stmt.executeUpdate();
		
		// Fechar a conexão (passo 4)
		stmt.close();
		con.close();
	}
	
	// Fim CRUD EDIT =========================================================
	
	
	// =====================================================
	// Editar Fornecedor (Crud Delete)
	// =====================================================
 
	public boolean Excluir(int idFornecedor) {
	    try {
	        String sql = """
	            delete from fornecedores
	            where idFornecedor = ?
	        """;
 
	        Connection con = database.conectar();
	        PreparedStatement stmt = con.prepareStatement(sql);
 
	        stmt.setInt(1, idFornecedor);
 
	        int linhasAfetadas = stmt.executeUpdate();
	        
	        stmt.close();
	        con.close();
 
	        return linhasAfetadas > 0;
 
 
	    } catch (Exception e) {
	        System.out.println(e);
	        return false;
	    }
	}
	
 
	
	// Fim CRUD Delete =========================================================
	
	
	
	
	// =====================================================
	// Listar Fornecedores -> Produtos
	// =====================================================
	
	// Para criar uma lista é necessário instanciar um Array no método e também criar um objeto que será usado no array
	public ArrayList <Fornecedor> listaFornecedores () {
		
		//objeto lista (usado a classe modelo ArrayList)
		ArrayList<Fornecedor> lista = new ArrayList<>();
		
		try {
			// buscar o id e o nome dos fornecedores
			String sql = """
					select idFornecedor, nome
					from fornecedores
					order by nome
					""";
			
			// Abrir a conexão com o banco
			Connection con = database.conectar();
			
			//preparar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// Obter os dados do banco
			ResultSet rs = stmt.executeQuery();		
			
			// Enquanto existir fornecedores cadastrados
			while (rs.next()) {
				
				// criar o objeto fornecedor
				Fornecedor fornecedor = new Fornecedor();
				
				// Armazenar o objeto dos IDS e Nomes
				fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
				fornecedor.setNome(rs.getString("Nome"));
				
				//Adicionar os fornecedores a lista (Array)
				lista.add(fornecedor);
				
				
				
			}
		
			rs.close();
			stmt.close();
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//System.out.println(lista);
		
		// retornar a lista de fornecedores
		return lista;
	}
	
	
	
	// Fim listar Fornecedores =========================================================
	
	
	// =====================================================
	// Gerar Relatório de fornecedores (PDF)
	// =====================================================
	/*
		public void gerarRelatorioFornecedores() {
			try {
				String sql = """
					select nome, fone, email, site
					from fornecedores
					order by nome
				""";
				
		        Connection con = database.conectar();
		        PreparedStatement stmt = con.prepareStatement(sql);
		        
		        ResultSet rs = stmt.executeQuery();
		        
		        // importar a biblioteca com.lowagie.text
		        Document documento = new Document();
		        
		        String caminho = "relatorio_fornecedores.pdf";
		        
		        PdfWriter.getInstance(documento, new FileOutputStream(caminho));
		        
		        // abrir documento >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		        documento.open();
		        
		        // Titúlo
		        Font fonteTitulo = new Font(Font.HELVETICA, 18, Font.BOLD);
		        
		        Paragraph titulo = new Paragraph("RELATÓRIO DE FORNECEDORES", fonteTitulo);
		        
		        titulo.setAlignment(Element.ALIGN_CENTER);
		        documento.add(titulo);
		        
		        // Data e hora
		        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		        
		        String dataHora = LocalDateTime.now().format(formato);
		        
		        Paragraph data = new Paragraph ("Data de emissão: " + dataHora);
		        
		        data.setAlignment(Element.ALIGN_CENTER);
		        
		        documento.add(data);
		        
		        //Espaço
		        
		        documento.add(new Paragraph (" "));
		        
		        
		        // Tabela ------------------------------------------
		        
		        // Criar a tabela com 5 colunas
		        PdfPTable tabela = new PdfPTable(4);
		        
		        //definir largura das colunas
		        tabela.setWidths(new float [] {
		        		
		        		2.5f, 2.0f, 3.0f, 4.0f
		        		
		        });
		        
		        // Ocupar toda a largura disponível
		        tabela.setWidthPercentage(100);
		        
		        // Cabeçalho da tabela
		        tabela.addCell("Nome");
		        tabela.addCell("Fone");
		        tabela.addCell("E-mail");
		        tabela.addCell("Site");
		        
		        // dados do fornecedor
		        int quantidade = 0;
		        
		        // enquanto existir fornecedores, adicionar a tabela
		        while(rs.next()) {
		        	
		        	tabela.addCell(rs.getString("nome"));
		        	tabela.addCell(rs.getString("fone"));
		        	tabela.addCell(rs.getString("email"));
		        	tabela.addCell(rs.getString("site"));
		        	
		        	// Somar a quantidade, atribuindo a variável
		        	quantidade++;
		        	
		        }
		        
		      //adicionar a tabela ao documento
		        documento.add(tabela);
		        
		        // Fim da Tabela -----------------------------------
		        
		        
		        documento.add(new Paragraph (" "));
		        
		        // total de fornecedores
		        Font fonteTotal = new Font(Font.HELVETICA, 10, Font.BOLD);
		        
		        Paragraph total = new Paragraph ("Total de fornecedores:" + quantidade, fonteTotal);
		        
		        total.setAlignment(Element.ALIGN_RIGHT);
		        
		        documento.add(total);
		        
		        
		        
		        //fechar o documento <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		        documento.close();
		        
		        
		        con.close();
		        stmt.close();
		        rs.close();
		        
		        //Abrir o pdf automaticamente no leitor padrão (PDF)
		        File arquivo = new File (caminho);
		        Desktop.getDesktop().open(arquivo);
				
				
			} catch (Exception e) {
				System.out.println();
				return;
			}
			
			
			
		}*/
	
	
	
	// Fim Gerar Relatório =========================================================
}
 
 