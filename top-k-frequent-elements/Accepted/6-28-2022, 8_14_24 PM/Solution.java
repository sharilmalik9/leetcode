// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
          Map<Integer,Integer> sh= new HashMap<>();
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->-sh.get(a)+sh.get(b));

        for(int i:nums){
            if(!sh.isEmpty() && sh.containsKey(i)){
                sh.replace(i,sh.get(i)+1);
            }
            else{
                sh.put(i,1);
            }
        }
        for(int i: sh.keySet()){
            pq.add(i);
        }
        int[] ans= new int[k];
        int idx=0;
        while(k>0){
            ans[idx]=pq.poll();
            k--;
            idx++;

        }
        return ans;

    }
}