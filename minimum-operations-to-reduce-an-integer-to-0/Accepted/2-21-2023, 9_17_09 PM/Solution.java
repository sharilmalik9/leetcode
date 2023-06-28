// https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0

class Solution {
    public int minOperations(int n) {
        int count=0;
        while(n!=0)
        {
            int c=1;
            while(c<=n)
            {
                c*=2; 
            }
            int s=n-(c/2);
            int h =c-n;
            if(h>s)
            {
                n=s;
                count++;
            }else
            {
                n=h;
                count++;
            }
        }
        return count;
    }
}