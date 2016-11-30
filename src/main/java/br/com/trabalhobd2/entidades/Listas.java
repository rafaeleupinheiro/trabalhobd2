package br.com.trabalhobd2.entidades;

import java.util.List;

public class Listas {
    private List<Produto> produtos;
    private List<Fabricante> fabricantes;
    private static Listas uniqueInstance = new Listas();

    private Listas() {
    }


}
