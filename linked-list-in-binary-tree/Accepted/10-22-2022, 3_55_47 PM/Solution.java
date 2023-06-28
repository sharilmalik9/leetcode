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
        if(root == null && head == null) return true;
        if(root == null || head == null) return false;
        
        return isSubPath(head, root.left) || isSubPath(head, root.right) || isSame(head, root);
    }
    
    private boolean isSame(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null || root.val != head.val) return false;

        boolean leftTree = isSame(head.next, root.left);
        boolean rightTree = isSame(head.next, root.right);
        
        return leftTree || rightTree;
    }
}