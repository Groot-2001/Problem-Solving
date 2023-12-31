public class Solution {
    public boolean containsDuplicate(int[] nums) {
        // create Set data structure
        Set<Integer> set = new HashSet<>();
        // one by one element were gonna add and check element
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            // if element is not found in set then were gonna add it.
            set.add(nums[i]);
        }
        return false;
    }
}

/**
 * class Solution {
 * public boolean containsDuplicate(int[] nums) {
 * 
 * Arrays.sort(nums); //n log(n)
 * 
 * for(int i=0; i<nums.length;i++){
 * if(nums[i]==nums[i+1]){ //o(n)
 * return true;
 * }
 * }
 * 
 * return false;
 * 
 * }
 * }
 * 
 * Time Complexity : O(nlogn) + O(n)
 * Space Complexity : O(n)
 */