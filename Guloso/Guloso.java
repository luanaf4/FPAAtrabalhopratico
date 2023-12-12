package Guloso;

import java.util.Arrays;
import java.util.List;

public class Guloso {
    
    public static int time = 0;

    public static void execute(List<List<Integer>>[] trucks, int[] routes){

        Arrays.sort(routes);
        Guloso.distributeRoutesRecursive(routes, routes.length - 1, trucks);

    }


    public static void distributeRoutesRecursive(int[] routes, int actualRoute, List<List<Integer>>[] trucks){

        if(actualRoute >= 0){
            
            int smallestSet = Integer.MAX_VALUE;
            List<Integer> truckSetReference = null;
            List<Integer> smallestTruckSetReference = null;

            for(List<List<Integer>> truck : trucks){
                truckSetReference = truck.get(time);

                Integer totalKm = truckSetReference.stream()
                    .reduce(0, (accumulator, route) -> accumulator += route);

                if(totalKm < smallestSet){
                    smallestSet = totalKm;
                    smallestTruckSetReference = truckSetReference;
                }

            }

            smallestTruckSetReference.add(routes[actualRoute]);

            Guloso.distributeRoutesRecursive(routes, actualRoute - 1, trucks);

            return;

        }

        return;

    }


}
