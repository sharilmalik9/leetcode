// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
     int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       
        help(root);
        return ans;
        
        
    }
    public int help(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,help(root.left));
        int right=Math.max(0,help(root.right));
        ans=Math.max(ans,root.val+left+right);
        return Math.max(left,right)+root.val;
    }
}