// https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters

class Solution {
    public int minimumBuckets(String street) {
        int buckets=0;
        int n =street.length();
        for(int i=0;i<street.length();i++){
            if(street.charAt(i)=='H'){
                if(i+1<n && street.charAt(i+1)=='.'){
                    buckets++;
                    i+=2;
                }
                 else if(i-1>=0 && street.charAt(i-1)=='.'){
                buckets++;
            }
            else{
                return -1;
            }
            }
           
        }
        
        
        return buckets;
        
    }
}




















