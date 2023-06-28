// https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii

class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int[] check=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            check[i]=nums1[i]-nums2[i];
            if(k==0 && check[i]!=0){
                return -1;
            }
        }
        if(k==0){
            return 0;
        }

        long sum=0;
        long ans=0;
        for(int i=0;i<nums1.length;i++){
            if(check[i]!=0 && check[i]%k!=0){
                return -1;
            }
            sum+=check[i];
            if(check[i]>0){
                ans+=check[i]/k;
            }
        }
        
       return sum==0 ? ans:-1;
    }
}