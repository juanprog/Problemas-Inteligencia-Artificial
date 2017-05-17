package iacaminho;

/**
 * Utilizada para armazenar para cada vertice o seu custo+heuristica
 * @author juan
 */
class Adjacentes {
    
    private int vertice;
    private int total;

    public Adjacentes(int v, int h){
        this.vertice = v;
        this.total = h;
    }
    
    /**
     * @return the vertice
     */
    public int getVertice() {
        return vertice;
    }

    /**
     * @param vertice the vertice to set
     */
    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    
}
