// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    int[] arr;
    int sum;
    int[] prefix;
    public Solution(int[] w) {
        arr=w;
        Arrays.sort(arr);
        sum=0;
        prefix=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            prefix[i]=sum;
        }
    }
    
    public int pickIndex(){
        int idx=(int)Math.random()*sum;
        return findindex(idx);  
    }
    public int findindex(int num){
        int start=0;
        int ans=-1;
        int end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(prefix[mid]>num){
                ans=mid;
                end=mid-1;

            }
            else{
                start=mid+1;
            }
        }
        return ans;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */