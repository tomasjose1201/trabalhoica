package trabalhoica;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Tomás José e Wesley Maffazzolli
 */
public class InterfaceGrafica extends JPanel {

    public static JFrame frame = new JFrame("Inteligência Computacional Aplicada - Tomás José e Wesley Maffazzolli");
    public static InterfaceGrafica iG = null;
    public static Tour melhorTour;
    public static Tour ultimoTour;
    public static int geracao;

    public InterfaceGrafica(Tour melhor) {
        ultimoTour = melhorTour;
        melhorTour = melhor;
    }

    public static void createWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 720);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void updateWindow(Tour bestTour) {
        if (melhorTour != null && melhorTour.equals(bestTour)) {
            return;
        }
        if (iG != null) {
            frame.remove(iG);
        }
        InterfaceGrafica iG = new InterfaceGrafica(bestTour);
        frame.add(iG);
        frame.setVisible(true);
    }

    public static void setGeracao(int generation) {
        geracao = generation;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setFont(g.getFont().deriveFont(20.0f));
        g.setColor(Color.BLACK);
        g.drawString("Geração: " + geracao, 230, 20);
        g.setColor(Color.BLACK);
        g.drawString("Mutações: " + AlgoritmoGenetico.getMutacoes(), 390, 20);
        g.setColor(Color.BLACK);
        g.drawString("Comprimento: " + (int) melhorTour.getDistancia(), 10, 20);
        Cidade city;
        Cidade city2;
        for (int i = 0; i < melhorTour.tamanhoTour(); i++) {
            city = melhorTour.getCidade(i);
            if (i + 1 < melhorTour.tamanhoTour()) {
                city2 = melhorTour.getCidade(i + 1);
            } else {
                city2 = melhorTour.getCidade(0);
            }
            g.setColor(Color.GREEN);
            g.fillRect(city.getX() * 6 - 5, city.getY() * 6 - 5, 10, 10);
            g.setColor(Color.BLUE);
            g.drawString(city.getNome(), city.getX() * 6 - 5, city.getY() * 6 - 10);
            g.setColor(Color.BLUE);
            g.drawLine(city.getX() * 6 - 5, city.getY() * 6 - 5, city2.getX() * 6 - 5, city2.getY() * 6 - 5);

        }

    }

}
