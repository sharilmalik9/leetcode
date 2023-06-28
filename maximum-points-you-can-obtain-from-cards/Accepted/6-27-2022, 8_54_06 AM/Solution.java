// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        if(k==0){
            return 0;
        }
        if(k==cardPoints.length){
            int sum=0;
            for(int i=0;i<cardPoints.length;i++ ){
                sum+=cardPoints[i];
                
            }
            return sum;
        }
        int start= cardPoints.length-k;
        int end = cardPoints.length-1;
        int curr=0;
        int max=0;
        for(int i=start;i<=end;i++){
            curr+=cardPoints[i]; 
        }
        max=curr;
        while(end!=k-1){
            curr=curr-cardPoints[start];
            start=(start+1)%cardPoints.length;
            end=(end+1)%cardPoints.length;
            curr+=cardPoints[end];
            if(curr>max){
                max=curr;
            }
            
        }
        return max;
        
    }
}