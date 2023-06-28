// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements

class Solution {
    public long findScore(int[] nums) {
        int[][] arr= new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            int[] curr= new int[2];
            curr[0]=i;
            curr[1]=nums[i];
            arr[i]=curr;
        }
        Arrays.sort(arr,(a,b)->
        a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]
        );
        boolean[] check=new boolean[nums.length];
        int score=0;
        int idx=0;
        while(idx<nums.length){
            if(!check[arr[idx][0]]){
                 score+=arr[idx][1];
                 check[arr[idx][0]]=true;
                 if(arr[idx][0]!=0){
                     check[arr[idx][0]-1]=true;

                 }
                 if(arr[idx][0]!=nums.length-1){
                     check[arr[idx][0]+1]=true;
                 }
                
            }
            idx++;
        }
        return score; 
    }
}