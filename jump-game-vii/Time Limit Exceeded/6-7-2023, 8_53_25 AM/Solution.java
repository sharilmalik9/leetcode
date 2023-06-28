// https://leetcode.com/problems/jump-game-vii

class Solution {
   public boolean canReach(String s, int minJump, int maxJump) {
    int n=s.length();
    Queue<Integer> q=new LinkedList();
    if(s.charAt(n-1)=='1') // can't reach destination
        return false;
    q.offer(0);
    int far=0;
    while(!q.isEmpty()){
        int i=q.poll();
        int min=i+minJump;
        int max=i+maxJump;
       
        for(int j=Math.max(min,far);j<=max && j<n;j++){
            if(s.charAt(j)=='0'){    
                q.offer(j);
                if(j==n-1)
                    return true; //reached at destination
            }            
        }
        far=Math.max(far, max);
    }
    return false; 
}
}