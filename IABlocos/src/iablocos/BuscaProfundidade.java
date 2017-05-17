package iablocos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Impleta a busca em profundidade
 * @author juan
 */
public class BuscaProfundidade {

    private ArrayList visitados;
    private HashMap<Integer, Integer[]> adj;
    private HashMap<Integer, int[]> array;
    private boolean encontrou;
    private int custo;
    private int estados;
    private final int TAM = 9;

    public BuscaProfundidade() {
        this.adj = new HashMap<Integer, Integer[]>();
        this.array = new HashMap<Integer, int[]>();
        this.visitados = new ArrayList();
        this.custo = 0;
        this.estados = 0;
        this.encontrou = false;
    }
    
    /**
     * Realiza a busca em profundidade
     * @param inicial
     * @param objetivo
     * @param i 
     */
    public void buscaProfundidade(int[] inicial, int[] objetivo, int i) {
        array.put(i, inicial.clone());
        custo++;
        estados++;
        if (verificarResultado(inicial, objetivo) == false) {
            System.out.print("(" + i + ")");
            printVetor(array, i);
            visitados.add(i);
        
            for (Integer u : adj.get(i)) {            
                if ((visitados.contains(u) == false) && (encontrou == false)) {
                    trocar(inicial, i, u);
                    buscaProfundidade(inicial, objetivo, u);
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
     * Imprime o vetor com as peças
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
     * Utilizado para trocar a posiçao do zero
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
     * @param v
     * @param valor
     * @return 
     */
    public boolean verificarResultado(int[] v, int[] valor) {
        boolean res = false;
        int i = 0;
        int j = 0;
        while (i < TAM) {
            if (v[j] == valor[j]) {
                j++;
            }
            i++;
        }
        if (j == TAM) {
            res = true;
        }
        return res;
    }
    
    /**
     * Calcula quantas peças nao estao em ordem numerica
     * @param vetor
     * @return 
     */
    public int calcularDesordem(int vetor[]){
        int cont = 0;
        for(int i = 0; i < vetor.length; i++){
            for(int j = i; j < vetor.length; j++){
                if((vetor[j] != 0) && (vetor[j] < vetor[i]))
                    cont++;
            }
        }
        if (cont%2 == 0)
            return 0;
        else
            return 1;        
    }

    public void setAdj(Integer i, Integer[] lista) {
        this.adj.put(i, lista);
    }

    public HashMap<Integer, Integer[]> getAdj() {
        return this.adj;
    }

    public boolean getEncontrou() {
        return this.encontrou;
    }
    
    public int getCusto(){
        return this.custo;
    }
    
    public int getEstados(){
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
