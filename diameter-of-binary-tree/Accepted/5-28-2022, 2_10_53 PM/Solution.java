// https://leetcode.com/problems/diameter-of-binary-tree

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
import java.util.*;
class Solution {
    public int height(TreeNode nn){
        if(nn==null){
            return -1;
        }
        int left=height(nn.left);
        int right=height(nn.right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return -1;
        }
        int self= height(root.left)+height(root.right)+2;
        int left=diameterOfBinaryTree(root.left);
         int right=diameterOfBinaryTree(root.right);
        return Math.max(self,Math.max(left,right));
        
        
    }
}