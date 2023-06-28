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
        if(root==null){
            return 0;
        }
        FindSum(root, targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
        
        
       
}
    public void FindSum(TreeNode root, int sum,int currsum){
        if(root==null){
            return;
        }
        currsum+=root.val;
        if(currsum==sum){
            count++;
        }
        FindSum(root.left,sum,currsum);
        FindSum(root.right,sum,currsum);
    }
        
    }