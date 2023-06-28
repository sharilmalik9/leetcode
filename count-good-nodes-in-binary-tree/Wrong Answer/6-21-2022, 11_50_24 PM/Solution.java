// https://leetcode.com/problems/count-good-nodes-in-binary-tree

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
    public int goodNodes(TreeNode root) {
         String sb = "";
    ArrayList<String> result = new ArrayList<String>();
    helper(root, result, sb);
    return result.size();
        
    }
    public boolean issorted(String str){
        boolean ans=true;
        for(int i=0;i<str.length();i++){
            System.out.println("here");
            if(!(str.charAt(str.length()-1)-'0'>=str.charAt(i)-'0')){
                ans=false;
                  System.out.println("hii");
                
            }
        }
        return ans;
    }
    public void helper(TreeNode root, ArrayList<String> result, String s){
    if(root==null){
        return;
    }
 
    s = s+root.val;
   // System.out.println(s);
    if(issorted(s)){
            System.out.println(s);
        
        result.add(s);
    }
 
   
 
    if(root.left!=null){
        helper(root.left, result, s);
    }
    if(root.right!=null){
        helper(root.right, result, s);
    }
    }
}