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
        return rec(preorder,0,preorder.length-1);
    }
    public TreeNode rec(int[] preorder,int start,int end){
        if(start>end){
            return null;
        }
        if(start==end){
            return new TreeNode(preorder[start]);
        }
        TreeNode curr=new TreeNode(preorder[start]);
        start++;
        int idx=search(preorder,start,end,curr.val);
        
        curr.left=rec(preorder,start,idx-1);
        if(idx!=-1)
        curr.right=rec(preorder,idx,end);
        return curr;
    }
    public int search(int[] preorder,int i,int j,int num ){
        int left=i;
        int right=j;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(preorder[mid]>num){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}