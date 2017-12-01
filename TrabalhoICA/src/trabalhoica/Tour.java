package trabalhoica;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Tomás José e Wesley Maffazzolli
 */
public class Tour {

    private ArrayList<Cidade> tour = new ArrayList<>();
    private double fitness = 0;
    private double distancia = 0;

    public Tour() {
        for (int i = 0; i < TourManager.numeroDeCidades(); i++) {
            tour.add(null);
        }
    }

    public Tour(ArrayList<Cidade> tour) {
        this.tour = tour;
    }

    //Cria o tour
    public void gerarIndividuo() {
        for (int i = 0; i < TourManager.numeroDeCidades(); i++) {
            setCidade(i, TourManager.getCidade(i));
        }
        Collections.shuffle(tour); //Reordena aleatoriamente o tour
    }

    //Pega uma cidade específica do tour
    public Cidade getCidade(int index) {
        return tour.get(index);
    }

    //Seta uma cidade em uma determinada posição do tour
    public void setCidade(int posicao, Cidade cidade) {
        tour.set(posicao, cidade);
        //Quando o tour muda, a fitness e a distancia são resetadas
        fitness = 0;
        distancia = 0;
    }

    //Calcula o fitness do tour
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1 / (double) getDistancia();
        }
        return fitness;
    }

    // Pega a distancia total do tour
    public double getDistancia() {
        if (distancia == 0) {
            double tourDistancia = 0;
            for (int i = 0; i < tamanhoTour(); i++) {
                Cidade origem = getCidade(i);
                Cidade destino;
                //Verifica se não está na última cidade do tour, if we are set our 
                //Se está então setamos o destino final como cidade inicial
                if (i + 1 < tamanhoTour()) {
                    destino = getCidade(i + 1);
                } else {
                    destino = getCidade(0);
                }
                // Pega a distancia entre duas cidades
                tourDistancia += origem.distanciaAte(destino);
            }
            distancia = tourDistancia;
        }
        return distancia;
    }

    // Número de cidade no tour
    public int tamanhoTour() {
        return tour.size();
    }

    // Verifica se o tour contém uma certa cidade
    public boolean contemCidade(Cidade cidade) {
        return tour.contains(cidade);
    }

    public boolean equals(Object object) {
        Tour tour2;
        if (object instanceof Tour) {
            tour2 = (Tour) object;
        } else {
            return false;
        }
        if (tamanhoTour() == tour2.tamanhoTour()) {
            Cidade c1;
            Cidade c2;
            for (int i = 0; i < tamanhoTour(); i++) {
                c1 = getCidade(i);
                c2 = tour2.getCidade(i);
                if (!c1.equals(c2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String geneString = new String();
        for (int i = 0; i < tamanhoTour(); i++) {
            geneString += getCidade(i) + " -> ";
        }
        return geneString;
    }
}
