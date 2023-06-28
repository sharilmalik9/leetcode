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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans= new ArrayList<Integer>();
        lsr(root,k,ans);
        System.out.println(ans);
        return ans.get(k-1);
    }
    public List<Integer> lsr(TreeNode root,int k,List<Integer> ans){
       if(ans.size()==k){
           return ans;
       }
       
        if(root==null){
            return null;
        }
        lsr(root.left,k,ans);
        ans.add(root.val);
        lsr(root.right,k,ans);
        return ans; 
    }
}