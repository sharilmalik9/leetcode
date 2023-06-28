// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list

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
    public ListNode removeZeroSumSublists(ListNode head) {
        
        HashMap<Integer,ListNode> hm= new HashMap<>();
        ListNode nn=head;
        ListNode fake=new ListNode(10001);
        fake.next=head;
        hm.put(0,fake);
        int sum=0;
        while(nn!=null){
            sum+=nn.val;
            if(hm.containsKey(sum)){
                
                ListNode curr=hm.get(sum);
                if(curr==fake){
                    head=nn.next;
                }
                else{
                    curr.next=nn.next;
                }
                
                
            }
            else{
                 hm.put(sum,nn);
            }
           
            nn=nn.next;
            
        }
        
        return head;
        
    }
}