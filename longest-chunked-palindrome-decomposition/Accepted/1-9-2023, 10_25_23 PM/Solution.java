// https://leetcode.com/problems/longest-chunked-palindrome-decomposition

class Solution {
    public int longestDecomposition(String text) {
        int start = 0;
        int end = text.length() -1 ;

        String startTemp = "";
        String endTemp = "";

        int sameCount = 0;
        while(end!=-1){
            startTemp += text.charAt(start++);
            endTemp = text.charAt(end--) + endTemp;

            if(startTemp.equals(endTemp)){
                sameCount++;
                startTemp = "";
                endTemp = "";
            }
        }

        if(sameCount == 0){
            return 1;
        }
        return sameCount;



        }
    }
