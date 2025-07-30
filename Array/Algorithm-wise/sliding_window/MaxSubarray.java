// # Maximum Subarray Problem

// ## Problem Definition

// **Given**: An array of integers (positive and/or negative)

// **Find**: The contiguous subarray (containing at least one number) which has the largest sum

// **Return**: The sum of this subarray (and optionally its start/end indices)

// ### Formal Definition

// For an array `A = [a₁, a₂, ..., aₙ]`, find indices `i` and `j` (where 1 ≤ i ≤ j ≤ n) such that the sum `S = aᵢ + aᵢ₊₁ + ... + aⱼ` is maximized.

// ### Example

// **Input**: `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`
// **Output**: `6`
// **Explanation**: The subarray `[4, -1, 2, 1]` has the largest sum = 6.

// ### Variations

// 1. **Basic Version**: Just return the maximum sum
// 2. **Extended Version**: Return both the sum and the subarray indices
// 3. **Circular Version**: Consider subarrays that can wrap around the end of the array
// 4. **2D Version**: Find maximum submatrix in a 2D array

// ### Constraints

// - The array may contain both positive and negative numbers
// - The subarray must be contiguous (elements in consecutive positions)
// - The subarray must contain at least one element
// - For empty array inputs, behavior is typically defined to return 0 or null

// ### Applications

// 1. Financial analysis (maximum profit over time periods)
// 2. Computer vision (finding brightest region in an image)
// 3. Genomic sequence analysis
// 4. Data mining applications

// ### Common Solutions

// 1. **Brute Force**: O(n²) - Check all possible subarrays
// 2. **Divide and Conquer**: O(n log n) - Recursive approach
// 3. **Kadane's Algorithm**: O(n) - Optimal solution
// 4. **Sliding Window**: O(n) - Variation that tracks subarray indices

// ### Edge Cases

// 1. All positive numbers → entire array is solution
// 2. All negative numbers → single largest element is solution
// 3. Multiple subarrays with same maximum sum
// 4. Array with all zeros
// 5. Single-element array

// This problem is also known as the "Maximum Segment Sum" problem and was first solved by Jay Kadane in 1984, leading to the famous Kadane's algorithm.

public class MaxSubarray {

    // Sliding Window approach to find maximum subarray
    public static int[] maxSubarraySlidingWindow(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{0, 0, 0}; // Handle empty array case
        }

        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0; // Temporary start index for current window

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] > nums[i]) {
                // Extend the current window
                currentSum += nums[i];
            } else {
                // Start a new window at current element
                currentSum = nums[i];
                tempStart = i;
            }

            // Update maxSum and window indices if currentSum is greater
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{maxSum, start, end};
    }

    public static void main(String[] args) {
        int[] nums = {4, -1, 2, -7, 3, 4};
        int[] result = maxSubarraySlidingWindow(nums);

        System.out.println("Maximum Subarray Sum: " + result[0]);
        System.out.println("Subarray from index " + result[1] + " to " + result[2]);
        System.out.print("Elements: [");
        for (int i = result[1]; i <= result[2]; i++) {
            System.out.print(nums[i] + (i < result[2] ? ", " : ""));
        }
        System.out.println("]");
    }
}