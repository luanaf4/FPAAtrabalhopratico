import java.util.Arrays;
import java.util.List;

import GeradorDeProblemas.GeradorDeProblemas;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int qntRotas = 6;
        int numCaminhoes = 3;
        int tamConjunto = 10;
        double dispersao = 0.5;
        long tempo = 0;


        DivisaoConquista dc = new DivisaoConquista();
        // List<int[]> rotas = GeradorDeProblemas.geracaoDeRotas(qntRotas, tamConjunto, dispersao);

        while (true) {

            long inicio = System.currentTimeMillis();
            List<int[]> conjuntos = GeradorDeProblemas.geracaoDeRotas(qntRotas, tamConjunto, dispersao);
            for (int[] rotas : conjuntos) {
                System.out.println("Rotas geradas: " + Arrays.toString(rotas));
                dc.dvc(rotas, numCaminhoes);

            }
            long fim = System.currentTimeMillis();

            tempo += (fim - inicio);

            qntRotas++;

            if (tempo >= 30000) {
                System.out.println(tempo);
                System.out.println("Em 30 segundos, o algoritmo parou com o conjunto de rotas contendo " + qntRotas + " rotas.");
                System.out.println("Tempo médio: " + qntRotas / (tempo / 1000) + " rotas por segundo.");
                return;
            }




        /*
        int[] r = {40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
        int[] r2 = {32,51,32,43,42,30,42,51,43,51,29,25,27,32,29,55,43,29,32,44,55,29,53,30,24,27};
        int[] r3 = {35, 34, 33, 23, 21, 32, 35, 19, 26, 42};
         */

       }
    }

    /*
    // Ordenar array v entre posições start e end
    static void mergeSort(int v[], int start, int end) {
        if (start == end) return;        // caso base (tamanho 1)
        int middle = (start + end) / 2;  // ponto médio
        mergeSort(v, start, middle);     // chamada recursiva à metade esquerda
        mergeSort(v, middle+1, end);     // chamada recursiva à metade direita
        merge(v, start, middle, end);    // combinar resultados
    }

    // Juntar duas metadas já ordenadas
    static void merge(int v[], int start, int middle, int end) {
        int aux[] = new int[end-start+1]; // Novo array temporário

        int p1 = start;    // "Apontador" do array da metade esquerda
        int p2 = middle+1; // "Apontador" do array da metade direita
        int cur = 0;       // "Apontador" do array aux[] a conter juncao
        while (p1 <= middle && p2 <= end) { // Enquanto der para comparar
            if (v[p1] <= v[p2]) aux[cur++] = v[p1++]; // Escolher menor
            else aux[cur++] = v[p2++];                // e adicionar
        }
        while (p1<=middle) aux[cur++] = v[p1++]; // Adicionar o que resta
        while (p2<=end)    aux[cur++] = v[p2++];

        // Copiar array aux[] para v[]
        for (int i=0; i<cur; i++) v[start+i] = aux[i];
    }
    */

}
