// https://leetcode.com/problems/recover-binary-search-tree

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
    public void recoverTree(TreeNode root) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        
        Inorder(root,pq);
        arrange(root,pq);
        
    }
    public void Inorder(TreeNode root,PriorityQueue<Integer> pq){
        if(root==null){
            return;
}
        Inorder(root.left,pq);
        pq.add(root.val);
        Inorder(root.right,pq);
    }
    public void arrange(TreeNode root,PriorityQueue<Integer> pq){
        if(root==null){
            return;
        }
        arrange(root.left,pq);
        int curr=pq.poll();
        if(curr!=root.val){
            root.val=curr;
        }
        arrange(root.right,pq);
    }
}