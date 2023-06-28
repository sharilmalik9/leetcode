// https://leetcode.com/problems/determine-if-two-strings-are-close

class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> hp1= new HashMap<>();
        HashMap<Character,Integer> hp2= new HashMap<>();
        for(int i=0;i<word1.length();i++){
            char s= word1.charAt(i);
            hp1.put(s,hp1.getOrDefault(s,0)+1);
}
        for(int i=0;i<word2.length();i++){
            char s= word2.charAt(i);
            hp2.put(s,hp2.getOrDefault(s,0)+1);
}
         for(int i=0;i<word1.length();i++){
            char s= word1.charAt(i);
             int freq=hp1.get(s);
             if(!hp2.containsValue(freq)){
                 return false;
             }
           
}
        
        return true;
        
        
    }
}