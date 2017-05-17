package iablocos;

import java.util.Scanner;

/**
 * @author juan
 */
public class IABlocos {

    public static void main(String[] args) {

        BuscaProfundidade buscaProf;
        BuscaAEstrela buscaAEst;
        Scanner input = new Scanner(System.in);
        int resp;
        int estadoInicial[];
        int estadoObjetivo[];
        int escolherHeuristica;

        System.out.println("Selecione a entrada de 1 a 10, ou 0 para sair");
        resp = input.nextInt();

        while (resp != 0) {
            switch (resp) {
                case 1:
                    escolherHeuristica = 1;
                    System.out.println("**PRIMEIRA ENTRADA – Heurística: numero de peças fora do lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 1 2 3 |");
                    System.out.println("        | 4 0 5 |");
                    System.out.println("        | 7 8 6 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 1 2 3 |");
                    System.out.println("          | 4 5 6 |");
                    System.out.println("          | 7 8 0 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {1, 2, 3, 4, 0, 5, 7, 8, 6};
                    estadoObjetivo = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 0};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");

                    System.out.println("Caminho percorrido: ");                    
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 4);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 4);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 2:
                    escolherHeuristica = 1;
                    System.out.println("**SEGUNDA ENTRADA – Heurística: numero de peças fora do lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 1 2 3 |");
                    System.out.println("        | 4 5 6 |");
                    System.out.println("        | 0 7 8 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 1 2 3 |");
                    System.out.println("          | 4 5 6 |");
                    System.out.println("          | 7 8 0 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                                        
                    estadoInicial = new int[] {1, 2, 3, 4, 5, 6, 0, 7, 8};
                    estadoObjetivo = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 0};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 6);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 6);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 3:
                    escolherHeuristica = 1;
                    System.out.println("**TERCEIRA ENTRADA – Heurística: numero de peças fora do lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 0 2 3 |");
                    System.out.println("        | 1 5 6 |");
                    System.out.println("        | 4 7 8 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 2 5 3 |");
                    System.out.println("          | 1 0 6 |");
                    System.out.println("          | 4 7 8 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {0, 2, 3, 1, 5, 6, 4, 7, 8};
                    estadoObjetivo = new int[] {2, 5, 3, 1, 0, 6, 4, 7, 8 };
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 0);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 0);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 4:
                    escolherHeuristica = 1;
                    System.out.println("**QUARTA ENTRADA – Heurística: numero de peças fora do lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 2 3 0 |");
                    System.out.println("        | 1 5 6 |");
                    System.out.println("        | 4 7 8 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 2 3 6 |");
                    System.out.println("          | 1 5 8 |");
                    System.out.println("          | 0 4 7 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {2, 3, 0, 1, 5, 6, 4, 7, 8};
                    estadoObjetivo = new int[] {2, 3, 6, 1, 5, 8, 0, 4, 7};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 2);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 2);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 5:
                    escolherHeuristica = 1;
                    System.out.println("**QUINTA ENTRADA – Heurística: numero de peças fora do lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 1 2 3 |");
                    System.out.println("        | 4 5 6 |");
                    System.out.println("        | 7 8 0 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 4 2 3 |");
                    System.out.println("          | 1 5 0 |");
                    System.out.println("          | 7 8 6 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                                        
                    estadoInicial = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 0};
                    estadoObjetivo = new int[] {4, 2, 3, 1, 5, 0, 7, 8, 6};  
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 8);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 8);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 6:
                    escolherHeuristica = 2;
                    System.out.println("**SEXTA ENTRADA – Heurística: numero de movimentos para colocar as peças no lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 1 2 3 |");
                    System.out.println("        | 4 0 5 |");
                    System.out.println("        | 7 8 6 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 1 2 3 |");
                    System.out.println("          | 4 5 6 |");
                    System.out.println("          | 7 8 0 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {1, 2, 3, 4, 0, 5, 7, 8, 6};
                    estadoObjetivo = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 0};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");

                    System.out.println("Caminho percorrido: ");                    
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 4);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 4);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 7:
                    escolherHeuristica = 2;
                    System.out.println("**SETIMA ENTRADA – Heurística: numero de movimentos para colocar as peças no lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 2 3 0 |");
                    System.out.println("        | 1 5 6 |");
                    System.out.println("        | 4 7 8 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 2 3 6 |");
                    System.out.println("          | 1 5 8 |");
                    System.out.println("          | 0 4 7 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {2, 3, 0, 1, 5, 6, 4, 7, 8};
                    estadoObjetivo = new int[] {2, 3, 6, 1, 5, 8, 0, 4, 7};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 2);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 2);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 8:
                    escolherHeuristica = 2;
                    System.out.println("**OITAVA ENTRADA – Heurística: numero de movimentos para colocar as peças no lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 1 4 2 |");
                    System.out.println("        | 0 3 7 |");
                    System.out.println("        | 6 8 5 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 1 4 2 |");
                    System.out.println("          | 3 7 5 |");
                    System.out.println("          | 6 8 0 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {1, 4, 2, 0, 3, 7, 6, 8, 5};
                    estadoObjetivo = new int[] {1, 4, 2, 3, 7, 5, 6, 8, 0};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 3);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 3);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 9:
                    escolherHeuristica = 2;
                    System.out.println("**NONA ENTRADA – Heurística: numero de movimentos para colocar as peças no lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 1 4 2 |");
                    System.out.println("        | 0 3 7 |");
                    System.out.println("        | 6 8 5 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 4 1 2 |");
                    System.out.println("          | 3 0 7 |");
                    System.out.println("          | 6 8 5 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {1, 4, 2, 0, 3, 7, 6, 8, 5};
                    estadoObjetivo = new int[] {4, 1, 2, 3, 0, 7, 6, 8, 5};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 3);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 3);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 10:
                    escolherHeuristica = 2;
                    System.out.println("**DECIMA ENTRADA – Heurística: numero de movimentos para colocar as peças no lugar**");
                    System.out.println("-----------------");
                    System.out.println("Origem: | 4 0 2 |");
                    System.out.println("        | 1 3 7 |");
                    System.out.println("        | 6 8 5 |");
                    System.out.println("-------------------");
                    System.out.println("Objetivo: | 4 3 2 |");
                    System.out.println("          | 1 8 7 |");
                    System.out.println("          | 6 0 5 |");
                    System.out.println("-------------------");
                    System.out.println("**BUSCA EM PROFUNDIDADE**");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();                    
                    estadoInicial = new int[] {4, 0, 2, 1, 3, 7, 6, 8, 5};
                    estadoObjetivo = new int[] {4, 3, 2, 1, 8, 7, 6, 0, 5};
                    
                    // verifica previamente se o problema possui soluçao
                    if(buscaProf.calcularDesordem(estadoObjetivo) == 1)
                        System.out.println("Por meio de verificaçao preliminar NAO POSSUI SOLUÇAO!");
                    else
                        System.out.println("Por meio de verificaçao preliminar POSSUI SOLUÇAO!");
                    
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(estadoInicial.clone(), estadoObjetivo.clone(), 1);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(estadoInicial.clone(), estadoObjetivo.clone(), 1);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println("Nao ha caminho possivel!");
                    } else {
                        System.out.println("Sucesso!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
            }

            System.out.println("Selecione a entrada de 1 a 10, ou 0 para sair");
            resp = input.nextInt();
        }
    }

}
