package br.com.trabalhobd2.daos;

import br.com.trabalhobd2.conexao.Conexao;
import br.com.trabalhobd2.entidades.Fabricante;
import br.com.trabalhobd2.entidades.Produto;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

  public List<Produto> getProdutos() throws PropertyVetoException, SQLException, ClassNotFoundException {
    StringBuilder sql = new StringBuilder();
    sql.append("select * from Produtos");
    List<Produto> produtos = new ArrayList<>();

    try (Connection conn = Conexao.getInstance().conn().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql.toString());
         ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        Produto produto = new Produto();
        produto.setCodProduto(rs.getInt("CodProduto"));
        produto.setDescricao(rs.getString("Descricao"));
        produto.setCodFabricante(rs.getInt("CodFabricante"));
        produto.setCodEAN(rs.getString("CodEAN"));
        produto.setNumRegMS(rs.getString("NumRegMS"));
        produto.setCodNCM(rs.getString("CodNCM"));
        produto.setPrcFaricante(rs.getFloat("PrcFabricante"));
        produto.setPrcVenda(rs.getFloat("PrcVenda"));
        produtos.add(produto);
      }
    }
    return produtos;
  }
}
