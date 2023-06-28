// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

import java.util.*;
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
                                                                            

class Solution {
    public Node flatten(Node head) {
     if(head == null) return null;
        Node current = head;
        
        while(current != null){
            if(current.child != null){
                Node nextNode = current.next;
                Node childNode = flatten(current.child); //get recursive child
                
                current.child = null;
                current.next = childNode;
                childNode.prev = current;
                
                while(current.next != null) current = current.next;
                current.next = nextNode;
                
                if(nextNode != null) nextNode.prev = current;
            }
            current = current.next;
        }
        return head;
        
    }
}