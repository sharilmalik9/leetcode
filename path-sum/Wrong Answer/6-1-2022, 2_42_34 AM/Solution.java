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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        else if(root.left==null || root.right==null){
            if(targetSum==root.val){
                return false;
            }
        }
       else if(root.left==null && root.right==null && root.val==targetSum ){
            return true;
            
        }
        
          return answer(root,targetSum);
        
       
             
        
        
    }
    public boolean answer(TreeNode root, int targetSum){
         if(root==null){
            if(targetSum==0){
                
                return true;
            }
            return false;
        }
        
        int curr= root.val;
        
        return answer(root.left,targetSum-curr) || answer(root.right,targetSum-curr);
        
    }
}