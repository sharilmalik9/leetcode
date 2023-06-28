// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal

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
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return preorder(traversal,0);
    }
    public TreeNode preorder(String traverse,int c){
        if(i==traverse.length()){
            return null;
        }
        int j=i;
        while(i<traverse.length() && traverse.charAt(i)!='-'){
            i++;
        }
        TreeNode root=new TreeNode(Integer.parseInt(traverse.substring(j,i)));
        int co=0;
        j=i;
        while(i<traverse.length() && traverse.charAt(i)=='-'){
            i++;
            co++;
        }
        if(co==c+1){
            root.left=preorder(traverse,c+1);
        }else{
            i=j;
        }
        co=0;
        j=i;
        while(i<traverse.length() && traverse.charAt(i)=='-'){
            i++;
            co++;
        }
        if(co==c+1){
            root.right=preorder(traverse,c+1);
        }else{
            i=j;
        }
        return root;
    }
}