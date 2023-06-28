// https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations

class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> hs= new HashSet<>();
        for(int i: nums){
            hs.add(i);
           hs.add(reverse(i));
        }
        return hs.size();
        
    }
    public int reverse(int i){
        int ans=0;
        int rem=0;
        while(i>0){
            rem=i%10;
            i=i/10;
            ans=ans*10+rem;
            
        }
        
        return ans;
        
     }
}