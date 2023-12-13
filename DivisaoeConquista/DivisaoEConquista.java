import java.util.*;
public class DivisaoConquista {

    public static void dvc(int[] rotas, int numCaminhoes) {

        long inicio = System.currentTimeMillis();

        Arrays.sort(rotas);
        double media = Arrays.stream(rotas).sum() / numCaminhoes;
        int[] caminhoes = new int[numCaminhoes];
        List<Integer>[] rotasPorCaminhao = new ArrayList[numCaminhoes];
        for (int i = 0; i < numCaminhoes; i++) {
            rotasPorCaminhao[i] = new ArrayList<>();
        }
        dividir(rotas, 0, rotas.length - 1, caminhoes, media, rotasPorCaminhao, 0);

        for (int i = 0; i < numCaminhoes; i++) {
            System.out.println("Caminhão " + (i+1) + ": " + caminhoes[i] + "Km - " + rotasPorCaminhao[i]);
        }

        long fim = System.currentTimeMillis();
        long tempoTotal = fim - inicio;

        System.out.println("Algoritmo finalizado em " + tempoTotal + " milisegundos, com número de rotas igual a " + rotas.length);
    }

    public static void dividir(int[] rotas, int inicio, int fim, int[] kmCaminhoes, double media, List<Integer>[] rotasPorCaminhao, int caminhaoAtual) {
        if (caminhaoAtual >= kmCaminhoes.length) {
            return;
        }

        int soma = 0;
        int i = inicio;
        while (i <= fim && soma + rotas[i] < media) {
            soma += rotas[i];
            rotasPorCaminhao[caminhaoAtual].add(rotas[i]);
            i++;
        }

        kmCaminhoes[caminhaoAtual] = soma;

        dividir(rotas, i, fim, kmCaminhoes, media, rotasPorCaminhao, caminhaoAtual + 1);
    }


    }

