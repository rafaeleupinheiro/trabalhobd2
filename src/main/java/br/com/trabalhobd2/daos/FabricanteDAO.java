package br.com.trabalhobd2.daos;

import br.com.trabalhobd2.conexao.Conexao;
import br.com.trabalhobd2.entidades.Fabricante;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabricanteDAO {

  public List<Fabricante> getFabricantes() throws PropertyVetoException, SQLException, ClassNotFoundException {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT * FROM Fabricantes");
    List<Fabricante> fabricantes = new ArrayList<>();

    try (Connection conn = Conexao.getInstance().conn().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql.toString());
         ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        Fabricante fabricante = new Fabricante();
        fabricante.setCodFabricante(rs.getInt("CodFabricante"));
        fabricante.setDescricao(rs.getString("Descricao"));
        fabricantes.add(fabricante);
      }
    }
    return fabricantes;
  }
}
