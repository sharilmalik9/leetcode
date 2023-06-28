// https://leetcode.com/problems/two-sum-iv-input-is-a-bst

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
    boolean ans=false;
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hm= new HashSet<>();
        help(root,k,hm);
        return ans;
        
    }
    public void help(TreeNode root,int k,HashSet<Integer> hm){
        if(root==null){
            return;
        }
        if(hm.contains(root.val)){
            ans=true;
        }
        else{
           hm.add( k-root.val);
        }
        help(root.left,k,hm);
        help(root.right,k,hm);
    }
}