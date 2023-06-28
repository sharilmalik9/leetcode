// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

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
    public ListNode deleteDuplicates(ListNode head) {
       ListNode it= new ListNode(-1);
         it.next=head;
        ListNode Fakehead=it;
        
        while(Fakehead.next!=null&&Fakehead.next.next!=null){
            if(Fakehead.next.val==Fakehead.next.next.val){
                int Element = Fakehead.next.val;
                while(Fakehead.next!=null && Fakehead.next.val==Element){
                    Fakehead.next=Fakehead.next.next;
                }
            }
            else{
                Fakehead=Fakehead.next;
            }
        }
        return it.next;
        
    }
}