package iacores;

import java.util.Scanner;

/**
 * @author juan
 */
public class IACores {

    // numero maximo que a busca ira se repetir para um mesmo valor de custo
    private static final int REP = 5;

    public static void main(String[] args) {

        BuscaBacktrack buscaBack;
        BuscaLocal buscaLocal;
        Scanner input = new Scanner(System.in);
        int resp;
        System.out.println("Selecione a entrada de 1 a 10, ou 0 para sair");
        resp = input.nextInt();

        while (resp != 0) {
            switch (resp) {
                case 1:
                    System.out.println("**PRIMEIRA ENTRADA: 3 cores e 4 vertices");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(3, 4);
                    buscaBack.cenario1();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(3, 4);
                    buscaLocal.cenario1();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("**SEGUNDA ENTRADA: 1 cores e 4 vertices");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(1, 4);
                    buscaBack.cenario1();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(1, 4);
                    buscaLocal.cenario1();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();
                    break;
                   
                case 3:
                    System.out.println("**TERCEIRA ENTRADA: 3 cores e 6 vertices");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(3, 6);
                    buscaBack.cenario2();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(3, 6);
                    buscaLocal.cenario2();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("**TERCEIRA ENTRADA: 2 cores e 6 vertices");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(2, 6);
                    buscaBack.cenario2();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(2, 6);
                    buscaLocal.cenario2();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();
                    break;
                    
                case 5:
                    System.out.println("**TERCEIRA ENTRADA: 3 cores e 5 vertices adjacentes entre si");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(3, 5);
                    buscaBack.cenario3();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(3, 5);
                    buscaLocal.cenario3();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();
                    break;
                    
                case 6:
                    System.out.println("**TERCEIRA ENTRADA: 4 cores e 5 vertices adjacentes entre si");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(4, 5);
                    buscaBack.cenario3();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(4, 5);
                    buscaLocal.cenario3();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();                    
                    break;
                    
                    
                case 7:
                    System.out.println("**TERCEIRA ENTRADA: 5 cores e 5 vertices adjacentes entre si");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(5, 5);
                    buscaBack.cenario3();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(5, 5);
                    buscaLocal.cenario3();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();    
                    break;
                    
                case 8:
                    System.out.println("**TERCEIRA ENTRADA: 3 cores e 9 vertices");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(3, 9);
                    buscaBack.cenario4();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(3, 9);
                    buscaLocal.cenario4();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();   
                    break;
                    
                case 9:
                    System.out.println("**TERCEIRA ENTRADA: 2 cores e 9 vertices");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(2, 9);
                    buscaBack.cenario4();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(2, 9);
                    buscaLocal.cenario4();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();
                    break;
                    
                case 10:
                    System.out.println("**TERCEIRA ENTRADA: 5 cores e 9 vertices adjacentes entre si");
                    System.out.println("**BUSCA BACKTRACK**");
                    buscaBack = new BuscaBacktrack(5, 9);
                    buscaBack.cenario5();
                    buscaBack.buscaBacktrack(0);
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaBack.getQtPassos());
                    if (buscaBack.getConseguiu() == true) {
                        System.out.println("CONSEGUIU COLORIR");
                    } else {
                        System.out.println("NAO CONSEGUIU COLORIR");
                    }
                    System.out.println();

                    System.out.println("**BUSCA LOCAL**");
                    buscaLocal = new BuscaLocal(5, 9);
                    buscaLocal.cenario5();
                    buscaLocal.buscaLocal();
                    System.out.println("QUANTIDADE DE PASSOS: " + buscaLocal.getQtPassos());
                    if (buscaLocal.getTimeOut() >= REP) {
                        System.out.println("Como o valor da funçao de custo continuou igual depois de " + REP + " repetiçoes,"
                                + " ENCONTROU UM MINIMO LOCAL");
                    } else {
                        System.out.println("CONSEGUIU COLORIR");
                    }
                    System.out.println();
                    break;
                    
            }

            System.out.println("Selecione a entrada de 1 a 10, ou 0 para sair");
            resp = input.nextInt();
        }
    }

}
