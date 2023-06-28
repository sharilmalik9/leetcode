// https://leetcode.com/problems/number-of-laser-beams-in-a-bank

class Solution {
   public int numberOfBeams(String[] bank) 
    {
        int ans=0;
        int prev=0;
        int curr=0;
        for(int i=0;i<bank.length;i++)
        {
            curr=0;
            for(int j=0;j<bank[i].length();j++)
            {
                if(bank[i].charAt(j)=='1')
                    curr++;
            }
            if(prev==0)
            {
                prev=curr;
            }
            else
            {
                if(curr!=0)
                {
                ans+=(prev*curr);
                prev=curr;
                }
            }
            
        }
        return ans;
        
    }
}