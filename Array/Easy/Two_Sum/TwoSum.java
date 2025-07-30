package Two_Sum;
import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    // Brute-force approach
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // return empty array if no solution found
    }

    // Optimized approach using HashMap
    public int[] twoSumOptimized(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{}; // return empty array if no solution found
    }

    // Main method to test both approaches
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Test brute-force solution
        int[] result1 = solution.twoSumBruteForce(nums, target);
        System.out.println("Brute-force Result: " + Arrays.toString(result1));

        // Test optimized solution
        int[] result2 = solution.twoSumOptimized(nums, target);
        System.out.println("Optimized Result: " + Arrays.toString(result2));
    }
}
