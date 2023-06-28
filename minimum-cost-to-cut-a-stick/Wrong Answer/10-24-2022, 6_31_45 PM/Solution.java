// https://leetcode.com/problems/minimum-cost-to-cut-a-stick

// ye hadd se zyada tough sawal h isko bar bar dekhlo nhi hoga phir bhi 
class Solution {
    public int minCost(int n, int[] cuts) {
        int[] arr= new int[cuts.length+1];
        arr[0]=0;
        arr[arr.length-1]=n;
        for(int i=1;i<cuts.length;i++){
            arr[i]=cuts[i];
        }
        Arrays.sort(arr);
        return help(1,cuts.length-1,arr);
    }
    public int help(int i,int j,int[] cuts){
        if(i>j){
            return 0;
        }
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            // ye ajib h thoda krke dekhna ek baar yehi hota h isme as such koi logic nhi h 
            
            int cost=cuts[j+1]+cuts[i-1]+ help(i,k-1,cuts)+help(k+1,j,cuts);
            mini=Math.min(cost,mini);
            
        }
        return mini;
    }
}