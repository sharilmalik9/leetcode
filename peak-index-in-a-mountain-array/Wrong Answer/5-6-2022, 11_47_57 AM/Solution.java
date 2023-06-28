// https://leetcode.com/problems/peak-index-in-a-mountain-array

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid-1]>arr[mid]&& arr[mid+1]<arr[mid]){
                end=mid-1;
            }
            if(arr[mid-1]<mid&& arr[mid+1]>mid){
                start=mid+1;
                
            }
            else{
                return mid;
            }
        }
        return -1;
        
        
    }
}