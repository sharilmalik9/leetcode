// https://leetcode.com/problems/validate-binary-search-tree

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
    static boolean isBSTutil(TreeNode nn,int max,int min){
        if(nn==null){
            return true;
        }
        if(nn.val<min||nn.val>max){
            return false;
        }
        return (isBSTutil(nn.left,nn.val-1,min)&&isBSTutil(nn.right,max,nn.val+1));
    }
    public boolean isValidBST(TreeNode root) {
        
        return isBSTutil(root, Integer.MAX_VALUE,Integer.MIN_VALUE);
        
    }
}