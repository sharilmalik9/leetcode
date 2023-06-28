// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return help(beginWord,wordList,0,endWord);
    }
    public int help(String prev,List<String> wordList,int idx,String endWord){
        if(idx==wordList.size()){
            return 0;
        }
        if(wordList.get(idx)==endWord ){
            return 0;
        }
        int len = 0+help(prev,wordList,idx+1,endWord);
        if(check(prev,wordList.get(idx))){
            len=1+help(wordList.get(idx),wordList,idx+1,endWord);
        }
        
        return len;
        
        
        
    }
    public boolean check(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int idx1=0;
        int idx2=0;
        boolean used=false;
        while(idx1<s.length()){
            if(s.charAt(idx1)==t.charAt(idx2)){
                idx1++;
                idx2++;
            }
            else if(!used){
                idx1++;
                idx2++;
                used=true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}