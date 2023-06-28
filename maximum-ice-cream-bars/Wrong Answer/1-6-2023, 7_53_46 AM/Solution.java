// https://leetcode.com/problems/maximum-ice-cream-bars

class Solution {
    public int maxIceCream(int[] costs, int coins){
        Arrays.sort(costs);
        if(costs[0]>coins){
            return 0;
        }
        int ans=0;
        int index=0;
        while(index<costs.length && coins>0){
            coins-=costs[index];
            index++;
            ans++;

        }
        return ans;
        
    }
}