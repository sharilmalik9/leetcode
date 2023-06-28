// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int start=1;
        long ans=0;
        int end=skill.length-2;
        int sum=skill[0]+skill[skill.length-1];
        ans=skill[0]*skill[skill.length-1];
        while(start<end){
            if(sum!=skill[start]+skill[end]){
                return -1;
            }
            else{
                ans+=(long)skill[start]*skill[end];

            }
            start++;
            end--;

        }
        return ans;
        
    }
}