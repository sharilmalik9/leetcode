// https://leetcode.com/problems/prime-subtraction-operation

class Solution {
    public boolean primeSubOperation(int[] nums) {
        TreeSet<Integer> tmp = new TreeSet<>();
        int max = 0;
        for(int i : nums){
            max = Math.max(i,max);
        }
        // tmp.add(2);
        
        for(int i = 2; i< max;i ++){
            if(isPrime(i)){
               tmp.add(i); 
            }
        }
        // System.out.println(tmp);
        for(int i = nums.length-2; i>=0;i--){
            if(nums[i]>=nums[i+1]){                
            Integer diff = tmp.ceiling(nums[i] - nums[i+1] + 1);
            if(diff == null || diff >= nums[i]){
                return false;
            }
            nums[i] -= diff;
                
            }
        }
        
        return true;
        
        
    }
    
    public boolean isPrime(int n){
        for(int i = 2; i<= n/2;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}