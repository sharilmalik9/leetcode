// https://leetcode.com/problems/sort-an-array

class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
        
        
    }
    public void mergesort(int[] nums,int s, int e){
        if(s<e){
            int mid= (s+e)/2;
            mergesort(nums,s,mid);
            mergesort(nums,mid+1,e);
            merge(nums,s,mid,e);
        }
       
    }
    
    public void merge(int[] nums,int s,int mid,int e){
        int[] b= new int[nums.length];
        int i=s;
        int j= mid+1;
        int k=s;
        while(i<=mid && j<=e){
            if(nums[i]<nums[j]){
                b[k]=nums[i];
              
                i++;
            }
            else{
                b[k]=nums[j];
               j++;
            }
            k++;
}
        if(i>mid){
            while(j<=e){
                b[k]=nums[j];
                j++;
                k++;
            }
        }
        else {
            while(i<=mid){
                b[k]=nums[i];
                k++;
                i++;
}
}
        for(int p=s;p<=e;p++){
            nums[p]=b[p];
        }
    }
}