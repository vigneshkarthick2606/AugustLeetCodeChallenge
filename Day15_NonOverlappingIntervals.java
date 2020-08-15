/*

Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

*/

--------------------------------------------------------------------------------------------------------------------------
Ref: https://www.youtube.com/watch?v=kkUm-OW3amo

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0 || intervals.length == 1) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[1] == b[1] ? b[0] -a[0] : a[1] - b[1]);

        int ans = 0;
        int prevEnd = Integer.MIN_VALUE;
        for(int[] interval: intervals){
            if(prevEnd > interval[0]) ans++;
            else prevEnd = interval[1];
        }

        return ans;
        
    }
}

-------------------------------
ref: https://leetcode.com/problems/non-overlapping-intervals/discuss/282743/Java-updated-solution-based-on-the-top-voted-post

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0; 
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int end = intervals[0][1]; 
        int count = 1; 
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1]; 
                count++; 
            }
        }
        
        return intervals.length - count; 
    }
}