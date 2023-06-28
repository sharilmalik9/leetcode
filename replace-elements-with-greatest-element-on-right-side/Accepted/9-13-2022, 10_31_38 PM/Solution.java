// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side

class Solution {
    public int[] replaceElements(int[] arr) {
        int n= arr.length;
        int max = arr[n-1];
        arr[n-1] = -1;
        
        int newMax = 0;
        for(int i = n-2; i>=0; i--){
            if(arr[i]>max){
                newMax = arr[i];
                arr[i] = max;
                max = newMax;
            }else{
                arr[i] = max;
            }
        }
        
        return arr;
    }
}