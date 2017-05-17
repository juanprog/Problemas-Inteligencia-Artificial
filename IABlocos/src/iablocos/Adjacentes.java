package iablocos;

/**
 * Utilizada para armazenar para cada vertice a quantidade de peças diferentes
 * @author juan
 */
public class Adjacentes {

    private int diferentes;
    private int vertice;
    
    public Adjacentes(int v, int t){
        this.vertice = v;
        this.diferentes = t;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public int getDiferentes() {
        return diferentes;
    }

    public void setDiferentes(int total) {
        this.diferentes = total;
    }

}
