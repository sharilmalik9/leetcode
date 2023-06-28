// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i:nums){
            pq.add(i);
        }
        int ans=0;
        for(int i=0;i<nums.length-k+1;i++){
            ans=pq.peek();
            pq.poll();
            
        }
        return ans;
        
    }
}