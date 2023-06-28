// https://leetcode.com/problems/flip-string-to-monotone-increasing

class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones=0;
        int zeroes=0;
        int i=s.length()-1;
        int j=0;
        while( i>=0 && s.charAt(i)=='1'){
            i--;
        }
        while(j<s.length() && s.charAt(j)=='0'){
            j++;
        }
        while(j<=i){
            if(s.charAt(j)=='1'){
                ones++;

            }
            else{
                zeroes++;

            }
             j++;
            
        }
        return Math.min(zeroes,ones);
    
    }
}