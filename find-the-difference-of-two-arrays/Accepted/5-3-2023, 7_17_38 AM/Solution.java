// https://leetcode.com/problems/find-the-difference-of-two-arrays

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1= new HashSet<>();
        HashSet<Integer> hs2= new HashSet<>();
        for(int i:nums1){
            hs1.add(i);
        }
          for(int i:nums2){
            hs2.add(i);
        }
        List<Integer> hm1=new ArrayList<>();
        List<Integer> hm2=new ArrayList<>();
        for(int i:nums1){
            if(!hs2.contains(i)){
                hs2.add(i);
                hm1.add(i);
            }
        }
        for(int i:nums2){
            if(!hs1.contains(i)){
                hs1.add(i);
                hm2.add(i);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(hm1);
        ans.add(hm2);
        return ans;
        




    }
}