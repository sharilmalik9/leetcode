// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt= new int[26];
        for(int i=0;i<tasks.length;i++){
            cnt[tasks[i]-'A']+=1;    
}
        Arrays.sort(cnt);
        int chunk=cnt[25]-1;
        int remTime=chunk*n;
        for(int i=24;i>=0;i--){
            remTime-=Math.min(chunk,cnt[i]);
}
        return remTime<0 ? tasks.length:tasks.length+remTime;
    }
}