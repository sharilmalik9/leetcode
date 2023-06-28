// https://leetcode.com/problems/recover-binary-search-tree

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
    public void recoverTree(TreeNode root) {
        TreeNode dummy=new TreeNode(-1-(int)Math.pow(2,31));
        TreeNode bummy=new TreeNode((int)Math.pow(2,31));
        rec(root,dummy,bummy);
    }
    public void rec(TreeNode root,TreeNode min,TreeNode max){
        if(root==null){
            return ;
        }
        if( min.val>root.val && min.val<=max.val){
            int temp=root.val;
            root.val=min.val;
            min.val=temp;

        }
        if( max.val<root.val && max.val>=min.val){
             int temp=root.val;
            root.val=max.val;
            max.val=temp;

        }
        if(min.val>root.val || max.val<root.val ){
            //replace max and min now because root has no error 
            int temp=min.val;
            min.val=max.val;
            max.val=temp;
        }
        rec(root.left,min,max.val>root.val ? root : max);
        rec(root.right,min.val>root.val ? min:root,max);

    }
}