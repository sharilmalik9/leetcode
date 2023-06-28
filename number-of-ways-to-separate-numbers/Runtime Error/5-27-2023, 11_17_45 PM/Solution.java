// https://leetcode.com/problems/number-of-ways-to-separate-numbers

class Solution {
    int n;
    public int numberOfCombinations(String num) {
        n=num.length();
        return rec(num,0,0);
    }
    public int rec(String num,int idx,int prev){
        if(idx==n){
            return 1;
        }
        int ans=0;
        for(int i=idx;i<n;i++){
            if(i==idx && num.charAt(i)=='0'){
              //  continue;
                break;
            }
            int no=Integer.parseInt(num.substring(idx,i+1));
            System.out.println(no);
            if(no>=prev){
                ans+=rec(num,i+1,no);
            }

        }
        return ans;
    }
}