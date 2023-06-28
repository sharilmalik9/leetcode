// https://leetcode.com/problems/maximum-sum-queries

class Solution {
    
public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
    int[] res = new int[queries.length];
    TreeMap<Integer, TreeSet<Integer>> sumToNum1 = createTreeMap(nums1, nums2);
    for (int i = 0; i < res.length; i++) {
        res[i] = getMax(sumToNum1, queries[i]);
    }
    return res;
}

private TreeMap<Integer, TreeSet<Integer>> createTreeMap(int[] nums1, int[] nums2) {
    TreeMap<Integer, TreeSet<Integer>> sumToNum1 = new TreeMap<>();
    for (int i = 0; i < nums1.length; i++) {
        int num1 = nums1[i];
        int num2 = nums2[i];
        int sum = num1 + num2;
        if (!sumToNum1.containsKey(sum)) {
            sumToNum1.put(sum, new TreeSet<>());
        }
        sumToNum1.get(sum).add(num1);
    }
    return sumToNum1;
}

private int getMax( TreeMap<Integer, TreeSet<Integer>> treeMap, int[] q) {
    int x = q[0];
    int y = q[1];
    Integer sum = treeMap.lastKey();
    while (sum != null) {
        TreeSet<Integer> num1Set = treeMap.get(sum);
        Integer num1 = num1Set.last();
        while (num1 != null && num1 >= x) {
            int num2 = sum - num1;
            if (num2 >= y) {
                return sum;
            }
            num1 = num1Set.lower(num1);
        }
        sum = treeMap.lowerKey(sum);
    }
    return -1;
}
}