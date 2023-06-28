// https://leetcode.com/problems/binary-tree-paths

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
   public List<String> binaryTreePaths(TreeNode root) {
 
    String sb = "";
    ArrayList<String> result = new ArrayList<String>();
 
    helper(root, result, sb);
 
    return result;
}
 
public void helper(TreeNode root, ArrayList<String> result, String s){
    if(root==null){
        return;
    }
 
    s = s+"->"+root.val;
 
    if(root.left==null &&root.right==null){
        result.add(s.substring(2));
        System.out.println(s.substring(2));
        return;
    }
 
    if(root.left!=null){
        helper(root.left, result, s);
    }
    if(root.right!=null){
        helper(root.right, result, s);
    }
}
}