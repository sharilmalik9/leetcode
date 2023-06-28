// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes

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
    TreeNode ans;
    int max;
    int height;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        height=ht(root);
        ans=null;
        max=0;
        rec(root,0);
        return ans;
    }
    public  int rec(TreeNode root,int level){
        if(root==null){
            return 0;
        }
        int left=rec(root.left,level+1);
        int right=rec(root.right,level+1);
        if(left==right){
            if(level+left+1==height){
                ans=root;
            }
            return left+1;
        }
        else{
            return Math.max(left,right)+1;
        }
    }
    public int ht(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(ht(root.left),ht(root.right))+1;
    }
}