/*
Find All Duplicates in an Array

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/
--------------------------------------------------------------------------------------------------------------------------
// O(n) , O(n)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>(); 
        List<Integer> result = new ArrayList<Integer>();
        
        for(int a: nums){
           if(!set.add(a))
               result.add(a);
        }
        
        return result; 
    }
}

-------------------
 // when find a number i, flip the number at position i-1 to negative. 
 // if the number at position i-1 is already negative, i is the number that occurs twice.

// O(n) , O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                result.add(index+1);
            nums[index] = -nums[index];
        }
        
        return result; 
    }
}