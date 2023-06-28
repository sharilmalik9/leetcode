// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // bfs i know 
 // so task is to do dfs
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
       help(root.left,root.right,1);
        return root;
        
    }
    public void  help(TreeNode left,TreeNode right,int level){
        if(left==null || right==null){
            return ;
        }
        if(level%2==1){
            System.out.println(level + " "+ left.val+ " " + right.val);
           int vale=left.val;
           left.val=right.val;
           right.val=vale;

        }
           help(left.left,right.right,level+1);
           help(left.right,right.left,level+1);
      
    
    }
}