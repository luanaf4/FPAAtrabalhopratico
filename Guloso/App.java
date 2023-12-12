package Guloso;
import GeradorDeProblemas.GeradorDeProblemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        int trucksQuantity = 3;
        int routesQuantity = 15;
        int setLength = 6;

        List<List<Integer>>[] trucks = new ArrayList[trucksQuantity];

        for (int i = 0; i < trucksQuantity; i++) {
            trucks[i] = new ArrayList<>(setLength);

            for (int j = 0; j < setLength; j++) {
                trucks[i].add(new ArrayList<Integer>());
            }
        }

        List<int[]> routesSet = GeradorDeProblemas.geracaoDeRotas(routesQuantity, setLength, 0.5);
        long start = System.currentTimeMillis();

        for (int[] routes : routesSet) {

            Guloso.execute(trucks, routes);

            //change the routes set
            Guloso.time++;
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("\nTempo de duração do algoritmo: " + duration + "ms\n");
        System.out.println("-------------------------------------------\n");

        String result = "";
        int aux = 1;
        for(int[] route : routesSet){
            result += "Conjunto " + aux + " de rotas a ser distribuídas: " + Arrays.toString(route) + "\n";
            aux++;
        }

        System.out.println(result);
        System.out.println("-------------------------------------------\n");


        result = "";
        aux = 1;
        for(List<List<Integer>> truck : trucks){
            result += "Conjunto de rotas do Caminhão " + aux + ":" + truck.toString() + "\n";
            aux++;
        }

        System.out.println(result);
        System.out.println("-------------------------------------------\n");


        result = "";
        aux = 1;
        for(List<List<Integer>> truck : trucks){
            List<String> temp = truck.stream()
                .map((routeSet) -> routeSet.stream().mapToInt(Integer::intValue).sum())
                .map((totalRouteSet) -> totalRouteSet + "Km")
                .collect(Collectors.toList());

            result += "Total de Km por conjunto de rotas do Caminhão " + aux + ":" + temp + "\n";
            aux++;
        }

        System.out.println(result);

        
    }


    
}
