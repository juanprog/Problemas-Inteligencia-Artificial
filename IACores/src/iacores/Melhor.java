package iacores;

/**
 * Utilizada para guardar o melhor custo e sua posiçao na matriz
 * @author juan
 */
public class Melhor {

    private int melhor;
    private int l;
    private int c;

    public Melhor(int n) {
        inicializarMelhor(n);
    }
    
    /**
     * Inicializa a variavel melhor com o pior valor que a funçao de custo pode calcular
     * @param n 
     */
    private void inicializarMelhor(int n) {
        setMelhor(0);
        for (int i = n - 1; i > 0; i--) {
            setMelhor(getMelhor() + i);
        }
        setMelhor(getMelhor() + 1);
    }

    /**
     * @return the melhor
     */
    public int getMelhor() {
        return melhor;
    }

    /**
     * @param melhor the melhor to set
     */
    public void setMelhor(int melhor) {
        this.melhor = melhor;
    }

    /**
     * @return the l
     */
    public int getL() {
        return l;
    }

    /**
     * @param l the l to set
     */
    public void setL(int l) {
        this.l = l;
    }

    /**
     * @return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
    }

}
