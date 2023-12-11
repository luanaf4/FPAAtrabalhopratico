import java.util.*;
public class DivisaoEConquista {
    public static void dvc(int[] rotas, int numCaminhoes) {

        long inicio = System.currentTimeMillis();

        Arrays.sort(rotas);
        System.out.println(Arrays.toString(rotas));
        int[] caminhoes = new int[numCaminhoes];
        List<Integer>[] rotasPorCaminhao = new ArrayList[numCaminhoes];
        for (int i = 0; i < numCaminhoes; i++) {
            rotasPorCaminhao[i] = new ArrayList<>();
        }
        dividir(rotas, 0, rotas.length - 1, caminhoes, rotasPorCaminhao);

        for (int i = 0; i < numCaminhoes; i++) {
            System.out.println("Caminhão " + (i+1) + ": " + rotasPorCaminhao[i] + " - " + caminhoes[i] + "km");

        }

        long fim = System.currentTimeMillis();
        long tempoTotal = fim - inicio;

        System.out.println("Algoritmo finalizado em " + tempoTotal + " milisegundos, com número de rotas igual a " + rotas.length);
    }

    public static void dividir(int[] rotas, int inicio, int fim, int[] kmCaminhoes, List<Integer>[] rotasPorCaminhao) {
        if (inicio > fim) {
            return;
        }
        else {
            int mid = inicio + (fim - inicio) / 2;

            dividir(rotas, inicio, mid - 1, kmCaminhoes, rotasPorCaminhao);
            dividir(rotas, mid + 1, fim, kmCaminhoes, rotasPorCaminhao);

            int menorKm = acharMenorKmTotal(kmCaminhoes);
            kmCaminhoes[menorKm] += rotas[mid];
            rotasPorCaminhao[menorKm].add(rotas[mid]);
        }
    }

    public static int acharMenorKmTotal(int[] caminhoes) {
        int minIndex = 0;
        for (int i = 0; i < caminhoes.length; i++) {
            if (caminhoes[i] < caminhoes[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
