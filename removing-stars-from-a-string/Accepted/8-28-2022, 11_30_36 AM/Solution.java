// https://leetcode.com/problems/removing-stars-from-a-string

class Solution {
    public String removeStars(String s) {
        List<Character> charList = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                charList.remove(charList.size()-1);
            }else{
                charList.add(s.charAt(i));
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0;i<charList.size();i++){
            strBuilder.append(charList.get(i));
        }
        return strBuilder.toString();
    }
}