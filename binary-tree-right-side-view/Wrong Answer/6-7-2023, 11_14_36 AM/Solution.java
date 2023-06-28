// https://leetcode.com/problems/binary-tree-right-side-view

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
    List<Integer> ls;
    public List<Integer> rightSideView(TreeNode root) {
        ls=new ArrayList<>();
        help(root);
        return ls;
    }
    public void help(TreeNode root){
        if(root==null){
            return;
        }
        ls.add(root.val);
        help(root.right);
        if(root.right==null){
                help(root.left);
        }
       
        

    }
}