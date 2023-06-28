// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> needed = new HashMap<>();
        for(char c : t.toCharArray()){
            needed.put(c, needed.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> map = new HashMap<>();
        String result = "";
        int currentCount = 0;
        int resultLength = Integer.MAX_VALUE;
        
        int start = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            if(map.get(c)<=needed.getOrDefault(c,0))
                currentCount++;
            if(currentCount == t.length()){
                if(resultLength>(i - start + 1)){
                    result = s.substring(start, i + 1);
                    resultLength = i - start + 1;
                }
                while(start<i){
                    char sc = s.charAt(start);
                    map.put(sc, map.get(sc) - 1);
                    
                    start++;
                  
                    if(map.get(sc)<needed.getOrDefault(sc,0)){
                        currentCount--;
                        break;
                    }
                    if(resultLength>(i - start + 1)){
                        resultLength = i - start + 1;
                        result = s.substring(start, i + 1);
                    }
                    
                }
            }
        }
        
        return result;
    }
}