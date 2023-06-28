// https://leetcode.com/problems/domino-and-tromino-tiling

class Solution {
    public int numTilings(int n) {
        int[] arr= new int[n];
        if(n==1){
            return 1;
        }
        else if (n==2){
            return 2;
        }
        else if(n==3){
            return 5;
        }
        arr[1]=1;
        arr[2]=2;
        arr[3]=5;
        for(int i=4;i<n;i++){
            arr[i]=arr[i-1]*2+arr[i-3];
        }        

       return arr[n-1];
        
    }
}