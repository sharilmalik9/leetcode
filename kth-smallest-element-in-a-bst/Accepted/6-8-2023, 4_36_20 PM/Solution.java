// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        int left=kthSmallest(root.left,k);
        count++;
        if(count==k){
            return root.val;
        }
        int right=kthSmallest(root.right,k);
        if(left==-1){
            return right;
        }
        else{
            return left;
        }

    }
   
}