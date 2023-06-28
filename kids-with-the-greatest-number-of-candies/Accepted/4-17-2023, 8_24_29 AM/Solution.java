// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest=candies[0];
        for(int i=0;i<candies.length;i++){
            largest=Math.max(largest,candies[i]);
        }
        List<Boolean> ans= new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(largest==candies[i]){
                ans.add(true);
            }
            else if(largest<=candies[i]+extraCandies){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}