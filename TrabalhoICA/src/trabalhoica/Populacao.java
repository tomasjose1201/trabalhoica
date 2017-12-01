package trabalhoica;

/**
 *
 * @author Tomás José e Wesley Maffazzolli
 */
public class Populacao {

    Tour[] tours;

    public Populacao(int tamanhoPopulacao, boolean iniciar) {
        tours = new Tour[tamanhoPopulacao];
        if (iniciar) {
            for (int i = 0; i < tamanhoPopulacao(); i++) {
                Tour novaTour = new Tour();
                novaTour.gerarIndividuo();
                salvarTour(i, novaTour);
            }
        }
    }

    public void salvarTour(int index, Tour tour) {
        tours[index] = tour;
    }

    public Tour getTour(int index) {
        return tours[index];
    }

    //Pega o melhor tour da população
    public Tour getFittest() {
        Tour fittest = getTour(0);
        for (int i = 1; i < tamanhoPopulacao(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    public int tamanhoPopulacao() {
        return tours.length;
    }
}
