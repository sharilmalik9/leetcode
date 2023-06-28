// https://leetcode.com/problems/largest-substring-between-two-equal-characters

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> hm= new HashMap<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                max=Math.max(max,i-1-hm.get(s.charAt(i)));
            }
            else{
                hm.put(s.charAt(i),i);
            }
            
        }
        return max;
    }
}