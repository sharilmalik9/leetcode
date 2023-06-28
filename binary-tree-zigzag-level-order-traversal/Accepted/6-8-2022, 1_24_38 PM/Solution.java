// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

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
     public List<Integer> returnlevel(TreeNode root,int level,List<Integer> ans1){
        if(root== null){
            return null;
        }
       // List<Integer> ans1= new ArrayList<Integer>();
        if(level==1){
          //  System.out.println(root.val);
            ans1.add(root.val);
          //  System.out.println(ans1);
            
        }
         returnlevel(root.left,level-1,ans1);
        returnlevel(root.right,level-1,ans1);
       
       
        return ans1;
    }
    
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans= new ArrayList<>();
      
        
         for(int i=1;i<height(root)+1;i++){
             List<Integer> ans1=new ArrayList<Integer>();
             ans1=returnlevel(root,i,ans1);
             if(i%2==0){
                 Collections.reverse(ans1);
             }
           
             ans.add(ans1);
         }
        return ans;
        
        
        
    }
}