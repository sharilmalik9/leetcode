// https://leetcode.com/problems/broken-calculator

class Solution {
    public int brokenCalc(int startValue, int target) {
        Queue<Integer> que= new LinkedList<>();
        que.add(startValue);
        int level=0;
        while(que.size()!=0){
            int size=que.size();
            level++;
            while(size!=0){
                int curr=que.poll();
            if(curr*2==target || curr-1==target){
                return level;
            }
            que.add(curr*2);
            que.add(curr-1);
            size--;

            }
            
            
        }
        return -1;
    }
}