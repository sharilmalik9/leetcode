// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days

class Solution {
    public int shipWithinDays(int[] weights, int days) {
         int max=0;
        int min=0;
        int ans=0;
        for(int i=0;i<weights.length;i++){
            max+=weights[i];
            if(weights[i]>min){
                min=weights[i];
            }
        }
        while(min<=max){
            int mid=(max+min)/2;
            if(check(weights,mid,days)){
                ans=mid;
                max=mid-1;

            }
            else{
                min=mid+1;
            }
        }
        return ans;
        
        
        
    }
    public Boolean check(int[] arr,int mid,int days){
        int myday=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            if(sum+arr[i]<=mid){

                sum+=arr[i];
            }
            else{
                sum=arr[i];
                myday++;
            }
        }
        if(myday<=days){
            return true;
        }
        else{
            return false;
        }
    }
}