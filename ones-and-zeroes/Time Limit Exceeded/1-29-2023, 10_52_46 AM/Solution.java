// https://leetcode.com/problems/ones-and-zeroes

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return help(strs,0,m,n);
    }
    public int help(String[] strs,int idx,int m,int n ){
        if(idx==strs.length){
            return 0;
        }
        if(m==0 && n==0){
            return 0;
        }
        int ones=0;
        int zeros=0;
        for(int i=0;i<strs[idx].length();i++){
            if(strs[idx].charAt(i)=='0'){
                zeros++;
            }
            else{
                ones++;
            }

        }
        int include=0;
        if(m-zeros>=0 && n-ones>=0){
            include=1+help(strs,idx+1,m-zeros,n-ones);


        }
        int dont=help(strs,idx+1,m,n);
        return Math.max(include,dont);
    }
}