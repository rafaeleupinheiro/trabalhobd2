package br.com.trabalhobd2.daos;

import br.com.trabalhobd2.conexao.Conexao;
import br.com.trabalhobd2.entidades.CodigoNCM;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodigoNCMDAO {

  public List<CodigoNCM> getCodigoNCM() throws PropertyVetoException, SQLException, ClassNotFoundException {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT * FROM CodigoNCM");
    List<CodigoNCM> codigoNCMs = new ArrayList<>();

    try (Connection conn = Conexao.getInstance().conn().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql.toString());
         ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        CodigoNCM codigoNCM = new CodigoNCM();
        codigoNCM.setCodNCM(rs.getString("CodNCM"));
        codigoNCM.setDescricao(rs.getString("Descricao"));
        codigoNCMs.add(codigoNCM);
      }
    }
    return codigoNCMs;
  }
}
