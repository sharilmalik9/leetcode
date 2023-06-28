// https://leetcode.com/problems/find-and-replace-in-string

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
      boolean[] check=new boolean[targets.length];
      for(int i=0;i<sources.length;i++){
          int idx=indices[i];
          String curr=sources[i];
           int len=curr.length();
           String currs=s.substring(idx,idx+len);
           if(currs.equals(curr)){
               check[i]=true;
           }
           else{
               check[i]=false;
           }
      }
      StringBuilder sb= new StringBuilder();
      int idx=0;
      int id=0;
      while(idx<s.length()){
          if(indices[id]==idx && check[id]){
              sb.append(targets[id]);
              idx+=sources[id].length();
              id++;
          }
          else{
              sb.append(s.charAt(idx));
              idx++;
          }
      }
      return sb.toString();





    }
}