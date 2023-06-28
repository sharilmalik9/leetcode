// https://leetcode.com/problems/concatenated-words

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> hs= new HashSet<>();
        for(int i=0;i<words.length;i++){
            hs.add(words[i]);
        }
        List<String> ans= new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(check(words[i],hs)){
                ans.add(words[i]);
            }
        }
        return ans;
        
    }
    public boolean check(String str,HashSet<String> hs){
        for(int i=0;i<str.length()-1;i++){
            String prefix=str.substring(0,i+1);
            String suffix=str.substring(i+1);
            if((hs.contains(suffix)&& hs.contains(prefix)) ||(hs.contains(prefix)&& check(suffix,hs))){
                return true;
            }
        }
        return false;

    }
}