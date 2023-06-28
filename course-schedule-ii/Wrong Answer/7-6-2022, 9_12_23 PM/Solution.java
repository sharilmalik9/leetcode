// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      
         Stack<Integer> st= new Stack<>();
        int v=numCourses;
         boolean[] visited=new boolean[v];
        boolean[] visited1=new boolean[v];
        boolean[] rec= new boolean[v];
        List<List<Integer>> neigh=convertToGraph(prerequisites,v);
       boolean check=cycle(v,neigh);
       
        if(check==true){
            return new int[0];
        }
        for(int i=0;i<v;i++){
            if(!visited[i]){
                findOrderUtil(neigh,i,visited,st);
            }
        }
        int[] ans = new int[v];
        for(int i=0;i<v;i++){
            ans[i]=st.pop();
        }
        return ans;
    }
    public void findOrderUtil(List<List<Integer>> neigh,int v, boolean[] visited,Stack<Integer> st){
        visited[v]=true;
        for(int i:neigh.get(v)){
           
            if(!visited[i]){
                findOrderUtil(neigh,i,visited,st);
            }
            
        }
        st.push(v);
        
    }
    public List<List<Integer>> convertToGraph(int[][] pre,int v){
        List<List<Integer>> neigh = new ArrayList<>();
        for(int i=0;i<v;i++){
            List<Integer> hel=new ArrayList<>();
            neigh.add(hel);
        }
        for(int i=0;i<pre.length;i++){
            int parent =pre[i][1];
            int child=pre[i][0];
           neigh.get(parent).add(child);
        }
        return neigh;
        
    }
    public boolean cycle(int v,List<List<Integer>> neigh){
         boolean[] visited=new boolean[v];
        boolean[] rec= new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if( detectCycleDirectedGraph(i,neigh,visited,rec)){
                    return true;
                }
            }
                   
        }
                   return false;
        
    }
     public boolean detectCycleDirectedGraph(int v,List<List<Integer>> neigh , boolean[] visited ,boolean[] rec){
        rec[v]=true;
        visited[v]=true;
        for(int i: neigh.get(v)){
            if(!visited[i]){
                detectCycleDirectedGraph(i,neigh,visited,rec);
            }
            else if(rec[i]){
                return true;
            }
        }
        rec[v]=false;
        return false;
    }
    
        
    
}