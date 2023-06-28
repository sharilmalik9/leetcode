// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree

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
    public TreeNode sortedListToBST(ListNode head) {
       
        return generate(head,null);
    }
    public TreeNode generate(ListNode start,ListNode end){
        if(start==null){
            return null;
        }
        ListNode mid=mid(start,end);
        TreeNode node=new TreeNode(mid.val);
        if(!start.equals(mid)){
           node.left=generate(start,mid);
        }
        if(mid.next != null && !mid.next.equals(end)){
            node.right=generate(mid.next,end);

        }   
        return node;
    }
    public ListNode mid(ListNode start, ListNode end) {
        if(start == null || start.next == null) return start; 
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}