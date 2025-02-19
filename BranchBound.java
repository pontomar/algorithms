import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BranchBound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("List the weight[g] of each item that you want to bring on your trip.");
        List<List<Integer>> suitcases = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
        String input = scanner.nextLine();
        String[] itemStrings = input.split(" ");  // Split the input by spaces

        // Convert each string to an integer and add it to the items list
        for (String item : itemStrings) {
            try {
                int weight = Integer.parseInt(item);  // Convert to integer
                items.add(weight);  // Add to the list of items
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + item + " is not a valid number.");
            }
        }

        System.out.println("What's the weight allowance for each suitcase?");
        int weightLimit = scanner.nextInt();
        scanner.close();

        List<List<Integer>> result = branchAndBound(items, weightLimit, 0, suitcases);

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Total Weight of Suitcase " + i + " : " + result.get(i).getFirst());
        }
    }

    //TODO: transform the algorithm, so that we can print the list of which item goes into which bag
    //TODO: Refactor / Simplify Code

    public static List<List<Integer>> branchAndBound(List<Integer> items, int maxWeight, int currentItem, List<List<Integer>> suitcases) {
        if (currentItem >= items.size()) {
            return suitcases;
        }

        int weightToAdd = items.get(currentItem);
        if (weightToAdd > maxWeight) {
            return branchAndBound(items, maxWeight, currentItem + 1, suitcases);
        }
        int currentSuitcase = 0;
        while (currentSuitcase < suitcases.size()) {
            int currentTotalWeight = suitcases.get(currentSuitcase).getFirst();
            currentTotalWeight += weightToAdd;
            if (currentTotalWeight <= maxWeight) {
                suitcases.get(currentSuitcase).set(0, currentTotalWeight);
                return branchAndBound(items, maxWeight, currentItem + 1, suitcases);
            } else {
                currentSuitcase++;
            }
        }
        List<Integer> newSuitcase = new ArrayList<>();
        newSuitcase.add(weightToAdd);
        suitcases.add(newSuitcase);
        return branchAndBound(items, maxWeight, currentItem+1, suitcases);
    }
}
