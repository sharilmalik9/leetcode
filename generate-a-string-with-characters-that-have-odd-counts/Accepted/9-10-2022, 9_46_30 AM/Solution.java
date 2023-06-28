// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts

class Solution {
    public String generateTheString(int n) {
        String result = "";
        for(int i=0; i<n; i++){
            if(n%2==0){
                if(i==(n-1)) result+="n";
                else result+="p";
            } else result+="p";
        }
        return result;
    }
}