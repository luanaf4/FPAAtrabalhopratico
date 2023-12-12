import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    private int numCaminhoes;
    private int[] rotas;
    private int[] caminhoes;
    private int[][] rotasCaminhoes;
    private int[] melhorDistribuicao;
    private int[][] melhorRotasCaminhoes;
    private int menorDiferenca = Integer.MAX_VALUE;
    private int quilometragemIdeal;

    public Backtracking(int numCaminhoes, int[] rotas) {
        this.numCaminhoes = numCaminhoes;
        this.rotas = rotas;
        this.caminhoes = new int[numCaminhoes];
        this.rotasCaminhoes = new int[numCaminhoes][rotas.length];
        this.melhorDistribuicao = new int[numCaminhoes];
        this.melhorRotasCaminhoes = new int[numCaminhoes][rotas.length];
        this.quilometragemIdeal = Arrays.stream(rotas).sum() / numCaminhoes;
    }

    public void distribuirRotas() {
        distribuirRotas(0);
    }

    private void distribuirRotas(int rotaAtual) {
        if (rotaAtual == rotas.length) {
            int diferenca = Arrays.stream(caminhoes).max().getAsInt() - Arrays.stream(caminhoes).min().getAsInt();
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                System.arraycopy(caminhoes, 0, melhorDistribuicao, 0, numCaminhoes);
                for (int i = 0; i < numCaminhoes; i++) {
                    System.arraycopy(rotasCaminhoes[i], 0, melhorRotasCaminhoes[i], 0, rotas.length);
                }
            }
        } else {
            for (int i = 0; i < numCaminhoes; i++) {
                if (caminhoes[i] + rotas[rotaAtual] <= quilometragemIdeal &&
                        caminhoes[i] <= quilometragemIdeal &&
                        (Arrays.stream(caminhoes).max().getAsInt() - Arrays.stream(caminhoes).min().getAsInt() < menorDiferenca) &&
                        Arrays.stream(caminhoes).sum() <= quilometragemIdeal * numCaminhoes) {
                    caminhoes[i] += rotas[rotaAtual];
                    rotasCaminhoes[i][rotaAtual] = 1;
                    distribuirRotas(rotaAtual + 1);
                    caminhoes[i] -= rotas[rotaAtual];
                    rotasCaminhoes[i][rotaAtual] = 0;
                }
            }
        }
    }
//    * Conjunto de rotas 1: 40;36;38;29;32;28;31;35;31;30;32;30;29;39;35;38;39;35;32;38;32;33;29;33;29;39;28
//
//    public static void main(String[] args) {
//        int numCaminhoes = 3;
//        int[] rotas = {40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
//
//        Backtracking backtracking = new Backtracking(numCaminhoes, rotas);
//        backtracking.distribuirRotas();
//
//        System.out.println("Melhor distribuição: " + Arrays.toString(backtracking.melhorDistribuicao));
//        for (int i = 0; i < numCaminhoes; i++) {
//            System.out.println("Caminhão " + (i + 1) + ": " + backtracking.melhorDistribuicao[i] + " km");
//            System.out.print("Rotas: ");
//            for (int j = 0; j < rotas.length; j++) {
//                if (backtracking.melhorRotasCaminhoes[i][j] == 1) {
//                    System.out.print(rotas[j] + " ");
//                }
//            }
//            System.out.println();
//        }
//    }

    //    Conjunto de rotas 2: 32;51;32;43;42;30;42;51;43;51;29;25;27;32;29;55;43;29;32;44;55;29;53;30;24;27
//
//    public static void main(String[] args) {
//        int numCaminhoes = 3;
//        int[] rotas = {40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
//
//        Backtracking backtracking = new Backtracking(numCaminhoes, rotas);
//        backtracking.distribuirRotas();
//
//        System.out.println("Melhor distribuição: " + Arrays.toString(backtracking.melhorDistribuicao));
//        for (int i = 0; i < numCaminhoes; i++) {
//            System.out.println("Caminhão " + (i + 1) + ": " + backtracking.melhorDistribuicao[i] + " km");
//            System.out.print("Rotas: ");
//            for (int j = 0; j < rotas.length; j++) {
//                if (backtracking.melhorRotasCaminhoes[i][j] == 1) {
//                    System.out.print(rotas[j] + " ");
//                }
//            }
//            System.out.println();
//        }
//    }

// Utilizando o código do gerador de problemas

    public static void main(String[] args) {
        int numCaminhoes = 3;
        int tamConjunto = 10;
        double dispersao = 0.5;
        int quantRotas = 6; // começando com 6 rotas

        while (true) {
            List<int[]> conjuntosDeTeste = GeradorDeProblemas.geracaoDeRotas(quantRotas, tamConjunto, dispersao);
            long totalDuration = 0;

            for (int[] rotas : conjuntosDeTeste) {
                Instant start = Instant.now();
                Backtracking backtracking = new Backtracking(numCaminhoes, rotas);
                backtracking.distribuirRotas();
                Instant end = Instant.now();
                Duration duration = Duration.between(start, end);
                totalDuration += duration.toMillis();

                // Imprimir as rotas
                System.out.println("Rotas: " + Arrays.toString(rotas));
            }

            long averageDuration = totalDuration / tamConjunto;

            System.out.println("Número de rotas: " + quantRotas + ", Tempo médio de execução: " + averageDuration + " ms");

            if (averageDuration > 30000) { // se o tempo médio de execução ultrapassar 30 segundos, pare o loop
                break;
            }

            quantRotas++; // aumenta o número de rotas para o próximo teste
        }
    }
}



