/*

Sort Array By Parity

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

*/

--------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int i=0, j=n-1, index=0;
        while(i<=j){
            if(A[index]%2 == 0)
               ans[i++] = A[index]; 
            else
               ans[j--] = A[index];
            index++;
        }
        return ans;
    }
}

----------------------
Ref: https://leetcode.com/problems/sort-array-by-parity/discuss/170734/C%2B%2BJava-In-Place-Swap

In Place Sol:

    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }