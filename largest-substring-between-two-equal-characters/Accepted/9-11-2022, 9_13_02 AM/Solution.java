// https://leetcode.com/problems/largest-substring-between-two-equal-characters

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> hm= new HashMap<>();
        int max=0;
        int here=0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                here++;
                max=Math.max(max,i-1-hm.get(s.charAt(i)));
            }
            else{
                hm.put(s.charAt(i),i);
            }
            
        }
        if(here==0){
            return -1;
        }
        return max;
    }
}