// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
        
        
        
    }
    public TreeNode construct(int[] preorder,int[] postorder,int prestart,int preend,int poststart,int postend){
        if(prestart>preend){
            return null;
        }
         TreeNode root= new TreeNode(preorder[prestart]);
        if(prestart==preend){
            return root;
        }
        int postindex=poststart;
        while(postorder[postindex]!=preorder[prestart+1]){
            postindex++;
        }
        int len=postindex-poststart+1;
        root.left=construct(preorder,postorder,prestart+1,prestart+len,poststart,postindex);
            root.right=construct(preorder,postorder,prestart+len+1,preend,postindex+1,postend-1);
        return root;
        
    }
}