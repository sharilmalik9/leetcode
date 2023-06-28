// https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day

class Solution {
    public boolean[] canEat(int[] candies, int[][] queries) {
        int[] sum=new int[candies.length];
        sum[0]=candies[0];
        for(int i=1;i<candies.length;i++){
            sum[i]=sum[i-1]+candies[i];
        }
        boolean[] ans=new boolean[queries.length];
        int idx=0;
        for(int[] curr:queries){
            boolean hey=true;
            int type=curr[0];
            int day=curr[1];
            int cap=curr[2];
            if(sum[type]<day){
                hey=false;
            }
            else{
                if(type!=0 && sum[type-1]/cap>=day){
                    hey=false;
                }
               

            }
            ans[idx]=hey;
            idx++;
        }
        return ans;
        
    }
}