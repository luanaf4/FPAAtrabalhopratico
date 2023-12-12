package ProgramacaoDinamica;

import GeradorDeProblemas.GeradorDeProblemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        int trucksQuantity = Integer.parseInt(args.length > 0 ? args[0] : "3");
        int routesQuantity = Integer.parseInt(args.length > 1 ? args[1] : "6");
        int setLength = Integer.parseInt(args.length > 2 ? args[2] : "10");

        List<List<Integer>>[] trucks = new ArrayList[trucksQuantity];


        for (int i = 0; i < trucksQuantity; i++) {
            trucks[i] = new ArrayList<>(setLength);

            for(int j = 0; j < setLength; j++){
                trucks[i].add(new ArrayList<Integer>());
            }

        }

        List<int[]> routesSet = GeradorDeProblemas.geracaoDeRotas(routesQuantity, setLength, 0.5);

        long start = System.currentTimeMillis();

        for(int[] routes : routesSet){
            ProgramacaoDinamica.execute(trucks, routes);
            ProgramacaoDinamica.time++;
        }


        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Tempo de duração do algoritmo: " + duration + "ms");
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