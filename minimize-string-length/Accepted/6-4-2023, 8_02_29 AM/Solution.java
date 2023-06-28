// https://leetcode.com/problems/minimize-string-length

class Solution {
    public int minimizedStringLength(String s) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            hs.add(s.charAt(i)-'a');
        }
        return hs.size();
        
    }
}