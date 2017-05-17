package iarainhas;

import java.util.Scanner;

/**
 * @author juan
 */
public class IARainhas {

    // numero maximo que a busca ira se repetir para um mesmo valor de custo
    private static final int REP = 5;

    public static void main(String[] args) {

        BuscaBacktracking buscaBack;
        BuscaLocal buscaLocal;
        Scanner input = new Scanner(System.in);
        int resp;
        int n;
        
        System.out.println("Selecione a entrada de 1 a 10, ou 0 para sair");
        resp = input.nextInt();        

        while (resp != 0) {
            switch (resp) {
                case 1:
                    System.out.println("**PRIMEIRA ENTRADA - 4 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 4;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("**SEGUNDA ENTRADA - 2 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 2;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("**TERCEIRA ENTRADA - 1 Rainha");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 1;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("**QUARTA ENTRADA - 8 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 8;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("**QUINTA ENTRADA - 10 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 10;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.println("**SEXTA ENTRADA - 12 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 12;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 7:
                    System.out.println("**SETIMA ENTRADA - 14 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 14;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 8:
                    System.out.println("**OITAVA ENTRADA - 15 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 15;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 9:
                    System.out.println("**NONA ENTRADA - 17 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 17;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;

                case 10:
                    System.out.println("**DECIMA ENTRADA - 16 Rainhas");
                    System.out.println("**BUSCA BACKTRACK**");
                    n = 16;
                    buscaBack = new BuscaBacktracking(n);
                    buscaBack.buscaBacktracking(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    } else {
                        System.out.println("NAO CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(n);
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU DISTRIBUIR");
                    }
                    System.out.println();
                    break;
            }

            System.out.println("Selecione a entrada de 1 a 10, ou 0 para sair");
            resp = input.nextInt();
        }
    }
}
