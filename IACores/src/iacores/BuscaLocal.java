package iacores;

import java.util.HashMap;
import java.util.Random;

/**
 * Implementa tudo que eh necessario para realizar a busca local, nesse caso a descida do gradiente
 * @author juan
 */
public class BuscaLocal {

    // a linha sao as cores e as colunas sao os vertices
    private int[][] matrizCores;
    private int cores;
    private int vertices;
    // guarda a posiçao (linha, coluna) da cor
    private HashMap<Integer, Integer> pos;
    // contem as adjacencias dos vertices
    private HashMap<Integer, Integer[]> adj;
    // guarda o menor custo
    private Melhor melhor;
    private int qtPassos;
    // conta quantas vezes a busca foi repetida para um mesmo resultado da funçao de custo
    private int timeOut;

    /**
     * Construtor, faz todas as inicializaçoes incluindo a distribuiçao das cores
     * @param cores
     * @param vertices 
     */
    public BuscaLocal(int cores, int vertices) {
        this.matrizCores = new int[cores][vertices];
        this.pos = new HashMap<Integer, Integer>();
        this.adj = new HashMap<>();
        this.cores = cores;
        this.vertices = vertices;
        this.melhor = new Melhor(cores);
        this.qtPassos = 0;
        this.timeOut = 0;
        inicializarTabuleiro();
        distribuirCores();
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
     * Distribui as cores de forma aleatoria
     */
    private void distribuirCores() {
        System.out.println("DISPOSIÇAO DAS CORES");
        System.out.println("L C");
        int i;
        Random random = new Random();
        for (int j = 0; j < vertices; j++) {
            i = random.nextInt(cores);
            matrizCores[i][j] = -1;
            pos.put(j, i);
            System.out.println(i + " " + j);
        }
    }

    /**
     * Realiza a busca em si
     */
    public void buscaLocal() {
        int custoAnterior;
        int custoAtual;
        int[][] aux;
        int melhorLinha;
        int melhorCol;

        aux = matrizCores.clone();
        custoAnterior = calcularCusto(aux.clone(), pos.get(0), 0);
        melhor.setMelhor(custoAnterior);
        melhor.setL(pos.get(0));
        melhor.setC(0);
        melhorLinha = melhor.getL();
        melhorCol = melhor.getC();
        System.out.println("CUSTO INICIAL: " + custoAnterior);
        System.out.println();
        
        while ((melhor.getMelhor() != 0) && (timeOut < 5)) {
            for (int j = 0; j < vertices; j++) {
                aux[pos.get(j)][j] = 0;
                for (int i = 0; i < cores; i++) {
                    if (i != pos.get(j)) {
                        aux[i][j] = -1;
                        custoAtual = calcularCusto(aux.clone(), i, j);
                        if (custoAtual <= melhor.getMelhor()) {
                            melhor.setMelhor(custoAtual);
                            melhor.setL(i);
                            melhor.setC(j);
                        }
                        aux[i][j] = 0;
                    }
                }
                aux[pos.get(j)][j] = -1;
            }
            if (custoAnterior == melhor.getMelhor()) {
                timeOut++;
            }
            
            qtPassos++;
            matrizCores[melhor.getL()][melhor.getC()] = -1;
            matrizCores[pos.get(melhor.getC())][melhor.getC()] = 0;
            pos.put(melhor.getC(), melhor.getL());
            custoAnterior = melhor.getMelhor();
            melhorLinha = melhor.getL();
            melhorCol = melhor.getC();
            
            System.out.println("PASSO: " + qtPassos);
            System.out.println("Melhor custo seguinte: " + melhor.getMelhor());
            System.out.println("Posicao: " + melhor.getL() + " " + melhor.getC());
            System.out.println();
        }
    }

    /**
     * Realiza o calculo do custo verificando se existe uma mesma cor atribuida a vertices adjacentes
     * @param tabuleiro
     * @param posLinha
     * @param posCol
     * @return custo
     */
    private int calcularCusto(int[][] tabuleiro, int posLinha, int posCol) {
        int linha = posLinha;
        int custo = 0;
        
        if (posCol != 0) {
            linha = pos.get(0);
        }

        for (int coluna = 0; coluna < vertices; coluna++) {
            for (Integer u : adj.get(coluna)) {                
                if ((u > coluna) && (tabuleiro[linha][u] == -1)) {
                    custo++;
                }
            }
            if (coluna < vertices - 1) {
                if (coluna + 1 == posCol) {
                    linha = posLinha;
                } else {
                    linha = pos.get(coluna + 1);
                }
            }
        }

        return custo;
    }

    public int getQtPassos() {
        return this.qtPassos;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    private void setAdj(Integer i, Integer[] lista) {
        this.adj.put(i, lista);
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
     * Realiza a inicializaçao das adjacencias para o caso de 5 vertices
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
     * Realiza a inicializaçao das adjacencias para o caso de 9 vertices
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
