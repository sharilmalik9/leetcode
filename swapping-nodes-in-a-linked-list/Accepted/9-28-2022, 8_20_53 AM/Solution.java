// https://leetcode.com/problems/swapping-nodes-in-a-linked-list

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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return head;
        ListNode p = head, end = null,begin = null;
        for(int i = 1; i < k; i++){
            if(p != null) p = p.next;
        }
        begin = p;
        while(p != null){
            if(end == null) end = head;
            else{
                end = end.next;
            }
            p = p.next;    
        }
        int temp = 0;
        temp = begin.val;
        begin.val = end.val;
        end.val = temp;
        
        return head;
    }
}