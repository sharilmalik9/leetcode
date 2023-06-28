// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(inorder[i],i);
        }
        int postStart=0;
        int postEnd=postorder.length-1;
        int inStart=0;
        int inEnd=inorder.length-1;
        return helper(postStart,postEnd,inStart,inEnd,postorder,inorder,map);
    }
    public TreeNode helper(int postStart,int postEnd,int inStart,int inEnd,int[] postorder,int[] inorder,
    HashMap<Integer,Integer> map){
        if(inStart>inEnd||postStart>postEnd){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int posOfRoot=map.get(root.val);
        int numsLeft=posOfRoot-inStart;
        root.left=helper(postStart,postStart+numsLeft-1,inStart,posOfRoot-1,postorder,inorder,map);
        root.right=helper(postStart+numsLeft,postEnd-1,posOfRoot+1,inEnd,postorder,inorder,map);
        return root;
    }
}