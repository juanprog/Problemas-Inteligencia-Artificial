package iarainhas;

import java.util.Random;

/**
 * @author juan
 */
public class Rainhas {
    
    public Rainhas(){
    }

    /**
     * Distribui as linhas aleatoriamente nas colunas
     * @param n
     * @return 
     */
    public int[] distribuirRainhas(int n) {
        Random random = new Random();
        int[] linhas = new int[n];
        for (int j = 0; j < n; j++) {
            linhas[j] = random.nextInt(n);
        }
        return linhas;
    }

}
