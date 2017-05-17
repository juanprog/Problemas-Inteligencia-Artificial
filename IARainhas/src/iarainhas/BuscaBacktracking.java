package iarainhas;

/**
 * Implementa a busca com retrocesso (backtracking)
 * @author juan
 */
public class BuscaBacktracking {

    private int[][] tabuleiro;
    private int n;
    private int qtPassos;
    private boolean conseguiu;

    public BuscaBacktracking(int n) {
        this.tabuleiro = new int[n][n];
        this.n = n;
        this.qtPassos = 0;
        this.conseguiu = false;

        inicializarTabuleiro();
    }
    
    /**
     * Inicializa a matriz tabuleiro com zeros
     */
    private void inicializarTabuleiro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tabuleiro[i][j] = 0;
            }
        }
    }
    
    /**
     * Realiza a busca
     * @param c 
     */
    public void buscaBacktracking(int c) {
        qtPassos++;
        for (int i = 0; i < n; i++) {
            if (verificarAtaques(tabuleiro, i, c) == false) {
                tabuleiro[i][c] = -1;
                if (c + 1 < n) {
                    buscaBacktracking(c + 1);
                }
                if (c + 1 != n) {
                    tabuleiro[i][c] = 0;
                } else {
                    conseguiu = true;
                }
            }
        }
    }

    /**
     * Verifica se existe rainha atacando uma outra
     * @param tabuleiro
     * @param posLinha
     * @param posCol
     * @return 
     */
    private boolean verificarAtaques(int[][] tabuleiro, int posLinha, int posCol) {
        int l, c;
        // verifica linha
        for (int j = 0; j < n; j++) {
            if (tabuleiro[posLinha][j] == -1) {
                return true;
            }
        }
        // diagonais principais superior
        l = posLinha;
        c = posCol;
        while ((l > 0) && (c > 0)) {
            l--;
            c--;
            if (tabuleiro[l][c] == -1) {
                return true;
            }
        }
        // diagonais principais inferior
        l = posLinha;
        c = posCol;
        while ((l < n - 1) && (c < n - 1)) {
            l++;
            c++;
            if (tabuleiro[l][c] == -1) {
                return true;
            }
        }
        // diagonais secundarias superior
        l = posLinha;
        c = posCol;
        while ((l > 0) && (c < n - 1)) {
            l--;
            c++;
            if (tabuleiro[l][c] == -1) {
                return true;
            }
        }
        // diagonais secundarias inferior
        l = posLinha;
        c = posCol;
        while ((l < n - 1) && (c > 0)) {
            l++;
            c--;
            if (tabuleiro[l][c] == -1) {
                return true;
            }
        }
        return false;
    }

    public int getQtPassos() {
        return qtPassos;
    }
    
    public boolean getConseguiu(){
        return this.conseguiu;
    }

}
