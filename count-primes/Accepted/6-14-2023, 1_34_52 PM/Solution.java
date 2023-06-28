// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        boolean a[] = new boolean[n];
		Arrays.fill(a, true);
		int limit = (int)Math.sqrt(n);
		for(int i=2;i<=limit;i++) {
			if(a[i]) {
				for(int j=i*i;j<n;j+=i)
		    		a[j] = false;
			}
		}
		int counter = 0;
		for(int i=2;i<n;i++)
			if(a[i])counter++;
		return counter;
    }
}