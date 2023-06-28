// https://leetcode.com/problems/palindrome-linked-list

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
    public int GetAtIdx(int idx,ListNode head){
        if(idx==0 ){
            return head.val;
        }
        ListNode nn=head;
        for(int i=1;i<=idx;i++){
            nn=nn.next;
            
            
        }
        return nn.val;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null|| head.next==null){
            return false;
            
        }
        ListNode nn= head;
        int len=0;
        while(nn!=null){
            len++;
            nn=nn.next;
        
        }
        int check=0;
        int check1=0;
        for(int i=0;i<len;i++){
            check1++;
            if(GetAtIdx(i,head)==GetAtIdx(len-i-1,head)){
                check++;
            }
            
        }
        if(check1==check){
            return true;
        }
        else{
            return false;
        }
        
        
    }
}