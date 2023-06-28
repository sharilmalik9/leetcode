// https://leetcode.com/problems/random-pick-index

class Solution {
    int[] nums;
     HashMap<Integer,ArrayList<Integer>> hm;
    

    public Solution(int[] nums) {
        this.nums=nums;
          hm=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                 hm.get(nums[i]).add(i);
            }
           
        
        else{
            ArrayList<Integer> arr= new ArrayList<>();
            arr.add(i);
            hm.put(nums[i],arr);
        }
        }
        
    
    }
    
    public int pick(int target) {
        
        ArrayList<Integer> arr= hm.get(target);
       // int idx= (int)Math.random()*arr.size()+0;
        Random random= new Random();
        return arr.get(random.nextInt(arr.size()));
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */