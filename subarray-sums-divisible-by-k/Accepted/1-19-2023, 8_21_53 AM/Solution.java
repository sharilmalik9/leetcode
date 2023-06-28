// https://leetcode.com/problems/subarray-sums-divisible-by-k

class Solution {
public int subarraysDivByK(int[] nums, int k) {
    
    int pre=0,cnt=0;
    HashMap<Integer,Integer> hm=new HashMap();
    for(int i:nums){
        pre=pre+i;
        if(pre%k==0)cnt++;
       int res=pre%k<0?(pre%k)+k:pre%k;
        if(hm.containsKey(res)){
            cnt+=hm.get(res);
        }
        hm.put(res,hm.getOrDefault(res,0)+1);       
    }
    return cnt;
}
}