package iacaminho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Implementa a busca com heurista a*
 * @author juan
 */
public class BuscaAEstrela {

    private ArrayList visitados;
    private PriorityQueue<Integer> abertos;
    private PriorityQueue<Integer> fechados;
    private HashMap<Integer, Integer[]> adj;
    private HashMap<Integer, Integer[]> coordenadas;
    private boolean encontrou;
    private int custo;
    private int estados;
    private int heuristicaEscolhida;

    private final int TAM = 21;

    public BuscaAEstrela(int heuristica) {
        this.adj = new HashMap<Integer, Integer[]>();
        this.coordenadas = new HashMap<Integer, Integer[]>();
        this.abertos = new PriorityQueue<Integer>();
        this.fechados = new PriorityQueue<Integer>();
        this.visitados = new ArrayList();
        this.encontrou = false;
        this.custo = 0;
        this.estados = 0;
        this.heuristicaEscolhida = heuristica;
        
        definirCoordenadas();
    }

    /**
     * Realiza a busca a*
     * @param v
     * @param valor
     */
    public void buscaAEstrela(int v, int valor) {
        // se o valor(destino) foi encontrado imprime, senao realiza a busca
        if (v == valor) {
            System.out.print(v + " ");
            System.out.println();
            System.out.println("Caminho encontrado!");
            encontrou = true;
        } else {
            PriorityQueue<Adjacentes> heuristica = new PriorityQueue<Adjacentes>(new AdjacenteComparator());
            custo++;
            estados++;
            visitados.add(v);
            
            // escolhe a heuristica a ser utilizada
            if (heuristicaEscolhida == 1)
                calcularHeuristicaManhattan(v, valor, heuristica);
            else
                calcularHeuristicaEuclidiana(v, valor, heuristica);
            
            System.out.println(v);
            Integer u;
            while(heuristica.isEmpty() == false){
                u = heuristica.poll().getVertice();
                if ((visitados.contains(u) == false) && (encontrou == false)) {                    
                    buscaAEstrela(u, valor);
                    if (encontrou == false) {
                        int index = visitados.indexOf(u) - 1;
                        visitados.remove(u);
                        if (index > -1) {
                            System.out.println("voltou para o: " + visitados.get(index));
                            custo++;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Realiza o calculo da heuristica distancia de manhattan
     * @param v
     * @param valor
     * @param heuristica 
     */
    private void calcularHeuristicaManhattan(int v, int valor, PriorityQueue<Adjacentes> heuristica){
        int heu, x1, x2, y1, y2;
        Adjacentes melhor;
        x2 = coordenadas.get(valor)[1];        
        y2 = coordenadas.get(valor)[0];
        for(Integer u : adj.get(v)){
            x1 = coordenadas.get(u)[1];            
            y1 = coordenadas.get(u)[0];
            heu = Math.abs(x1-x2) + Math.abs(y1-y2);
            melhor = new Adjacentes(u, heu);
            heuristica.offer(melhor);
        }
    }
    
    /**
     * Realiza o calculo da heuristica distancia euclidiana
     * @param v
     * @param valor
     * @param heuristica 
     */
    private void calcularHeuristicaEuclidiana(int v, int valor, PriorityQueue<Adjacentes> heuristica){
        int heu, x1, x2, y1, y2;
        Adjacentes melhor;
        x2 = coordenadas.get(valor)[1];        
        y2 = coordenadas.get(valor)[0];
        for(Integer u : adj.get(v)){
            x1 = coordenadas.get(u)[1];            
            y1 = coordenadas.get(u)[0];
            heu = (int) Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
            melhor = new Adjacentes(u, heu);
            heuristica.offer(melhor);
        }
    }

    /**
     * Define as coordenadas dos vertices para realizar o calculo das distancias
     * com base nessas coordenadas
     */
    private void definirCoordenadas() {
        int i = 1;
        int j = 1;
        Integer[] array = new Integer[2];
        for (Integer k = 1; k < TAM; k++) {
            array[0] = i;
            array[1] = j;
            coordenadas.put(k, array.clone());
            if (j % 5 == 0) {
                i++;
                j = 0;
            }
            j++;
        }
    }

    public void setAdj(Integer i, Integer[] adjacentes) {
        this.adj.put(i, adjacentes);
    }

    public HashMap<Integer, Integer[]> getAdj() {
        return adj;
    }

    public int getCusto() {
        return custo;
    }
    
    public int getEstados() {
        return estados;
    }

    public boolean getEncontrou() {
        return encontrou;
    }

    public void cenario1() {
        // Vertice 1        
        Integer[] lista1 = {2, 6};        
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {1, 7};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {5, 9};
        setAdj(4, lista4);
        // Vertice 5
        Integer[] lista5 = {4, 10};
        setAdj(5, lista5);
        // Vertice 6
        Integer[] lista6 = {1, 7, 11};
        setAdj(6, lista6);
        // Vertice 7
        Integer[] lista7 = {2, 6};
        setAdj(7, lista7);
        // Vertice 8
        Integer[] lista8 = {};
        setAdj(8, lista8);
        // Vertice 9
        Integer[] lista9 = {4, 10, 14};
        setAdj(9, lista9);
        // Vertice 10
        Integer[] lista10 = {5, 9, 15};
        setAdj(10, lista10);
        // Vertice 11
        Integer[] lista11 = {6, 16};
        setAdj(11, lista11);
        // Vertice 12
        Integer[] lista12 = {};
        setAdj(12, lista12);
        // Vertice 13
        Integer[] lista13 = {};
        setAdj(13, lista13);
        // Vertice 14
        Integer[] lista14 = {9, 15, 19};
        setAdj(14, lista14);
        // Vertice 15
        Integer[] lista15 = {10, 14, 20};
        setAdj(15, lista15);
        // Vertice 16
        Integer[] lista16 = {11, 17};
        setAdj(16, lista16);        
        // Vertice 17
        Integer[] lista17 = {16, 18};
        setAdj(17, lista17);        
        // Vertice 18
        Integer[] lista18 = {17, 19};
        setAdj(18, lista18);        
        // Vertice 19
        Integer[] lista19 = {14, 18, 20};
        setAdj(19, lista19);        
        // Vertice 20
        Integer[] lista20 = {15, 19};
        setAdj(20, lista20);        
    }

    public void cenario2() {
        // Vertice 1        
        Integer[] lista1 = {6};        
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {4, 8};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {3, 5};
        setAdj(4, lista4);
        // Vertice 5
        Integer[] lista5 = {4, 10};
        setAdj(5, lista5);
        // Vertice 6
        Integer[] lista6 = {1, 11};
        setAdj(6, lista6);
        // Vertice 7
        Integer[] lista7 = {};
        setAdj(7, lista7);
        // Vertice 8
        Integer[] lista8 = {3, 13};
        setAdj(8, lista8);
        // Vertice 9
        Integer[] lista9 = {};
        setAdj(9, lista9);
        // Vertice 10
        Integer[] lista10 = {5, 15};
        setAdj(10, lista10);
        // Vertice 11
        Integer[] lista11 = {6, 16};
        setAdj(11, lista11);
        // Vertice 12
        Integer[] lista12 = {13, 17};
        setAdj(12, lista12);
        // Vertice 13
        Integer[] lista13 = {8, 12, 18};
        setAdj(13, lista13);
        // Vertice 14
        Integer[] lista14 = {};
        setAdj(14, lista14);
        // Vertice 15
        Integer[] lista15 = {10, 20};
        setAdj(15, lista15);
        // Vertice 16
        Integer[] lista16 = {11, 17};
        setAdj(16, lista16);        
        // Vertice 17
        Integer[] lista17 = {12, 16, 18};
        setAdj(17, lista17);        
        // Vertice 18
        Integer[] lista18 = {13, 17};
        setAdj(18, lista18);        
        // Vertice 19
        Integer[] lista19 = {};
        setAdj(19, lista19);        
        // Vertice 20
        Integer[] lista20 = {15};
        setAdj(20, lista20);        
    }

    public void cenario3() {
        // Vertice 1        
        Integer[] lista1 = {2, 6};        
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {1, 3};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {2, 4, 8};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {3};
        setAdj(4, lista4);
        // Vertice 5
        Integer[] lista5 = {};
        setAdj(5, lista5);
        // Vertice 6
        Integer[] lista6 = {1, 11};
        setAdj(6, lista6);
        // Vertice 7
        Integer[] lista7 = {};
        setAdj(7, lista7);
        // Vertice 8
        Integer[] lista8 = {3};
        setAdj(8, lista8);
        // Vertice 9
        Integer[] lista9 = {};
        setAdj(9, lista9);
        // Vertice 10
        Integer[] lista10 = {15};
        setAdj(10, lista10);
        // Vertice 11
        Integer[] lista11 = {6, 12, 16};
        setAdj(11, lista11);
        // Vertice 12
        Integer[] lista12 = {11, 17};
        setAdj(12, lista12);
        // Vertice 13
        Integer[] lista13 = {};
        setAdj(13, lista13);
        // Vertice 14
        Integer[] lista14 = {15, 19};
        setAdj(14, lista14);
        // Vertice 15
        Integer[] lista15 = {10, 14, 20};
        setAdj(15, lista15);
        // Vertice 16
        Integer[] lista16 = {11, 17};
        setAdj(16, lista16);        
        // Vertice 17
        Integer[] lista17 = {12, 16};
        setAdj(17, lista17);        
        // Vertice 18
        Integer[] lista18 = {};
        setAdj(18, lista18);        
        // Vertice 19
        Integer[] lista19 = {14, 20};
        setAdj(19, lista19);        
        // Vertice 20
        Integer[] lista20 = {15, 19};
        setAdj(20, lista20);        
    }

    public void cenario4() {
        // Vertice 1        
        Integer[] lista1 = {2, 6};        
        setAdj(1, lista1);
        // Vertice 2
        Integer[] lista2 = {1, 3, 7};
        setAdj(2, lista2);
        // Vertice 3
        Integer[] lista3 = {2, 8};
        setAdj(3, lista3);
        // Vertice 4
        Integer[] lista4 = {};
        setAdj(4, lista4);
        // Vertice 5
        Integer[] lista5 = {};
        setAdj(5, lista5);
        // Vertice 6
        Integer[] lista6 = {1, 7, 11};
        setAdj(6, lista6);
        // Vertice 7
        Integer[] lista7 = {2, 6, 8, 12};
        setAdj(7, lista7);
        // Vertice 8
        Integer[] lista8 = {3, 7, 13};
        setAdj(8, lista8);
        // Vertice 9
        Integer[] lista9 = {};
        setAdj(9, lista9);
        // Vertice 10
        Integer[] lista10 = {};
        setAdj(10, lista10);
        // Vertice 11
        Integer[] lista11 = {6, 12, 16};
        setAdj(11, lista11);
        // Vertice 12
        Integer[] lista12 = {7, 11, 13, 17};
        setAdj(12, lista12);
        // Vertice 13
        Integer[] lista13 = {8, 12, 18};
        setAdj(13, lista13);
        // Vertice 14
        Integer[] lista14 = {};
        setAdj(14, lista14);
        // Vertice 15
        Integer[] lista15 = {};
        setAdj(15, lista15);
        // Vertice 16
        Integer[] lista16 = {11, 17};
        setAdj(16, lista16);        
        // Vertice 17
        Integer[] lista17 = {12, 16, 18};
        setAdj(17, lista17);        
        // Vertice 18
        Integer[] lista18 = {13, 17};
        setAdj(18, lista18);        
        // Vertice 19
        Integer[] lista19 = {};
        setAdj(19, lista19);        
        // Vertice 20
        Integer[] lista20 = {};
        setAdj(20, lista20);        
    }
}
