// https://leetcode.com/problems/minimum-time-to-complete-all-tasks

class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks,(a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
        HashSet<Integer> hs=new HashSet<>();
        for(int[] i: tasks){
            int used=0;
            for(int j=i[0];j<=i[1];j++){
                if(hs.contains(j)){
                    used++;
                }
            }
            int rem=i[2]-used;
            int end=i[1];
            for(int j=i[1];rem>0;j--){
                if(!hs.contains(j)){
                      hs.add(j);
                      rem--;

                }
               
               
            }
        }
        return hs.size();
    }
}