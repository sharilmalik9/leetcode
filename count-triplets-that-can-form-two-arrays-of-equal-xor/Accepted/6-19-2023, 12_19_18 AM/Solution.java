// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {
        int r=0;
        for(int i=0;i<arr.length;i++) {
            int acc=arr[i];
            for(int k=i+1;k<arr.length;k++) {
                acc^=arr[k];
                // Item 1 from intuition
                if(acc==0)
                    // Item 2 from intuition
                    r+=k-i;
            }
        }
        return r;
    }
}