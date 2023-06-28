// https://leetcode.com/problems/course-schedule-ii

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            adj.get(i[1]).add(i[0]);
        }
        return isCyclic(numCourses,adj);
        
    }
    public int[] isCyclic(int V, List<List<Integer>> adj) {
        int[] ans= new int[V];
        int idx=0;
       int[] indegree= new int[V];
       for(int i=0;i<V;i++){
           for(int j: adj.get(i)){
               indegree[j]++;
           }
       }
       Queue<Integer> que= new LinkedList<>();
       for(int i=0;i<V;i++){
           if(indegree[i]==0){
               que.add(i);
           }
       }
       int cnt=0;
       while(que.size()!=0){
           
           cnt++;
           int curr=que.poll();
           ans[idx]=curr;
           idx++;
           for(int i: adj.get(curr)){
               indegree[i]--;
               if(indegree[i]==0){
                   que.add(i);
               }
           }
           
       }
       if(cnt==V){
           return ans;
       }
       return new int[0];
    }
}