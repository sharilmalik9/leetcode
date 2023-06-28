// https://leetcode.com/problems/sign-of-the-product-of-an-array

class Solution {
public int arraySign(int[] nums) {
int n=nums.length;
int prod=1;
for(int i=0;i<n;i++){
if(nums[i]>0){
prod*=1;
} else if(nums[i]<0){
prod*=-1;
} else prod*=0;
}

    return signFunc(prod);
} 

public int signFunc(long product){
    if(product<0) return -1;
    else if(product>0) return 1;
    else return 0;
}
}