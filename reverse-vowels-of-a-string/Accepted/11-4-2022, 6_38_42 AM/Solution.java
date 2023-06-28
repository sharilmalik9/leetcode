// https://leetcode.com/problems/reverse-vowels-of-a-string

class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;


        while (left < right) {
            if (!isVowel(array[left])) {
                left++;
            } else if (!isVowel(array[right])) {
                right--;
            } else {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return String.valueOf(array);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}