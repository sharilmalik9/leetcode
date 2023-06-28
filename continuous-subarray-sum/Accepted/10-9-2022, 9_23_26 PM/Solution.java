// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
public boolean checkSubarraySum(int[] arr, int k) {

    int sum = 0;
    
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,-1);

    for(int i=0;i<arr.length;i++)
    {
        sum += arr[i];
        int rem = sum%k;
        
        if(map.containsKey(rem))
        {
            if(i-map.get(rem)>=2)
            {
                return true;
            }
            else
            {
              //  map.put(rem,map.get(rem));
                continue;
            }
        }
        
        map.put(rem,i);
    }
    
    return false;
}
}