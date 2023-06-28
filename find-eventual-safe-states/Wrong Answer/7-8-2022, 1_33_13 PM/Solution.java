// https://leetcode.com/problems/find-eventual-safe-states

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> st= new HashSet<>();
         List<Integer> ls= new ArrayList<>();
        
        
        for(int i=0;i<graph.length;i++){
            int[] curr=graph[i];
            if(curr.length==0){
                st.add(i);
               
                
            }
        }
        for(int i=0;i<graph.length;i++){
            boolean ans= true;
            if(st.contains(i)){
                ls.add(i);
                continue;
            }
            for(int j:graph[i]){
                if(!st.contains(j)){
                    ans=false;
                    break;
                    
                }
                
            }
            if(ans){
                ls.add(i);
            }
        }
        return ls;
       
       
        
    }
}