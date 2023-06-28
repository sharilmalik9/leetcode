// https://leetcode.com/problems/additive-number

class Solution {
    String num;
    public boolean isAdditiveNumber(String nums) {
        num=nums;
        return help(0,-1,-1,0);
    }
    public boolean help(int idx,int prev1,int prev2,int count){
        if(idx>=num.length()){
            if(count>=3){
                return true;
            }
            return false;
        }
        boolean ans=false;
        for(int i=idx;i<num.length();i++){
            int curr=Integer.parseInt(num.substring(idx,i+1));
            if(prev1==-1 && prev2==-1){
                
                ans=ans || help(i+1,curr,prev2,count+1);
            }
            if(prev1!=-1 && prev2==-1){
                ans=ans|| help(i+1,prev1,curr,count+1);
            }
            if(prev1!=-1 && prev2!=-1 && prev1+prev2==curr){
                ans=ans || help(i+1,prev2,curr,count+1);

            }
        }
        return ans;
    }
}