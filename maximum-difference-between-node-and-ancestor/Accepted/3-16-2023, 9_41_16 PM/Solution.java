// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor

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
int ans=-1;
    public int maxAncestorDiff(TreeNode root) {
     
        if(root==null){
            return 0;
        }
        help(root,-1,Integer.MAX_VALUE);
        return ans;
        
    }
    public void help(TreeNode root,int max,int min){
        if(root==null){
            return;
        }
         
         max=Math.max(root.val,max);
         min=Math.min(root.val,min);
         if(root.left==null && root.right==null){
             ans=Math.max(max-min,ans);
         }
         help(root.left,max,min);
         help(root.right,max,min);
    }
}