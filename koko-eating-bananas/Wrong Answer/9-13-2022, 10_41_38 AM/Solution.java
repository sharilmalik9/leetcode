// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start=1;
         int total=0;
        int end=piles[piles.length-1];
        while(start<=end){
            int mid=(start+end)/2;
            total=0;
            for(int i=0;i<piles.length;i++){
                if(piles[i]%mid==0){
                    total+=piles[i]/mid;
                   }
                else{
                    total+=piles[i]/mid+1;
                    
                }
                
            }
            
            if(total<h){
                start=mid+1;
            }
            else if(total==h){
                return total;
            }
            else{
                end=mid-1;
            }
        }
        
        return total;
        
    }
}