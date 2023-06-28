// https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] arr1= new int[10];
        int[] arr2=new int[10];
        for(int i:nums1){
            arr1[i]=1;
        }
        for(int i:nums2){
            arr2[i]=1;
        }
        int ans=0;
        for(int i=1;i<10;i++){
            if(arr1[i]==1 && arr2[i]==1){
                ans=i;
                return ans;
            }
        }
        int first=0;
        int second=0;
        for(int i=1;i<10;i++){
            if(arr1[i]==1){
                first=i;
                break;
            }
        }
         for(int i=1;i<10;i++){
            if(arr2[i]==1){
                second=i;
                break;
            }
        }
        ans=first*10+second;
        return ans;
        
    }
}