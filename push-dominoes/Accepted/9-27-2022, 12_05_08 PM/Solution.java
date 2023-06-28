// https://leetcode.com/problems/push-dominoes

class Solution {
    public void solve(int i, int j, char[] arr){
        if(arr[i] == 'L' && arr[j] == 'L'){
            for(int k = i+1; k<j; k++){
                arr[k] = 'L';
            }
        }else if(arr[i] == 'R' && arr[j] == 'R'){
            for(int k = i+1; k<j; k++){
                arr[k] = 'R';
            }
        }else if(arr[i] == 'L' && arr[j] == 'R'){
            //pass
        }else{
            int mid = (j+i)/2;
            if((j-i)%2!=0){
                for(int idx = i+1; idx<=mid; idx++){
                    arr[idx] = 'R';
                }
            }else {
                for(int idx = i+1; idx<mid; idx++){
                    arr[idx] = 'R';
                }
            }
            for(int idx = mid+1; idx<j; idx++){
                arr[idx] = 'L';
            }
        }
    } 
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = new char[n+2];
        arr[0] = 'L';
        arr[n+1] = 'R';
        for(int i = 1; i<arr.length-1; i++){
            arr[i] = dominoes.charAt(i-1);
        }
        int start = 0;
        int end = 1;
        while(end<arr.length){
            while(arr[end] == '.'){
                end++;
            }
            if(end-start>1){
                solve(start, end, arr);
            }
            start = end;
            end++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<arr.length-1; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}