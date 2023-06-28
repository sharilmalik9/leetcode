// https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero

public class Solution {
    public int makeTheIntegerZero(int firstNumber, int secondNumber) {
        if (firstNumber < secondNumber) {
            return -1;
        }

        for (int count = 0; count <= 100; count++) {
            int difference = firstNumber - secondNumber * count;
            int bitCount = Integer.bitCount(difference);
            if (bitCount <= count && count <= difference) {
                return count;
            }
        }

        return -1;
    }
}
