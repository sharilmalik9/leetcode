// https://leetcode.com/problems/target-sum

class Solution {

public int countOfSubsetSum(int []arr,int sum,int n){
    int [][]t = new int[n+1][sum+1];
    for(int i=0;i<sum+1;i++){
        t[0][i]=0;
    }
    for(int i=0;i<n+1;i++){
        t[i][0]=1;
    }
    for(int i=1;i<n+1;i++){
        for(int j=0;j<sum+1;j++){
            if(arr[i-1]<=j){
                t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
            }
            else{
                t[i][j]=t[i-1][j];
            }
        }
    }
    return t[n][sum];
}

public int findTargetSumWays(int[] nums, int target) {
    int sum=0;
    int n=nums.length;
    for(int i=0;i<n;i++){
        sum+=nums[i];
    }
    if(target>sum){
        return 0;
    }
    if((target+sum)%2!=0){
        return 0;
    }
    sum = (target+sum)/2;
    
    return countOfSubsetSum(nums,sum,n);
}
}