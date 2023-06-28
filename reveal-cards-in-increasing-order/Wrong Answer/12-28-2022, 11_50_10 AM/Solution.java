// https://leetcode.com/problems/reveal-cards-in-increasing-order

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck.length==1){
            return deck;
        }
        Arrays.sort(deck);
        int start=0;
        int idx=0;
        int[] ans= new int[deck.length];
        while(idx<deck.length){
            ans[idx]=deck[start];
            idx+=2;
            start++;
        }
        idx=1;
        System.out.println(Arrays.toString(deck));
        
        int mid=deck.length/2;
        if(deck.length%2!=0){
            mid++;

        }
        int remL=deck.length-mid;
        int[] rem=new int[remL];
        for(int i=1;i<rem.length;i+=2){
            rem[i]=deck[mid];
            mid++;

        }
        for(int i=0;i<rem.length;i+=2){
            rem[i]=deck[mid];
            mid++;
        }
        System.out.println(Arrays.toString(rem));
         idx=0;
        for(int i=1;i<ans.length;i+=2){
            ans[i]=rem[idx];
            idx++;

        }
        return ans;
    }
}