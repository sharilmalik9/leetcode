// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
      String  index="";
        int len=Integer.MAX_VALUE;
        for(String str:strs){
            if(str.length()<len){
                index=str;
                len=str.length();
            }
        }
        String common=strs[0];
        
        for(String str:strs){
            for(int i=0;i<str.length();i++){
                 if(i>common.length()-1){
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