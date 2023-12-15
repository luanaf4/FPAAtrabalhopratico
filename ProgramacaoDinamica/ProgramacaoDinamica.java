package ProgramacaoDinamica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramacaoDinamica {

    public static int turn = 0;
    public static int totalKm = 0;

    public static void execute(List<Integer> routes, List<Integer>[] trucks){

        

        int bestResult = (int) Math.ceil((double) totalKm / trucks.length);

        int[][] memoryTable = new int[bestResult + 1][routes.size() + 1];

        // filling the table with invalid values
        for (int[] row : memoryTable) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i <= routes.size(); i++) {
            memoryTable[0][i] = 1;
        }

        for (int i = 1; i <= bestResult; i++) {
            for (int j = 1; j <= routes.size(); j++) {
                memoryTable[i][j] = memoryTable[i][j - 1];
                if (i >= routes.get(j - 1)) {
                    if (memoryTable[i][j] == 1 || memoryTable[i - routes.get(j - 1)][j - 1] == 1) {
                        memoryTable[i][j] = 1;
                    } else {
                        memoryTable[i][j] = 0;
                    }
                }
            }
        }


        //!TODO: remover as rotas que já foram selecionadas.
        // System.out.println("Caminhão" + turn);
        List<Integer> result = ProgramacaoDinamica.findRouteSet(routes, memoryTable);
        trucks[turn] = result;

        for (Integer route : result) {
            routes.remove(routes.indexOf(route));
        }
        // ProgramacaoDinamica.turn++;

    }


    public static List<Integer> findRouteSet(List<Integer> routes, int[][] table){

        List<Integer> findedSet = new ArrayList<Integer>();
        int line = table.length - 1;
        int column = routes.size();

        for(int i = line; i > 0; i--){
            if (table[i][column] == 1) {
                line = i;
                break;
            }
        }

        while (line > 0 && column > 0) {
            if (table[line][column] != table[line][column - 1]) {
                findedSet.add(routes.get(column - 1));
                line -= routes.get(column - 1);
            }
            column--;
        }
        

        return findedSet;
    }

}
