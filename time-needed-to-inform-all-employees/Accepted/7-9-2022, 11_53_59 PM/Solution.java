// https://leetcode.com/problems/time-needed-to-inform-all-employees

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
       
    Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
    for(int i = 0; i < n; i++){
        if(manager[i] != -1){
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i],list);
        }
    }
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{headID,0});
    int res = 0;
    while(!q.isEmpty()){
        int[] cur = q.poll();
        int boss = cur[0], time = cur[1];
        res = Math.max(res, time);
        if(map.containsKey(boss)){
            for(int child: map.get(boss)){
                q.add(new int[]{child, time+informTime[boss]});
            }
        }
        
    }
    return res;
        
        
        
        
    }
}