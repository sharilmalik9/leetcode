// https://leetcode.com/problems/trim-a-binary-search-tree

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
    public TreeNode trimBST(TreeNode root, int low, int high){
        
        return delete(root,low,high,root);
        
        
        
        
    }
    public TreeNode delete(TreeNode root,int low, int high,TreeNode mainroot){
        if(root==null){
            return null;
        }
        delete(root.left,low,high,mainroot);
        delete(root.right,low,high,mainroot);
        
        if(root.val<low || root.val>high){
            return helper(mainroot,root.val);
        }
        
        return root;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
        int min=root.val;
        while(root.left!=null){
            
           min=root.left.val;
            root=root.left;
        }
        return min;
        
    }

        
    
    
    
}