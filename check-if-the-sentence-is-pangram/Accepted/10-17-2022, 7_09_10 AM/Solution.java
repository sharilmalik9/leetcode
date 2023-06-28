// https://leetcode.com/problems/check-if-the-sentence-is-pangram

class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hm= new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            hm.add(sentence.charAt(i));
        }
        return hm.size()==26 ? true : false;
        
    }
}