// https://leetcode.com/problems/task-scheduler-ii

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> mp=new HashMap<>();
        long ans =0l;
        for(int i=0;i<tasks.length;i++){
            if(mp.containsKey(tasks[i])){
                if(ans-mp.get(tasks[i])<space){
                    ans+=space-(ans-mp.get(tasks[i]));
                }
            }
            ans++;
            mp.put(tasks[i],ans);
        }
        return ans;
        
        
        
    }
}