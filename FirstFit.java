import java.util.*;

public class FirstFit {


    public static void main(String[] args) {
        double[] items = new double[]{0.5, 0.2, 0.8, 0.5, 0.2};
        //   int result = nextFit(items);
        //   System.out.println(result);
        System.out.println(bestFit(items));
    }

    public static int firstFit(double[] items) { // each item is in interval [0.0, 1.0)
        List<Double> bins = new ArrayList<>();
        bins.add(0.0);
        double maxWeight = 1.0;
        for (double item : items) {
            for (int i = 0; i < bins.size(); i++) {
                double totalWeight = bins.get(i) + item;
                if (totalWeight <= maxWeight) {
                    bins.set(i, totalWeight);
                    break;
                } else if (i == bins.size() - 1) {
                    bins.add(item);
                    break;
                }
            }
        }
        return bins.size();
    }

    public static int nextFit(double[] items) { // each item is in interval [0.0, 1.0)
        List<Double> bins = new ArrayList<>();
        bins.add(0.0);
        double maxWeight = 1.0;
        for (double item : items) {
            double totalWeight = bins.get(bins.size() - 1) + item;
            if (totalWeight <= maxWeight) {
                bins.set(bins.size() - 1, totalWeight);
            } else {
                bins.add(item);
            }

        }
        return bins.size();
    }

    public static int bestFit(double[] items) {
        List<Double> bins = new ArrayList<>();
        bins.add(0.0);
        double maxWeight = 1.0;
        for (double item : items) {
            for (int i = 0; i < bins.size(); i++) {
                double currentTotalWeight = bins.get(i) + item;
                if (currentTotalWeight <= maxWeight) {
                    bins.set(0, currentTotalWeight);
                    break;
                }
                else if (i == (bins.size() - 1)){
                    bins.add(item);
                    break;
                }
            }
            bins.sort(Collections.reverseOrder());
        }
        return bins.size();
    }
}
