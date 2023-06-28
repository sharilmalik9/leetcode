// https://leetcode.com/problems/most-profit-assigning-work

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr= new int[profit.length][2];
        for(int i=0;i<profit.length;i++){
            arr[i][0]=difficulty[i];
            arr[i][1]=profit[i];
        }
        Arrays.sort(arr,(a,b)->
        a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]
        );
        int max=arr[0][1];
        for(int i=1;i<arr.length;i++){
            arr[i][1]=Math.max(max,arr[i][1]);
            max=arr[i][1];
        }
        int ans=0;
        for(int i=0;i<worker.length;i++){
            ans+=check(arr,worker[i]);
        }
        return ans;
    }
    public int check(int[][] arr,int target ){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid][0]==target){
                return arr[mid][1];
            }
            if(arr[mid][0]<target){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        if(ans==-1){
            return 0;
        }
        else{
            return arr[ans][1];
        }
    }
}