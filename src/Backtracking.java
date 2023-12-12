import java.util.Arrays;

public class Backtracking {
    private int numCaminhoes;
    private int[] rotas;
    private int[] caminhoes;
    private int minDiferenca = Integer.MAX_VALUE;
    private int mediaKm;

    public Backtracking(int numCaminhoes, int[] rotas) {
        this.numCaminhoes = numCaminhoes;
        this.rotas = rotas;
        this.caminhoes = new int[numCaminhoes];
        this.mediaKm = Arrays.stream(rotas).sum() / numCaminhoes;
    }

    public void distribuirRotas() {
        Arrays.sort(rotas);
        if (Arrays.stream(rotas).sum() % numCaminhoes == 0) {
            backtrack(0, true);
        } else {
            System.out.println("Não foi possível dividir igualmente. Tentando minimizar a diferença...");
            backtrack(0, false);
        }
    }

    private void backtrack(int rotaAtual, boolean dividirIgualmente) {
        if (rotaAtual == rotas.length) {
            int maxKm = Arrays.stream(caminhoes).max().getAsInt();
            int minKm = Arrays.stream(caminhoes).min().getAsInt();
            int diferenca = maxKm - minKm;

            if (diferenca < minDiferenca) {
                minDiferenca = diferenca;
                System.out.println("Nova melhor distribuição: " + Arrays.toString(caminhoes));
            }
            return;
        }

        for (int i = 0; i < numCaminhoes; i++) {
            caminhoes[i] += rotas[rotaAtual];

            if (dividirIgualmente && caminhoes[i] <= mediaKm || !dividirIgualmente && isPromising(i)) {
                backtrack(rotaAtual + 1, dividirIgualmente);
            }

            caminhoes[i] -= rotas[rotaAtual];
        }
    }

    private boolean isPromising(int caminhao) {
        int maxKm = Arrays.stream(caminhoes).max().getAsInt();
        int minKm = Arrays.stream(caminhoes).min().getAsInt();
        int diferenca = maxKm - minKm;

        return diferenca < minDiferenca;
    }

    public static void main(String[] args) {
        int numCaminhoes = 3;
        int[] rotas = {32,51,32,43,42,30,42,51,43,51,29,25,27,32,29,55,43,29,32,44,55,29,53,30,24,27};
        Backtracking backtracking = new Backtracking(numCaminhoes, rotas);
        backtracking.distribuirRotas();
    }
}