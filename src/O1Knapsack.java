import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O1Knapsack {

    static int[][] matrix;

    static public void knapsack(Pair[] pairs, int totalWeight) {
        matrix = new int[pairs.length][totalWeight+1];
        for (int i = 0; i < pairs.length; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < pairs.length; i++) {
            int value = pairs[i].value;
            int weight = pairs[i].weight;
            for (int localWeight = 1; localWeight < matrix[i].length; localWeight++) {
                if (weight <= localWeight) {
                    if (i-1 < 0) {
                        matrix[i][localWeight] = value;
                        continue;
                    }
                    matrix[i][localWeight] = Math.max(value + matrix[i - 1][localWeight - weight], matrix[i - 1][localWeight]);
                } else {
                    matrix[i][localWeight] = matrix[i-1][localWeight];
                }
            }
        }
    }

    static public void reconstruct(Pair[] pairs) {
        List<Integer> picks = new ArrayList<>();
        int i = matrix.length-1;
        int k = matrix[i].length-1;
        while (i != 0 && k != 0) {
            int totalWeight = matrix[i][k];
            if (totalWeight == matrix[i-1][k]) {
                i--;
            } else {
                int value = pairs[i].value;
                int weight = pairs[i].weight;
                picks.add(value);
                k = k-weight;
                i--;
            }
        }
        System.out.print("Picked values: ");
        for (Integer val : picks) {
            System.out.print(val + " ");
        }
    }

    static class Pair {
        int weight;
        int value;
    }

    static public void main(String[] args) {
        int weight = 7;
        Pair[] pairs = new Pair[4];
        for (int i = 0; i < 4; i ++) {
            pairs[i] = new Pair();
        }
        pairs[0].weight = 1;
        pairs[0].value = 1;
        pairs[1].weight = 3;
        pairs[1].value = 4;
        pairs[2].weight = 4;
        pairs[2].value = 5;
        pairs[3].weight = 5;
        pairs[3].value = 7;
        knapsack(pairs, weight);
        for (int i=0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
        reconstruct(pairs);
    }
}
