// https://leetcode.com/problems/find-and-replace-in-string

class Solution {
    class pair{
        int index;
        String source;
        String target;
        public pair(int index,String target,String source){
            this.index=index;
            this.target=target;
            this.source=source;
        }
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
       pair[] arr= new pair[sources.length];
       for(int i=0;i<sources.length;i++){
           pair curr= new pair(indices[i],targets[i],sources[i]);
           arr[i]=curr;
       }
       Arrays.sort(arr,(a,b)-> a.index-b.index);
      boolean[] check=new boolean[targets.length];
      for(int i=0;i<sources.length;i++){
          int idx=arr[i].index;
          String curr=arr[i].source;
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
          if(id<arr.length && arr[id].index==idx && check[id]){
              sb.append(arr[id].target);
              idx+=arr[id].source.length();
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