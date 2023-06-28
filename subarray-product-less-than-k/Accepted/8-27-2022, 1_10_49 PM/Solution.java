// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {

public int numSubarrayProductLessThanK(int[] nums, int k) {
    
    //two pointer
    //nums[i] check -> +
    //less then k => + length 
	//(n + 1) * ( n + 2) / 2 - n * (n + 1) / 2))  = n + 1;
	// else left++
    
	int sum = 1;
    int result = 0;
    int left = 0;
    int right = 0;
    
    while(right < nums.length) {
        sum *= nums[right];
        
        while(left <= right && sum >= k) {
            sum /= nums[left++];
        }
        
        if(left <= right) {
            result += (right - left) + 1;                
        }
        right++;            
    }
return result;
}
}