// https://leetcode.com/problems/maximal-score-after-applying-k-operations

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> a>b ?-1 :1);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
         long  ans=0;
        while(k!=0){
            int val=pq.poll();
            ans+=val;
            if(val%3==0){
                val=val/3;
            }
            else{
                val=val/3+1;
            }
            System.out.println(val);
            pq.add(val);
            k--;
        }
        return ans;

    }
}