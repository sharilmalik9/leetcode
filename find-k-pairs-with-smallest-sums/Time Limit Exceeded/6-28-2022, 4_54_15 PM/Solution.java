// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq= new PriorityQueue<>((a,b)->
                                                            (a.get(0)+a.get(1))-(b.get(0)+b.get(1)));
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
               List<Integer> arr= new ArrayList<>();
                arr.add(nums1[i]);
                arr.add(nums2[j]);
                pq.add(arr);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<k;i++){
            if(!pq.isEmpty()){
                ans.add(pq.poll());
            }
            else{
                break;
            }
        }
        return ans;
        
        
    }
}