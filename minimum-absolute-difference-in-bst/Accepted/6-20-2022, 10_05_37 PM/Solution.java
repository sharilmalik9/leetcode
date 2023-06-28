// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    ArrayList<Integer> arr= new ArrayList<>();
    public void returnarray(TreeNode root, ArrayList<Integer> arr){
        if(root==null){
            return ;
        }
         returnarray(root.left,arr);
        arr.add(root.val);
      
        returnarray(root.right,arr);
        
    }
    public int getMinimumDifference(TreeNode root) {
         returnarray(root,arr);
        int min=-arr.get(0)+arr.get(1);
        int curr=0;
      //  returnarray(root,arr);
        for(int i=0;i<arr.size()-1;i++){
            curr=-arr.get(i)+arr.get(i+1);
            if(min>curr){
                min=curr;
            }
            
            
            
            
        }
        System.out.println(arr);
        return min;
        
        
    }
}