// https://leetcode.com/problems/jump-game-iii

// Breadth First Search
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int curr = queue.remove();
            if(curr>=arr.length||curr<0||vis[curr])
                continue;
            if(arr[curr]==0){
                return true;
            }
            vis[curr]=true;
            queue.add(curr+arr[curr]);
            queue.add(curr-arr[curr]);
        }
        return false;
    }
}