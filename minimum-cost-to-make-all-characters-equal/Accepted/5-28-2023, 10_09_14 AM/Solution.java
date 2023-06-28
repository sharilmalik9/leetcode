// https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal

class Solution {
    public long minimumCost(String s) {
     
        int len=s.length()-1;
        long count=0;
        for(int m=0;m<len;m++)
        {
            if(s.charAt(m)!=s.charAt(m+1)) count+=Math.min(len-m,m+1);
        }
        return count;
    }
}