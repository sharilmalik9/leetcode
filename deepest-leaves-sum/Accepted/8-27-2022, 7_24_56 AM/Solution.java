// https://leetcode.com/problems/deepest-leaves-sum

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
// brute force 
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int h = height(root);
        
        return currLevelSum(root, h);
    }
    
    private int height(TreeNode root){
        if(root==null)
            return 0;
        
        return Math.max(height(root.left), height(root.right))+1;
    }
    
    int sum = 0;
    
    private int currLevelSum(TreeNode root, int level){
        if(root==null)
            return 0;
        
        if(level==1)
            sum+=root.val;
        else if(level>1){
            currLevelSum(root.left, level-1);
            currLevelSum(root.right, level-1);
        }
        
        return sum;
    }
}