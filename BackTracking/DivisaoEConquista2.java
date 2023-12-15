import java.util.Arrays;
import java.util.List;

public class DivisaoEConquista2 {
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
    public static void main(String[] args) {
        // Gera uma lista de arrays de inteiros para teste
        List<int[]> conjuntosDeTeste = GeradorDeProblemas.geracaoDeRotas(6,10,0.5);

        // Processa cada caso de teste
        for (int[] rotas : conjuntosDeTeste) {
            System.out.println("Testando rotas: " + Arrays.toString(rotas));

            System.out.println("Soma total das rotas: " + Arrays.stream(rotas).sum());

            int numCaminhoes = 3;
            int[] rotasPorCaminhao = new int[numCaminhoes];

            // Atribui as rotas aos caminhões
            for (int i = 0; i < rotas.length; i++) {
                rotasPorCaminhao[i % numCaminhoes] += rotas[i];
            }

            rotasPorCaminhao = divideConquista(rotasPorCaminhao);

            for (int i = 0; i < rotasPorCaminhao.length; i++) {
                System.out.println("Caminhão " + (i + 1) + ": " + rotasPorCaminhao[i]);
            }

            System.out.println("-------------------------");
        }
    }
}
