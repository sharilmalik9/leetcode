// https://leetcode.com/problems/linked-list-in-binary-tree

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        
        return help(head,root);
        
        
        
        
        
        
        
    }
     public boolean help(ListNode head,TreeNode root){
         if(head==null){
             return true;
         }
         if(root==null && head==null){
             return true;
         }
         if(root==null){
             return false;
         }
         if(head.val==root.val){
             boolean right=help(head.next,root.right);
             boolean left=help(head.next,root.left);
             return right|| left;
         }
         else{
             return help(head,root.right) || help(head,root.left);
         }
     }
}