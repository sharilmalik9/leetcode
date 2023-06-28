// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
        for(int i : nums){
            high=Math.max(i,high);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(findSum(nums,threshold,mid)==true){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return high;
        
    }
    public boolean findSum(int[] nums,int threshold,int divisor)
    {
        int sum=0;
        for(int i:nums){
            sum+=i/divisor;
            if(i%divisor!=0)sum+=1;
        }
        if(sum<=threshold)return true;
        return false;
    }
}