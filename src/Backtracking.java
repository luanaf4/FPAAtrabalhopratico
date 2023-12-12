import java.util.Arrays;

public class Backtracking {
    private int[] rotas;
    private int[] caminhoes;
    private int melhorDiferenca = Integer.MAX_VALUE;

    public Backtracking(int[] rotas, int numCaminhoes) {
        this.rotas = rotas;
        this.caminhoes = new int[numCaminhoes];
    }

    public void distribuir() {
        Arrays.sort(rotas);
        backtrack(rotas.length - 1);
    }

    private void backtrack(int rotaAtual) {
        if (rotaAtual < 0) {
            int maxKm = Arrays.stream(caminhoes).max().getAsInt();
            int minKm = Arrays.stream(caminhoes).min().getAsInt();
            int diferenca = maxKm - minKm;

            if (diferenca < melhorDiferenca) {
                melhorDiferenca = diferenca;
                System.out.println("Nova melhor distribuição: " + Arrays.toString(caminhoes));
            }
            return;
        }

        for (int i = 0; i < caminhoes.length; i++) {
            caminhoes[i] += rotas[rotaAtual];
            backtrack(rotaAtual - 1);
            caminhoes[i] -= rotas[rotaAtual];
        }
    }

    public static void main(String[] args) {
        int[] rotas = {35, 34, 33, 23, 21, 32, 35, 19, 26, 42};
        Backtracking bt = new Backtracking(rotas, 3);
        bt.distribuir();
    }
}