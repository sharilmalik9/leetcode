// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes

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
    TreeNode ans;
    int max;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans=null;
        max=0;
        rec(root);
        return ans;
    }
    public  int rec(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=rec(root.left);
        int right=rec(root.right);
         max=Math.max(max,Math.max(right,left)+1);
     
        if(left==right){
            if(left+1>=max){
                ans=root;
            }
            return left+1;
        }
        else{
            return Math.max(left,right)+1;
        }
    }
}