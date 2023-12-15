import java.util.Arrays;
import java.util.List;

public class DivisaoEConquista2 {

    public static void main(String[] args) {
        int qtdRotas = 22;
        int numCaminhoes = 3;
        double dispersao = 0.5;

        //int[] rotas = {40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
        //int[] rotas = {32,51,32,43,42,30,42,51,43,51,29,25,27,32,29,55,43,29,32,44,55,29,53,30,24,27};

        /*
        long inicio = System.nanoTime();

        int[] rotasPorCaminhao = new int[numCaminhoes];
        for (int i = 0; i < rotas.length; i++) {
            rotasPorCaminhao[i % numCaminhoes] += rotas[i];
        }

        rotasPorCaminhao = divideConquista(rotasPorCaminhao);

        long fim = System.nanoTime();
        long tempoCorrido = fim - inicio;

        for (int i = 0; i < rotasPorCaminhao.length; i++) {
            System.out.println("Caminhão " + (i + 1) + ": " + rotasPorCaminhao[i] + " km");
        }

        System.out.println("Tempo de execução: " + tempoCorrido + " nanossegundos.");

         */

        long startTime = System.nanoTime();

        while (true) {
            List<int[]> conjuntosDeTeste = GeradorDeProblemas.geracaoDeRotas(qtdRotas, 10, dispersao);
            for (int[] rotas : conjuntosDeTeste) {
                System.out.println("Soma total das rotas: " + Arrays.stream(rotas).sum());

                int[] rotasPorCaminhao = new int[numCaminhoes];

                // Atribui as rotas aos caminhões
                for (int i = 0; i < rotas.length; i++) {
                    rotasPorCaminhao[i % numCaminhoes] += rotas[i];
                }

                rotasPorCaminhao = divideConquista(rotasPorCaminhao);

                for (int i = 0; i < rotasPorCaminhao.length; i++) {
                    System.out.println("Caminhão " + (i + 1) + ": " + rotasPorCaminhao[i]);
                }


                System.out.println("Quantidade de rotas: " + qtdRotas);
                System.out.println("-------------------------");

            }

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            qtdRotas++;

            if (duration >= 30_000_000_000L) { // 30 segundos em nanossegundos
                System.out.println("Tempo total de execução: " + duration + " nanossegundos.");
                break;
            }
        }


    }


    public static int[] divideConquista(int[] rotas) {
        if (rotas.length == 1) {
            return rotas;
        }
        int[] rotas1 = Arrays.copyOfRange(rotas, 0, rotas.length / 2);
        int[] rotas2 = Arrays.copyOfRange(rotas, rotas.length / 2, rotas.length);

        rotas1 = divideConquista(rotas1);
        rotas2 = divideConquista(rotas2);

        return combinar(rotas1, rotas2);
    }

    public static int[] combinar(int[] rotas1, int[] rotas2) {
        int[] rotas = new int[rotas1.length + rotas2.length];

        for (int i = 0; i < rotas1.length; i++) {
            rotas[i] = rotas1[i];
        }

        for (int i = 0; i < rotas2.length; i++) {
            rotas[rotas1.length + i] = rotas2[i];
        }

        return rotas;
    }
}