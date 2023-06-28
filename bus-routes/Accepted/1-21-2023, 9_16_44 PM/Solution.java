// https://leetcode.com/problems/bus-routes

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,List<Integer>> hm= new HashMap<>();
         Queue<Integer> que= new LinkedList<>();
         if(source==target){
             return 0;
         }
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                if(hm.get(routes[i][j])==null){
                    hm.put(routes[i][j],new ArrayList<>());
                    
                }
                hm.get(routes[i][j]).add(i);
                if(routes[i][j]==source){
                    que.add(i);
                }
                
            }
        }
        HashSet<Integer> vis= new HashSet<>();
        int level=0;
        while(que.size()!=0){
            level++;
            int size=que.size();
            for(int i=0;i<size;i++){
                int curr=que.poll();
                if(vis.contains(curr)){
                    continue;
                }
                for(int j=0;j<routes[curr].length;j++){
                    int bus=routes[curr][j];
                    if(bus==target){
                        return level;
                    }
                    else{
                        for(int m: hm.get(bus)){
                            que.add(m);
                        }
                    }
                }
                vis.add(curr);
            }

        }
       





      return -1;

    }
}