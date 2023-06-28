// https://leetcode.com/problems/largest-merge-of-two-strings

class Solution {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < n1 && j < n2){
          if(word1.charAt(i) < word2.charAt(j)){
            sb.append(word2.charAt(j));
            j++;
          }else if(word1.charAt(i) > word2.charAt(j)){
            sb.append(word1.charAt(i));
            i++;
          }else{
            if(word1.substring(i).compareTo(word2.substring(j)) > 0){
              sb.append(word1.charAt(i));
              i++;
            }else{
              sb.append(word2.charAt(j));
              j++;
            }
          }
        }
        if(word1.substring(i).isEmpty()){
          sb.append(word2.substring(j));
        }else{
          sb.append(word1.substring(i));
        }
        return sb.toString();
    }
}