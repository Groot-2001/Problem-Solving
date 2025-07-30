// Find a non-empty subarray with largest sum.
// [ 4,-1 ,2 ,-7, 3, 4]

public class largest_sum {
//  Brute Force: O(n^2)
 public int bruteForce(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        System.out.println("arraySize:"+n);

        for(int i=0; i<n;i++ ){
            int currentSum = 0;
            for(int j=i; j<n;j++){
                currentSum = currentSum + nums[j];
                maxSum = Math.max(currentSum,maxSum);
            }
        }
        return maxSum;
    }


     // Kadane's Algorithm: O(n)
    public int kadanesAlgorithm(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum,0);
            currentSum = currentSum + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

 public static void main(String[] args) {
        largest_sum solution = new largest_sum();
         int[] subarray = {4,-1,2,-7,3,4};

        int result1 = solution.bruteForce(subarray);
        System.out.println("Using bruteForce: " + result1);

        int result2 = solution.kadanesAlgorithm(subarray);
        System.out.println("Using Kadane's algorithm: " + result2);
    }
}
