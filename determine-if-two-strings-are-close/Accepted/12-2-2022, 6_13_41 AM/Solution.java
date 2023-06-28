// https://leetcode.com/problems/determine-if-two-strings-are-close

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Not possible to change length of array so check same length
        // O(1) time
        if (word1.length() != word2.length())
            return false;
        
        // Order of characters doesn't matter because rule 1 allows reordering
        // so don't need to preserve order.
        // Only lowercase English characters - so can track at character level
        // Can store character frequency in fixed size array
        // O(26) = O(1) space O(N) time
        int[] cc1 = new int[26];
        int[] cc2 = new int[26];
        for (int i=0; i<word1.length(); i++) {
            cc1[word1.charAt(i)-'a']++;
            cc2[word2.charAt(i)-'a']++;
        }
        
        // Same set of characters must be in both strings as no rule introduces
        // new characters into a string,
        // rule two only allows changing frequency of characters.
        // So check same characters are in each string
        // O(26) = O(1) time
        for (int i=0; i<26; i++)
            if ((cc1[i]==0) != (cc2[i]==0))
                return false;
        
        // We can swap characters to change frequencies of a character
        // to the frequency of another character.
        // But we can'tchange the mix of frequencies.
        // So we can sort and then ensure that frequencies match.
        // O(26 log 26) = O(1) time to sort
        // O(26) = O(1) time to match frequencies
        Arrays.sort(cc1);
        Arrays.sort(cc2);
        for (int i=0; i<26; i++)
            if (cc1[i] != cc2[i])
                return false;
        
        // Every check passed so they are close
        // Overall Time Complexity O(N) and Space Complexity O(1)
        return true;
    }    
}