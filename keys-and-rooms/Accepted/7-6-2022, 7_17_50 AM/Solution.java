// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         ArrayDeque<Integer> q = new ArrayDeque<>();
        int n = rooms.size();
        boolean [] visited = new boolean[n];
        visited[0] = true;
        List<Integer> r0 = rooms.get(0);
        for(int val : r0){
            q.add(val);
        }
        while(q.size() > 0){
            int idx = q.remove();
            if(visited[idx] == true){
                continue;
            }
            List<Integer> room = rooms.get(idx);
            for(int val : room){
                q.add(val);
            }
            visited[idx] = true;
        }
        for(boolean val : visited){
            if(val == false){
                return false;
            }
        }
        return true;
       
    }
}