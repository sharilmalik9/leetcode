// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return helpfunc(nums,0,nums.length-1);
        
    }
    public TreeNode helpfunc(int[] nums,int start,int end ){
        if(start>end){
            return null;
            
        }
        int mid=(start+end)/2;
        TreeNode nn= new TreeNode(nums[mid]);
        nn.left=helpfunc(nums,start,mid-1);
        nn.right=helpfunc(nums,mid+1,end);
        return nn;
    }
}