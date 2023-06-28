// https://leetcode.com/problems/path-sum-iii

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
    int ans=0;
    public int pathSum(TreeNode root, int targetSum){
        help(root,targetSum,0);
        return ans;

    }
    public boolean help(TreeNode root,int targetSum,int curr){
        if(root==null){
            return false;
        }
        curr+=root.val;
        if(curr==targetSum){
            ans++;
           
        }
        return help(root.left,targetSum,curr) || 
        help(root.right,targetSum,curr)|| help(root.right,targetSum,0) ||
         help(root.left,targetSum,0);

    }
}