// https://leetcode.com/problems/next-greater-node-in-linked-list

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
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> st= new Stack<>();
        int[] ans= new int[size(head)];
       ListNode safe=head;
        st.push(head);
        head=head.next;
        while(head!=null){
            if( st.size()!=0 && st.peek().val<head.val){
                 while(st.size()!=0 && st.peek().val<head.val){
                    st.pop().val=head.val;
                }
                
            }
            st.push(head);
            head=head.next;
            
            
            
        }
        while(st.size()!=0){
            st.pop().val=0;
        }
        int idx=0;
        while(safe!=null){
            ans[idx]=safe.val;
            safe=safe.next;
            idx++;
            
}
        return ans;
        
        
        
    }
    public int size(ListNode head){
        int cnt=0;
        while(head!=null){
            cnt++;
            head=head.next;
        }
        return cnt;
    }
}