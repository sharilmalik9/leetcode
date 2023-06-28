// https://leetcode.com/problems/koko-eating-bananas

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
       
        if(piles.length==h){
            return piles[piles.length-1];
        }
        int start=1;
         int ans=Integer.MAX_VALUE;
         
        int end=piles[piles.length-1];
        while(start<=end){
            int mid=(start+end)/2;
             System.out.println(mid);
           int  total=0;
           
            for(int i=0;i<piles.length;i++){
                if(piles[i]%mid==0){
                    total+=piles[i]/mid;
                   }
                else{
                    total+=piles[i]/mid+1;
                    
                }
                
            }
          //  System.out.println(mid);
            if(total<=h){
                ans=Math.min(mid,ans);
                end=mid-1;
            }
            
            else{
                start=mid+1;
            }
        }
        
        return ans;
        
    }
}