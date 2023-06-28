// https://leetcode.com/problems/delete-node-in-a-bst

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
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root,key);
        
    }
    public TreeNode helper(TreeNode root,int key){
        if(root==null){
            return null;
        }
        if(root.val>key){
            root.left=helper(root.left,key);
            
        }
        else if(root.val<key){
            root.right=helper(root.right,key);
            
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                  return root.left;
            }
            root.val=minval(root.right);
          root.right= helper(root.right,root.val);
        }
        return root;
    }
    public int minval(TreeNode root){
        if(root==null){
            return -1;
}
        int max=root.val;
        while(root.left!=null){
            
            max=Math.min(max,root.val);
            root=root.left;
        }
        return max;
        
    }

        
        
        
        
        
        
        
        
}