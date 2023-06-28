// https://leetcode.com/problems/ways-to-make-a-fair-array

class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n=nums.length;
        int []even=new int[n];
        int []odd=new int[n];
        
        int evensum=0;
        int oddsum=0;
        
        for(int i=0;i<n;i++){
            if(i%2==0){
                evensum+=nums[i];
            }else{
                oddsum+=nums[i];
            }
            
            even[i]=evensum;
            odd[i]=oddsum;
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            int neven=0;
            int nodd=0;
            
            if(i==0){
                nodd=even[n-1]-even[0];
                neven=odd[n-1];
            }else{
                nodd=odd[i-1]+even[n-1]-even[i];
                neven=even[i-1]+odd[n-1]-odd[i];
            }
            
            if(neven==nodd){
                ans++;
            }
        }
        
        return ans;
    }
}