// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree

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
    public TreeNode bstToGst(TreeNode root) {
                replace(root,true);
    return root;
    }
    
    ArrayList<Integer> inOrderList = new ArrayList<>();
    
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }
    
    
    public int sumGreater(TreeNode root){
        int sum = 0;
        for(int i = 0; i<inOrderList.size(); i++){
            if(inOrderList.get(i)>=root.val){
                sum+= inOrderList.get(i);
            }
        }
    return sum;
    }
    public void replace(TreeNode root , boolean value)
    {
        if(root == null){
            return;
        }
        if(value){
            inOrder(root);
        }
        int temp = sumGreater(root);
        // System.out.println("Temp = " + temp);
        // System.out.println("Temp = " + inOrderList);
        root.val = temp;
        replace(root.left,false);
        replace(root.right,false);
    }	
}