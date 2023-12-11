import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int numCaminhoes = 3;
        int tamanhoConjunto = 10;
        int numRotas = 6;
        double dispersao = 0.5;
        long tempo = 0;
        DivisaoEConquista dc = new DivisaoEConquista();
        
        while(true){

            long inicio = System.currentTimeMillis();
            List<int[]> conjuntos = GeradorDeProblemas.geracaoDeRotas(numRotas, tamanhoConjunto, dispersao);
            for(int[] rotas : conjuntos){
                System.out.println("Rotas geradas: " + Arrays.toString(rotas));
                dc.dvc(rotas,numCaminhoes);

            }
            long fim = System.currentTimeMillis();

            tempo += (fim - inicio);

            numRotas++;

            if(tempo >= 30000){
                System.out.println(tempo);
                System.out.println("Em 30 segundos, o algoritmo parou com o conjunto de rotas contendo " + numRotas + " rotas.");
                System.out.println("Tempo médio: " + numRotas / (tempo / 1000) + " rotas por segundo.");
                return;
            }


        }

        /*
        int[] rotaTeste = {14, 16, 25, 15 , 23, 14};
        int[] rotaTeste2 = {14,23,22,18,16,15};
        int[] teste3 = {35, 34, 33, 23, 21, 32, 35, 19, 26, 42};
        dc.distruirRotas(teste3, 3);
        System.out.println(Arrays.toString(rotaTeste2));
        */
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
