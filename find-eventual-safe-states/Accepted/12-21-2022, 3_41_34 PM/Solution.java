// https://leetcode.com/problems/find-eventual-safe-states

// do topo after reversing the entire graph (reversing all nodes and later sort it for returning correct ans)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> g= new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                g.get(graph[i][j]).add(i);
            }
        }
        int[] indegree =new int[graph.length];
        for(int i=0;i<g.size();i++){
            for(int j=0;j<g.get(i).size();j++){
                indegree[g.get(i).get(j)]++;

            }
        }
         Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<g.size();i++){
            if(indegree[i]==0){
                que.add(i);
            }

        }
        List<Integer> ans= new ArrayList<>();
        while(que.size()!=0){
            int curr= que.poll();
            ans.add(curr);

            for(int i=0;i<g.get(curr).size();i++){
                indegree[g.get(curr).get(i)]--;
                if(indegree[g.get(curr).get(i)]==0){
                    que.add(g.get(curr).get(i));
                }

                
            }
        }
        Collections.sort(ans);
        return ans;

    }
}