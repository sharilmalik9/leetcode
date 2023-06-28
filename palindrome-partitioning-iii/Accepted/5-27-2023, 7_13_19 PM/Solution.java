// https://leetcode.com/problems/palindrome-partitioning-iii

class Solution {
       //isme sbse imp h min steps to ki ek string ko palindrome bana skein
    // uske liye vo wala ques yaad krle sharil 
    // iske dp m for every i and j k liye save ho jaayega 
    // phir bar bar calculate krne ki zaruat nhi h 
    // varna tle ajata 
    // # Faith :

    // Maine apni ek string kati aur maiine ek bachi hui string ko bola ki tum apne
    // aap ko k string mai break karke apni minChange ki value return karde. Main
    // sabme se min value nikal ke return kardunga.

    public static void minChanges(String str, int[][] dp) {
        // YE function bilkul same hai jaise palindromic substring ki dp fill karte
        // hain. Usko dry run kar lena, ye bhi same waise he hai.
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; i < n && j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 0; // har single character ek palindrome hai, to 0 changes required hai isko
                                  // palindrome mai convert karne ke liye
                    continue;
                }

                char ch1 = str.charAt(i);
                char ch2 = str.charAt(j);

                if (ch1 != ch2) {
                    // Agar mere dono character equal nhi hai to mujhe
                    // For ex : "abbbc" to iske liye mujhe jo beech ki string ke min changes + 1
                    // + 1 isiliye kyunki palindrome ke liye ya to a c mai convert hoga ya c a mai.
                    // To isiliye +1 kiya.
                    dp[i][j] = dp[i + 1][j - 1] + 1;
                } else {

                    // Ab gar mere dono character equal hai, to mujhe palindrome mai convert karne
                    // ke liye utne he changes chahiyein honge jitne meri beech ki string ko chahiye
                    // honge.
                    if (gap == 1) {
                        dp[i][j] = 0; // for condition like "ee", dono character equal hai to no changes required.
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
    }

    public int palindromePartition(String str, int k, int si, int ei, int[][] dp, int[][] minChangesDp) {

        if (si == str.length()) // Agar meri string he khatam ho gyi, to answer kabhi milega he nhi.
            return (int) 1e9;

        if (str.length() - si < k) // For condition like "abc, 5", to abc ko 5 set mai break karna hai, which is
                                   // not possible.
            return (int) 1e9;

        if (k == 1) // Ab agar K==1 bacha hai to sidhe uske min changes he return kardo.
            return dp[k][si] = minChangesDp[si][ei];

        if (dp[k][si] != -1)
            return dp[k][si];

        int minAns = (int) 1e9;
        for (int cut = si; cut <= ei; cut++) {

            int myStringCutValue = minChangesDp[si][cut];
            int remainingStringValue = palindromePartition(str, k - 1, cut + 1, ei, dp, minChangesDp);

            if (remainingStringValue != (int) 1e9) // Since hum chahte hain ki whi answer evaluate ho jiska answer ban
                                                   // sakta hai. To agar remainingStringValue ki value (int)1e9 hai to
                                                   // `uper se wali condition hit hui hai jiska matlba hai ki answer
                                                   // create he nhi ho sakta.
                minAns = Math.min(minAns, myStringCutValue + remainingStringValue);
        }

        return dp[k][si] = minAns;
    }

    public int palindromePartition(String str, int k) {
        int n = str.length();
        int[][] minChangesDp = new int[n][n];
        minChanges(str, minChangesDp);

        int[][] dp = new int[k + 1][n + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return palindromePartition(str, k, 0, n - 1, dp, minChangesDp);
    }
}