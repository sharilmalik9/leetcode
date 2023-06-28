// https://leetcode.com/problems/jump-game-vii

class Solution {
      public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) != '0')
            return false;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        
        while(!queue.isEmpty()){
            int idx = queue.remove();
            if(idx == s.length() - 1)
                return true;
            for(int i = idx + minJump; i <= idx + maxJump && i < s.length(); i++){
                if(!visited[i] && s.charAt(i) == '0'){
                    visited[i] = true;
                    queue.add(i);
                }   
            }
        }
        
        return false;
    }
}