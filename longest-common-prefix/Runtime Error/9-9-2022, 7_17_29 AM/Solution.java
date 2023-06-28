// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common=strs[0];
        
        for(String str:strs){
            for(int i=0;i<str.length();i++){
                 if(i>common.length()){
                        break;
                    }
                if( str.charAt(i)==common.charAt(i)){
                   
                    continue;
                }
                else{
                    common=common.substring(0,i);
                }
            }
        }
        return common;
    }
}