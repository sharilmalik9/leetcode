// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer

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
    public int getDecimalValue(ListNode head) {
        ListNode nn= head;
        int count=0;
        while(nn!=null){
            nn=nn.next;
            count++;
        }
        int ans=0;
        ListNode nn2= head;
        for(int i=count-1;i>=0;i--){
            ans+=nn2.val*Math.pow(2,i);
            nn2=nn2.next;
            
        }
        return ans;
        
    }
}