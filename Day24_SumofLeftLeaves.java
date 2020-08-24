/*
Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

*/

--------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null ) return 0;
        return sumOfLeftLeaves(root, false);
    }
    
   public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
       if(root == null) return 0;
       if(isLeft && root.left == null && root.right == null)
           return root.val;
       return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
   }
}