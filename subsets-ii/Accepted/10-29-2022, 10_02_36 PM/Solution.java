// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<ArrayList<Integer>>hs=new HashSet<>();
        ArrayList<Integer>al=new ArrayList<>();
        List<List<Integer>>l=new ArrayList<>();
        Arrays.sort(nums);
        fn(0,nums,hs,new ArrayList<>(),l);
        return l;
    }
    public void fn(int idx,int[] nums,HashSet<ArrayList<Integer>>hs,ArrayList<Integer>al,List<List<Integer>>l){
        if(idx>nums.length){
            return;
        }
        if(hs.contains(al)==false){
            hs.add(al);
            l.add(new ArrayList<>(al));
        }
        for(int i=idx;i<nums.length;i++){
            al.add(nums[i]);
            fn(i+1,nums,hs,al,l);
            al.remove(al.size()-1);
        }
    }
}