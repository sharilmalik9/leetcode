// https://leetcode.com/problems/path-sum-iii

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
    int ans=0;
    HashSet<TreeNode> hs= new HashSet<>();
    public int pathSum(TreeNode root, int targetSum){
        help(root,targetSum,0L);
        return ans;

    }
    public void help(TreeNode root,int targetSum,long curr){
        if(root==null){
            return ;
        }
        curr+=root.val;
        if(curr==targetSum){
            ans++;
        }
        help(root.left,targetSum,curr) ;
        help(root.right,targetSum,curr);
        if(!hs.contains(root.right)){
               help(root.right,targetSum,0);
        }
        hs.add(root.right);
        if(!hs.contains(root.left)){
            help(root.left,targetSum,0);
        }
        hs.add(root.left);
       
       

    }
}