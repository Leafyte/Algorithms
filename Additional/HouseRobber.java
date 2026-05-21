import java.util.*;

public class HouseRobber {

    public static int rob(int[] nums) {
        int prev = 0;
        int curr = 0;

        for (int num : nums) {
            int temp = Math.max(curr, prev + num);
            prev = curr;
            curr = temp;
        }

        return curr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter money in each house:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = rob(nums);

        System.out.println("Maximum money that can be robbed: " + result);

        sc.close();
    }
}