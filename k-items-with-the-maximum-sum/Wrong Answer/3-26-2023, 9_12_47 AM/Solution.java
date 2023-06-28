// https://leetcode.com/problems/k-items-with-the-maximum-sum

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
       if(k<numOnes){
           return numOnes;
       }
        int sum=0;
          sum+=numOnes;
          k-=numOnes;
        if(k<numZeros){
            return numOnes;
        }
        else{
            k-=numZeros;
        }
        return sum-k;
     
        
        
    }
}