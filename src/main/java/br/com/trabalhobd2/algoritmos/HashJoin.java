package br.com.trabalhobd2.algoritmos;

import br.com.trabalhobd2.app.Application;
import br.com.trabalhobd2.daos.FabricanteDAO;
import br.com.trabalhobd2.daos.ProdutoDAO;
import br.com.trabalhobd2.entidades.Fabricante;
import br.com.trabalhobd2.entidades.ListarTabela;
import br.com.trabalhobd2.entidades.Produto;
import br.com.trabalhobd2.entidades.ProdutoFabricante;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class HashJoin {
  List<Produto> produtos = null;
  List<Fabricante> fabricantes = null;
  List<ProdutoFabricante> resultado = null;
  int contador = 1;

  public void iniciar() {
    hashJoin();
    ListarTabela listarTabela = new ListarTabela(resultado);
    listarTabela.pesquisar();
  }

  public void hashJoin() {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    FabricanteDAO fabricanteDAO = new FabricanteDAO();
    resultado = new ArrayList<>();
    Map<Integer, Fabricante> map = new HashMap<>();

    try {
      produtos = produtoDAO.getProdutos();
      fabricantes = fabricanteDAO.getFabricantes();
      for (Fabricante fabricante : fabricantes) {
        map.put(fabricante.getCodFabricante(), fabricante);
      }

      long tempoInicial = System.currentTimeMillis();
      for (Produto produto : produtos) {
        Fabricante fabricante = map.get(produto.getCodFabricante());
        if (fabricante != null) {
          ProdutoFabricante produtoFabricante = new ProdutoFabricante(produto, fabricante);
          resultado.add(produtoFabricante);
        }
      }
      long tempo = System.currentTimeMillis() - tempoInicial;
      Application.txfNaoProcessado.setText("o metodo executou em " + new SimpleDateFormat("mm:ss").format(new Date(tempo)));
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}