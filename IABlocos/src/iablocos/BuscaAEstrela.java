package iablocos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Implementa a busca heuristica a
 *
 *
 * @author juan
 */
public class BuscaAEstrela {

    private ArrayList visitados;
    private HashMap<Integer, Integer[]> adj;
    private HashMap<Integer, Integer[]> coordenadas;
    private HashMap<Integer, int[]> array;
    private boolean encontrou;
    private int heuristicaEscolhida;
    private int diferentes;
    private int custo;
    private int estados;
    private final int TAM = 9;

    public BuscaAEstrela(int heuristica) {
        this.adj = new HashMap<Integer, Integer[]>();
        this.coordenadas = new HashMap<Integer, Integer[]>();
        this.array = new HashMap<Integer, int[]>();
        this.visitados = new ArrayList();
        this.encontrou = false;
        this.heuristicaEscolhida = heuristica;
        this.diferentes = 0;
        this.custo = 0;
        this.estados = 0;

        definirCoordenadas();
    }

    /**
     * Realiza a busca a*
     *
     *
     * @param inicial
     * @param objetivo
     * @param i
     */
    public void buscaAEstrela(int[] inicial, int[] objetivo, int i) {
        PriorityQueue<Adjacentes> heuristica = new PriorityQueue<Adjacentes>(new AdjacenteComparator());
        array.put(i, inicial.clone());
        custo++;
        estados++;
        if (verificarResultado(inicial, objetivo) == false) {
            System.out.print("(" + i + ")");
            printVetor(array, i);
            visitados.add(i);

            // escolhe a heuristica a ser utilizada
            if (heuristicaEscolhida == 1) {
                calcularHeuristicaDiferentes(inicial.clone(), objetivo.clone(), i, heuristica);
            } else {
                calcularHeuristicaMovimentos(inicial.clone(), objetivo.clone(), i, heuristica);
            }

            Integer u;

            while (heuristica.isEmpty() == false) {
                u = heuristica.poll().getVertice();

                if ((visitados.contains(u) == false) && (encontrou == false)) {
                    trocar(inicial, i, u);
                    buscaAEstrela(inicial, objetivo, u);

                    if (encontrou == false) {
                        int index = visitados.indexOf(u) - 1;
                        visitados.remove(u);

                        if (index > -1) {
                            System.out.println("voltou: " + visitados.get(index));
                            inicial = array.get(visitados.get(index)).clone();
                            custo++;
                        }
                    }
                }
            }
        } else {
            System.out.print("(" + i + ")");
            printVetor(array, i);
            encontrou = true;
        }
    }

    /**
     * Realiza o calculo de quantas peças estao diferentes
     *
     * @param inicial
     * @param objetivo
     * @param i
     * @param heuristica
     */
    public void calcularHeuristicaDiferentes(int[] inicial, int[] objetivo, int i, PriorityQueue<Adjacentes> heuristica) {
        Adjacentes melhor;
        int[] aux;
        for (Integer u : adj.get(i)) {
            aux = inicial.clone();
            trocar(aux, i, u);
            verificarResultado(aux, objetivo);
            melhor = new Adjacentes(u, diferentes);
            heuristica.offer(melhor);
        }
    }

    /**
     * Realiza o calculo da quantidade de movimentos necessários para colocar
     * cada peça no seu lugar
     *
     * @param inicial
     * @param objetivo
     * @param i
     * @param heuristica
     */
    public void calcularHeuristicaMovimentos(int[] inicial, int[] objetivo, int i, PriorityQueue<Adjacentes> heuristica) {
        Adjacentes melhor;
        int[] aux;
        for (Integer u : adj.get(i)) {
            aux = inicial.clone();
            trocar(aux, i, u);
            melhor = new Adjacentes(u, calcularDistanciaManhattan(aux.clone(), objetivo.clone()));
            heuristica.offer(melhor);
        }
    }

    /**
     * Realiza o calculo da heuristica distancia de manhattan
     *
     * @param v
     * @param valor
     * @param heuristica
     */
    private int calcularDistanciaManhattan(int inicial[], int objetivo[]) {
        int soma = 0, heu, inix, objx, iniy, objy;
        for (int i = 0; i < TAM; i++) {
            if (inicial[i] != objetivo[i]) {
                objx = coordenadas.get(objetivo[i])[1];
                objy = coordenadas.get(objetivo[i])[0];
                inix = coordenadas.get(inicial[i])[1];
                iniy = coordenadas.get(inicial[i])[0];
                heu = Math.abs(inix - objx) + Math.abs(iniy - objy);
                soma = soma + heu;
            }
        }
        return soma;
    }

    /**
     * Define as coordenadas dos vertices para realizar o calculo das distancias
     * com base nessas coordenadas
     */
    private void definirCoordenadas() {
        int i = 0;
        int j = 0;
        int cont = 1;
        Integer[] array = new Integer[2];
        for (Integer k = 0; k < TAM; k++) {
            array[0] = i;
            array[1] = j;
            coordenadas.put(k, array.clone());
            if (cont % 3 == 0) {
                i++;
                j = 0;
            }
            j++;
            cont++;
        }
    }

    /**
     * Imprime o estado atual
     *
     * @param array
     * @param pos
     */
    public void printVetor(HashMap<Integer, int[]> array, int pos) {
        for (int i = 0; i < TAM; i++) {
            System.out.print(array.get(pos)[i] + " ");
        }
        System.out.println();
    }

    /**
     * Troca as posiçoes do estado em branco
     *
     * @param ini
     * @param i
     * @param u
     */
    public void trocar(int[] ini, int i, int u) {
        int aux;
        aux = ini[i];
        ini[i] = ini[u];
        ini[u] = aux;
    }

    /**
     * Verifica se o estado atual eh o estado objetivo
     *
     * @param v
     * @param valor
     * @return res
     */
    public boolean verificarResultado(int[] v, int[] valor) {
        diferentes = 0;
        boolean res = false;
        int i = 0;
        int j = 0;
        while (i < TAM) {
            if (v[i] == valor[i]) {
                j++;
            } else {
                diferentes++;
            }
            i++;
        }
        if (j == TAM) {
            res = true;
        }
        return res;
    }

    public void setAdj(Integer i, Integer[] lista) {
        this.adj.put(i, lista);
    }

    public HashMap<Integer, Integer[]> getAdj() {
        return adj;
    }

    public boolean getEncontrou() {
        return encontrou;
    }

    public int getCusto() {
        return this.custo;
    }

    public int getEstados() {
        return this.estados;
    }

    /**
     * Seta as posiçoes adjacencias das posiçoes das peças
     */
    public void cenario1() {
        // Indice 0     
        Integer[] array0 = {1, 3};
        setAdj(0, array0);
        // Indice 1
        Integer[] array1 = {0, 2, 4};
        setAdj(1, array1);
        // Indice 2
        Integer[] array2 = {1, 5};
        setAdj(2, array2);
        // Indice 3
        Integer[] array3 = {0, 4, 6};
        setAdj(3, array3);
        // Indice 4
        Integer[] array4 = {1, 3, 5, 7};
        setAdj(4, array4);
        // Indice 5
        Integer[] array5 = {2, 4, 8};
        setAdj(5, array5);
        // Indice 6
        Integer[] array6 = {3, 7};
        setAdj(6, array6);
        // Indice 7
        Integer[] array7 = {4, 6, 8};
        setAdj(7, array7);
        // Indice 8
        Integer[] array8 = {5, 7};
        setAdj(8, array8);
    }

}
