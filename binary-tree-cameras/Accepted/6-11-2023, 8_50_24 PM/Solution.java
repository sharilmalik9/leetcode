// https://leetcode.com/problems/binary-tree-cameras

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
 // 0 - captured
 // 1-not captured
 // 2-would like to capture you
class Solution {
    int camera;
    TreeNode supernode;
    public int minCameraCover(TreeNode root) {
        camera=0;
        supernode=root;
        rec(root);
        return camera; 
    }
    public int rec(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=rec(root.left);
        int right=rec(root.right);
        if(left==0 && right==0){
            if(root==supernode){
                camera++;
            }
            return 1;
        }
        if(left==1 || right==1){
            camera++;
            return 2;
        }
        if(left==2 || right==2){
            return 0;
            

        }
        return 0;
    }
}