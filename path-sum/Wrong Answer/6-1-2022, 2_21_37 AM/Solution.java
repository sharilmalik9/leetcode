// https://leetcode.com/problems/path-sum

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
    int count=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(count==0){
            if(targetSum==0){
                return false;
            }
        }
        
        if(root==null){
            if(targetSum==0){
                
                return true;
            }
            return false;
        }
        
        int curr= root.val;
        count++;
        return hasPathSum(root.left,targetSum-curr) || hasPathSum(root.right,targetSum-curr);
        
    
        
    }
}