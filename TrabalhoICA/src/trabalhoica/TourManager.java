package trabalhoica;

import java.util.ArrayList;

/**
 *
 * @author Tomás José e Wesley Maffazzolli
 */
public class TourManager {

    //Lista que contém todas as cidades que o mercador terá de visitar
    private static ArrayList<Cidade> cidadesDestino = new ArrayList<>();

    //Adiciona uma cidade à lista de cidades
    public static void adicionarCidade(Cidade cidade) {
        cidadesDestino.add(cidade);
    }

    //Retorna a cidade que se encontra na posição 'index' da lista de cidades
    public static Cidade getCidade(int index) {
        return cidadesDestino.get(index);
    }

    //Retorna o número de cidades da lista
    public static int numeroDeCidades() {
        return cidadesDestino.size();
    }
}
