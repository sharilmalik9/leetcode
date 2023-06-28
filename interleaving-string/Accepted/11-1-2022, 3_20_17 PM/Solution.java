// https://leetcode.com/problems/interleaving-string

class Solution {
   public boolean isInterleave(String s1, String s2, String s3) {
	var m = s1.length();
	var n = s2.length();
	if (m + n != s3.length())
		return false;

	var dp = new boolean[m + 1][n + 1];
	dp[m][n] = true;

	for (var i = m; i >= 0; i--)
		for (var j = n; j >= 0; j--)
			if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j] 
			 || j < n && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1])				
				dp[i][j] = true;

	return dp[0][0];
}
}