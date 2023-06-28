// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work

class Solution {
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        long sum=0;
        for(int i:milestones){
        sum+=i;
        }
        long spaces=milestones[milestones.length-1]-1;
        long avail=spaces;
        for(int i=milestones.length-2;i>=0;i--){
            avail-=Math.min(milestones[i],spaces);
        }
        return avail<0 ? sum:sum-avail;
        
    }
}