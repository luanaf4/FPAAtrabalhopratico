package ProgramacaoDinamica;

import java.util.Arrays;
import java.util.List;

public class ProgramacaoDinamica {

    public static int turn = 0;

    public static void execute(int[] routes, List<List<Integer>>[] trucks){

        int[][] memoryTable = new int[routes.length][trucks.length];

        //filling the table with invalid values
        for (int[] row : memoryTable) {
            Arrays.fill(row, -1);
        }

        ProgramacaoDinamica.distributeRoutes(routes, routes.length - 1, trucks, memoryTable);

    }

    public static void distributeRoutes(int[] routes, int actualRoute, List<List<Integer>>[] trucks, int[][] memoryTable) {
        if (actualRoute >= 0) {

            int smallestSet = Integer.MAX_VALUE;
            List<Integer> iterationTruckSetRef = null;
            List<Integer> smallestTruckSetReference = null;

            for (int i = 0; i < trucks.length; i++) {
                iterationTruckSetRef = trucks[i].get(ProgramacaoDinamica.turn);
                int totalKm = iterationTruckSetRef.stream().reduce(0, (accumulator, route) -> accumulator += route);

                if (totalKm < smallestSet) {
                    smallestSet = totalKm;
                    smallestTruckSetReference = iterationTruckSetRef;
                }
            }

            smallestTruckSetReference.add(routes[actualRoute]);

            // verify if the next solution was already finded
            if (memoryTable[actualRoute][ProgramacaoDinamica.turn] == -1) {

                // find the next solution and save the finded solution
                distributeRoutes(routes, actualRoute - 1, trucks, memoryTable);
                memoryTable[actualRoute][ProgramacaoDinamica.turn] = smallestSet;

            }
        }
    }
}
