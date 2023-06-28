// https://leetcode.com/problems/number-of-beautiful-pairs

class Solution {
    public int countBeautifulPairs(int[] nums) {
        String[] arrhe = new String[nums.length];
        
        for(int i =0; i < nums.length; i ++) arrhe[i] = Integer.toString(nums[i]);
        
        int ans = 0;
        
        for(int i =0; i< arrhe.length; i++){
            for(int j = i+1; j< arrhe.length; j++){
                String num = arrhe[i];
                String numhe = arrhe[j];
                
                if( gcd(num.charAt(0) - '0', numhe.charAt(numhe.length() - 1) -'0') ==1){
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
    
    public int gcd(int m, int b)
    {
      if (b == 0)
        return m;
      return gcd(b, m % b);
    }
    
}