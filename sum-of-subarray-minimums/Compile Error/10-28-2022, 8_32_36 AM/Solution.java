// https://leetcode.com/problems/sum-of-subarray-minimums

class Solution {
public static int sumSubarrayMins(int[] arr) {
int n = arr.length;
Deque monoStack = new ArrayDeque<>();
// traverse every element as the minimum value, find the left and right boundaries, and calculate the number of permutations
int[] left = new int[n];
int[] right = new int[n];

    Arrays.fill(right, n - 1);
    for (int i = 0; i < n; i++) {
        while (!monoStack.isEmpty() && arr[monoStack.peek()] > arr[i]) {
            right[monoStack.pop()] = i - 1;
        }
        monoStack.push(i);
    }

    monoStack.clear();
    
    for (int i = n - 1; i >= 0; i--) {
        while (!monoStack.isEmpty() && arr[monoStack.peek()] >= arr[i]) {
            left[monoStack.pop()] = i + 1;
        }
        monoStack.push(i);
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
        long leftCount = i - left[i];
        long rightCount = right[i] - i;
        ans += arr[i] * (leftCount + 1) * (rightCount + 1);
    }
    return (int)(ans % 1000000007);
}
}