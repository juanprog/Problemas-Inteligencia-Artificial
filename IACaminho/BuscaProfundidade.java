package iacaminho;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementa busca em profundidade
 * @author juan
 */
public class BuscaProfundidade {

    public ArrayList visitados;
    private HashMap<Integer, Integer[]> adj;
    private boolean encontrou;
    private int custo;
    private int estados;
    private final int TAM = 21;

    public BuscaProfundidade() {
        this.adj = new HashMap<Integer, Integer[]>();
        this.visitados = new ArrayList();
        this.encontrou = false;
        this.custo = 0;
        this.estados = 0;
    }

    /**
     * Realiza a busca em profundidade
     * @param v
     * @param valor
     */
    public void buscaProfundidade(int v, int valor) {        
        // entra se o valor(destino) nao foi encontrado
        if (v != valor) {
            custo++;
            estados++;
            System.out.println(v);
            visitados.add(v);
            for (Integer u : adj.get(v)) {
                if ((visitados.contains(u) == false) && (encontrou == false)) {
                    buscaProfundidade(u, valor);
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
        } else {
            System.out.print(v + " ");
            System.out.println();
            System.out.println("Caminho encontrado!");
            encontrou = true;
        }
    }

    public void setAdj(Integer i, Integer[] lista) {
        this.adj.put(i, lista);
    }

    public HashMap<Integer, Integer[]> getAdj() {
        return adj;
    }
    
    public int getCusto(){
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
