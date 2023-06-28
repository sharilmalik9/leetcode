// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game

class Solution {
   
    public int numberOfWeakCharacters(int[][] prop) {
         Arrays.sort(prop, new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
              return Integer.compare(o1[1], o2[1]);
            } else {
              return Integer.compare(o2[0], o1[0]);
            }
        }
    });
        int cnt=0;
        int max=0;
        for(int[] arr:prop){
            if(arr[1]<max){
                cnt++;
            }
            else{
                max=arr[1];
}
            
        }
        return cnt;
        
        
        
        
        
        
        
        
        
        
    }
}