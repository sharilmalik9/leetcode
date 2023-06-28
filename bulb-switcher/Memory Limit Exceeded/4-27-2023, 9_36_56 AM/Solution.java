// https://leetcode.com/problems/bulb-switcher

class Solution {
    public int bulbSwitch(int n) {
        int[] fac=new int[n];
        for(int i=2;i<=n;i++){
            int idx=1;
            while(idx*i<=n){
                fac[idx*i-1]+=1;
                idx++;

            }

        }
         int ans=0;
         for(int i:fac){
             if(i%2==0){
                 ans++;
             }
         }
        return ans;
        
    }
}