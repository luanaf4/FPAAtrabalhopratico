package ProgramacaoDinamica;

import GeradorDeProblemas.GeradorDeProblemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        int trucksQuantity = 3;
        int routesQuantity = 12;
        int setLength = 10;
        long totalTime = 0;

        // List<int[]> routesSet = GeradorDeProblemas.geracaoDeRotas(routesQuantity, setLength, 0.5);
        List<int[]> routesSet = new ArrayList<>();
        int[] set1 = new int[]{40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
        int[] set2 = new int[]{32,51,32,43,42,30,42,51,43,51,29,25,27,32,29,55,43,29,32,44,55,29,53,30,24,27};

        routesSet.add(set1);
        routesSet.add(set2);

        // array de quantidadde de caminhoes que possui uma lista de soluções para os
        // conjuntos de rotas
        List<Integer>[] trucks = new ArrayList[trucksQuantity];

        long start = System.currentTimeMillis();

        for (int[] routes : routesSet) {

            List<Integer> routesAsList = new ArrayList<Integer>(Arrays.asList(Arrays.stream(routes).boxed().toArray(Integer[]::new)));

            ProgramacaoDinamica.turn = 0;

            int totalKm = 0;
            for (int i = 0; i < routes.length; i++) {
                totalKm += routes[i];
            }

            ProgramacaoDinamica.totalKm = totalKm;

            for (int i = 0; i < trucks.length; i++) {
                ProgramacaoDinamica.execute(routesAsList, trucks);
                ProgramacaoDinamica.turn++;
            }

            long end = System.currentTimeMillis();

            totalTime = end - start;
            System.out.println("Tempo de execução: " + totalTime + "ms");
            System.out.println("Tempo de execução: " + totalTime * 1000000 + "ns");
            System.out.println("---------------------------------------------------");


            for (int i = 0; i < trucks.length; i++) {
                System.out.println("Conjunto resultado do Caminhão " + (i + 1) + ": " + trucks[i]);
                int routesSum = trucks[i].stream().reduce(0, (accumulator, index) -> accumulator += index);
                System.out.println("Soma total das rotas: " + routesSum + "\n");
            }

        }
    }
}
