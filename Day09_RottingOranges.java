/*
Rotting Oranges

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.


*/
--------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        for(int i=0; i<row; i++){
            for( int j=0; j<col; j++){
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }
        
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size>0){
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];

                for(int[] direction: dir){
                    int x = direction[0] + i;
                    int y = direction[1] + j;

                    if(x < row && x >=0 && y < col && y >=0 && grid[x][y] == 1){
                        grid[x][y] = 2; // dont forget update the grid value
                        queue.add(new int[]{x,y}); 
                        freshOranges--;
                    }
                }
                
                size--;
            }
            
            time++;
        }
        
        if(freshOranges!=0) return -1;
        
        return time>0 ? time-1 : 0;
    }
}

