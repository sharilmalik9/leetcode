// https://leetcode.com/problems/sum-of-left-leaves

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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum=0;
        if(root.left!=null){
        TreeNode left1=root.left;
             while(left1.left!=null){
               left1=left1.left;
        }
            if(left1.left==null && left1.right==null){
              sum+=left1.val;
        }
        }
        if(root.right!=null){
        TreeNode right1=root.right;
            while(right1.left!=null){
            right1=right1.left;
        }
            if(right1.left==null && right1.right==null){
            sum+=right1.val;
        }
        }
       
        
      
       
        return sum;
    }
}