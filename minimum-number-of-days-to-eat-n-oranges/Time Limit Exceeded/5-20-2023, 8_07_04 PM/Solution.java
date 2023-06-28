// https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges

class Solution {
    public int minDays(int n) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       hm.put(0,0);
       hm.put(1,1);
        for(int i=2;i<n+1;i++){
            int ans=Integer.MAX_VALUE;
            if(i%3==0 && i-2*(i/3)>=0){
                ans=Math.min(ans,hm.get(i-2*(i/3))+1);

            }
            
             if(i%2==0 && i-i/2>=0){
                ans=Math.min(ans,hm.get(i-i/2)+1);
            }
        
                ans=Math.min(ans,hm.get(i-1)+1);
            
            hm.put(i,ans);


        }
        return hm.get(n);
        
    }
}