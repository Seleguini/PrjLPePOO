package gui;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static final List<String> itens = new ArrayList<>();

    public static void adicionarProduto(String produto) {
        itens.add(produto);
    }

    public static List<String> getItens() {
        return new ArrayList<>(itens);
    }

    public static void limparCarrinho() {
        itens.clear();
    }
}