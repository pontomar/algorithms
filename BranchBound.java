import java.util.ArrayList;
import java.util.List;

public class BranchBound {
    static double[] items = new double[]{0.5, 0.8, 0.1, 0.9, 0.2};

    static int bestSolution = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int result = branchBound(items);
        System.out.println(result);
    }

    public static int branchBound(double[] items) { // each item is in interval [0.0, 1.0)

        ArrayList<Double> bins = new ArrayList<>();
        bins.add(0.0);
        int currentItem = 0;
        double maxWeight = 1.0;
        return backtrack(items, maxWeight, currentItem, bins);
    }

    public static int backtrack(double[] items, double maxWeight, int currentItem, List<Double> bins) {
        if (currentItem == items.length || bins.size() > bestSolution){
            return bins.size();
        }

        for (int i = 0; i < bins.size(); i++) {
            double currentTotalWeight = bins.get(i) + items[currentItem];
            if (currentTotalWeight <= maxWeight) {
                bins.set(i, bins.get(i) + items[currentItem]);

                int result = backtrack(items, maxWeight, currentItem + 1, bins);
                bestSolution = Math.min(bestSolution, result);
                bins.set(i, bins.get(i) - items[currentItem]);
            }
        }
        bins.add(items[currentItem]);
        int result = backtrack(items, maxWeight, currentItem + 1, bins);
        bestSolution = Math.min(bestSolution, result);
        bins.removeLast();
        return bestSolution;
    }

}




