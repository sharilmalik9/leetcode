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
        TreeNode left=root.left;
        TreeNode right=root.right;
        while(left.left!=null){
            left=left.left;
        }
        while(right.left!=null){
            right=right.left;
        }
        if(left.left==null && left.right==null){
            sum+=left.val;
        }
        if(right.left==null && right.right==null){
            sum+=right.val;
        }
        return sum;
    }
}