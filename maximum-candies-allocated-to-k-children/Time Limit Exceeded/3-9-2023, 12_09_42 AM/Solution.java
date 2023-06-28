// https://leetcode.com/problems/maximum-candies-allocated-to-k-children

class Solution {
    public int maximumCandies(int[] candies, long k){
        int max=0;
        long sum=0;
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
            sum+=candies[i];
        }
        if(sum<k){
            return 0;
        }
        if(sum==k){
            return 1;
        }
        int min=0;
        int ans=0;
        while(min<=max){
            int mid=(max+min)/2;
            if(check(candies,k,mid)){
                min=mid+1;
                ans=mid;

            }
            else{
                max=mid-1;

            }
        }
        return ans;
        
    }
    public boolean check(int[] candies,long k,int mid){
        for(int i : candies){
            while(i>=0){
                i=i-mid;
                if(i<0){
                    break;
                }
                k--;

            }
        }
        if(k<=0){
            return true;
        }
        return false;
    }
}