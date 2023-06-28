// https://leetcode.com/problems/minimum-cost-to-cut-a-stick

// ye hadd se zyada tough sawal h isko bar bar dekhlo nhi hoga phir bhi 
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] arr= new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp= new int[cuts.length+2][cuts.length+2];
        for(int i=cuts.length;i>=1;i--){
            for(int j=1;j<=cuts.length;j++){
                if(i>j){
                    continue;
                }
             int mini=Integer.MAX_VALUE;
              for(int k=i;k<=j;k++){
            
            
            int cost=arr[j+1]-arr[i-1]+ dp[i][k-1]+dp[k+1][j];
            mini=Math.min(cost,mini);
            
        }
            dp[i][j]= mini;
                
            }
            
        }
        return dp[1][cuts.length];
    }
    public int help(int i,int j,int[] cuts){
        if(i>j){
            return 0;
        }
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            // ye ajib h thoda krke dekhna ek baar yehi hota h isme as such koi logic nhi h 
            
            int cost=cuts[j+1]-cuts[i-1]+ help(i,k-1,cuts)+help(k+1,j,cuts);
            mini=Math.min(cost,mini);
            
        }
        return mini;
    }
}