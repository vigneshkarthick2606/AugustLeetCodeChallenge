/*
Pascal's Triangle II

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

*/
--------------------------------------------------------------------------------------------------------------------------

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        Integer[] rowList = new Integer[rowIndex+1];
        rowList[0] = 1;
        for(int i=1; i<rowList.length;i++) {
            rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
        }
        return Arrays.asList(rowList);
    }
}

/*

Based on rules:

row k of Pascal's Triangle:

[C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]

and

C[k,i] = C[k,i-1]*(k-i+1)/i

*/

--------------------------------------------------------------------------------------------------------------------------
/*
118. Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/
https://leetcode.com/problems/pascals-triangle/discuss/38343/Another-accepted-Java-solution

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>(Arrays.asList(1));
            
            for (int j = 1; j < i; j++) 
                list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                
            if (i > 0) list.add(1);
            
            res.add(list);
        }
        
        return res;
    }
}
