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
        if(root==null){
            return ls;
        }
        ls.add(root.val);
        help(root.left,root.right,2);
        return ls;
    }
    public void help(TreeNode left,TreeNode right,int level){
        if(left==null && right==null){
            return;
        }
        if(ls.size()<level){
            if(right==null){
            ls.add(left.val);
        }
        else{
            ls.add(right.val);
           }
        }
        
        if(right!=null){
        help(right.left,right.right,level+1);
        }
        else if(left!=null){
        help(left.left,left.right,level+1);
        }   
    }
}