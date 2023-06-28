// https://leetcode.com/problems/make-array-strictly-increasing

class Solution {
    HashMap<Integer,Integer> dp[];
    TreeSet<Integer> ts;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        ts = new TreeSet<>();
        for(int i : arr2){
            ts.add(i);
        }
        dp = new HashMap[arr1.length];
        for(int i = 0 ; i < arr1.length ;i++) dp[i] = new HashMap<>();

        int res = help(0,Integer.MIN_VALUE,arr1);
        // if(res == 10000)
        return res < Integer.MAX_VALUE-1 ? res : -1;
    }
    public int help(int ind,int prev, int arr1[]){
        if(ind == arr1.length) return 0;
        
        if(dp[ind].containsKey(prev)) return dp[ind].get(prev);

        int nottake = Integer.MAX_VALUE-1;
        if(arr1[ind] > prev) nottake = help(ind+1,arr1[ind],arr1);

        int take = Integer.MAX_VALUE-1;
        Integer greater_avail = ts.higher(prev);

        if(greater_avail != null) take = 1+ help(ind+1,greater_avail,arr1);

        dp[ind].put(prev,Math.min(take,nottake));

        return dp[ind].get(prev);
    }
}