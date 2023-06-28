// https://leetcode.com/problems/count-good-nodes-in-binary-tree

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
    int cnt;
  //  PriorityQueue<TreeNode> ans= new PriorityQueue<>((a,b)->b.val-a.val);
    public int goodNodes(TreeNode root) {
         
         
        helper(root,Integer.MIN_VALUE);
        return cnt;
        
    }
    public void helper(TreeNode root,int max){
        if(root==null){
            return ;
        }
        if(root.val>=max){
            max=root.val;
            cnt++;
        }
        helper(root.left,max);
        helper(root.right,max);
        
        
        
        
}
}