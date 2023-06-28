// https://leetcode.com/problems/boats-to-save-people

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0;
        int start=0;
        int end=people.length-1;
        while(start<=end){
            if(people[end]>=limit){
                end--;
                ans++;
            }
            else if(people[start]+people[end]>limit){
                end--;
                ans++;
            }
            else if(people[start]+people[end]<=limit){
                start++;
                end--;
                ans++;
            }
        }
        return ans;
        
    }
}