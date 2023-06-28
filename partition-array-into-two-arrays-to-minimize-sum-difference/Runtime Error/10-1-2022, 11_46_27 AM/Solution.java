// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference

class Solution {
    public int minimumDifference(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        boolean[][] dp=new boolean[nums.length][sum+1];
        int k=sum;
         if(nums[0]<k){
             dp[0][nums[0]]=true;
        }
    
       for(int i=0;i<nums.length;i++){
           dp[i][0]=true;
       }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<k+1;j++){
                boolean notinclude=dp[i-1][j];
                boolean include=false;
                if(nums[i]<=j){
                    include=dp[i-1][j-nums[i]];
                    
                }
                dp[i][j]=include || notinclude;
                
                
                
}
        }
      
       int[] rem= new int[sum+1];
        for(int i=0;i<sum+1;i++){
            if(dp[nums.length-1][i]){
                 rem[i]=Math.abs(i-sum);
            }
            else{
                  rem[i]=Integer.MAX_VALUE;
            }
            
         
        }
        int[] sem= new int[sum+1];
        for(int i=0;i<sum+1;i++){
            if(dp[nums.length-1][i]){
                sem[i]=Math.abs(i-rem[i]);
            }
            else{
                sem[i]=Integer.MAX_VALUE;
            }
}
        
        
        int min=sem[0];
        for(int i:sem){
            min=Math.min(min,i);
        }
       
        
        
        return min;
        
        
    }
}