package iablocos;

import java.util.Comparator;

/**
 * Utilizada para fazer a comparaçao com base no estado com menor numero de peças diferentes
 * para alcançar o estado final
 * @author juan
 */
public class AdjacenteComparator implements Comparator<Adjacentes> {

    @Override
    public int compare(Adjacentes o1, Adjacentes o2) {
        if (o1.getDiferentes() > o2.getDiferentes()) {
            return 1;
        } else {
            return -1;
        }
    }

}
