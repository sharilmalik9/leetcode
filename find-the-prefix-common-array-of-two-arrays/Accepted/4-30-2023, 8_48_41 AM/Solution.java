// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B){
        int n=A.length;
        int[] check= new int[n+1];
        int[] ans=new int[n];
        int idx=0;
        while(idx<n){
            int curr=0;
            check[A[idx]]++;
            check[B[idx]]++;
            for(int i=1;i<n+1;i++){
                if(check[i]>1){
                    curr++;
                }
            }
            ans[idx]=curr;
            idx++;
        }
        return ans;
        
    }
}