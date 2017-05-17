package iacaminho;

import java.util.Scanner;

/**
 * @author juan
 */
public class IACaminho {

    public static void main(String[] args) {

        BuscaProfundidade buscaProf;
        BuscaAEstrela buscaAEst;
        Scanner input = new Scanner(System.in);
        int resp;
        int n;
        int escolherHeuristica;

        System.out.println("Selecione a entrada de 1 a 10, ou 0 para sair");
        resp = input.nextInt();

        while (resp != 0) {
            switch (resp) {
                case 1:
                    escolherHeuristica = 1;
                    System.out.println("**PRIMEIRA ENTRADA - Origem: 1 - Destino: 5 – Heurística: Distância Manhattan");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(1, 5);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(1, 5);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;

                case 2:
                    escolherHeuristica = 1;
                    System.out.println("**SEGUNDA ENTRADA - Origem: 14 - Destino: 5 – Heurística: Distância Manhattan");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(14, 5);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(14, 5);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                
                case 3:
                    escolherHeuristica = 1;
                    System.out.println("**TERCEIRA ENTRADA - Origem: 10 - Destino: 2 – Heurística: Distância Manhattan");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(10, 2);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(10, 2);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 4:
                   escolherHeuristica = 1;
                    System.out.println("**QUARTA ENTRADA - Origem: 1 - Destino: 20 – Heurística: Distância Manhattan");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(1, 20);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(1, 20);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 5:
                   escolherHeuristica = 1;
                    System.out.println("**QUINTA ENTRADA - Origem: 17 - Destino: 10 – Heurística: Distância Manhattan");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(17, 10);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(17, 10);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                
                case 6:
                    escolherHeuristica = 2;
                    System.out.println("**SEXTA ENTRADA - Origem: 1 - Destino: 5 – Heurística: Distância Euclidiana");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(1, 5);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(1, 5);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 7:
                    escolherHeuristica = 2;
                    System.out.println("**SETIMA ENTRADA - Origem: 14 - Destino: 5 – Heurística: Distância Euclidiana");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(14, 5);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(14, 5);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 8:
                    escolherHeuristica = 2;
                    System.out.println("**OITAVA ENTRADA - Origem: 10 - Destino: 2 – Heurística: Distância Euclidiana");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(10, 2);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario1();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(10, 2);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                
                case 9:
                    escolherHeuristica = 2;
                    System.out.println("**NOVA ENTRADA - Origem: 1 - Destino: 20 – Heurística: Distância Euclidiana");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(1, 20);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(1, 20);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaAEst.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaAEst.getEstados());
                    System.out.println();
                    break;
                    
                case 10:
                    escolherHeuristica = 2;
                    System.out.println("**DECIMA ENTRADA - Origem: 17 - Destino: 10 – Heurística: Distância Euclidiana");
                    System.out.println("**BUSCA EM PROFUNDIDADE");
                    buscaProf = new BuscaProfundidade();
                    buscaProf.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaProf.buscaProfundidade(17, 10);
                    if (buscaProf.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
                    }
                    System.out.println("CUSTO: " + buscaProf.getCusto());
                    System.out.println("ESTADOS EXPANDIDOS: " + buscaProf.getEstados());
                    System.out.println();

                    System.out.println("**BUSCA A ESTRELA**");
                    buscaAEst = new BuscaAEstrela(escolherHeuristica);
                    buscaAEst.cenario3();
                    System.out.println("Caminho percorrido: ");
                    buscaAEst.buscaAEstrela(17, 10);
                    if (buscaAEst.getEncontrou() == false) {
                        System.out.println();
                        System.out.println("Nao ha caminho possivel!");
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