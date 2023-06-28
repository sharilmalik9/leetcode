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
     public int height(TreeNode nn){
        if(nn==null){
            return -1;
        }
        int left=height(nn.left);
        int right=height(nn.right);
        return Math.max(left,right)+1;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l1= new ArrayList<Integer>();
       
        
        rightviewutil(root,l1,0);
        return l1;
    }
    public void rightviewutil(TreeNode root, List<Integer> l1,int level){
        if(root==null){
            return;
        }
        if(l1.get(level)==101){
            l1.set(level,root.val);
        }
        rightviewutil(root.right,l1,level+1);
        rightviewutil(root.left,l1,level+1);
    }
}