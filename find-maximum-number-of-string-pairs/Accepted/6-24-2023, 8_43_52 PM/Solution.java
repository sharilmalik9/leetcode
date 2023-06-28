// https://leetcode.com/problems/find-maximum-number-of-string-pairs

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(check(words[i],words[j])){
                    ans++;
                }
            }
            
        }
        return ans;
        
    }
    public boolean check(String one,String two){
        if(one.length()!=two.length()){
            return false;
        }
        int start=0;
        int end=two.length()-1;
        while(start<two.length()){
            if(one.charAt(start)!=two.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}