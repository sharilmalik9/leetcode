// https://leetcode.com/problems/fair-distribution-of-cookies

class Solution {
    int res = Integer.MAX_VALUE;

public int distributeCookies(int[] c, int k) {
    int[] nums = new int[k];
    dfs(c, nums, 0);
    return res;
}

void dfs(int[] c, int[] nums, int cur){
    if(cur == c.length){
        int r = 0;
        for(int i=0;i<nums.length;i++){
            r = Math.max(r, nums[i]);
        }
        res = Math.min(res, r);
        return;
    }
    for(int i=0;i<nums.length;i++){
        if(nums[i] + c[cur] > res)
            continue;
        nums[i] += c[cur];
        dfs(c, nums, cur+1);
        nums[i] -= c[cur];
    }
}
}