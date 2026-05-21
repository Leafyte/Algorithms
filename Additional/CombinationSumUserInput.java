import java.util.*;

public class CombinationSumUserInput {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] candidates, int target,
            int start, List<Integer> current,
            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            current.add(candidates[i]);

            backtrack(candidates, target - candidates[i], i, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] candidates = new int[n];

        System.out.println("Enter distinct elements:");

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println("Combinations are:");

        for (List<Integer> list : result) {
            System.out.println(list);
        }

        sc.close();
    }
}