package trabalhoica;

/**
 *
 * @author Tomás José e Wesley Maffazzolli
 */
public class AlgoritmoGenetico {

    private static final double taxaMutacao = 0.0015;
    private static final int tamanhoTorneio = 5;
    private static final boolean elitismo = true;
    private static int mutacoes = 0;

    public static Populacao evoluirPopulacao(Populacao pop) {
        Populacao novaPopulacao = new Populacao(pop.tamanhoPopulacao(), false);

        int elitismoOffset = 0;
        if (elitismo) {
            novaPopulacao.salvarTour(0, pop.getFittest());
            elitismoOffset = 1;
        }

        //Crossover da população
        for (int i = elitismoOffset; i < novaPopulacao.tamanhoPopulacao(); i++) {
            //Seleciona pais
            Tour pai1 = tournamentSelection(pop);
            Tour pai2 = tournamentSelection(pop);
            //Crossover pais
            Tour filho = crossover(pai1, pai2);
            //Adiciona filho a nova população
            novaPopulacao.salvarTour(i, filho);
        }

        //Muta a nova população para adicionar material genético
        mutacoes = 0;
        for (int i = elitismoOffset; i < novaPopulacao.tamanhoPopulacao(); i++) {
            mutar(novaPopulacao.getTour(i));
        }
        InterfaceGrafica.updateWindow(novaPopulacao.getFittest());
        return novaPopulacao;
    }

    public static Tour crossover(Tour pai1, Tour pai2) {
        Tour filho = new Tour();

        //Pega posição inicial e final do subtour do pai1
        int posInicial = (int) (Math.random() * pai1.tamanhoTour());
        int posFinal = (int) (Math.random() * pai1.tamanhoTour());

        // Percorre e adiciona o subtour do pai1 no tour filho
        for (int i = 0; i < filho.tamanhoTour(); i++) {
            //Se a posição inicial é menor que a posição final
            if (posInicial < posFinal && i > posInicial && i < posFinal) {
                filho.setCidade(i, pai1.getCidade(i));
            }//Se a posição inicial é maior
            else if (posInicial > posFinal) {
                if (!(i < posInicial && i > posFinal)) {
                    filho.setCidade(i, pai1.getCidade(i));
                }
            }
        }

        //Percorre cidades no tour pai2
        for (int i = 0; i < pai2.tamanhoTour(); i++) {
            //Adiciona a cidade caso o filho não possua
            if (!filho.contemCidade(pai2.getCidade(i))) {
                //Laço de repetição para encontrar uma posição livre no tour filho
                for (int ii = 0; ii < filho.tamanhoTour(); ii++) {
                    //Quando encontra posição livre, adiciona cidade
                    if (filho.getCidade(ii) == null) {
                        filho.setCidade(ii, pai2.getCidade(i));
                        break;
                    }
                }
            }
        }
        return filho;
    }

    //Mutação de troca (swap mutation) do tour
    private static void mutar(Tour tour) {
        //Percorre cidades do tour
        for (int tourPos1 = 0; tourPos1 < tour.tamanhoTour(); tourPos1++) {
            if (Math.random() < taxaMutacao) {
                mutacoes++;
                //Pega uma segunda posição aleatória do tour
                int tourPos2 = (int) (tour.tamanhoTour() * Math.random());

                //Pega as cidades alvo do tour
                Cidade c1 = tour.getCidade(tourPos1);
                Cidade c2 = tour.getCidade(tourPos2);

                //Faz a troca
                tour.setCidade(tourPos2, c1);
                tour.setCidade(tourPos1, c2);
            }
        }
    }

    //Seleciona tour para crossover
    private static Tour tournamentSelection(Populacao pop) {
        //Cria uma população para o torneio
        Populacao torneio = new Populacao(tamanhoTorneio, false);
        //Para cada lugar do torneio, pega um tour aleatório e o adiciona
        for (int i = 0; i < tamanhoTorneio; i++) {
            int idAleatorio = (int) (Math.random() * pop.tamanhoPopulacao());
            torneio.salvarTour(i, pop.getTour(idAleatorio));
        }
        //Pega o tour fittest
        Tour fittest = torneio.getFittest();
        return fittest;
    }

    public static int getMutacoes() {
        return mutacoes;
    }
}
