// https://leetcode.com/problems/maximum-split-of-positive-even-integers

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum%2!=0){
            return new ArrayList<>();
        }
        List<Long> ans= new ArrayList<>();
        long currsum=0;
        long sum=0;
        while(currsum<finalSum){
            sum+=2;
            currsum+=sum;
            ans.add(sum);
        }
        if(currsum!=finalSum){
            Long diff=currsum-finalSum;
            ans.remove((int)(diff/2)-1);
        }
        return ans;
        


    }
}