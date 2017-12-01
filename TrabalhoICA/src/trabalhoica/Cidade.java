package trabalhoica;

/**
 *
 * @author Tomás José e Wesley Maffazzolli
 */
public class Cidade {

    private int x;
    private int y;
    private String nome;

    public Cidade(String nome, int x, int y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

    //GETTERS
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getNome() {
        return this.nome;
    }

    public double distanciaAte(Cidade cid) {
        int xDif = Math.abs(this.x - cid.x);
        int yDif = Math.abs(this.y - cid.y);
        double dist = Math.sqrt(Math.pow(xDif, 2) + Math.pow(yDif, 2));
        return dist;
    }

    @Override
    public String toString() {
        return "" + this.nome + "(" + this.x + "," + this.y + ")";
    }
}
