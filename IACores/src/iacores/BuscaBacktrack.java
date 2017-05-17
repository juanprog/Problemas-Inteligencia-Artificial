package iacores;

import java.util.HashMap;

/**
 * Implementa tudo que eh necessario para realizar a busca com retrocesso, nesse caso o backtracking
 * @author juan
 */
public class BuscaBacktrack {
    
    // a linha sao as cores e as colunas sao os vertices
    private int[][] matrizCores;
    private int cores;
    private int vertices;
    private int qtPassos;
    // marca se conseguiu ou nao encontrar a soluçao
    private boolean conseguiu;
    // contem as adjacencias dos vertices
    private HashMap<Integer, Integer[]> adj;

    /**
     * Faz todas as inicializaçoes
     * @param cores
     * @param vertices 
     */
    public BuscaBacktrack(int cores, int vertices) {
        this.matrizCores = new int[cores][vertices];
        this.cores = cores;
        this.vertices = vertices;
        this.qtPassos = 0;
        this.adj = new HashMap<>();

        inicializarTabuleiro();
    }

    /**
     * Inicializa a matriz com zeros
     */
    private void inicializarTabuleiro() {
        for (int i = 0; i < cores; i++) {
            for (int j = 0; j < vertices; j++) {
                matrizCores[i][j] = 0;
            }
        }
    }

    /**
     * Realiza a busca iniciando sempre da coluna 0
     * @param c 
     */
    public void buscaBacktrack(int c) {
        qtPassos++;
        for (int i = 0; i < cores; i++) {
            if ((conseguiu == false) && (verificarAtaques(matrizCores, i, c) == false)) {
                matrizCores[i][c] = -1;
                if (c + 1 < vertices) {
                    buscaBacktrack(c + 1);
                }
                if (c + 1 == vertices) {
                    conseguiu = true;
                }
                if (conseguiu == false) {
                    matrizCores[i][c] = 0;
                }
            }
        }
    }
    
    /**
     * Verifica os ataques, ou seja, se algum vertice adjacente possui a cor na sua respectiva linha
     * @param tabuleiro
     * @param posLinha
     * @param posCol
     * @return 
     */
    private boolean verificarAtaques(int[][] tabuleiro, int posLinha, int posCol) {
        for (Integer u : adj.get(posCol)) {
            //Essa comparaçao AQUI
            if (tabuleiro[posLinha][u] == -1) {
                return true;
            }
        }

        return false;
    }

    private void setAdj(Integer i, Integer[] lista) {
        this.adj.put(i, lista);
    }
    
    public int getQtPassos(){
        return this.qtPassos;
    }
    
    public boolean getConseguiu(){
        return this.conseguiu;
    }

    /**
     * Realiza a inicializaçao das adjacencias para o caso de 4 vertices
     */
    public void cenario1() {
        // Vertice 0
        Integer[] lista0 = {1, 2};
        setAdj(0, lista0);
        // Vertice 1
        Integer[] lista1 = {0, 3};
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {0, 3};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {1, 2};
        setAdj(3, lista3);
    }

    /**
     * Realiza a inicializaçao das adjacencias para o caso de 6 vertices
     */
    public void cenario2() {
        // Vertice 0
        Integer[] lista0 = {1, 2};
        setAdj(0, lista0);
        // Vertice 1
        Integer[] lista1 = {0, 2, 3, 5};
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {0, 1, 3, 4};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {1, 2, 4, 5};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {2, 3, 5};
        setAdj(4, lista4);
        // Vertice 5
        Integer[] lista5 = {1, 3, 4};
        setAdj(5, lista5);
    }
    
        /**
     * Realiza a inicializaçao das adjacencias para o caso de 6 vertices adjacentes entre si
     */
    public void cenario3() {
        // Vertice 0
        Integer[] lista0 = {1, 2, 3, 4};
        setAdj(0, lista0);
        // Vertice 1
        Integer[] lista1 = {0, 2, 3, 4};
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {0, 1, 3, 4};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {0, 1, 2, 4};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {0, 1, 2, 3};
        setAdj(4, lista4);
    }
    
    /**
     * Realiza a inicializaçao das adjacencias para o caso de 9 vertices
     */
    public void cenario4() {
        // Vertice 0
        Integer[] lista0 = {4, 5, 6};
        setAdj(0, lista0);
        // Vertice 1
        Integer[] lista1 = {3, 4};
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {3, 8};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {1, 2, 8};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {0, 1, 7};
        setAdj(4, lista4);
        // Vertice 5
        Integer[] lista5 = {0};
        setAdj(5, lista5);
        // Vertice 6
        Integer[] lista6 = {0};
        setAdj(6, lista6);
        // Vertice 7
        Integer[] lista7 = {4, 8};
        setAdj(7, lista7);
        // Vertice 8
        Integer[] lista8 = {2, 3, 8};
        setAdj(8, lista8);
    }

    /**
     * Realiza a inicializaçao das adjacencias para o caso de 9 vertices adjacentes entre si
     */
    public void cenario5() {
        // Vertice 0
        Integer[] lista0 = {1, 2, 3, 4, 5, 6, 7, 8};
        setAdj(0, lista0);
        // Vertice 1
        Integer[] lista1 = {0, 2, 3, 4, 5, 6, 7, 8};
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {0, 1, 3, 4, 5, 6, 7, 8};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {0, 1, 2, 4, 5, 6, 7, 8};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {0, 1, 2, 3, 5, 6, 7, 8};
        setAdj(4, lista4);
        // Vertice 5
        Integer[] lista5 = {0, 1, 2, 3, 4, 6, 7, 8};
        setAdj(5, lista5);
        // Vertice 6
        Integer[] lista6 = {0, 1, 2, 3, 4, 5, 7, 8};
        setAdj(6, lista6);
        // Vertice 7
        Integer[] lista7 = {0, 1, 2, 3, 4, 5, 6, 8};
        setAdj(7, lista7);
        // Vertice 8
        Integer[] lista8 = {0, 1, 2, 3, 4, 5, 6, 7};
        setAdj(8, lista8);
    }
}
