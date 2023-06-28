// https://leetcode.com/problems/set-mismatch

class Solution {
    public int[] findErrorNums(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int duplicate=0;
        for(int i: nums){
            
            if(set.contains(i)){
                duplicate=i;
            }else {
                set.add(i);
            }
        }
        
        int setSum =0;
        for(int i: set){
            setSum+=i;
        }
        
        int totalSum = (nums.length*(nums.length+1))/2;
        
        int missing = totalSum - setSum;
        System.out.println(totalSum + " "+ duplicate + " "+setSum);
        
        return new int[]{duplicate, missing};
        
    }
}
