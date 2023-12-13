package ProgramacaoDinamica;

import GeradorDeProblemas.GeradorDeProblemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        //Valores encontrados no algoritmo de backtracking
        int trucksQuantity = 3;
        int routesQuantity = 22;
        int setLength = 10;
        long totalTime = 0;

        List<List<Integer>>[] trucks = new ArrayList[trucksQuantity];

        for (int i = 0; i < trucksQuantity; i++) {
            trucks[i] = new ArrayList<>(setLength);

            for (int j = 0; j < setLength; j++) {
                trucks[i].add(new ArrayList<Integer>());
            }
        }

        List<int[]> routesSet = GeradorDeProblemas.geracaoDeRotas(routesQuantity, setLength, 1);

        
        
        // Conjuntos definido no enunciado do trabalho:

        // int[] routes1 = {40, 36, 38, 29, 32, 28, 31, 35, 31, 30, 32, 30, 29, 39, 35, 38, 39, 35, 32, 38, 32, 33, 29, 33, 29, 39, 28};
        // int[] routes2 = {32, 51, 32, 43, 42, 30, 42, 51, 43, 51, 29, 25, 27, 32, 29, 55, 43, 29, 32, 44, 55, 29, 53, 30, 24, 27};

        // List<int[]> routesSet = new ArrayList<int[]>();
        // routesSet.add(routes1);
        // routesSet.add(routes2);
        

        for(int i = 1; i <= 30; i++){

            long start = 0;
            long end = 0;
            long localTime = 0;
            long duration = 0;

            //10 testes para realizar a média;
            for(int j = 0; j < 10; j++){
                start = System.currentTimeMillis();

                ProgramacaoDinamica.turn = 0;
                for (int[] routes : routesSet) {
                    ProgramacaoDinamica.execute(routes, trucks);

                    //change the routes set
                    ProgramacaoDinamica.turn++;
                }

                end = System.currentTimeMillis();
                duration += end - start;
                localTime += duration;
            }
            
            System.out.println("Tempo média de " + i + "T: " + localTime / 10 + "ms");
            
            totalTime += duration;
            setLength = 10 * i;

            for (int j = 0; j < trucksQuantity; j++) {
                trucks[j] = new ArrayList<>(setLength);

                for (int h = 0; h < setLength; h++) {
                    trucks[j].add(new ArrayList<Integer>());
                }
            }   

            routesSet = GeradorDeProblemas.geracaoDeRotas(routesQuantity, setLength, 1);


        }
        

        System.out.println("\nTempo de duração do algoritmo: " + totalTime + "ms\n");
        System.out.println("-------------------------------------------\n");
        
    }

// public static void main(String[] args) {

//         int t = 10;
//         int trucksQuantity = 3;
//         int routesQuantity = 22 * t;
//         int setLength = 10;
//         long totalTime = 0;

//         List<List<Integer>>[] trucks = new ArrayList[trucksQuantity];

//         for (int i = 0; i < trucksQuantity; i++) {
//             trucks[i] = new ArrayList<>(setLength);

//             for (int j = 0; j < setLength; j++) {
//                 trucks[i].add(new ArrayList<Integer>());
//             }
//         }

//         List<int[]> routesSet = GeradorDeProblemas.geracaoDeRotas(routesQuantity, setLength, 1);
        

//         long start = 0;
//         long end = 0;
//         long duration = 0;

//         for(int j = 0; j < 10; j++){
//             start = System.currentTimeMillis();

//             ProgramacaoDinamica.turn = 0;
//             for (int[] routes : routesSet) {
//                 ProgramacaoDinamica.execute(routes, trucks);

//                 ProgramacaoDinamica.turn++;
//             }

//             end = System.currentTimeMillis();
//             duration += end - start;
//             totalTime += duration;
//         }
        
//         System.out.println("Tempo médio: " + totalTime / 10 + "ms.");

//     }
    
}