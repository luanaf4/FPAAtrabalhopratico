import java.util.*;
public class DivisaoConquista {

    public static void main(String[] args) {
        int qntRotas = 22;
        int numCaminhoes = 3;
        int tamConjunto = 10;
        double dispersao = 0.5;
        long tempo = 0;
        DivisaoConquista dc = new DivisaoConquista();

        long inicio = System.nanoTime();
//        int[] r = {40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
        int[] r = {32,51,32,43,42,30,42,51,43,51,29,25,27,32,29,55,43,29,32,44,55,29,53,30,24,27};
        dc.dvc(r,3);
        long fim = System.nanoTime();
        System.out.println("Tempo de execução: " + (fim - inicio) + " nanossegundos.");


//        while (true) {
//
//            long inicio = System.currentTimeMillis();
//            List<int[]> conjuntos = GeradorDeProblemas.geracaoDeRotas(qntRotas, tamConjunto, dispersao);
//            for (int[] rotas : conjuntos) {
//                System.out.println("Rotas geradas: " + Arrays.toString(rotas));
//                dc.dvc(rotas, numCaminhoes);
//
//            }
//            long fim = System.currentTimeMillis();
//
//            tempo += (fim - inicio);
//
//            qntRotas++;
//
//            if (tempo >= 30000) {
//                System.out.println(tempo);
//                System.out.println("Em 30 segundos, o algoritmo parou com o conjunto de rotas contendo " + qntRotas + " rotas.");
//                System.out.println("Tempo médio: " + qntRotas / (tempo / 1000) + " rotas por segundo.");
//                return;
//            }
//        }

    }
    public static void dvc(int[] rotas, int numCaminhoes) {

        Arrays.sort(rotas);
        double media = Arrays.stream(rotas).sum() / numCaminhoes;
        int[] caminhoes = new int[numCaminhoes];
        List<Integer>[] rotasPorCaminhao = new ArrayList[numCaminhoes];
        for (int i = 0; i < numCaminhoes; i++) {
            rotasPorCaminhao[i] = new ArrayList<>();
        }
        dividir(rotas, 0, rotas.length - 1, caminhoes, media, rotasPorCaminhao, 0);

        System.out.println("Quantidade de rotas geradas: " + rotas.length);

        for (int i = 0; i < numCaminhoes; i++) {
            System.out.println("Caminhão " + (i+1) + ": " + caminhoes[i] + "Km ");
        }


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

