// https://leetcode.com/problems/single-number-iii

class Solution {
    public int[] singleNumber(int[] arr) {
        int xor=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            xor^=arr[i];
        }

        int rmsb=xor&-xor;
        int x=0;
        int y=0;
        for(int i=0;i<n;i++){
            if((rmsb & arr[i])==0){
                x=x^arr[i];
            }else{
                y=y^arr[i];
            }
        }

        return new int[]{x,y};

        

    }
}