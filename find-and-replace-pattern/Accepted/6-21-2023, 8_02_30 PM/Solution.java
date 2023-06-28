// https://leetcode.com/problems/find-and-replace-pattern

import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String word: words){
            if(createPattern(word).equals(createPattern(pattern))){
                list.add(word);
            }
        }
        return list;
    }
    public List<Integer> createPattern(String word){
        StringBuilder givenPattern = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<word.length();i++){
            if(!map.containsKey(word.charAt(i))){
                map.put(word.charAt(i), count);
                list.add(count);
                count++;
            }
            else{
                list.add(map.get(word.charAt(i)));
            }
        }
        return list;
    }
}