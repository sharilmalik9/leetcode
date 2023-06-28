// https://leetcode.com/problems/grumpy-bookstore-owner

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int maxW=0;
        int sum=0;
        int start=0;
        int end=minutes-1;
        while(end<customers.length && start<=end){
            if(grumpy[start]==1){
                maxW=customers[start];
            }
            start++;
        }
      sum=maxW;
      start=0;
        end++;
      while(end<customers.length && start<=end){
          
          if(grumpy[end]==1){
              maxW+=customers[end];
             
          }
           if(grumpy[start]==1){
                    maxW-=customers[start];
             }
             
           end++;
           start++;  
          sum=Math.max(sum,maxW);
      }
      for(int i=0;i<grumpy.length;i++){
          if(grumpy[i]!=1){
              sum+=customers[i];
          }
      }
        
        return sum;
    }
}