/*
Vertical Order Traversal of a Binary Tree

Given a binary tree, return the vertical order traversal of its nodes values.

"If two nodes have the same position, then the value of the node that is reported first is the value that is smaller."

This statment is ambiguous which make people think just order from small to large for each position.

From test case, the real requirement is:
If two nodes have the same position,

check the layer, the node on higher level(close to root) goes first
if they also in the same level, order from small to large
provide one solution here, but recommand
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231125/Java-HashMap-and-TreeMap-and-PriorityQueue-Solution
which use Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>(); to store the result. 
So, we can use any traversal method BFS, DFS(inorder, preorder, postorder, customized order etc)

*/
--------------------------------------------------------------------------------------------------------------------------

class Solution { 
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if (root == null) { 
            List<List<Integer>> result = new  ArrayList<List<Integer>>();
            return result;              
        }
        
        Map<Integer,List<int[]>> tempResult = new TreeMap<Integer,List<int[]>>();  
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        
        queue.add(new Pair<TreeNode, Integer> (root, 0));
        int level =0;
        while(!queue.isEmpty()){
            
            int size = queue.size(); 
            for(int i=0; i<size;i++){
                TreeNode node = queue.peek().getKey();
                int hd = queue.peek().getValue(); 
                queue.poll(); 

                if(tempResult.get(hd) == null){
                    tempResult.put(hd, new ArrayList<int[]>());
                }
                tempResult.get(hd).add(new int[] {node.val, level});

                if(node.left != null){  
                    queue.add(new Pair<TreeNode, Integer> (node.left, hd - 1));
                }

                if(node.right != null){
                    queue.add(new Pair<TreeNode, Integer> (node.right, hd + 1)); 
                }
            }
            
            level++;
        }
        
        List<List<Integer>> result = new  ArrayList<List<Integer>>();
        for (List<int[]> entry : tempResult.values()){
             Collections.sort(entry, (a,b) -> {
                 if(a[1] == b[1]){
                     return a[0] - b[0];
                 }
                 return a[1] - b[1];
             });
             List<Integer> lst = new ArrayList<>();
             for(int[] a: entry)
                 lst.add(a[0]);
             result.add(lst);  
        } 
        
        return result;
        
    }
}