// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

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
    public int pairSum(ListNode head) {
        int n=0;
        ListNode pp=head;
        while(pp!=null){
            pp=pp.next;
            n++;
        }
        Stack<Integer> st= new Stack<>();
        int end=n/2-1;
        ListNode endn=head;
        int idx=0;
    
        while(idx<=end){
            st.push(endn.val);
            endn=endn.next;
            idx++;
        }
        System.out.println(endn.val+" " + n);
        int ans=0;
        while(endn!=null){
            ans=Math.max(ans,st.pop()+endn.val);
            head=head.next;
            endn=endn.next;
        }
        return ans;
        
    }
}