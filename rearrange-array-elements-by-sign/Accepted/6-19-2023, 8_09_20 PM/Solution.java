// https://leetcode.com/problems/rearrange-array-elements-by-sign

class Solution {
    public int[] rearrangeArray(int[] nums) {
       int arr[]=new int[nums.length];
        int k=0,l=0,i=0;
        while(true){
            while(k<nums.length&&nums[k]<0)
            k++;
            while(l<nums.length&&nums[l]>0)
            l++;
            if(l>=nums.length&&k>=nums.length)
            break;
            if(i>=nums.length)
            break;
            arr[i]=nums[k];
            k++;
            i++;
            arr[i]=nums[l];
            l++;
            i++;
        }
        return arr;
    }
}