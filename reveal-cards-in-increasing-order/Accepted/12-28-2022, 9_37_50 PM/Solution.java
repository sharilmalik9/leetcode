// https://leetcode.com/problems/reveal-cards-in-increasing-order

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deq=new ArrayDeque<>();
        int i=deck.length-1;
        while(i>0){
            deq.addFirst(deck[i]);
            int curr=deq.removeLast();
            deq.addFirst(curr);
            i--;

        }
        deq.addFirst(deck[0]);
     //   deq.addFirst(deq.removeLast());
        for( i=0;i<deck.length;i++){
            deck[i]=deq.removeFirst();
        }
        return deck;
    
    }
}