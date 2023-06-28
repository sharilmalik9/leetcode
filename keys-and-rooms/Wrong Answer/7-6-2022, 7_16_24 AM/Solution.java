// https://leetcode.com/problems/keys-and-rooms

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited= new boolean[rooms.size()];
        List<Integer> ls= new ArrayList<>();
        visited[0]=true;
        for(int i=0;i<rooms.size();i++){
            ls=rooms.get(i);
            for(Integer j:ls){
                visited[j]=true;
            }
            
            
        }
        for(boolean k:visited){
            if( k==false){
                return false;
            }
           
        }
        return true;
        
    }
}