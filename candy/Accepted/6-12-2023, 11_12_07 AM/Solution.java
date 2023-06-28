// https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] ratings) {
        int[] ans=new int[ratings.length];
       // Arrays.fill(ans,1);
       ans[0]=1;
        for(int i=1;i<ans.length;i++){
            if(ratings[i]>ratings[i-1]){
                ans[i]=ans[i-1]+1;
            }
            else{
                ans[i]=1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && ans[i]<=ans[i+1]){
                ans[i]=ans[i+1]+1;
            }
        }
        int sum=0;
        for(int i:ans){
            sum+=i;
        }
        return sum;
        
    }
}