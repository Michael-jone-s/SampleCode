package GroceryPurchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryPurchase {
    private static final int[] GROCERY_PRICES = {10, 20, 30, 40, 60};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount you have: Rs.");
        int amount = scanner.nextInt();

        List<List<Integer>> combinations = getCombinations(amount);

        System.out.println("Possible combinations of groceries: " + combinations);
    }

    private static List<List<Integer>> getCombinations(int amount) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (1 << GROCERY_PRICES.length); i++) {
            List<Integer> combination = new ArrayList<>();
            int totalPrice = 0;

            for (int j = 0; j < GROCERY_PRICES.length; j++) {
                if ((i & (1 << j)) != 0) {
                    totalPrice += GROCERY_PRICES[j];
                    combination.add(GROCERY_PRICES[j]);
                }
            }

            if (totalPrice == amount) {
                result.add(combination);
            }
        }

        return result;
    }
}
