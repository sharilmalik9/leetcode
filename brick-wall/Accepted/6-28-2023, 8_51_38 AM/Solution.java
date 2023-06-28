// https://leetcode.com/problems/brick-wall

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // map will be storing gap position and it's count
        int ans = 0;

        for(List<Integer> row : wall) {
            int sum = 0;
            for(int i=0;i<row.size()-1;i++) {
                sum += row.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for(Map.Entry <Integer,Integer> en : map.entrySet()) {
            ans = Math.max(en.getValue(),ans);
        }



        return wall.size() - ans; 
    }
}