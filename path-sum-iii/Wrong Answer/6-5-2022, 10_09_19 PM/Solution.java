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
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null || (root.left==null && root.right==null)){
            if(targetSum==0){
                count++;
            }
            
            return 0;
        }
        
        if(targetSum<=0){
            if(targetSum==0){
                
               // System.out.println(root.val);
                count++;
            }
            return 0;
        }
       
        if(root.val>targetSum){
            pathSum(root.left,targetSum);
            pathSum(root.right,targetSum);
        }
        else{
            pathSum(root.left,targetSum-root.val);
            pathSum(root.right,targetSum-root.val);
        }
        return count+1;
    
}
        
    }