// https://leetcode.com/problems/repeated-string-match

class Solution {
    public int repeatedStringMatch(String A, String B) {
         int[] freq1=new int[26];
      int[] freq2=new int[26];
      for(int i=0;i<A.length();i++){
          freq1[A.charAt(i)-'a']+=1;
      }
      for(int i=0;i<B.length();i++){
          if(freq1[B.charAt(i)-'a']==0){
              return -1;
          }
          freq2[B.charAt(i)-'a']+=1;
      }
      int one=A.length();
      int two=B.length();
      int idx1=0;
      int idx2=0;
      while(idx1<one){
          int opt=idx1;
          while(idx2<two && A.charAt(idx1%one)==B.charAt(idx2)){
              idx2++;
              idx1++;
          }
          if(idx2==two){
              return (idx1-1)/one+1;
          }
          idx1=opt+1;
          idx2=0;
      }
      return -1;
    }
}