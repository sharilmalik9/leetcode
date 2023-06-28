// https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero

class Solution(object):
    def makeTheIntegerZero(self, firstNumberme, secondNumberme):
        if firstNumberme < secondNumberme:
            return -1
        
        for count in range(101):
            difference = firstNumberme - secondNumberme * count
            bitCount = bin(difference)[2:].count("1")
            if bitCount <= count and count <= difference:
                return count
            
        return -1 
