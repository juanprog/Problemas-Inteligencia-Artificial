package iacaminho;

import java.util.Comparator;

/**
 * Utilizada para fazer a comparaçao com base no valor do custo+heuristica
 * @author juan
 */
public class AdjacenteComparator implements Comparator<Adjacentes> {

    @Override
    public int compare(Adjacentes o1, Adjacentes o2) {
        if (o1.getTotal() > o2.getTotal()) {
            return 1;
        } else {
            return -1;
        }
    }

}
