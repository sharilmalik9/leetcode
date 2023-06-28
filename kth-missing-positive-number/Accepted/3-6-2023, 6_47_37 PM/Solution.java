// https://leetcode.com/problems/kth-missing-positive-number

class Solution {
    public int findKthPositive(int[] num, int k){
        int[] arr= new int[k];
        int idx=0;
        int idx1=0;
       for(int i=1;i<10000;i++){
         
           if( idx <num.length && i==num[idx]){
               idx++;
           }
           else{
               arr[idx1]=i;
               idx1++;
               if(idx1==k){
                   return arr[idx1-1];
               }
           }

       }
        return 0;
    }
}