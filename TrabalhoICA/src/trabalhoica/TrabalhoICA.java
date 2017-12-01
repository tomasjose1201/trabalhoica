package trabalhoica;

/**
 *
 * @author Tomás José e Wesley Maffazzolli
 */
public class TrabalhoICA {

    public static void main(String[] args) {
        InterfaceGrafica.createWindow();

        Cidade c1 = new Cidade("Porto Alegre", 80, 110);
        TourManager.adicionarCidade(c1);
        Cidade c2 = new Cidade("Florianópolis", 90, 100);
        TourManager.adicionarCidade(c2);
        Cidade c3 = new Cidade("Curitiba", 85, 90);
        TourManager.adicionarCidade(c3);
        Cidade c4 = new Cidade("São Paulo", 95, 80);
        TourManager.adicionarCidade(c4);
        Cidade c5 = new Cidade("Rio de Janeiro", 110, 75);
        TourManager.adicionarCidade(c5);
        Cidade c6 = new Cidade("Vitória", 120, 65);
        TourManager.adicionarCidade(c6);
        Cidade c7 = new Cidade("Belo Horizonte", 105, 62);
        TourManager.adicionarCidade(c7);
        Cidade c8 = new Cidade("Goiânia", 140, 50);
        TourManager.adicionarCidade(c8);
        Cidade c9 = new Cidade("Cuiabá", 40, 60);
        TourManager.adicionarCidade(c9);
        Cidade c10 = new Cidade("Campo Grande", 100, 30);
        TourManager.adicionarCidade(c10);
        Cidade c11 = new Cidade("Brasília", 180, 100);
        TourManager.adicionarCidade(c11);
        Cidade c12 = new Cidade("Maceió", 133, 30);
        TourManager.adicionarCidade(c12);
        Cidade c13 = new Cidade("Salvador", 125, 45);
        TourManager.adicionarCidade(c13);
        Cidade c14 = new Cidade("Fortaleza", 180, 60);
        TourManager.adicionarCidade(c14);
        Cidade c15 = new Cidade("São Luís", 20, 40);
        TourManager.adicionarCidade(c15);
        Cidade c16 = new Cidade("João Pessoa", 100, 40);
        TourManager.adicionarCidade(c16);
        Cidade c17 = new Cidade("Recife", 200, 50);
        TourManager.adicionarCidade(c17);
        Cidade c18 = new Cidade("Teresina", 200, 20);
        TourManager.adicionarCidade(c18);
        Cidade c19 = new Cidade("Natal", 60, 20);
        TourManager.adicionarCidade(c19);
        Cidade c20 = new Cidade("Aracaju", 130, 35);
        TourManager.adicionarCidade(c20);
        Cidade c21 = new Cidade("Rio Branco", 100, 20);
        TourManager.adicionarCidade(c21);
        Cidade c22 = new Cidade("Macapá", 120, 20);
        TourManager.adicionarCidade(c22);
        Cidade c23 = new Cidade("Manaus", 150, 20);
        TourManager.adicionarCidade(c23);
        Cidade c24 = new Cidade("Belém", 90, 20);
        TourManager.adicionarCidade(c24);
        Cidade c25 = new Cidade("Porto Velho", 60, 30);
        TourManager.adicionarCidade(c25);
        Cidade c26 = new Cidade("Boa Vista", 40, 20);
        TourManager.adicionarCidade(c26);
        Cidade c27 = new Cidade("Palmas", 15, 20);
        TourManager.adicionarCidade(c27);

        //Inicializa a população
        Populacao pop = new Populacao(20000, true);

        //Evolui a população durante algumas gerações
        for (int i = 0; i < 300; i++) {
            pop = AlgoritmoGenetico.evoluirPopulacao(pop);
            InterfaceGrafica.setGeracao(i + 1);
        }
    }
}
