// https://leetcode.com/problems/minimum-string-length-after-removing-substrings

class Solution {
    public int minLength(String s){
       List<Character> ls= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            ls.add(s.charAt(i));
        }
        
        
        int idx=0;
      while(idx<ls.size()-1){
         
        
          if((ls.get(idx)=='A' && ls.get(idx+1)=='B')||(ls.get(idx)=='C' && ls.get(idx+1)=='D') ){
              
              ls.remove(idx);
              ls.remove(idx);
              idx=0;
          }
          else{
              idx++;
          }
      }
          return ls.size();
       
        
    }
}