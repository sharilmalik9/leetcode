// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal

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
    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder,0,preorder.length-1);
    }
    public TreeNode help(int[] preorder,int start,int end){
        
        if(start>end){
            return null;
        }
        TreeNode nn= new TreeNode(preorder[start]);
        int mid=-1;
        for(int i=start+1;i<=end;i++){
            if(preorder[i]>preorder[start]){
                mid=i;
                break;
            }
        }
        if(mid==-1){
            mid=end+1;
        }
        nn.left=help(preorder,start+1,mid-1);
        nn.right=help(preorder,mid,end);
        return nn;
    }

}