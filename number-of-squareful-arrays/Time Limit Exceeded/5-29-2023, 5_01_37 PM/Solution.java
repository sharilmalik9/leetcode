// https://leetcode.com/problems/number-of-squareful-arrays

class Solution {
    int ans=0;
    public int numSquarefulPerms(int[] nums) {
        int len = nums.length;
        boolean[] vis = new boolean[len];
        HashSet<List<Integer>> res=new HashSet<>();
        backtrack(res ,new ArrayList<>(), nums, vis, 0);
        return ans;
        
    }
    public void backtrack( HashSet<List<Integer>> res,List<Integer> list, int[] nums, boolean[] visited, int idx) {
        if (idx == nums.length) {
            if(res.contains(list)){
                return;
            }
            else{
                ans++;
                res.add(new ArrayList<>(list));
                return;
            }
            
            
        }
        for (int i = 0; i < nums.length; i++) {
            // avoid duplicate
            if (!visited[i] ) {
                if(list.size()==0){
                visited[i] = true;
                list.add(nums[i]);
                backtrack(res,list, nums, visited, idx + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
                }
                else if(list.size()!=0 && check(list.get(list.size()-1)+nums[i])){
                visited[i] = true;
                list.add(nums[i]);
                backtrack(res,list, nums, visited, idx + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
                }
                
            }
        }
    }
    public boolean check(int no){
        System.out.println(no);
        for(int i=1;i<=Math.sqrt(no);i++){
            if(i*i==no){
                return true;
            }
        }
        return false;
    }
}