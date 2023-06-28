// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
public:
   bool helper(vector<int>& nums,int index,int target,vector<vector<int>>& dp){
      
        if(target==0){
            dp[index][0]=1;
            return true;
        }
        if(index==0){
            if(target==nums[0]){
                dp[0][nums[0]]=1;
                return true;
            }
            else{
                dp[0][nums[0]]=0;
                return false;
            }
        }
           if(dp[index][target]!=-1){
            return dp[index][target];
        }
       

        else{
            bool take=false;
            if(nums[index]<=target){
            take=helper(nums,index-1,target-nums[index],dp);
            }
            bool nottake=helper(nums,index-1,target,dp);
            if(take||nottake){
                dp[index][target]=1;
                return true;
            }
            else{
                dp[index][target]=0;
                return false;
            }
        }
    }





    bool canPartition(vector<int>& nums) {
        int sum=0;
        
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
        }
        if(sum%2==1){
            return 0;
        }
        else{
            int m=nums.size();
            vector<vector<int>>dp(m,vector<int>(sum/2+1,-1));
            return helper(nums,m-1,sum/2,dp);
        }
    }
};