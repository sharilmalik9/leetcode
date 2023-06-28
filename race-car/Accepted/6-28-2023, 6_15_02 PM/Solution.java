// https://leetcode.com/problems/race-car

class Solution {
    public int racecar(int target) {
        // if(currentPosition < target) then accelerate
        // if(currentPosition > target) then reverse

        Queue<int[]> q = new LinkedList<>();
        HashSet<int[]> visited = new HashSet<>();

        q.add(new int[] {0, 0, 1}); // -> {moves, position, speed}
        while(!q.isEmpty()){
            int[] instance = q.poll();
            
            int moves = instance[0];
            int position = instance[1];
            int speed = instance[2];

            if(position == target){
                return moves;
            } else if(visited.contains(instance)){
                continue;
            }

            visited.add(instance);
            q.add(new int[] {moves + 1, position + speed, speed * 2});

            if((position + speed > target && speed > 0) || (position + speed < target && speed < 0)){
                q.add(new int[] {moves + 1, position, speed > 0 ? -1 : 1});
            }
        }

        return -1;
    }
}