package Duplicates_contains;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

public class Duplicate_contains {

    // Method 1: Using HashSet (Recommended for better performance)
    public boolean containsDuplicateUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // Method 2: Using sorting
    public boolean containsDuplicateUsingSorting(int[] nums) {
        Arrays.sort(nums); // O(n log n)
        for (int i = 0; i < nums.length - 1; i++) { // O(n)
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Test the methods
    public static void main(String[] args) {
        Duplicate_contains solution = new Duplicate_contains();

        int[] nums = {1, 2, 3, 4, 5, 1}; // sample input

        boolean result1 = solution.containsDuplicateUsingSet(nums);
        boolean result2 = solution.containsDuplicateUsingSorting(nums);

        System.out.println("Using HashSet: " + result1);
        System.out.println("Using Sorting: " + result2);
    }
}


// containsDuplicateUsingSet:

// Time Complexity: O(n)

// Space Complexity: O(n)

// Best for performance.

// containsDuplicateUsingSorting:

// Time Complexity: O(n log n)

// Space Complexity: O(1) (if sort is in-place)

// Slightly slower but no extra memory (other than sorting buffer).