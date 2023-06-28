// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends

class Solution {
    public int minimumLength(String s) {
        if(s.length()==1){
            return 1;
        }
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                int j=start;
                while(j<end && s.charAt(j)==s.charAt(start)){
                    j++;
                }
                start=j;
                j=end;
                while(j>start && s.charAt(j)==s.charAt(end)){
                    j--;
                }
                end=j;
            }
            else{
                return end-start+1;
            }
        }
        if(start==end && s.charAt(start)==s.charAt(end)){
            return 0;

        }
        return end-start+1;
        
    }
}