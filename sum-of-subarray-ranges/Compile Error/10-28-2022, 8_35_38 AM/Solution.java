// https://leetcode.com/problems/sum-of-subarray-ranges

 public static long subArrayRanges(int[] nums) {

        long[] minLeft = subArrayMaxMinLeft(nums, true);
        long[] minRight = subArrayMaxMinRight(nums, true);
        long[] maxLeft = subArrayMaxMinLeft(nums, false);
        long[] maxRight = subArrayMaxMinRight(nums, false);

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += ((maxLeft[i] * maxRight[i]) - (minLeft[i] * minRight[i])) * nums[i];
        }
        return res;
    }

    static long[] subArrayMaxMinRight(int[] nums, boolean lesser) {
        long[] arr = new long[nums.length];
        Deque<Pair> st = new ArrayDeque<>();
        Predicate<Integer> predicate = lesser ? num -> num <= st.peek().num : num -> num >= st.peek().num;
        for (int i = nums.length - 1; i >= 0; i--) {
            long count = 1;
            while (!st.isEmpty() && predicate.test(nums[i])) {
                count += st.pop().count;
            }
            st.push(new Pair(nums[i], count));
            arr[i] = count;
        }
        st.clear();
        return arr;
    }

    static long[] subArrayMaxMinLeft(int[] nums, boolean lesser) {
        long[] arr = new long[nums.length];
        Deque<Pair> st = new ArrayDeque<>();
        Predicate<Integer> predicate = lesser ? num -> num < st.peek().num : num -> num > st.peek().num;
        for (int i = 0; i < nums.length; i++) {
            long count = 1;
            while (!st.isEmpty() && predicate.test(nums[i])) {
                count += st.pop().count;
            }
            st.push(new Pair(nums[i], count));
            arr[i] = count;
        }
        st.clear();
        return arr;
    }

    static class Pair {
        long num, count;

        public Pair(long num, long count) {
            this.num = num;
            this.count = count;
        }
    }