package iarainhas;

import java.util.HashMap;
import java.util.Random;

/**
 * @author juan
 */
public class BuscaLocal {

    private int[][] tabuleiro;
    private int n;
    private HashMap<Integer, Integer> pos;
    private Melhor melhor;
    private int qtPassos;
    private int timeOut;
    private final int REP = 5;

    public BuscaLocal(int n) {
        this.tabuleiro = new int[n][n];
        this.pos = new HashMap<Integer, Integer>();
        this.n = n;
        this.melhor = new Melhor(n);
        this.qtPassos = 0;
        this.timeOut = 0;
        inicializarTabuleiro();
        distribuirRainhas();
    }

    /**
     * Inicializa o a matriz tabuleiro com zeros
     */
    private void inicializarTabuleiro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tabuleiro[i][j] = 0;
            }
        }
    }

    /**
     * Realiza a distribuiçao das rainhas no tabuleiro em linhas aleatorias
     */
    private void distribuirRainhas() {
        System.out.println("DISPOSIÇAO DAS RAINHAS");
        System.out.println("L C");
        int i;
        Random random = new Random();
        for (int j = 0; j < n; j++) {
            i = random.nextInt(n);
            tabuleiro[i][j] = -1;
            pos.put(j, i);
            System.out.println(i + " " + j);
        }
    }

    /**
     * Realiza a busca local
     */
    public void buscaLocal() {
        int custoAnterior;
        int custoAtual;
        int[][] aux;
        int melhorLinha;
        int melhorCol;

        aux = tabuleiro.clone();
        custoAnterior = calcularCusto(aux.clone(), pos.get(0), 0);
        melhor.setMelhor(custoAnterior);
        melhor.setL(pos.get(0));
        melhor.setC(0);
        melhorLinha = melhor.getL();
        melhorCol = melhor.getC();
        System.out.println("CUSTO INICIAL: " + custoAnterior);
        System.out.println();
        
        while ((melhor.getMelhor() != 0) && (timeOut < REP)) {
            for (int j = 0; j < n; j++) {
                aux[pos.get(j)][j] = 0;
                for (int i = 0; i < n; i++) {
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
            // faz a verificaçao se o custo esta se repetindo
            if (custoAnterior == melhor.getMelhor()) {
                timeOut++;
            }
            
            qtPassos++;
            tabuleiro[melhor.getL()][melhor.getC()] = -1;
            tabuleiro[pos.get(melhor.getC())][melhor.getC()] = 0;
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
     * Realiza o calculo de quantas rainhas estao se atacando
     * @param tabuleiro
     * @param posLinha
     * @param posCol
     * @return f
     */
    private int calcularCusto(int[][] tabuleiro, int posLinha, int posCol) {
        int linha = posLinha;
        int f = 0;
        int l, c;
        if (posCol != 0) {
            linha = pos.get(0);
        }
        for (int coluna = 0; coluna < n; coluna++) {
            // calcula rainhas na mesma linha
            for (int j = coluna; j < n; j++) {
                //Essa comparaçao AQUI
                if ((tabuleiro[linha][j] == -1) && (j != coluna)) {
                    f++;
                }
            }
            // diagonais principalis superior
            l = linha;
            c = coluna;
            while ((l > 0) && (c > coluna)) {
                l--;
                c--;
                if (tabuleiro[l][c] == -1) {
                    f++;
                }
            }
            // diagonais principais inferior
            l = linha;
            c = coluna;
            while ((l < n - 1) && (c < n - 1)) {
                l++;
                c++;
                if (tabuleiro[l][c] == -1) {
                    f++;
                }
            }
            // diagonais secundarias superior
            l = linha;
            c = coluna;
            while ((l > 0) && (c < n - 1)) {
                l--;
                c++;
                if (tabuleiro[l][c] == -1) {
                    f++;
                }
            }
            // diagonais secundarias inferior
            l = linha;
            c = coluna;
            while ((l < n - 1) && (c > coluna)) {
                l++;
                c--;
                if (tabuleiro[l][c] == -1) {
                    f++;
                }
            }
            // atualiza a posicao da linha
            if (coluna < n - 1) {
                if (coluna + 1 == posCol) {
                    linha = posLinha;
                } else {
                    linha = pos.get(coluna + 1);
                }
            }
        }
        return f;
    }

    public int getQtPassos() {
        return this.qtPassos;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

}
