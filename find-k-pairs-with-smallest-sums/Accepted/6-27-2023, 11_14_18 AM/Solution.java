// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        for(int i=0;i<nums1.length;i++){
            pq.add(new int[]{nums1[i],nums2[0],0});
        }
        List<List<Integer>> ls=new ArrayList<>();
        while(k-->0 && pq.size()!=0){
            int[] curr=pq.poll();
            List<Integer> he=new ArrayList<>();
            he.add(curr[0]);
            he.add(curr[1]);
            ls.add(he);
            int idx=curr[2]+1;
            if(idx<nums2.length ){
                pq.add(new int[]{curr[0],nums2[idx],idx});
            }
        }
        return ls;
    }
}