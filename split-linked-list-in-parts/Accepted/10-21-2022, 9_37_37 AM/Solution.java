// https://leetcode.com/problems/split-linked-list-in-parts

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
    public ListNode[] splitListToParts(ListNode head, int k) {
       
        ListNode[] ans = new ListNode[k];
         if(head == null) return ans;
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            length++; //Count total length of the given list
        }
      
        int eachLength = length/k;
        int extraElements = length % k;
        
        int i = 0;
        temp = head;
        while(temp != null) {
           ListNode dummy = temp;
           //Since the the list sizes should be equal or some lists can have size + 1 
            int bigList = (extraElements > 0)? 1 : 0;
            for(int j = 0;j<eachLength + bigList -1;j++ ){
                temp = temp.next;
            }
                ListNode store = temp.next;
                temp.next = null;
                temp = store;
            //add elements to the arrays
                ans[i] = dummy;
                i++;
            //decrement the extraElements
                extraElements--;
            
        }
        return ans;
    }
}