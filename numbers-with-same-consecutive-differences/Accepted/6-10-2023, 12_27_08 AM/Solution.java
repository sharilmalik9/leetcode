// https://leetcode.com/problems/numbers-with-same-consecutive-differences


class Solution {
    List<Integer> ans = new ArrayList();
    public int[] numsSameConsecDiff(int n, int k) {
        bt(0, k, -1, n, 0);
        int[] a = new int[ans.size()];
        for(int i=0; i<a.length; i++) a[i] = ans.get(i);
        return a;
    }
    
    public void bt(int num, int k, int l, int n, int c) {
        if (n == c) {
            ans.add(num);
            return;
        }
        for(int i=0; i<=9; i++) {
            if (c == 0 && i==0) continue;
            if (c > 0 && Math.abs(l-i) != k) continue;
            num=num*10 +i;
            bt(num, k, i, n, c+1);
            num = num / 10;
        }
    }
}