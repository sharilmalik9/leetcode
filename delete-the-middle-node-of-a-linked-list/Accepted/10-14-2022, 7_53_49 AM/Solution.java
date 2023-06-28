// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list

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
    public ListNode deleteMiddle(ListNode head) {
	    //base condition
        if(head.next==null)
            return null;
		// creating variables
        ListNode temp = null, slow = head, fast = head;
		//iterating such that we reach the middle element for slow variable while fast variable reaches the end
        while(fast!=null && fast.next!=null){
            temp = slow;
            slow=slow.next;
            fast = fast.next.next;
        }
		//now since temp is the node pointing at slow so now just make pointer from temp to slow->next i.e., deleting the middle node
        temp.next = slow.next;
        return head;
    }
}