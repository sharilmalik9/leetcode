// https://leetcode.com/problems/k-radius-subarray-averages

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[n];
        long[] prefixSum=new long[n];
        long sum=0;
        long sumAvg=0;
        long avg=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefixSum[i]=sum;
        }
        for(int i=0;i<n;i++){
            if(i<k || i>=(n-k)){
                arr[i]=-1;
            }else{
                if(i-k-1>=0){
                sumAvg=prefixSum[i+k]-prefixSum[i-k-1];
                }else{
                    sumAvg=prefixSum[i+k];
                }

                avg=sumAvg/(2*k +1);
                
                arr[i]=(int)avg;
            }
        }
        return arr;
    }
}